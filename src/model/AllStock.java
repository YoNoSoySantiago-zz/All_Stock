package model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllStock {
	
	//RELACIONES
   
	private SortedSet<User> users;
	
	
LinkedList<User> usuarios;
	
// agregar usuario en orden	
	public AllStock() {
		
	
		
		LinkedList<User> usuarios = new LinkedList<>();
		
		
	}
	
	
	
	
	
	public void sortByName() {
		
		Comparator<User> namecomparator= new NameComparator();
		
		//List<User>list.sortByName();
	}
	
	
	public void addUser(String id, String name, String idType, String password, String userType){
		  
	
		
		  usuarios.addAll(new LinkedList<User>());
	}
	
	
	//metodo para agregar al diagrama
	
	public void removeUser(String id) {
		
		
	}


}
