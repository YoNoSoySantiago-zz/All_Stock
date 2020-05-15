package model;

public class Others extends Product {
	private String[][] characteristics;
	public Others(String id, String name, String description, String brand, double price, int cant,String[][]characteristocs) {
		super(id, name, description, brand, price, cant);
		this.setCharacteristics(characteristocs);
	}
	public String[][] getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String[][] characteristics) {
		this.characteristics = characteristics;
	}

}
