package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.DbManager;
import pojo.SingleList;
import utils.Message;

/**
 * Servlet implementation class SearchSingles
 */
@WebServlet(description = "Search all the singles for a specified year", urlPatterns = { "/SearchSingles" })
public class SearchSingles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PrintWriter writer;
	private String message;
	private DbManager dbm;
	private ArrayList<SingleList> singleList;
	private boolean error;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSingles() {
    	//open connection to MySQL
		dbm = new DbManager();
		conn = dbm.getConn();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientResponse = null;
		//get the selected year
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		if (conn != null) { //no connection problems
			try {
				singleList = dbm.searchSinglesByYear(year);
			} catch (SQLException e) {
				e.printStackTrace();
				error = true;
				message = Message.SQL_EXCEPTION_MESSAGE;
			}
			//Encodes the Java object in JSON format
			Gson gson = new Gson();
			if (error)
				clientResponse = gson.toJson(message);
			else
				clientResponse = gson.toJson(singleList);
			response.setContentType("application/json");
		}
		//create writer
		writer = response.getWriter();
		//send response to the client
		writer.println(clientResponse); 
	}

}
