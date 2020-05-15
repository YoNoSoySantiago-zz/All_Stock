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
   
	
	
// agregar usuario en orden	
	public AllStock() {
		
	
		
		
		
	}
	
	
	
	
	
	public void sortByName() {
		
		Comparator<User> namecomparator= new NameComparator();
		
		//List<User>list.sortByName();
	}
	
	
	
public void addUser (NodeUser ns) {
		NodeUser node = NodeUser((new User(getid, name, idType, password, UserType)));
		if (getFirst()== null) {
			first = node;
		} else {
			NodeUser aux = first;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			node.setPrevious(aux);
			aux.setNext(node);
		}
	}

	
	
	//metodo para agregar al diagrama
	
	public void removeUser(String id) {
		
		
	}


}
