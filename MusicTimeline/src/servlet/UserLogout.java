package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DbManager;
import utils.Message;

/**
 * Servlet implementation class UserLogout
 */
@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PrintWriter writer;
	private DbManager dbm;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogout() {
    	//open connection to MySQL
    	dbm = new DbManager();
    	conn = dbm.getConn();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null; //session id
		//get current session
		session = request.getSession();
		//invalidate session
		session.invalidate();
		//create writer
		writer = response.getWriter();
		//send response to the client
		writer.println(Message.LOGOUT_MESSAGE);
	}

}
