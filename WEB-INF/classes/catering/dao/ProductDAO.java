package catering.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import catering.connection.ConnectionManager;
import catering.model.Food;
import catering.model.Product;
import catering.model.Service;

public class ProductDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps1=null, ps2=null;
	static Statement stmt=null;
	static String id, name, ptype, ftype, stype, description, email;
	static double price;
	static InputStream image;

	public Product getProduct(Product product) 
	{
		id = product.getProduct_id();

        String searchQuery = "select * from product where product_id='" + id + "'";

        try 
        {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if subject exists set the isValid variable to true
            if (more) 
            {
                product.setValid(true);
           	}
           
            else if (!more) 
            {            	
            	product.setValid(false);
            }
           
        }

        catch (Exception ex) 
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally 
        {
            if (rs != null) 
            {
                try 
                {
                    rs.close();
                } 
                catch (Exception e) {}
                rs = null;
            }

            if (stmt != null) 
            {
                try 
                {
                    stmt.close();
                } 
                catch (Exception e) {}
                stmt = null;
            }

            if (currentCon != null) 
            {
                try 
                {
                    currentCon.close();
                } 
                catch (Exception e) {}

                currentCon = null;
            }
        }

        return product;
	}
	
	public Food getFood(Food food) 
	{
		id = food.getProduct_id();

        String searchQuery = "select * from food where product_id='" + id + "'";

        try 
        {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if subject exists set the isValid variable to true
            if (more) 
            {
                food.setValid(true);
           	}
           
            else if (!more) 
            {            	
            	food.setValid(false);
            }
           
        }

        catch (Exception ex) 
        {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally 
        {
            if (rs != null) 
            {
                try 
                {
                    rs.close();
                } 
                catch (Exception e) {}
                rs = null;
            }

            if (stmt != null) 
            {
                try 
                {
                    stmt.close();
                } 
                catch (Exception e) {}
                stmt = null;
            }

            if (currentCon != null) 
            {
                try 
                {
                    currentCon.close();
                } 
                catch (Exception e) {}

                currentCon = null;
            }
        }

        return food;
	}
	
	public void add(Product product, Food food) 
	{
		
        id = product.getProduct_id();
        name = product.getProduct_name();
        price = product.getProduct_unitPrice();
        ptype = product.getProduct_type();
        image = product.getProduct_image();
        ftype = food.getFood_type();
 
    	try 
    	{
    		currentCon = ConnectionManager.getConnection();
    		System.out.print("ok");
    		ps1=currentCon.prepareStatement("insert into product (product_id, product_name, product_unitprice, product_type, product_image)values(?,?,?,?,?)");
    		ps2=currentCon.prepareStatement("insert into food (product_id, food_type)values(?,?)");
    		System.out.print("ok22");
    		
    		ps1.setString(1,id);
    		ps1.setString(2,name);
    		ps1.setDouble(3,price);
    		ps1.setString(4,ptype);
    		if (image != null) {
                ps1.setBlob(5, image);
            }
            
    		ps1.executeUpdate();
    		
    		ps2.setString(1,id);
    		ps2.setString(2,ftype);
    		
    		ps2.executeUpdate();
    		
    		System.out.println("Id is " + id);
			System.out.println("Name is " + name);
    		System.out.println("Price is " + price);
    		System.out.println("Product Type is " + ptype);
    		System.out.println(image);
    		System.out.println("Food Type is " + ftype);
    	}

    	catch (Exception ex) 
    	{
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally 
    	{
    		if (ps1 != null) 
    		{
    			try 
    			{
    				ps1.close();
    			} catch (Exception e) {}
    			ps1 = null;
    		}
    		
    		if (currentCon != null) 
    		{
    			try 
    			{
    				currentCon.close();
    			} catch (Exception e) {}
    			currentCon = null;
    		}
    	}
	}
	
	public void add(Product product, Service service) 
	{
		
        id = product.getProduct_id();
        name = product.getProduct_name();
        price = product.getProduct_unitPrice();
        ptype = product.getProduct_type();
        image = product.getProduct_image();
        stype = service.getService_type();
        description = service.getService_description();
       
    	try 
    	{
    		currentCon = ConnectionManager.getConnection();
    		ps1=currentCon.prepareStatement("insert into product (product_id, product_name, product_unitprice, product_type, product_image)values(?,?,?,?,?)");
    		ps2=currentCon.prepareStatement("insert into service (product_id, service_type, service_description)values(?,?,?)");
    		
    		ps1.setString(1,id);
    		ps1.setString(2,name);
    		ps1.setDouble(3,price);
    		ps1.setString(4,ptype);
    		if (image != null) {
                ps1.setBlob(5, image);
            }
    		ps1.setString(5,email);
    		ps1.executeUpdate();
    	
    		ps2.setString(1,id);
    		ps2.setString(2,stype);
    		ps2.setString(3,description);
    		
    		ps2.executeUpdate();
    		
    		System.out.println("Id is " + id);
			System.out.println("Name is " + name);
    		System.out.println("Price is " + price);
    		System.out.println("Product Type is " + ptype);
    		System.out.println(image);
    		System.out.println("Service Type is " + stype);
    		System.out.println("Service Description is " + description);
    	}

    	catch (Exception ex) 
    	{
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

    	finally 
    	{
    		if (ps1 != null) 
    		{
    			try 
    			{
    				ps1.close();
    			} catch (Exception e) {}
    			ps1 = null;
    		}
    		
    		if (currentCon != null) 
    		{
    			try 
    			{
    				currentCon.close();
    			} catch (Exception e) {}
    			currentCon = null;
    		}
    	}
	}
	
	public List<Product> getAllNasi() throws IOException 
	{
		List<Product> nasi = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from food join product using (product_id) where food_type = 'Nasi'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		          Product product = new Product();		          
		          
		          product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          nasi.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return nasi;
	}
	
	public List<Product> getAllDaging() throws IOException 
	{
		List<Product> daging = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from food join product using (product_id) where food_type = 'Daging'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Product product = new Product();		          
		          
		    	  product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          daging.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return daging;
	}
	
	public List<Product> getAllAyam() throws IOException 
	{
		List<Product> ayam = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from food join product using (product_id) where food_type = 'Ayam'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Product product = new Product();		          
		          
		    	  product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          ayam.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return ayam;
	}
	
	public List<Product> getAllSayur() throws IOException 
	{
		List<Product> sayur = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from food join product using (product_id) where food_type = 'Sayur'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Product product = new Product();		          
		          
		    	  product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          sayur.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return sayur;
	}
	
	public List<Product> getAllMinuman() throws IOException 
	{
		List<Product> minuman = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from food join product using (product_id) where food_type = 'Minuman'";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		    	  Product product = new Product();		          
		          
		    	  product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          minuman.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return minuman;
	}
	
	public List<Product> getAllService() throws IOException 
	{
		List<Product> service = new ArrayList<Product>();
		  
		  try 
		  {
		  	currentCon = ConnectionManager.getConnection();
		  	stmt = currentCon.createStatement();
		  
		  	  String q = "select * from service join product using (product_id)";
		      ResultSet rs = stmt.executeQuery(q);
		      
		      while (rs.next()) 
		      {
		          Product product = new Product();		          
		          
		          product.setProduct_id(rs.getString("product_id"));
		          product.setProduct_name(rs.getString("product_name"));
		          product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
		          
		          Blob blob = rs.getBlob("product_image");
		          InputStream inputStream = blob.getBinaryStream();
		          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		          byte[] buffer = new byte[4096];
		          int bytesRead = -1;
		          while ((bytesRead = inputStream.read(buffer)) != -1) {
		              outputStream.write(buffer, 0, bytesRead);
		          }
		          byte[] imageBytes = outputStream.toByteArray();
		          String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		          inputStream.close();
		          outputStream.close();
		          product.setBase64Image(base64Image);
		          
		          service.add(product);
		      }
		  } 
		  catch (SQLException e) 
		  {
		      e.printStackTrace();
		  }

		  return service;
	}
	
	public Product getProductByProduct_id(String id) throws IOException
	{
		Product product = new Product();

        try 
        {
            currentCon = ConnectionManager.getConnection();
            ps1 = currentCon.prepareStatement("select * from product where product_id = ?");
            
            ps1.setString(1, id);
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) 
            {
            	product.setProduct_id(rs.getString("product_id"));
            	product.setProduct_name(rs.getString("product_name"));
            	product.setProduct_unitPrice(rs.getDouble("product_unitPrice"));
            	product.setProduct_type(rs.getString("product_type"));
                
                Blob blob = rs.getBlob("product_image");
		        InputStream inputStream = blob.getBinaryStream();
		        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		        byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		        while ((bytesRead = inputStream.read(buffer)) != -1) {
		            outputStream.write(buffer, 0, bytesRead);
		        }
		        byte[] imageBytes = outputStream.toByteArray();
		        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		        inputStream.close();
		        outputStream.close();
		        product.setBase64Image(base64Image);
           	}
        }

        catch (SQLException e) 
        {
        	e.printStackTrace();
        }

        return product;
	}
	
	public void updateProduct(Product p) 
	{
		id = p.getProduct_id();
        name = p.getProduct_name();
        price = p.getProduct_unitPrice();
        ptype = p.getProduct_type();
        image = p.getProduct_image();
        
        String searchQuery = "UPDATE product SET product_name = '" + name + "', product_unitPrice = '" + price + "' WHERE product_id = '" + id + "'";
        
        try
        {
        	currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery); 
        }
        
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
	}
	
	public void deleteProduct(String product_id) 
	{
		String searchQuery1 = "delete from food where product_id = " + "'" + product_id + "'";
		String searchQuery2 = "delete from product where product_id = " + "'" + product_id + "'";
		System.out.println(searchQuery1);
		System.out.println(searchQuery2);
		
		try 
		{
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery1); 
	        stmt.executeUpdate(searchQuery2);
	    } 
		
		catch (SQLException e) 
		{
	        e.printStackTrace();
	    }
	}
	
	public void deleteService(String product_id) 
	{
		String searchQuery1 = "delete from service where product_id = " + "'" + product_id + "'";
		String searchQuery2 = "delete from product where product_id = " + "'" + product_id + "'";
		System.out.println(searchQuery1);
		System.out.println(searchQuery2);
		
		try 
		{
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery1); 
	        stmt.executeUpdate(searchQuery2); 
	    } 
		
		catch (SQLException e) 
		{
	        e.printStackTrace();
	    }
	}
	
	
}
