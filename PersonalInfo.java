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
 * Servlet implementation class PersonalInfo
 */
@WebServlet("/PersonalInfo")
public class PersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String uname = login.uname;
		String pword = login.pword;
		String lname = null;
		String fname = null;
		String email = null;
		String address = null;
		
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
			String sql = "SELECT * FROM User WHERE UserName='"+uname+"' AND Password='"+pword+"'";
			rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				lname = rs.getString("LastName");
				fname = rs.getString("FirstName");
				email = rs.getString("Email");
				address = rs.getString("street")+" , "+rs.getString("city")+" , "+rs.getString("state")+" "+rs.getString("Zip Code");
			} else {}
			System.out.println(lname);
			System.out.println(fname);
			System.out.println(email);
			request.setAttribute("uname",uname);
			request.setAttribute("lname",lname);
			request.setAttribute("fname",fname);
			request.setAttribute("email",email);
			request.setAttribute("address",address);
			request.getRequestDispatcher("PersonalInfo.jsp").forward(request, response);
			
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
