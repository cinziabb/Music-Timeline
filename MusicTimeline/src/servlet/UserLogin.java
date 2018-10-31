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
import javax.servlet.http.HttpSession;

import database.DbManager;
import pojo.User;
import utils.Message;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PrintWriter writer;
	private DbManager dbm;
	private int loginAttempts;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
    	//open connection to MySQL
    	dbm = new DbManager();
    	conn = dbm.getConn();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientResponse = null;
		Object result = null;
		HttpSession session = null; //session id
		String error = "error";
		//get current session
		session = request.getSession();
		//get the number of logins
		if (session.getAttribute("loginAttempts") == null) 
			loginAttempts = 0;
		if (loginAttempts > 2) 
			clientResponse = Message.BRUTEFORCE_ATTEMPT_MESSAGE;
		else {
			//get the user data
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (conn != null) { //no connection problems
				try {
					result = dbm.authenticateUser(username, password);
					if (result instanceof Integer) {
						if ((Integer) result == 0)  //the user is not registered
							clientResponse = Message.LOGIN_ERROR_MESSAGE;
						else if ((Integer) result < 0) //sql injection attack or code error
							clientResponse = Message.INJECTION_ATTEMPT_MESSAGE;
						session.setAttribute("loginAttempts", loginAttempts++);
					}
					else if (result instanceof User) {//the user is registered
						error = "";
						User user = (User) result;
						clientResponse = Message.LOGIN_CONFIRM_MESSAGE + " " + user.getUsername();
						/* invalidate current session, 
						then get new session (combacts session hijacking) */
						session.invalidate();
						session = request.getSession(true);
						session.setAttribute("idUser", user.getIdUser());
						session.setAttribute("username", user.getUsername());
						session.setAttribute("role", user.getRole());
					}		
				} catch (SQLException e) {
					e.printStackTrace();
					clientResponse = Message.SQL_EXCEPTION_MESSAGE;
				}
			}	
		}
		//create writer
		writer = response.getWriter();
		//send response to the client
		writer.println(clientResponse + error);
	}

}
