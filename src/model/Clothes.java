package model;

public class Clothes extends Product {
	private double[] sizes;
	private String[] colors;
	
	public Clothes(String id, String name, String description, String brand, double price, int cant,double[] sizes,String[] colors) {
		super(id, name, description, brand, price, cant);
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
	

}
