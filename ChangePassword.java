

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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String uname = request.getParameter("uname");
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("newPw");
		
		Connection con;
	    Statement statement;
	    ResultSet rs;
	    ResultSet rs2;
	    
	    String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://teddydatabase.cnigeahsjz2r.us-east-2.rds.amazonaws.com:3306/Watchdogs?serverTimezone=UTC&autoReconnect=true&useSSL=false";
		String user = "Watchdogs";
		String password = "12345678";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			if(!con.isClosed()) {
				System.out.println("Succeed conncet to database.");
			}
			statement = con.createStatement();
			String sql = "SELECT UserName, Password FROM User WHERE UserName='"+uname+"' AND Password='"+oldPw+"'";
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				String sql2= "UPDATE User SET Password='"+newPw+"' WHERE UserName='"+uname+"'";
				statement.executeUpdate(sql2);
				response.sendRedirect("Warning5(Suc update).html");
			} else {
				response.sendRedirect("Warning6(uname pw not match).html");
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
