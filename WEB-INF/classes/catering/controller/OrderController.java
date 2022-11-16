package catering.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering.dao.CartDAO;
import catering.dao.OrderDAO;
import catering.model.Order;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/OrderController")
@MultipartConfig(maxFileSize = 16177215)
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "adminIndex.html";
	private static String LIST_ORDER = "vieworders.jsp";
	private static String EACH_ORDER = "vieweachorder.jsp";
	private static String CUSTOMEREACH_ORDER = "viewcustomereachorder.jsp";
	private static String INVOICE = "customerinvoice.jsp";
	private static String CUSTOMERINVOICE = "invoice.jsp";
	private static String LIST_ALLORDER = "ListofCustomersOrder.jsp";
	private static String UPDATE_EACH_ORDER = "updateVieweachorder.jsp";
	private static String ADMIN_EACH_ORDER = "adminVieweachorder.jsp";
	private static String ADMIN_UPDATE_EACH_ORDER = "adminUpdateVieweachorder.jsp";
	
	private OrderDAO daoOrder;
	
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        daoOrder = new OrderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("currentSessionUser");
		
		//CUSTOMER VIEW
		if (action.equalsIgnoreCase("listCustomerOrder")) 
		{
			forward = LIST_ORDER;
            request.setAttribute("pending", daoOrder.getPendingOrderByCustomer(email));	
            request.setAttribute("confirmed", daoOrder.getConfirmedOrderByCustomer(email));	
            request.setAttribute("cancellations", daoOrder.getCancellationOrderByCustomer(email));
		}
		else if (action.equalsIgnoreCase("ListofCustomersOrder")) 
		{
			forward = LIST_ALLORDER;
            request.setAttribute("pending", daoOrder.viewPendingOrder());	
            request.setAttribute("confirmed", daoOrder.viewConfirmOrder());	
            request.setAttribute("cancellations", daoOrder.viewCancellationOrder());
		}
		
			else if (action.equalsIgnoreCase("customer")) //view customer order for customer
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = EACH_ORDER;
				

			}
			else if (action.equalsIgnoreCase("invoice")) //view customer invoice for customer
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = INVOICE;
				

			}
			else if (action.equalsIgnoreCase("customerorder")) //view customer order for admin
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = CUSTOMEREACH_ORDER;
				

			}
			else if (action.equalsIgnoreCase("customerinvoice")) //view customer invoice for admin
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = CUSTOMERINVOICE;
				

			}
		
			else if (action.equalsIgnoreCase("updateViewEachOrder"))
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = UPDATE_EACH_ORDER;
			}
			
			else if (action.equalsIgnoreCase("adminCustomer")) //view customer order for admin
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = ADMIN_EACH_ORDER;
			}
		
			else if (action.equalsIgnoreCase("adminUpdateViewEachOrder"))
			{
				Order cust = new Order();
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				cust =  daoOrder.getViewOrder(order_id);
				request.setAttribute("email", cust.getCust_email());
				request.setAttribute("name", cust.getCust_name());
				request.setAttribute("address", cust.getAddress());
				request.setAttribute("orderid", cust.getOrderid());
				request.setAttribute("date", cust.getDate());
				request.setAttribute("total", cust.getTotalamount());
	            request.setAttribute("view", daoOrder.viewlistofeachorder(order_id));	
				forward = ADMIN_UPDATE_EACH_ORDER;
			}
		
			else 
		{
			forward = MAIN_PAGE;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		{
			
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
			String email =(String) session.getAttribute("currentSessionUser");
			
			//CANCEL FOR CUSTOMER
			if (action.equalsIgnoreCase("cancel")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				daoOrder.updateCancellationOrderByCustomer(order_id);
				
				forward = LIST_ORDER;
				response.sendRedirect("/Catering/OrderController?action=listCustomerOrder");
			}
			//UPDATE ORDER STATUS FOR STAFF
			else if (action.equalsIgnoreCase("Update")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				daoOrder.confirmOrder(order_id);
				
				forward = LIST_ORDER;
				response.sendRedirect("/Catering/OrderController?action=listCustomerOrder");
			}
			
			else if (action.equalsIgnoreCase("Confirm")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				String date = request.getParameter("date");
				String address = request.getParameter("address");
				System.out.print(order_id);
				
				daoOrder.updateOrder(order_id, date, address);
				
				forward = UPDATE_EACH_ORDER;
				response.sendRedirect("/Catering/OrderController?action=listCustomerOrder");
			}
			
			else if (action.equalsIgnoreCase("Submit")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				String date = request.getParameter("date");
				String address = request.getParameter("address");
				System.out.print(order_id);
				
				daoOrder.updateOrder(order_id, date, address);
				
				forward = ADMIN_UPDATE_EACH_ORDER;
				response.sendRedirect("/Catering/OrderController?action=adminCustomer&orderid="+order_id);
			}
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
