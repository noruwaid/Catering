package catering.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import catering.dao.ProductDAO;
import catering.model.Product;
import catering.model.Service;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/ServiceController")
@MultipartConfig(maxFileSize = 16177215)
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO daoProduct;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
        super();
        daoProduct = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_id = request.getParameter("product_id");
		String product_name = request.getParameter("product_name");
		double product_unitPrice = Double.parseDouble(request.getParameter("product_unitPrice"));
		String product_type = request.getParameter("product_type");
		String service_type = request.getParameter("service_type");
		String service_description = request.getParameter("service_description");
		
		InputStream product_image = null;
		Part filePart = request.getPart("product_image");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            product_image = filePart.getInputStream();
        }
        
		Product product = new Product(product_id, product_name, product_unitPrice, product_type, product_image);
		Service service = new Service(service_type, service_description);
		
		product = daoProduct.getProduct(product);
		
		if(!product.isValid())
		{			
			System.out.println("inserting product");   	
        	daoProduct.add(product, service);
        	response.sendRedirect("/Catering/ProductController?action=listAdminProduct");
        }
	}

}
