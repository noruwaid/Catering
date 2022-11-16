package catering.model;

import java.io.InputStream;
import java.util.ArrayList;

public class Cart {
	private ArrayList<Order> cartItems;
    private int orderid;
    public String product_id;
    public String staff_id;
    public String cust_email;
	public String product_name;
	public String date;
	public String address;
	public int orderQtty;
	public double unitPrice;
	private String base64Image;
	private InputStream product_image;
	public double totalamount;
	public boolean valid;
     
	public Cart() {
		super();
	}

	public Cart(int orderid, String product_id, String staff_id, String cust_email, String product_name,
			String date, String address, int orderQtty, double unitPrice, double totalamount, boolean valid) {
		super();
		this.orderid = orderid;
		this.product_id = product_id;
		this.staff_id = staff_id;
		this.cust_email = cust_email;
		this.product_name = product_name;
		this.date = date;
		this.address = address;
		this.orderQtty = orderQtty;
		this.unitPrice = unitPrice;
		this.totalamount = totalamount;
		this.valid = valid;
	}

	public int getOrderid() {
		return orderid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public String getCust_email() {
		return cust_email;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getDate() {
		return date;
	}

	public String getAddress() {
		return address;
	}

	public int getOrderQtty() {
		return orderQtty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public boolean isValid() {
		return valid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrderQtty(int orderQtty) {
		this.orderQtty = orderQtty;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public InputStream getProduct_image() {
		return product_image;
	}

	public void setProduct_image(InputStream product_image) {
		this.product_image = product_image;
	}
	public ArrayList<Order> getCartItems() {
		return cartItems;
	}
}

	
