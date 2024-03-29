package model;

public class Medicines extends Product {

	private static final long serialVersionUID = 1L;
	
	private String type;
	public Medicines(String id, String name, String description, String brand, double price, int cant,String type) {
		super(id, name, description, brand, price, cant,"Medicines");
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Medicines "+super.toString()+ "[type=" + type + "]";
	}

}
