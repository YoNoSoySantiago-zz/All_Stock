package model;

public abstract class User implements Comparable<User>,Permissions{

	private String id;
	private String name;
	private String idType;
	private String password;
	private String UserType;
	//CHICOS PORQUE LAS CONSTANTES SON ENTEROS (LOS DEMAS VALORES SON STRING) 
	final static String ADMINISTRADOR="Admin";
	final static String EMPLOYEE="Employee";
	final static String CLIENT="Client";
	
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

	
	@Override
	public String toString() {
		return "USUARIO REGISTRADO [ID=" + id + ", Nombre=" + name + ", Tipo de identificacion=" + idType + ", Contraseña=" + password + ", TIPO DE USUARIO="
				+ UserType + "]";
	}


	@Override
	public int compareTo(User otherUser) {
		if(name.compareTo(otherUser.name)>0) {
			
			return 1;
		}if(name.compareTo(otherUser.name)<0) {
			
			return -1;
		}else {
			return 0;
		}

	}
	
	
	
	
	

}
