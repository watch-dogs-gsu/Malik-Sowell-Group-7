

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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String fname;
	public static String lname;
	public static String uname;
	public static String pword;
	public static String email;
	public static String street;
	public static String city;
	public static String state;
	public static String zipcode;
	public static String address;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		uname = request.getParameter("uname");
		pword = request.getParameter("pword");
		email = request.getParameter("email");
		street = request.getParameter("street");
		city = request.getParameter("city");
		state = request.getParameter("state");
		zipcode = request.getParameter("zipcode");
		
		if (fname==null||lname==null||uname==null||pword==null||email==null||street==null||city==null||state==null||zipcode==null) {
			response.sendRedirect("Warning1(emptyfeild).html");
		} else {
			address = street + " , " + city + " , " + state + " " + zipcode;
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
				String sql1 = "Select * from User WHERE UserName = '"+uname+"'";
				rs = statement.executeQuery(sql1);
				if (rs.next()) {
					response.sendRedirect("Warning2(uname).html");
				} else {
					String sql2 = "INSERT INTO User VALUES('"+uname+"','"+lname+"','"+fname+"','"+pword+"','"+email+"','"+street+"','"+city+"','"+state+"','"+zipcode+"')";
					statement.executeUpdate(sql2);
					response.sendRedirect("Actions.html");
				}
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Success!");
			}
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
