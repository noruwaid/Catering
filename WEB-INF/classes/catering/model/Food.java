package catering.model;

public class Food extends Product{
	private String food_type;

	public Food() {
		super();
	}

	public Food(String food_type) {
		super();
		this.food_type = food_type;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
}
