package catering.model;

public class Customer {
 
 private String name;
 private String email;
 private String phone;
 private String address;
 private String password;
 public boolean valid;
 
 
public String getCust_name() {
	return name;
}
public String getCust_email() {
	return email;
}
public String getCust_phone() {
	return phone;
}
public String getCust_address() {
	return address;
}
public String getCust_password() {
	return password;
}
public boolean isValid() {
	return valid;
}
public void setCust_name(String name) {
	this.name = name;
}
public void setCust_email(String email) {
	this.email = email;
}
public void setCust_phone(String phone) {
	this.phone = phone;
}
public void setCust_address(String address) {
	this.address = address;
}
public void setCust_password(String password) {
	this.password = password;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
 
}
 
