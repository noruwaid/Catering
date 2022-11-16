package catering.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering.dao.CartDAO;
import catering.dao.CustomerDAO;
import catering.model.Customer;


@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_CHECKOUT = "checkout.jsp";
	private static String MAIN_PAGE = "customerindex.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutController() {
		super();
	
	}
	
	String forward;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Customer cust = new Customer();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("currentSessionUser");
		
	
		if (action.equalsIgnoreCase("view")){
			
			
			System.out.println(email+"Email ada ke tidak?");
			cust = CustomerDAO.getUserByEmail(email);
			
			request.setAttribute("name", cust.getCust_name());
			request.setAttribute("email", cust.getCust_email());
			forward = VIEW_CHECKOUT;
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}

		else {
			forward = MAIN_PAGE;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
	    view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		{
			
			HttpSession session = request.getSession();
			String email =(String) session.getAttribute("currentSessionUser");
			
			//call java class
			String strItemIndex = request.getParameter("itemIndex");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String address = request.getParameter("address");
			String product_id = request.getParameter("product_id");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			
			System.out.print(name + date +address +product_id+quantity);
			Double ta = Double.parseDouble(request.getParameter("orderTotal"));
			System.out.print(ta);
			//set new information
			
			
			
			CartDAO dao = new CartDAO();
			dao.add(email, date, address, product_id, quantity, ta, strItemIndex);
			response.sendRedirect("/Catering/OrderController?action=listCustomerOrder");
		}
		}
    
}
