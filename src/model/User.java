package model;

import java.io.Serializable;

public abstract class User implements Comparable<User>,Permissions, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String idType;
	private String password;
	private String userType;
	
	private User next;
	private User prev;
	//CHICOS PORQUE LAS CONSTANTES SON ENTEROS (LOS DEMAS VALORES SON STRING) 
	public final static String ADMINISTRADOR="Admin";
	public final static String EMPLOYEE="Employee";
	public final static String CLIENT="Client";
	
	public User(String id, String name, String idType, String password, String userType) {
		this.userType = userType;
		this.id = id;
		this.name = name;
		this.idType = idType;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "USUARIO REGISTRADO ID: " + id + ", Nombre: " + name + ", Tipo de Usuario: " + idType + ", Contraseña: " + password ;
	}


	public User getNext() {
		return next;
	}


	public void setNext(User next) {
		this.next = next;
	}


	public User getPrev() {
		return prev;
	}


	public void setPrev(User prev) {
		this.prev = prev;
	}


	public String getUserType() {
		return userType;
	}
}
