package model;

import java.io.Serializable;

public abstract class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String description;
	private String brand;
	private double price;
	private int cant;
	
	private Product right;
	private Product left;
	
	public Product(String id, String name, String description, String brand, double price, int cant) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.cant = cant;
	}
	
	public void add(Product product) {
		if(product.getName().compareToIgnoreCase(name)<1) {
			if(left!=null) {
				left.add(product);
			}else {
				left = product;
			}
		}else {
			if(right!=null) {
				right.add(product);
			}else {
				right=product;
			}
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCant() {
		return cant;
	}
	
	public void setCant(int cant) {
		this.cant = cant;
	}

	public Product getRight() {
		return right;
	}

	public void setRight(Product right) {
		this.right = right;
	}

	public Product getLeft() {
		return left;
	}

	public void setLeft(Product left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", description: " + description
				+ ", brand: " + brand + ", price: " + price + ", cant: " + cant;
	}


}
