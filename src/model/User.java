package model;

public class User {
	

	private String id;
	private String name;
	private String idType;
	private String password;
	private String UserType;
	
	
	
	public User(String id, String name, String idType, String password, String userType) {
	
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.password = password;
		UserType = userType;
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
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	
	
	
	
	

}
