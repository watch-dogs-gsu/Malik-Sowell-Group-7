

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
 * Servlet implementation class ChangeEmail
 */
@WebServlet("/ChangeEmail")
public class ChangeEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String newEmail;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmail() {
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
		newEmail = request.getParameter("email");
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
			
			if(!con.isClosed()) {
				System.out.println("Succeed conncet to database.");
			}
			statement = con.createStatement();
			String sql = "SELECT UserName FROM User WHERE UserName='"+uname+"'";
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				String sql2= "UPDATE User SET Email='"+newEmail+"' WHERE UserName='"+uname+"'";
				statement.executeUpdate(sql2);
				response.sendRedirect("Warning5(Suc update).html");
			} else {
				response.sendRedirect("Warning4(wrongUname).html");
			}
			
		} catch (ClassNotFoundException E) {
			System.out.println("Sorry, can't find the Driver!");
			E.printStackTrace();
      
		} catch (SQLException E) {
			E.printStackTrace();
      
		} catch (Exception E) {
			E.printStackTrace();
      
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
