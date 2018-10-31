package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.SingleList;
import pojo.User;
import utils.Message;
import utils.SecurePassword;

public class DbManager {
	
	//********** connection attributes ***********/
	private static final String driver = "com.mysql.jdbc.Driver"; 
	private static final String url = "jdbc:mysql://localhost";
	private static final String username = "root";
	private static final String password = "";
	private static final String database = "musictimeline";
	private Connection conn = null;

	//********** static block to load driver JDBC **********/
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//********** CONSTRUCTOR **********/
	public DbManager() {
		conn = openConnection();
	}
	
	//********** GETTERS AND SETTERS **********/
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	//********** METHOD for opening connection to MySQL **********/
	public Connection openConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setCatalog(database);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//********** METHOD to search and return all the singles of a specified year **********/
	public ArrayList<SingleList> searchSinglesByYear(Integer year) throws SQLException {
		ArrayList<SingleList> singleList = new ArrayList<SingleList>();
		
		String sqlQuery = "SELECT S.idSingle, S.title, S.info, A.name, A.image, M.uri, S.nameGenre FROM single S, artist A, media M WHERE S.idArtist = A.idArtist AND S.idSingle = M.idSingle AND S.year = ? AND S.type = ? AND M.validityCheck = ? ORDER BY A.name";
		
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, year);
		ps.setString(2,  "original");
		ps.setBoolean(3, true);
		ResultSet rs = ps.executeQuery();
		//result extraction
		while(rs.next() ) {
			Integer idSingle = rs.getInt("idSingle");
			String title = rs.getString("title");
			String info = rs.getString("info");
			String name = rs.getString("name"); 
			String image = rs.getString("image");
			String uri = rs.getString("uri");
			String nameGenre = rs.getString("nameGenre");
			//add Single to ArrayList
			SingleList single = new SingleList(idSingle, title, info, name, image, uri, nameGenre);
			singleList.add(single);
		}
		rs.close();
		ps.close();
		return singleList;
	}
	
	//********** METHOD to search and return all the covers of a selected single **********/
	public ArrayList<SingleList> searchCoversByIdSingle(Integer id) throws SQLException {
		ArrayList<SingleList> coverList = new ArrayList<SingleList>();
		
		String sqlQuery = "SELECT S.idSingle, S.title, A.name, A.image, M.uri, S.nameGenre FROM single S, remake R, artist A, media M WHERE  R.idRemakeSingle = S.idSingle AND S.idArtist = A.idArtist AND S.idSingle = M.idSingle AND R.idOriginalSingle = ? AND S.type = ? AND M.validityCheck = ? ORDER BY A.name";
		
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, id);
		ps.setString(2, "remake");
		ps.setBoolean(3, true);
		ResultSet rs = ps.executeQuery();
		//result extraction
		while(rs.next() ) {
			Integer idSingle = rs.getInt("idSingle");
			String title = rs.getString("title");
			String name = rs.getString("name"); 
			String image = rs.getString("image");
			String uri = rs.getString("uri");
			String nameGenre = rs.getString("nameGenre");
			//add Single to ArrayList
			SingleList single = new SingleList(idSingle, title, null, name, image, uri, nameGenre);
			coverList.add(single);
			
		}
		rs.close();
		ps.close();
		return coverList;
	}
	
	//********** METHOD to search a user by username **********/
	public String searchUserByUsername(String username, String password) throws SQLException {
		String sqlQuery = "SELECT * FROM user U WHERE  U.username = ?";
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setString(1,  username);
		ResultSet rs = ps.executeQuery();
		//counts the number of row 
		int numRow = 0;
		String message = null;
		while(rs.next() )
			numRow++;
		if (numRow == 0) //not registered user
			message = null;
		if (numRow > 0) //possible sql injection
			message = Message.INJECTION_ATTEMPT_MESSAGE;
		if (numRow == 1) {
			//result extraction
			while(rs.next() ) {
				String pass = rs.getString("password");
				//encrypt password
				SecurePassword sp = new SecurePassword();
				String encPassword = sp.encrypt(password);
				if (pass.equals(encPassword)) //registered user
					message =  Message.SIGNUP_ERROR_MESSAGE;
				if (! pass.equals(encPassword)) //username already in use
					message =  Message.USERNAME_ERROR_MESSAGE;
			}
		}
		rs.close();
		ps.close();	
		return message;
	}
	
	//********** METHOD to register a new user **********/
	public String registerUser(User user) throws SQLException {
		//encrypt password
		SecurePassword sp = new SecurePassword();
		String encPassword = sp.encrypt(user.getPassword());
		//verify that the user is not already registered 
		String existingUser = searchUserByUsername(user.getUsername(), user.getPassword());
		if (existingUser == null) {  //it's possible to register the user
			//Create a new row in table user
			String sqlQuery = "INSERT INTO user (username, password, email, role) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, encPassword);
			ps.setString(3, user.getEmail());
			ps.setString(4,  user.getRole());
			ps.executeUpdate();
			
			//find the last idUser
			Integer idUser = 0;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
			    idUser = rs.getInt(1);
			
			if (user.getRole().equals("artist")) {
				//Create a new row in table artist
				sqlQuery = "INSERT INTO artist (name, idUser) VALUES (?, ?)";
				ps = conn.prepareStatement(sqlQuery);
				ps.setString(1, user.getEmail());
				ps.setInt(2, idUser); //id dell'utente inserito
				ps.executeUpdate();
			}
						
			ps.close();
			return Message.SIGNUP_CONFIRM_MESSAGE;
		}
		else
			return existingUser;
	}
	
	//********** METHOD that authenticate user after login *********/
	public Object authenticateUser(String username, String password) throws SQLException {
		//encrypt password
		SecurePassword sp = new SecurePassword();
		String encPassword = sp.encrypt(password);
		Object obj = null;
		Integer idUser = null;
		String email = null;
		String role = null;
		String sqlQuery = "SELECT * FROM user WHERE username =? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, username);
		ps.setString(2, encPassword);
		ResultSet rs = ps.executeQuery();
		int numRow = 0;
		//count the number of row in resulset
		//it must be 1, otherwise there is a problem
		while(rs.next())  
			numRow++;
		if (numRow > 1)
			obj = new Integer(-1);
		if (numRow == 0)
			obj = new Integer(0);
		if (numRow == 1) {
			//result extraction
			while(rs.next()) { 
				numRow++;
				idUser = rs.getInt("idUser");
				email = rs.getString("email");
				role = rs.getString("role");
			}
			obj = new User(idUser, username, password, email, role);
		}
		return obj;
		
	}
}