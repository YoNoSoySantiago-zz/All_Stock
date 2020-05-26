package model;

import java.io.Serializable;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import CustomExceptions.AlreadyProductExistException;
import CustomExceptions.CompanyExistException;
import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;

public class AllStock implements Serializable {
	///////////////////////////////////////////////////////////////////////////////////////
	/*
	 * AUNQUE EL RETORNO ESTE EN VOID LOGICAMENTE ESTO SE CAMBIA DEPENDIENDO COMO LO
	 * NECESITEMOS ASU QUE CAMBIENLO A GUSTO SI ES NECESARIO
	 */

	private static final long serialVersionUID = 1L;
	
	// RELACIONES
	private Company companies;
	private User users;
	private Company actualCompany;
	private int counter;
	
	// CONSTRUCTOR
	public AllStock () {
		users= null;
		//Login Default
		users = new Admin("1234", "admin", "CC", "admin", User.ADMINISTRADOR);
		counter = 0;
		companies = null;
		ArrayList<String> arr =  new ArrayList<String>();
		arr.add("Aliments");
		companies = new Company("CHOCOLIXIE", "121212", "CALI", "3558788", arr);
		actualCompany = null;
	}

	

	
	
	public User getUsers() {
		return users;
	}





	public void setUsers(User users) {
		this.users = users;
	}





	public Company getActualCompany() {
		return actualCompany;
	}





	public void setActualCompany(Company actualCompany) {
		this.actualCompany = actualCompany;
	}





	public void addCompanyList(String name, String nit, String locate, String phone, ArrayList<String> categories) throws ValueIsEmptyException, CompanyExistException {
		
		if (name.isEmpty() || nit.isEmpty() || phone.isEmpty() || locate.isEmpty() || categories.isEmpty()) {
			throw new ValueIsEmptyException();
		}
		
		if(searchCompany(name, nit)!=null) {
			throw new CompanyExistException();
		}
		
		Company nuevo = new Company(name, nit, locate, phone, categories);
		
		if (actualCompany == null) {
			actualCompany = nuevo;
		}else {
			Company aux = actualCompany;
			while (aux.getNextCompany() != null) {
				aux = aux.getNextCompany();
			}
			nuevo.setPrevCompany(aux);
			aux.setNextCompany(nuevo);
		}

	}
	
	//eliminar compania recursiva

	public void DeleteCompany(String nit) {
		if (companies != null) {
			deleteCompanyR(nit, companies);
		}

	}

	public void deleteCompanyR(String nit, Company actualCompany) {

		if (actualCompany != null) {

			if (actualCompany.getNit().equals(nit)) {
				actualCompany.getPrevCompany().setNextCompany(actualCompany.getNextCompany());
				actualCompany.getNextCompany().setPrevCompany(actualCompany.getPrevCompany());
			} else {
				deleteCompanyR(nit, actualCompany.getNextCompany());
			}

		}
	}
	
	//Buscar compania 
	public Company searchCompany(String name, String nit) {
		
		Company searched = null;
		
		if (actualCompany != null) {
			searched = searchCompanyR(name,nit,companies);
		}

		return searched;
	}
	
	
	private Company searchCompanyR(String name, String nit, Company actual) {
		//Si lo encuentra retorna la company actual
		if (actual.getName().equals(name) || actual.getNit().equals(nit)) {
			return actual;
		}
		//Si no la encuentra verifica si la siguiente es null, si no lo es llama de nuevo el metodo
		if(actual.getNextCompany()!=null) {
			return searchCompanyR(name,nit,actual.getNextCompany());
		}
		//Si la verificacion anterior no se cumple quiere decir que llego al final y no lo encontro por lo que retorna null
		return null;
		
	}
		
		
	
	

