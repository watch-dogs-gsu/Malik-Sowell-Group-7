

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFavourite
 */
@WebServlet("/MyFavourite")
public class MyFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFavourite() {
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
		System.out.println(uname);
		ArrayList<String> numbers = new ArrayList<String>();
		ArrayList<String> prices = new ArrayList<String>();
		ArrayList<String> addresses = new ArrayList<String>();
		ArrayList<String> stores = new ArrayList<String>();
		ArrayList<String> products = new ArrayList<String>();
		
		Connection con;
	    Statement statement;
		ResultSet rs1;
		ResultSet rs2;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://teddydatabase.cnigeahsjz2r.us-east-2.rds.amazonaws.com:3306/Watchdogs?serverTimezone=UTC&autoReconnect=true&useSSL=false";
		String user = "Watchdogs";
		String password = "12345678";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			
			statement = con.createStatement();
			String sql1 = "SELECT * FROM Favourite WHERE UserName='"+uname+"'";
			rs1 = statement.executeQuery(sql1);

			while (rs1.next()) {
				System.out.println(rs1.getString("ProductNumber"));
				numbers.add(rs1.getString("ProductNumber"));
			}
			System.out.println(numbers.size());
			for(int i=0; i<numbers.size(); i++) {
				String pnum = numbers.get(i);
				String sql = "SELECT * FROM Price WHERE Number='"+pnum+"'";
				rs2 = statement.executeQuery(sql);
				while (rs2.next()) {
					String price = rs2.getString("Price");
					String product = rs2.getString("product");
					String store = rs2.getString("Store");
					String address = rs2.getString("address");
					System.out.println(address);
					prices.add(price);
					addresses.add(address);
					stores.add(store);
					products.add(product);
				}
				
			}
			request.setAttribute("products",products);
			request.setAttribute("prices", prices);
			request.setAttribute("addresses", addresses);
			request.setAttribute("stores", stores);
			request.getRequestDispatcher("MyFavourite.jsp").forward(request, response);
			
			
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
