package model;

public class Aliments extends Product{

	private static final long serialVersionUID = 1L;
	
	private double weight;
	private String type;
	
	public Aliments(String id, String name, String description, String brand, double price, int cant, double weight,String type) {
		super(id, name, description, brand, price, cant,"Aliments");
		this.weight=weight;
		this.type = type;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
