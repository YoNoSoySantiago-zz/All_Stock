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

	@Override
	public int compareTo(User arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
