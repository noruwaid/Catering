package catering.model;

import java.io.InputStream;

public class Product {
	private String product_id;
	private String product_name;
	private double product_unitPrice;
	private String product_type;
	private String base64Image;
	private InputStream product_image;
	public boolean valid;
	
	public Product() {
		super();
	}

	public Product(String product_id, String product_name, double product_unitPrice, String product_type,
			InputStream product_image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_unitPrice = product_unitPrice;
		this.product_type = product_type;
		this.product_image = product_image;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_unitPrice() {
		return product_unitPrice;
	}

	public void setProduct_unitPrice(double product_unitPrice) {
		this.product_unitPrice = product_unitPrice;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
