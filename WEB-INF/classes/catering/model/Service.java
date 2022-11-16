package catering.model;

public class Service extends Product{
	private String service_type;
	private String service_description;
	
	public Service() {
		super();
	}

	public Service(String service_type, String service_description) {
		super();
		this.service_type = service_type;
		this.service_description = service_description;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getService_description() {
		return service_description;
	}

	public void setService_description(String service_description) {
		this.service_description = service_description;
	}
}
