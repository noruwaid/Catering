package catering.dao;


import java.security.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import catering.connection.ConnectionManager;
import catering.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class CustomerDAO {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String email, name,address, phone, password;

	//method for login
	public static Customer login(Customer bean) throws NoSuchAlgorithmException{
		///preparing some objects for connection
        
		   
  	  email = bean.getCust_email();
        password = bean.getCust_password();
     
       String searchQuery =
             "select * from CUSTOMER where CUST_EMAIL='" + email + "' AND CUST_PASSWORD='" + password+ "'";
     
    try
    {
       //connect to DB
       currentCon = ConnectionManager.getConnection();
       stmt=currentCon.createStatement();
       rs = stmt.executeQuery(searchQuery);           
       boolean more = rs.next();
        
       
       if (more)
       {
          bean.setValid(true);
       }
    // if user does not exist set the isValid variable to false
       else if (!more)
       {
          System.out.println("Sorry, you are not a registered user! Please sign up first" + email + password);
          bean.setValid(false);
       }
         
       //if user exists set the isValid variable to true
       
    }

    catch (Exception ex)
    {
       System.out.println("Log In failed: An Exception has occurred! " + ex);
    }
     
    //some exception handling
    finally
    {
       if (rs != null)    {
          try {
             rs.close();
          } catch (Exception e) {}
             rs = null;
          }
 
       if (stmt != null) {
          try {
             stmt.close();
          } catch (Exception e) {}
             stmt = null;
          }
 
       if (currentCon != null) {
          try {
             currentCon.close();
          } catch (Exception e) {
          }

          currentCon = null;
       }
    }

return bean;
 
    }

	//add new user (register)
	public void add(Customer bean) throws NoSuchAlgorithmException{
		
		//get email,firstname,lastname and password
		email = bean.getCust_email();
		name = bean.getCust_name();
		address = bean.getCust_address();
		phone = bean.getCust_phone();
		password = bean.getCust_password();

		try {
			//create connection
			currentCon = ConnectionManager.getConnection();
			//create statement
			ps=currentCon.prepareStatement("insert into customer(cust_name, cust_email, cust_address, cust_phone,cust_password)"
					+ "values(?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,address);
			ps.setString(4,phone);
			ps.setString(5,password);
			//execute statement
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//method to get user
	public static Customer getCustomer(Customer bean)  {   
		//get email
		email = bean.getCust_email();
		
		String searchQuery = "select * from customer where cust_email='" + email + "'";
		try {
			//create connection
			currentCon = ConnectionManager.getConnection();
			//create statement
			stmt = currentCon.createStatement();
			//execute statement
			rs = stmt.executeQuery(searchQuery);

			boolean more = rs.next();

			// if user exists set the isValid variable to true
			if (more) {
				System.out.println("Sorry, you are a registered user! Please login" + email + password + address + phone + name);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first" + email + password + address + phone + name);
				bean.setValid(false);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	//get user by email
	public static Customer getUserByEmail(String email) {
		Customer cust = new Customer();
		try {
			System.out.print(email);
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from customer where cust_email=?");

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				cust.setCust_name(rs.getString("cust_name"));
				cust.setCust_email(rs.getString("cust_email"));
				cust.setCust_address(rs.getString("cust_address"));
				cust.setCust_phone(rs.getString("cust_phone"));
				cust.setCust_password(rs.getString("cust_password"));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cust;
	}
	
	public void updateAccount(Customer bean) {
		email = bean.getCust_email();
		name = bean.getCust_name();
		address = bean.getCust_address();
		phone = bean.getCust_phone();
		password = bean.getCust_password();
		System.out.println(phone);
		String searchQuery = "UPDATE customer SET cust_name='" + name + 
				 "', cust_address='" + address + "' , cust_phone='" + phone + "', cust_password='" + password +"' where cust_email='"+ email +"'"; 
		
		try {
			currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  	stmt.executeUpdate(searchQuery);
		  	System.out.println("Customer details have been updated....");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