	// AGREGAR PRODUCT LO MISMO DE ARRIBA
	public void addProduct(String name, String description, String brand, double price, int cant, double weight,
			String type) throws AlreadyProductExistException {
		
		if (searchProductByName(name) == null) {
			String id = generateIdProducts();
			Product nuevo = new Aliments(id, name, description, brand, price, cant, weight, type);
			actualCompany.setCantProducts(actualCompany.getCantProducts()+1);
			if(actualCompany.getRoot()==null)
				actualCompany.setRoot(nuevo);
			else
				actualCompany.getRoot().add(nuevo);
		} else {
			throw new AlreadyProductExistException();
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant, double[] sizes,
			String[] colors) throws AlreadyProductExistException {
		
		if (searchProductByName(name) == null) {
			String id = generateIdProducts();
			Clothes nuevo = new Clothes(id, name, description, brand, price, cant, sizes, colors);
			actualCompany.setCantProducts(actualCompany.getCantProducts()+1);
			if(actualCompany.getRoot()==null)
				actualCompany.setRoot(nuevo);
			else
				actualCompany.getRoot().add(nuevo);
		} else {
			throw new AlreadyProductExistException();
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant) throws  AlreadyProductExistException {
		
		if (searchProductByName(name) == null) {
			String id = generateIdProducts();
			Cleaning nuevo = new Cleaning(id, name, description, brand, price, cant);
			actualCompany.setCantProducts(actualCompany.getCantProducts()+1);
			if(actualCompany.getRoot()==null)
				actualCompany.setRoot(nuevo);
			else
				actualCompany.getRoot().add(nuevo);
		} else {
			throw new AlreadyProductExistException();
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant, String type) throws AlreadyProductExistException {
		if (searchProductByName(name) == null) {
			String id = generateIdProducts();
			Medicines nuevo = new Medicines(id, name, description, brand, price, cant, type);
			actualCompany.setCantProducts(actualCompany.getCantProducts()+1);
			if(actualCompany.getRoot()==null)
				actualCompany.setRoot(nuevo);
			else
				actualCompany.getRoot().add(nuevo);
		} else {
			throw new AlreadyProductExistException();
		}
	}

	public void addProducts(String name, String description, String brand, double price, int cant,
			String[][] characteristics) throws  AlreadyProductExistException {
		
		if (searchProductByName(name) == null) {
			String id = generateIdProducts();
			Others nuevo = new Others(id, name, description, brand, price, cant, characteristics);
			actualCompany.setCantProducts(actualCompany.getCantProducts()+1);
			if(actualCompany.getRoot()==null)
				actualCompany.setRoot(nuevo);
			else
				actualCompany.getRoot().add(nuevo);
		} else {
			throw new AlreadyProductExistException();
		}
	}

	private String generateIdProducts() {
		int aux = 0;
		
		String result = "";
		if (actualCompany != null) {
			aux = actualCompany.getCantProducts();
		}
		if (aux < 10) {
			result = "000" + aux;
		} else if (aux < 100) {
			result = "00" + aux;
		} else if (aux < 1000) {
			result = "0" + aux;
		} else {
			result = "" + aux;
		}
		return result;
	}

	// BUSCAR UN PRODUCTO POR SU NOMBRE
	public Product searchProductByName(String name) {
		Product result = null;
		if(actualCompany.getRoot()!=null) {
			Product current = actualCompany.getRoot();
			while(current!=null&&result==null) {
				if(current.getName().equals(name)) {
					result = current;
				}else {
					if(name.compareToIgnoreCase(current.getName())<1) {
						current = current.getLeft();
					}else {
						current = current.getRight();
					}
				}
			}
		}
		return result;
	}
	//LOS PRODUCTOS ESTAN EN UN ARBOL BINARIO
	// BUSCAR UN PRODUCTO POR SU ID
	public Product searchProductById(String id) {
		Product searched = null;
		if(actualCompany.getRoot()!=null) {
			searched =  searchProductByIdR(id,actualCompany.getRoot());
		}
		return searched;		
	}
	
	private Product searchProductByIdR(String idSearch, Product actual){
		if(actual.getId().equals(idSearch)) {
			return actual;
		}
		Product searched = null;
		if(actual.getLeft()!=null) {
			searched = searchProductByIdR(idSearch,actual.getLeft());
		}
		if(actual.getRight()!=null&&searched==null){
			searched = searchProductByIdR(idSearch,actual.getRight());
		}
		return searched;
	}
	
	
	// ANIADIR UN USUARIO

	public void addUser(String id, String name, String idType, String password, String userType) throws UserExistException{

		
		if (searchUserR(id) == null) {
			User nuevo = null;
			if (userType.equalsIgnoreCase(User.ADMINISTRADOR)) {
				nuevo = new Admin(id, name, idType, password, userType);
			} else if (userType.equalsIgnoreCase(User.EMPLOYEE)) {
				nuevo = new Employee(id, name, idType, password, userType);
			} else if(userType.equalsIgnoreCase(User.CLIENT)){
				nuevo = new Client(id, name, idType, password, userType);
			}
			if(users==null) {
				if(nuevo!=null) {
					users = nuevo;
				}else {
					System.out.println("Error de creacion");
				}
			}else {
				addUserR(nuevo,users);
			}
			
		}else {
				throw new UserExistException();
		}

	}
	private void addUserR(User nuevo,User current) {
		if(current.getNext()==null) {
			current.setNext(nuevo);
		}else {
			addUserR(nuevo,current.getNext());
		}
	}
	
	public void delateUserR(String idName) {
		if(users!=null) {
			delateUserR(idName,users);
		}
	}
	
	private void delateUserR(String idName,User current) {
		if(current!=null) {
			if(current.getName().equals(idName)||current.getId().equals(idName)) {
				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
			}else {
				delateUserR(idName,current.getNext());
			}
		}
	}

	
	public User searchUserR(String idName) {
		User result = searchUserR(users,idName);;
		return result;
	}
	private User searchUserR(User current,String idName) {
		
		if(current!=null && (!current.getId().equals(idName)&&!current.getName().equals(idName))){
			return searchUserR(current.getNext(),idName);
		}
		
		return current;
	}

	
	// BORRA TODOS LOS DATOS ACTUALES PERO GUARDA UNA COPIA EN EL ORDENADOR
	public void reset() {

	}

	// SI EXISTE BORRAR UN PRODUCTO, SOLO PARA EMPLEADOS Y ADMIN
	public void delateProduc(String idName) {
		
	}

	// LOGIN
	public boolean loginUser(String id, String password) throws ValueIsEmptyException {
		boolean validate = false;
		if (!id.isEmpty() && !password.isEmpty()) {
			User user = searchUserR(id);
			if(user!=null) {
				String passwordLogin = user.getPassword();
				validate = passwordLogin.equals(password);
			}

		}else {
			throw new ValueIsEmptyException();
		}
		
		return validate;

	}
	
	private User[] generateUserArray() {
		int cant = 0;
		User current = users;
		while(current!=null) {
			cant++;
			current = current.getNext();
		}
		User[] result = new User[cant];
		current = users;
		int i=0;
		while(current!=null) {
			result[i] = current;
			current = current.getNext();
			i++;
		}
		return result;
	
	}
	
	private Product[] generateProductsArray() {
		Product[] result = new Product[actualCompany.getCantProducts()];
		counter = 0;
		if(actualCompany.getRoot()!=null) {
			result = generateProductsArrayR(result,actualCompany.getRoot());
		}
		return result;
	}
	
	
	private Product[] generateProductsArrayR(Product[] result,Product actual) {
		
		result[counter] = actual;
		counter++;
		if(actual.getLeft()!=null) {
			result = generateProductsArrayR(result,actual.getLeft());
		}
		
		if(actual.getRight()!=null){
			result = generateProductsArrayR(result,actual.getRight());
		}
		return result;
	}
	
	public ArrayList<User> userBubbleSortbyName(){
		User[] users = generateUserArray();
		ArrayList<User> result = new ArrayList<User>();
		for (int i = users.length; i >0; i--) {
			for (int j = 0; j < i-1; j++) {
				int compare =users[j].getName().compareTo(users[j+1].getName());
				if(compare<0) {
					User temp = users[j];
					users[j] = users[j+1];
					users[j+1]=temp;
				}else if(compare ==0) {
					 if(Integer.parseInt(users[j].getId())<Integer.parseInt(users[j+1].getId())) {
						User temp = users[j];
						users[j] = users[j+1];
						users[j+1]=temp;
					 }
				}
			}
		}
		for (int i = 0; i < users.length; i++) {
			result.add(users[i]);
		}
		return result;
	}
	
	public ArrayList<User> userSelectionSortById(){
		User[] users = generateUserArray();
		ArrayList<User> result = new ArrayList<User>();
		for (int i = 0; i < users.length; i++) {
			User less =	users[i];
			int wich = i;
			for (int j = i+1; j < users.length; j++) {
				
				if(Integer.parseInt(users[j].getId())<Integer.parseInt(less.getId())) {
					less = users[j];
					wich = j;
				}
			}
			User temp = users[i];
			users[i] = less;
			users[wich] = temp;
			result.add(less);
		}
		return result;
	}

	public ArrayList<Product> productSelectionSortById(){
		Product[] products = generateProductsArray();
		ArrayList<Product> result = new ArrayList<Product>();
		for (int i = 0; i < products.length; i++) {
			Product less =	products[i];
			int wich = i;
			for (int j = i+1; j < products.length; j++) {
				
				if(Integer.parseInt(products[j].getId())<Integer.parseInt(less.getId())) {
					less = products[j];
					wich = j;
				}
			}
			Product temp = products[i];
			products[i] = less;
			products[wich] = temp;
			result.add(less);
		}
		return result;
	}
	
	public ArrayList<Product> productInsertionSortByName(){
		Product[] products = generateProductsArray();
		ArrayList<Product> result = new ArrayList<Product>();
		System.out.println(products.length);
		
		for (int i = 1; i < products.length; i++) {
			
			Product temp = products[i];
			
			int j = i-1;
			
			while((j>-1) && products[j].getName().compareToIgnoreCase(temp.getName())>=0) {
				products[j+1] = products[j];
				j--;
			}
			products[j+1] = temp;

		}
		
		for(Product p : products) {
			result.add(p);
		}
		
		return result;
	}
	
	// GENEERA UN REPORTE Y LOS GUARDA EN UN ARCHIVO TXT, EL DIRECTORIO ES UNA
	// CONSTANTE
	public void generateReportUsers() throws IOException {
		File file = new File("data/reports/users.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String report = "id type;Nombre;id";
		User current = users;
		while(current!=null) {
			String id = current.getId();
			String name = current.getName();
			String idType = current.getIdType();

			report += "\n" + idType + ";" + name + ";" + id;
			current = current.getNext();
		}
		bw.write(report);
		bw.close();
		Desktop.getDesktop().open(file);
	}

	public void generateIncreasesDecreases() throws IOException {
		File file = new File("data/reports/increases-decreases.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
		LocalDateTime ldt = LocalDateTime.now();
		double result = actualCompany.getCantProductsPrev()-actualCompany.getCantProducts();
		double prev  = actualCompany.getCantProductsPrev();
		result = prev==0?100:result/prev;
		bw.write("\n"+ldt+ ";"+result+"%");
		bw.close();
		Desktop.getDesktop().open(file);
	}

	public void generateCantProducts() throws IOException {
		File file = new File("data/reports/cant-products.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
		LocalDateTime ldt = LocalDateTime.now();
		int cant = actualCompany.getCantProducts();
		bw.write(ldt+";"+cant);
		bw.close();
		Desktop.getDesktop().open(file);
	}
	
	public void generateProducts() throws IOException {
		Product[] products = generateProductsArray();
		File file = new File("data/reports/cant-products.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String result ="";
		for (int i = 0; i < products.length; i++) {
			if(products[i]!=null) {
				result+="\n"+products[i].toString();
			}
		}
		bw.write(result);
		bw.close();
		Desktop.getDesktop().open(file);
	}

	// Genera y retorna los datos necesarios para las graficas de la GUI
	public void generateGraphics() {

	}

}