package catering.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import catering.dao.CustomerDAO;
import catering.model.Customer;


@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
	private static String VIEW_ACCOUNT = "account.jsp";
	private static String UPDATE_ACCOUNT = "accountupdate.jsp";
	private static String MAIN_PAGE = "customerindex.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
		super();
		dao = new CustomerDAO();
	}
	
	String forward;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Customer cust = new Customer();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("currentSessionUser");
		
	
		if (action.equalsIgnoreCase("viewAccount")){
			
			
			System.out.println(email+"Email ada ke tidak?");
			cust = CustomerDAO.getUserByEmail(email);
			
			request.setAttribute("name", cust.getCust_name());
			request.setAttribute("address", cust.getCust_address());
			request.setAttribute("email", cust.getCust_email());
			request.setAttribute("phone", cust.getCust_phone());
			request.setAttribute("password", cust.getCust_password());
			forward = VIEW_ACCOUNT;
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		else if (action.equalsIgnoreCase("updateAccount"))
		{
			cust = CustomerDAO.getUserByEmail(email);
			
			 forward = UPDATE_ACCOUNT;
			 request.setAttribute("customer", cust);
			 request.setAttribute("email", email);
			 request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getCust_address());
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("phone", cust.getCust_phone());
				request.setAttribute("password", cust.getCust_password());
		}

		else {
			forward = MAIN_PAGE;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
	    view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
		
		//call logged in session
		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("currentSessionUser");
		
		//call java class
		Customer cust = new Customer();
		
		//set new information
		cust.setCust_name(request.getParameter("name"));
		cust.setCust_email(email);
		cust.setCust_address(request.getParameter("address"));
		cust.setCust_phone(request.getParameter("phone"));
		cust.setCust_password(request.getParameter("password"));
		
	
	//call update function
	dao.updateAccount(cust);
	response.sendRedirect("/Catering/AccountController?action=viewAccount");
	}

    
}
