package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import CustomExceptions.AlreadyProductExistException;
import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;

public class AllStock {
	///////////////////////////////////////////////////////////////////////////////////////
	/*
	 * AUNQUE EL RETORNO ESTE EN VOID LOGICAMENTE ESTO SE CAMBIA DEPENDIENDO COMO LO
	 * NECESITEMOS ASU QUE CAMBIENLO A GUSTO SI ES NECESARIO
	 */

	// RELACIONES
	private Company companies;
	private User users;
	private Company actualCompany;

	// RELACIONES
	public AllStock() {
		users = null;
		companies = null;
		actualCompany = null;
	}

	public void sortByName() {

		Comparator<User> namecomparator = new NameComparator();
		// List<User>list.sortByName();
	}

	public void removeUser(String id) {

	}

	//// AGREGAR COMPAÑIA VERIFICAR SI NO EXISTE Y LOS PARAMETROS OBLIGATORIOS ESTEN
	public void addCompany(String name, String nit, String locate, String phone, String category)
			throws ValueIsEmptyException {

		if (name.isEmpty() || nit.isEmpty() || locate.isEmpty() || category.isEmpty()) {

			throw new ValueIsEmptyException();
		} else {
			Company nueva = new Company(name, nit, locate, phone, category);
			companies.add(nueva);
		}
	}

	// AGREGAR PRODUCT LO MISMO DE ARRIBA
	public void addProduct(String name, String description, String brand, double price, int cant, double weight,
			String type) throws ValueIsEmptyException, AlreadyProductExistException {
		if (name.isEmpty() || description.isEmpty() || brand.isEmpty() || brand.isEmpty() || type.isEmpty()
				|| price <= 0 || cant < 0) {
			throw new ValueIsEmptyException();
		} else {
			if (searchProduct(name) == null) {
				String id = generateIdProducts();
				Product nuevo = new Aliments(id, name, description, brand, price, cant, weight, type);
				actualCompany.getProducts().add(nuevo);
			} else {
				throw new AlreadyProductExistException();
			}
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant, double[] sizes,
			String[] colors) throws ValueIsEmptyException, AlreadyProductExistException {
		if (name.isEmpty() || description.isEmpty() || brand.isEmpty() || brand.isEmpty() || price <= 0 || cant < 0
				|| sizes.length == 0 || colors.length == 0) {
			throw new ValueIsEmptyException();
		} else {
			if (searchProduct(name) == null) {
				String id = generateIdProducts();
				Product nuevo = new Clothes(id, name, description, brand, price, cant, sizes, colors);
				actualCompany.getProducts().add(nuevo);
			} else {
				throw new AlreadyProductExistException();
			}
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant)
			throws ValueIsEmptyException, AlreadyProductExistException {
		if (name.isEmpty() || description.isEmpty() || brand.isEmpty() || brand.isEmpty() || price <= 0 || cant < 0) {
			throw new ValueIsEmptyException();
		} else {
			if (searchProduct(name) == null) {
				String id = generateIdProducts();
				Product nuevo = new Cleaning(id, name, description, brand, price, cant);
				actualCompany.getProducts().add(nuevo);
			} else {
				throw new AlreadyProductExistException();
			}
		}
	}

	public void addProduct(String name, String description, String brand, double price, int cant, String type)
			throws ValueIsEmptyException, AlreadyProductExistException {
		if (name.isEmpty() || description.isEmpty() || brand.isEmpty() || brand.isEmpty() || type.isEmpty()
				|| price <= 0 || cant < 0 || type.isEmpty()) {
			throw new ValueIsEmptyException();
		} else {
			if (searchProduct(name) == null) {
				String id = generateIdProducts();
				Product nuevo = new Medicines(id, name, description, brand, price, cant, type);
				actualCompany.getProducts().add(nuevo);
			} else {
				throw new AlreadyProductExistException();
			}
		}
	}

	public void addProducts(String name, String description, String brand, double price, int cant,
			String[][] characteristics) throws ValueIsEmptyException, AlreadyProductExistException {
		if (name.isEmpty() || description.isEmpty() || brand.isEmpty() || brand.isEmpty() || price <= 0 || cant < 0) {
			throw new ValueIsEmptyException();
		} else {
			if (searchProduct(name) == null) {
				String id = generateIdProducts();
				Product nuevo = new Others(id, name, description, brand, price, cant, characteristics);
				actualCompany.getProducts().add(nuevo);
			} else {
				throw new AlreadyProductExistException();
			}
		}
	}

	private String generateIdProducts() {
		int aux = 0;
		String result = "";
		if (actualCompany != null) {
			if (actualCompany.getProducts().size() > 0) {
				String aux2 = actualCompany.getProducts().get(actualCompany.getProducts().size() - 1).getId();
				aux = Integer.parseInt(aux2) + 1;
			}
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

	// BUSCAR UN PRODUCTO POR SU ID o NOMBRE
	public Product searchProduct(String idName) {
		Product result = null;
		for (int i = 0; i < actualCompany.getProducts().size() && result == null; i++) {
			if (actualCompany.getProducts().get(i).getId().equals(idName)
					|| actualCompany.getProducts().get(i).getName().equals(idName)) {
				result = actualCompany.getProducts().get(i);
			}
		}
		return result;
	}

	// AÑADIR UN USUARIO
	// JAJAJA PACHON EXPLICA CON COMENTARIOS QUE NO SE ENTIENDE NI VERGA
	public void addUser(String id, String name, String idType, String password, String userType) throws UserExistException {
		if (searchUserR(id) == null) {
			User nuevo;
			if (id.equals(User.ADMINISTRADOR)) {
				nuevo = new Admin(id, name, idType, password, userType);
			} else if (id.equals(User.EMPLOYEE)) {
				nuevo = new Employee(id, name, idType, password, userType);
			} else {
				nuevo = new Client(id, name, idType, password, userType);
			}
			if(users==null) {
				users = nuevo;
			}
			addUserR(nuevo,users);
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
			searchUserR(current.getNext(),idName);
		}
		return current;
	}

	// BORRA TODOS LOS DATOS ACTUALES PERO GUARDA UNA COPIA EN EL ORDENADOR
	public void reset() {

	}

	// SI EXISTE BORRAR UN PRODUCTO, SOLO PARA EMPLEADOS Y ADMIN
	public void delateProduc(String idName) {
		for (int i = 0; i < actualCompany.getProducts().size(); i++) {
			if (actualCompany.getProducts().get(i).getId().equals(idName)
					|| actualCompany.getProducts().get(i).getName().equals(idName)) {
				actualCompany.getProducts().remove(i);
				break;
			}
		}
	}

	// LOGIN
	public boolean loginUser(String id, String password) {

		String idLogin = null;
		String passwordLogin = null;

		boolean validate = false;

		if (idLogin.isEmpty() || passwordLogin.isEmpty()) {

			
			// el usuario le falto algun campo.

		} else if (idLogin.equals(id) && passwordLogin.equals(password)) {

			validate = true;

			// el usuario ingreso correctamente
		} else {

			validate = false;
			//
		}

		return validate;

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
	}

	public void generateIncreasesDecreases() {

	}

	public void generateEarningsLoses() {

	}

	// Genera y retorna los datos necesarios para las graficas de la GUI
	public void generateGraphics() {

	}

}