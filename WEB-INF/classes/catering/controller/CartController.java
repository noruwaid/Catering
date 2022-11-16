package catering.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catering.dao.CartDAO;
import catering.model.Order;

/**
 * Servlet implementation class CustomerController
 */

@WebServlet("/CartController")
public class CartController extends HttpServlet {

	//public static final String addToCart

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strAction = request.getParameter("action");

		if(strAction!=null && !strAction.equals("")) {
			if(strAction.equalsIgnoreCase("add")) {
				addToCart(request);
			} else if (strAction.equalsIgnoreCase("Update")) {
				updateCart(request);
			} else if (strAction.equalsIgnoreCase("Delete")) {
				deleteCart(request);
			}
				
		response.sendRedirect("cart.jsp");
			}
	}

	protected void deleteCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String itemIndex = request.getParameter("itemIndex");
		CartDAO cartBean = null;

		Object objCartBean = session.getAttribute("cart");
		if(objCartBean!=null) {
			cartBean = (CartDAO) objCartBean ;
		} else {
			cartBean = new CartDAO();
		}
		cartBean.deleteCartItem(itemIndex);
	}

	protected void updateCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String strItemIndex = request.getParameter("itemIndex");
		String quantity = request.getParameter("quantity");
		
		CartDAO cartBean = null;

		Object objCartBean = session.getAttribute("cart");
		if(objCartBean!=null) {
			cartBean = (CartDAO) objCartBean ;
		} else {
			cartBean = new CartDAO();
		}
		cartBean.updateCartItem(strItemIndex, quantity);
	}

	protected void addToCart(HttpServletRequest request) {
		ArrayList<Order> cartItems = new ArrayList<Order>();
		HttpSession session = request.getSession();
	    
		String prodId = request.getParameter("product_id");
		String prodName = request.getParameter("product_name");
		String prodPrice = request.getParameter("product_unitPrice");
		String qtty = request.getParameter("quantity");
		String prodImage = request.getParameter("product_image");

		System.out.println(prodId+ prodName+prodPrice+qtty);
		
		CartDAO cartBean = null;

		Object objCartBean = session.getAttribute("cart");

		if(objCartBean!=null) {
			cartBean = (CartDAO) objCartBean ;
		} else {
			cartBean = new CartDAO();
			session.setAttribute("cart", cartBean);
		}

		cartBean.addCartItem(prodId, prodName, prodPrice, qtty, prodImage);
	}
	
}