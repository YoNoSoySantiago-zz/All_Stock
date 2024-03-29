package model;

import java.util.Arrays;

public class Clothes extends Product {

	private static final long serialVersionUID = 1L;
	
	private double[] sizes;
	private String[] colors;
	
	public Clothes(String id, String name, String description, String brand, double price, int cant,double[] sizes,String[] colors) {
		super(id, name, description, brand, price, cant,"Clothes");
		this.sizes = sizes;
		this.colors=colors;
	}

	public double[] getSizes() {
		return sizes;
	}

	public void setSizes(double[] sizes) {
		this.sizes = sizes;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Clothes"+super.toString()+" [sizes=" + Arrays.toString(sizes) + ", colors=" + Arrays.toString(colors) + "]";
	}
	
	
}
