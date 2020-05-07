package model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllStock {
	
	//RELACIONES
   
	private SortedSet<User> users;
	
// agregar usuario en orden	
	public AllStock() {
		
		Comparator c = new comparatorUser();
		
		users = new TreeSet<User>();
		
		
		
		
	}
	
	
	public void addUser(String id, String name, String idType, String password, String userType){
		
	}
	
	
	//metodo para agregar al diagrama
	
	public void removeUser(String id) {
		
		
	}


}
