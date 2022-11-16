package catering.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import catering.dao.CustomerDAO;
import catering.model.Customer;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        dao = new CustomerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cust = new Customer();
		//retrieve input and set
		cust.setCust_name(request.getParameter("name"));
		cust.setCust_email(request.getParameter("email"));
		cust.setCust_address(request.getParameter("address"));
		cust.setCust_phone(request.getParameter("phone"));
		cust.setCust_password(request.getParameter("password"));
		
		cust = CustomerDAO.getCustomer(cust);
		//check if cust exists
		if(!cust.isValid()){
        		System.out.println("inserting customer");
				try {
					dao.add(cust);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
        	//redirect to login page
        	response.sendRedirect("customerlogin.jsp");
        }	
	 
	
        
	}


