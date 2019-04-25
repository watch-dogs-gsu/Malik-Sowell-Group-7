

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
 * Servlet implementation class AddFavourite
 */
@WebServlet("/AddFavourite")
public class AddFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String fnumber;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFavourite() {
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
		String product = SearchProduct.product;
		fnumber = request.getParameter("favourite");
		System.out.println(fnumber);
		
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
			String sql1 = "SELECT * FROM Favourite WHERE UserName='"+uname+"' AND ProductNumber='"+fnumber+"'";
			rs = statement.executeQuery(sql1);
			
			if (rs.next()) {
				response.sendRedirect("Warning8(Added).html");
			} else {
				String sql2 = "SELECT * FROM Price WHERE Number='"+fnumber+"'";
				rs = statement.executeQuery(sql2);	

				String sql3 = "INSERT INTO Favourite VALUES('"+uname+"','"+fnumber+"')";
				statement.executeUpdate(sql3);
				response.sendRedirect("Warning9(Suc Added).html");
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
