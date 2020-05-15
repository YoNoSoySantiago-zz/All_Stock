package model;

public class Medicines extends Product {
	private String type;
	public Medicines(String id, String name, String description, String brand, double price, int cant,String type) {
		super(id, name, description, brand, price, cant);
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
