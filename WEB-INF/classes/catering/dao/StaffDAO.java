package catering.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import catering.connection.ConnectionManager;
import catering.model.Staff;

public class StaffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static Staff login(Staff staff) { 
		// preparing some objects for connection 
		System.out.println("JIJIJI"); 
		Statement stmt = null;
		
		String staff_email = staff.getStaff_email(); 
		String staff_password = staff.getStaff_password(); 
		
		String searchQuery = "select * from staff where staff_email='" + staff_email + "' AND staff_password='" + staff_password + "'";
		
		// "System.out.println" prints in the console; Normally used to trace the process 
		System.out.println("Your Email is " + staff_email); 
		System.out.println("Your password is " + staff_password); 
		System.out.println("Query: " + searchQuery); 
		
		try { 
			// connect to DB 
			currentCon = ConnectionManager.getConnection(); 
			stmt = currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			boolean more = rs.next(); 
			
			// if user does not exist set the isValid variable to false 
			if (!more) { 
				System.out.println("Sorry, you are not staff! Please login in customer section"); 
				staff.setValid(false); 
				} 
			
			// if user exists set the isValid variable to true 
			else if (more) { 
				String staff_name = rs.getString("staff_name");
 
				
				System.out.println("Welcome " + staff_name); 
				staff.setStaff_name(staff_name); 
				staff.setValid(true); 
				} 
			} 
		
		catch (Exception ex) { 
			System.out.println("Log In failed: An Exception has occurred! " + ex); 
			} 
		
		// some exception handling 
		finally { 
			if (rs != null) { 
				try { 
					rs.close(); 
					} catch (Exception e) {
					} 
				rs = null; 
				} 
			
			if (stmt != null) { 
				try { 
					stmt.close(); 
					} catch (Exception e) { 
					} 
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
		return staff; 
		}
}
