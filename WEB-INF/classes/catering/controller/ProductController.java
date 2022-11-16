package catering.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import catering.dao.ProductDAO;
import catering.model.Food;
import catering.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
@MultipartConfig(maxFileSize = 16177215)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String MAIN_PAGE = "adminIndex.html";
	private static String LIST_PRODUCT = "shop.jsp";
	private static String LIST_ADMIN_PRODUCT = "adminShop.jsp";
	private static String LIST_CUSTOMER_PRODUCT = "customerShop.jsp";
	private static String LIST_ORDER_PRODUCT = "order.jsp";
	private static String UPDATE_PRODUCT = "updateProduct.jsp";
	
	private ProductDAO daoProduct;
	
	String forward="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        daoProduct = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listProduct")) 
		{
			forward = LIST_PRODUCT;
            request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else if (action.equalsIgnoreCase("listAdminProduct")) 
		{
			forward = LIST_ADMIN_PRODUCT;
            request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else if (action.equalsIgnoreCase("listCustomerProduct")) 
		{
			forward = LIST_CUSTOMER_PRODUCT;
            request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else if (action.equalsIgnoreCase("listOrderProduct")) 
		{
			forward = LIST_ORDER_PRODUCT;
			request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else if (action.equalsIgnoreCase("updateProduct"))
		{
			String product_id = request.getParameter("product_id");
			Product product = new Product();
			product = daoProduct.getProductByProduct_id(product_id);
			forward = UPDATE_PRODUCT;
			request.setAttribute("product", product);
		}
		
		else if (action.equalsIgnoreCase("deleteProduct"))
		{
			String product_id = request.getParameter("product_id");
			daoProduct.deleteProduct(product_id);
			forward = LIST_ADMIN_PRODUCT;
			request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else if (action.equalsIgnoreCase("deleteService"))
		{
			String product_id = request.getParameter("product_id");
			daoProduct.deleteService(product_id);
			forward = LIST_ADMIN_PRODUCT;
			request.setAttribute("nasi", daoProduct.getAllNasi());	
            request.setAttribute("daging", daoProduct.getAllDaging());
            request.setAttribute("ayam", daoProduct.getAllAyam());
            request.setAttribute("sayur", daoProduct.getAllSayur());
            request.setAttribute("minuman", daoProduct.getAllMinuman());
            request.setAttribute("services", daoProduct.getAllService());
		}
		
		else 
		{
			forward = MAIN_PAGE;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String product_name = request.getParameter("product_name");
		double product_unitPrice = Double.parseDouble(request.getParameter("product_unitPrice"));
		String product_type = request.getParameter("product_type");
		String food_type = request.getParameter("food_type");
		
		InputStream product_image = null;
		Part filePart = request.getPart("product_image");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            product_image = filePart.getInputStream();
        }
        
		Product product = new Product(product_id, product_name, product_unitPrice, product_type, product_image);
		Food food = new Food(food_type);
		
		product = daoProduct.getProduct(product);
	
		if(!product.isValid())
		{			
			System.out.println("inserting product");   	
        	daoProduct.add(product, food);
        	response.sendRedirect("/Catering/ProductController?action=listAdminProduct");
        }
		
		else
		{
        	System.out.println("Product already exist");        	        	
        	daoProduct.updateProduct(product);

			request.setAttribute("product", daoProduct.getProductByProduct_id(product_id));
			response.sendRedirect("/Catering/ProductController?action=listAdminProduct");
        }
	}

}
