package model;
import model.User;

import java.util.Comparator;

public class NameComparator implements  Comparator <User>{
	@Override
	public int compare(User user1, User user2) {
		
		int comparator;
		
		// agregar el tpo de usuario
		
		String name1=user1.getName();
		String name2=user2.getName();
		
		
		if (name1.compareTo(name2) <0) {
			comparator=-1;
			
		}else if (name1.compareTo(name2)>0) {
			comparator=1;
		}else {
			comparator=0;
		}
		return comparator;
	
		
	}

	

}
