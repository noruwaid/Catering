package catering.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import catering.connection.ConnectionManager;
import catering.model.Order;

public class OrderDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps1=null, ps2=null;
	static Statement stmt=null, stmt1=null, stmt2=null;
	static String  name, ptype, ftype, stype, description, email, date, address, pid;
	static double price, totalamount;
	static int id, quantity;
	static InputStream image;
	
	//VIEW ORDERS FOR CUSTOMERS
	public List<Order> getPendingOrderByCustomer(String cust_id) throws IOException 
	{
		
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Processing' and cust_email='" + cust_id +"'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public List<Order> getConfirmedOrderByCustomer(String cust_id) throws IOException 
	{
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Confirmed' and cust_email='" + cust_id +"'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public List<Order> getCancellationOrderByCustomer(String cust_id) throws IOException 
	{
		
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
			  
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Request' and cust_email='" + cust_id +"'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public void updateCancellationOrderByCustomer(int order_id) {
	
		System.out.print("test");
		String searchQuery = "UPDATE orders SET order_status='Request' where order_id="+order_id;
		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.prepareStatement("select * from orders where order_id="+order_id);
		  	stmt.executeUpdate(searchQuery);
		  	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	
	//VIEW ORDERS BY ADMIN
	public List<Order> viewPendingOrder() throws IOException 
	{
		
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Processing'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public List<Order> viewConfirmOrder() throws IOException 
	{
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Confirmed'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public List<Order> viewCancellationOrder() throws IOException 
	{
		
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
			  
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from orders where order_status='Request'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setDate(rs.getString("order_date"));
		    	  order.setOrderstatus(rs.getString("order_status"));
		         
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	public void confirmOrder(int order_id) {
		
		System.out.print("test");
		String searchQuery = "UPDATE orders SET order_status='Confirmed' where order_id="+order_id;
		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.prepareStatement("select * from orders where order_id="+order_id);
		  	stmt.executeUpdate(searchQuery);
		  	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	
	public void deleteOrder(int order_id) {
		String searchQuery1 = "delete from orders where order_id = " + "'" + order_id + "'";
		String searchQuery2 = "delete from orderdetail where order_id = " + "'" + order_id + "'";
		System.out.println(searchQuery1);
		System.out.println(searchQuery2);
		
		try 
		{
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery1); 
	        stmt.executeUpdate(searchQuery2);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}

	public Order getViewOrder(int order_id) {
		Order order = new Order();
		System.out.print("order_id");
		try {

		  	currentCon = ConnectionManager.getConnection();
			PreparedStatement ps = currentCon.prepareStatement("select * from customer join orders using(cust_email) where order_id=?");

			ps.setInt(1, order_id);
			ResultSet rs = ps.executeQuery();
		  
		  	
		  	 while (rs.next()) 
		      {
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setCust_email(rs.getString("cust_email"));	
		    	  order.setCust_name(rs.getString("cust_name"));	
		    	  order.setDate(rs.getString("order_date"));	
		    	  order.setAddress(rs.getString("order_address"));	
		    	  order.setTotalamount(Double.parseDouble(rs.getString("order_totalamount")));	
		      }
		  	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	
	}
	
	public List<Order> viewlistofeachorder(int orderid) throws IOException 
	{
		System.out.print("MARIAAAA" +orderid);
		List<Order> orders = new ArrayList<Order>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  		double totalcost=0;
		  	  String q = "select * from customer join orders using(cust_email) join orderdetail using (order_id) join product using (product_id) where order_id="+orderid;
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Order order = new Order();
		    	  order.setOrderid(rs.getInt("order_id"));
		    	  order.setProduct_id(rs.getString("product_id"));	
		    	  order.setProduct_name(rs.getString("product_name"));	
		    	  order.setOrderQtty(rs.getInt("product_unitQuantity"));	
		    	  order.setUnitPrice(rs.getDouble("product_unitPrice"));	
		    	  totalcost= order.getOrderQtty()*order.getUnitPrice();
		    	  order.setTotalamount(totalcost);
		          orders.add(order);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return orders;
	}
	
	public void updateOrder(int order_id, String date, String address) {
		
		System.out.print("\nOrder ID: "+order_id+"\n");
		System.out.print("Date: "+date+"\n");
		System.out.print("Address: "+address+"\n");
		System.out.print("test");
		String searchQuery1 = "UPDATE orders SET order_date = to_date('"+ date +"','yyyy-mm-dd'), order_address = '"+ address +"' where order_id='"+order_id+"'";
		
		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt1 = currentCon.prepareStatement("select * from orders where order_id="+order_id);
		  	stmt1.executeUpdate(searchQuery1);
		  	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	}
}
