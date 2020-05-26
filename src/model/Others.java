package model;

import java.util.Arrays;

public class Others extends Product {
	
	private String[][] characteristics;
	public Others(String id, String name, String description, String brand, double price, int cant,String[][]characteristics) {
		super(id, name, description, brand, price, cant);
		this.setCharacteristics(characteristics);
	}
	public String[][] getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String[][] characteristics) {
		this.characteristics = characteristics;
	}
	
	@Override
	public String toString() {
		return "Others"+super.toString()+" [characteristics=" + Arrays.toString(characteristics) + "]";
	}

}
