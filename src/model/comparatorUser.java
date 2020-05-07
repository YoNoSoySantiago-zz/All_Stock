package model;

public class comparatorUser implements Comparable<User>{

	public int compare(User o1, User o2) {
		if(o1.getName().compareTo(o2.getName())==0) {
			return o1.getUserType().compareTo(o2.getUserType());
		}
		return o1.getName().compareTo(o2.getName());
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
