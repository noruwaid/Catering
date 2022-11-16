package catering.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import catering.connection.ConnectionManager;
import catering.model.Cart;
import catering.model.Order;


public class CartDAO {
	private static ArrayList<Order> cartItems = new ArrayList<Order>();
	private double orderTotal;
	private double eachamount;
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps1=null, ps2=null,ps3=null;
	static Statement stmt=null;
	static String email, address, product_id, date, orderstatus, cust_id;
	static int orderid;
	int quantity;
	double totalamount;
	
	public int getLineItemCount() {
		return cartItems.size();
	}
	
	//TO DELETE CART LIST IN THE CART.JSP
	public void deleteCartItem(String itemIndex) {
		int strItemIndex=0;;
		try {
			strItemIndex=Integer.parseInt(itemIndex);
			cartItems.remove(strItemIndex-1);
			calculateOrderTotal();
		} catch(NumberFormatException nfe) {
			System.out.println("Error while deleting cart item!"+nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	//TO UPDATE QUANTITY CART LIST IN THE CART.JSP
	public void updateCartItem(String ItemIndex, String quantity) {	
		try {
			double totalCost=0.0;
			double unitCost=0.0;
			int qtty=0;
			int strItemIndex=0;
			Order orderItem= null;
			
			try {
				strItemIndex=Integer.parseInt(ItemIndex);
				qtty=Integer.parseInt(quantity);
				if(qtty>0) {
					orderItem=(Order)cartItems.get(strItemIndex-1);
					unitCost =orderItem.getUnitPrice();
					totalCost=unitCost*qtty;
					orderItem.setOrderQtty(qtty);
					orderItem.setTotalamount(totalCost);
					calculateOrderTotal();
				}
			}catch (NumberFormatException nfe) {
				System.out.println("Error while updating cart:"+nfe.getMessage());
				nfe.printStackTrace();
			}
		}catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart:"+nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	//TO ADD PRODUCT INSIDE THE ARRAY LIST 
	public void addCartItem(String product_id, String product_name, String prodPrice, String quantity, String product_image) {
		double totalCost=0.0;
		double unitCost=0.0;
		int qtty=0;
		Order orderItem = new Order();
		
		try {
			unitCost= Double.parseDouble(prodPrice);
			qtty=Integer.parseInt(quantity);
			if(qtty>0) {
				totalCost= unitCost*qtty;
				orderItem.setProduct_id(product_id);
				orderItem.setProduct_name(product_name);
				orderItem.setUnitPrice(unitCost);
				orderItem.setOrderQtty(qtty);
				orderItem.setTotalamount(totalCost);
				orderItem.setBase64Image(product_image);
				cartItems.add(orderItem);
				calculateOrderTotal();
				System.out.println("testttttttttttttttttt"+cartItems);
			}
		} catch(NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types:"+nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	
	public void addCartItem(Order orderItem) {
		cartItems.add(orderItem);
	}
	
	public Order getCartItem(int strproduct_id) {
		Order orderItem = null;
		if(cartItems.size()>strproduct_id) {
			orderItem=(Order) cartItems.get(strproduct_id);
		}
		return orderItem;
	}
	
	public ArrayList<Order> getCartItems() {
		return cartItems;
	}
	
	public void setCartItems(ArrayList<Order> cartItems) {
		this.cartItems= cartItems;
	}
	
	public double getEachamount() {
		return eachamount;
	}
	
	public void setEachamount(double eachamount) {
		this.eachamount=eachamount;
	}
	
	public double getOrderTotal() {
		return orderTotal;
	}
	
	public void setOrderTotal(double orderTotal) {
		this.orderTotal=orderTotal;
	}
	
	//TO CALCULATE TOTAL ORDER 
	protected void calculateOrderTotal() {
		double total=0;
		for(int counter=0;counter<cartItems.size();counter++) {
			Order orderItem=(Order) cartItems.get(counter);
			total+=orderItem.getTotalamount();
		}
		setOrderTotal(total);
	}
	
	
	
	public void add(String cust_id, String date, String address, String product_id, int quantity, Double ta, String ItemIndex) 
	{
		Cart cart = new Cart();
		Order orderItem= null;
	
		orderstatus="Processing";
		
		cart.setProduct_id(product_id);
		cart.setOrderQtty(quantity);
		cart.setTotalamount(ta);
		cart.setDate(date);
		cart.setAddress(address);
		cart.setCust_email(cust_id);
        
		int strItemIndex=0;
		strItemIndex=Integer.parseInt(ItemIndex);
		
		
        System.out.print(product_id+ quantity+ address+ date + cust_id+ ta +orderstatus);
        
      
		try 
    	{		//inserting the ORDER TABLE
	    		currentCon = ConnectionManager.getConnection();
	    		ps1=currentCon.prepareStatement("insert into orders (order_totalamount, order_date, order_address, order_status, cust_email)values(?,to_date(?,'yyyy-mm-dd'),?,?,?)");
	    		ps1.setDouble(1,ta);
	    		ps1.setString(2,date);
	    		ps1.setString(3,address);
	    		ps1.setString(4,orderstatus);
	    		ps1.setString(5,cust_id);
	    		ps1.executeUpdate();
	    		System.out.print("You have inserted the order");
    		
	    		//TO GET ORDER_ID
    		ps2=currentCon.prepareStatement("select * from orders where cust_email=? and to_char(order_date,'yyyy-mm-dd')=?");
    		ps2.setString(1,cust_id);
    		ps2.setString(2,date);
    		ResultSet rs = ps2.executeQuery();
    		System.out.print("You have search....");
            
            if (rs.next()) 
            {
            	cart.setOrderid(rs.getInt("order_id"));
            }
    		
            orderid = cart.getOrderid();
		    System.out.print("BETA" + orderid);
           
		    //TO INSERT DATA INTO ORDERITEMS TABLE DATABASE
    		ps3=currentCon.prepareStatement("insert into orderdetail (order_id, product_id, product_unitquantity)values(?,?,?)");

    		
    		System.out.print("BRAVO");
    		for (Order items : cartItems) {
    			for(int counter=0; counter<cartItems.size();counter++)
    			{
    				ps3.setInt(1, orderid);
        			System.out.print(orderid);
        			
    			}
	    			ps3.setString(2,items.getProduct_id());
	    			
	    			ps3.setInt(3, items.getOrderQtty());
	    			
	    			System.out.print("You have inserted the orderitem");		
	    			ps3.executeUpdate();
    		}
    		
    		
    	}

    	catch (Exception ex) 
    	{
    		System.out.println("failed: An Exception has occurred! " + ex);
    	}

	}
}
