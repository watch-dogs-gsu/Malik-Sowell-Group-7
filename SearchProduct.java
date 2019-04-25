

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

import java.util.*;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String product;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		product = request.getParameter("product");
		ArrayList<String> prices = new ArrayList<String>();
		ArrayList<String> addresses = new ArrayList<String>();
		ArrayList<String> stores = new ArrayList<String>();
		ArrayList<String> numbers = new ArrayList<String>();
		
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
			String sql = "SELECT * FROM Price WHERE Product='"+product+"'";
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				
				String price = rs.getString("Price");
				String address = rs.getString("Address");
				String store = rs.getString("Store");
				String num = rs.getString("Number");
				prices.add(price);
				addresses.add(address);
				stores.add(store);
				numbers.add(num);
				
				while (rs.next()) {
					
					price = rs.getString("Price");
					address = rs.getString("Address");
					store = rs.getString("Store");
					num = rs.getString("Number");
					prices.add(price);
					addresses.add(address);
					stores.add(store);
					numbers.add(num);
					
				}

				request.setAttribute("product",product);
				request.setAttribute("prices", prices);
				request.setAttribute("addresses", addresses);
				request.setAttribute("stores", stores);
				request.setAttribute("numbers", numbers);
				request.getRequestDispatcher("ShowPrice.jsp").forward(request, response);
			} else {
				response.sendRedirect("Warning7(ProductNotFound).html");
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
