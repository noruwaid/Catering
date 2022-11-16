package catering.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catering.dao.OrderDAO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/StaffOrderController")
@MultipartConfig(maxFileSize = 16177215)
public class StaffOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "adminIndex.html";
	private static String LIST_ORDER = "vieworders.jsp";
	private static String LIST_ALLORDER = "ListofCustomersOrder.jsp";
	
	private OrderDAO daoOrder;
	
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffOrderController() {
        super();
        daoOrder = new OrderDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("ListofCustomersOrder")) 
		{
			forward = LIST_ALLORDER;
            request.setAttribute("pending", daoOrder.viewPendingOrder());	
            request.setAttribute("confirmed", daoOrder.viewConfirmOrder());	
            request.setAttribute("cancellations", daoOrder.viewCancellationOrder());
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

			//CANCEL FOR STAFF
			if (action.equalsIgnoreCase("Delete")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				daoOrder.deleteOrder(order_id);
				
				forward = LIST_ORDER;
				
			}
			//UPDATE ORDER STATUS FOR STAFF
			else if (action.equalsIgnoreCase("Update")) 
			{
				int order_id = Integer.parseInt(request.getParameter("orderid"));
				System.out.print(order_id);
				daoOrder.confirmOrder(order_id);
				
				forward = LIST_ORDER;
				
			}
			
			response.sendRedirect("/Catering/StaffOrderController?action=ListofCustomersOrder");
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
