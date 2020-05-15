package model;

public class Admin extends User{

	public Admin(String id, String name, String idType, String password, String userType) {
		super(id, name, idType, password, userType);
	}

	@Override
	public boolean toAddDelate() {
		return true;
	}

	@Override
	public boolean totalAccess() {

		return true;
	}
	

}
