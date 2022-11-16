package catering.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import catering.dao.CustomerDAO;
import catering.dao.StaffDAO;
import catering.model.Customer;
import catering.model.Staff;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	try { 
		Staff staff = new Staff(); 
		staff.setStaff_email(request.getParameter("staff_email")); 
		staff.setStaff_password(request.getParameter("staff_password")); 
		
		staff = StaffDAO.login(staff); 
		
		if (staff.isValid()) { 
			HttpSession session = request.getSession(true); 
			session.setAttribute("currentSessionStaff", staff); 
			response.sendRedirect("adminIndex.html"); // logged-in page 
			} 
		
		else 
			response.sendRedirect("adminInvalidLogin.jsp"); // error page 
		} 
	
	catch (Throwable theException) { 
		System.out.println(theException); 
		}
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
                       throws ServletException, java.io.IOException {

try
{       

     Customer cust = new Customer();
     cust.setCust_email(request.getParameter("email"));
     cust.setCust_password(request.getParameter("password"));
 
   

     cust = CustomerDAO.login(cust);
                  
     if (cust.isValid())
     {
         
    	 	HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", cust.getCust_email()); //set current session based on email
			//response.sendRedirect("/custExample/home.jsp"); // logged-in page
			request.setAttribute("cust", CustomerDAO.getUserByEmail(cust.getCust_email()));   //to retrieve user info 
			
			Cookie ck=new Cookie("email",cust.getCust_email());//creating cookie object  
		    response.addCookie(ck);
		    
			RequestDispatcher view = request.getRequestDispatcher("/customerindex.jsp"); // logged-in page
			view.forward(request, response);  
			
     }
     else 
			response.sendRedirect("invalidLogin.jsp"); // error page 
}
       
       
catch (Throwable theException)        
{
     System.out.println(theException);
}
       }
    }  