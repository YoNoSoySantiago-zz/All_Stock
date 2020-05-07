package model;

public class Company{
	
	private String name; 
	
	private String nit;
	private String locate;
	private String phone;
	private String category;
	
	public Company(String name, String nit, String locate, String phone, String category) {
		super();
		this.name = name;
		this.nit = nit;
		this.locate = locate;
		this.phone = phone;
		this.category = category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
