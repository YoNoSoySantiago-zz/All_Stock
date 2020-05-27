package model;

public class Cleaning extends Product{

	private static final long serialVersionUID = 1L;

	public Cleaning(String id, String name, String description, String brand, double price, int cant) {
		super(id, name, description, brand, price, cant,"Others");
	}

}
