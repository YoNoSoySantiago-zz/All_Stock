package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name; 
	private String nit;
	private String locate;
	private String phone;
	private ArrayList<String> categories;
	
	private Company nextCompany;
	private Company prevCompany;
	
	private Product root;
	
	private int cantProductsPrev;
	private int cantProducts;
	
	public Company(String name, String nit, String locate, String phone, ArrayList<String> categories) {
		super();
		this.name = name;
		this.nit = nit;
		this.locate = locate;
		this.phone = phone;
		this.categories = categories;
		root = null;
		
		setCantProducts(0);
		setCantProductsPrev(0);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getLocate() {
		return locate;
	}
	
	public void setLocate(String locate) {
		this.locate = locate;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public ArrayList<String> getCategories() {
		return categories;
	}

	public Company getNextCompany() {
		return nextCompany;
	}

	public void setNextCompany(Company nextCompany) {
		this.nextCompany = nextCompany;
	}

	public Company getPrevCompany() {
		return prevCompany;
	}

	public void setPrevCompany(Company prevCompany) {
		this.prevCompany = prevCompany;
	}

	public int getCantProducts() {
		return cantProducts;
	}

	public void setCantProducts(int cantProducts) {
		this.cantProducts = cantProducts;
	}

	public int getCantProductsPrev() {
		return cantProductsPrev;
	}

	public void setCantProductsPrev(int cantProductsPrev) {
		this.cantProductsPrev = cantProductsPrev;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public Product getRoot() {
		return root;
	}

	public void setRoot(Product root) {
		this.root = root;
	}



}
