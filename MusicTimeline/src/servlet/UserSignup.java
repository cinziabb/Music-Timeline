package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbManager;
import pojo.User;
import utils.Message;

/**
 * Servlet implementation class UserSignin
 */
@WebServlet("/UserSignup")
public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PrintWriter writer;
	private DbManager dbm;
	private boolean error;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignup() {
    	//open connection to MySQL
    	dbm = new DbManager();
    	conn = dbm.getConn();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientResponse = null;
		//get the user data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Boolean artist = Boolean.parseBoolean(request.getParameter("artist"));
		String role = null;
		String result = null;
		
		if (conn != null) { //no connection problems
			if (artist == true)
				role = "artist";
			else
				role = "user";
			try {
				User user = new User(username, password, email, role);
				result = dbm.registerUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
				error = true;
				clientResponse = Message.SQL_EXCEPTION_MESSAGE;
			}
			if (! error)
				clientResponse = result;
		}
		//create writer
		writer = response.getWriter();
		//send response to the client
		writer.println(clientResponse); 
	}

}
