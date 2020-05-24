package model;

public class Employee extends User{

	
	public Employee(String id, String name, String idType, String password, String userType) {
		super(id, name, idType, password, userType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean toAddDelate() {
		return true;
	}

	@Override
	public boolean totalAccess() {
		return false;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
