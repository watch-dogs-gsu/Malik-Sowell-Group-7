

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrievePassword
 */
@WebServlet("/RetrievePassword")
public class RetrievePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String uname;
	public static String pword;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		uname = request.getParameter("uname");
		
		Connection con;
	    Statement statement;
		ResultSet rs;
	    
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://teddydatabase.cnigeahsjz2r.us-east-2.rds.amazonaws.com:3306/Watchdogs?serverTimezone=UTC&autoReconnect=true&useSSL=false";
		String user = "Watchdogs";
		String password = "12345678";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			statement = con.createStatement();
			String sql = "SELECT * FROM User WHERE UserName='"+uname+"'";
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				pword = rs.getString("Password");
				request.setAttribute("yourPword",pword);
				request.getRequestDispatcher("RetrievePassword.jsp").forward(request, response);
			} else {
				response.sendRedirect("Warning3(wrongUname).html");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Success!");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
