package catering.model;

public class Staff {
	private String staff_id;
	private String staff_name;
	private String staff_address;
	private String staff_phone;
	private String staff_email;
	private String staff_ic;
	private String staff_password;
	public boolean valid;
	
	public Staff() {
		super();
	}

	public Staff(String staff_id, String staff_name, String staff_address, String staff_phone, String staff_email,
			String staff_ic, String staff_password) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_address = staff_address;
		this.staff_phone = staff_phone;
		this.staff_email = staff_email;
		this.staff_ic = staff_ic;
		this.staff_password = staff_password;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}

	public String getStaff_ic() {
		return staff_ic;
	}

	public void setStaff_ic(String staff_ic) {
		this.staff_ic = staff_ic;
	}

	public String getStaff_password() {
		return staff_password;
	}

	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
