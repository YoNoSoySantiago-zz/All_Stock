package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CustomExceptions.AlreadyProductExistException;
import CustomExceptions.CompanyExistException;
import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;

class AllStockTest {
	
	private AllStock control;
	private Product miproduct;
	private Company miCompany;
	private ArrayList<String> categories;
	private  User myUser;


// CREACION DE EMPRESAS
	public void setup1() throws CompanyExistException, ValueIsEmptyException {



		control.addCompanyList("Chocolixie", "0878", "Cali", "3224548", categories);
		control.addCompanyList("Tienda paquita", "4524", "Cali", "3365448", categories);
		control.addCompanyList("DROGERIA", "1234", "CALI", "45454", categories);

	}
	
	// productos sin categoria
	void setup2() throws ValueIsEmptyException, AlreadyProductExistException  {
		control.addProduct("agua", "botella 400", "manantial", 1500, 42);
		control.addProduct("pastel", "rico pastel, suave ", "Compan", 700, 8);
		control.addProduct("cafe", " colombiano 100%", "Aguila roja",3500, 74);
		control.addProduct("Alpinete", "mermelada ", "Alpina", 4500, 30);
	
	}
	void setup3() throws ValueIsEmptyException, AlreadyProductExistException  {
		//productos ropa
		//control.addProduct("Camisa manga larga", "cuadros azules", "polo", 100, 5, 16 , arrayColors);
	
	
	}

// usuarios
	public void setup4() throws UserExistException, ValueIsEmptyException {
		control.addUser("123", "Sebastian", "PASAPORTE", "123", User.ADMINISTRADOR);
		control.addUser("12454", "Santiago", "CEDULA DE CIUDADANIA ", "1234567", User.EMPLOYEE);
		control.addUser("4548", "Diego", "CEDULA DE CIUDADANIA ", "32145", User.CLIENT);
		
	}
// Agrega una empresa si la lista esta vacia.
	@Test
	public void TestaddCompanyList() throws ValueIsEmptyException, CompanyExistException {
		setup1();

		assertTrue(control.addCompanyList("Tienda paquita", "4524", "Cali", "3365448", categories));
	}
    @Test
    public void testAddCompanyList1() throws ValueIsEmptyException, CompanyExistException {
        System.out.println("addCompanyList");
        String name = "";
        String nit = "";
        String locate = "";
        String phone = "";
        ArrayList<String> categories = null;
        AllStock instance = new AllStock();
        instance.addCompanyList(name, nit, locate, phone, categories);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

	// Eliminar Empresa  del setup1 
	@Test
	public void TestDeleteCompanyR() {
		//setup1();
  // assertNull("4524", control.DeleteCompany(control.getActualCompany().getNit());
	}

	
// Buscar Empresa 
	@Test
	public void TestSearchCompanyR() throws ValueIsEmptyException, CompanyExistException {
		setup1();
		assertEquals("Chocolixie", control.getActualCompany().getName() );

	}
	// agregar un producto al arbol si esta vacio

	@Test
	public void TestaddProduct() throws ValueIsEmptyException, AlreadyProductExistException {
		// control.addProduct("gaseosa", "bebida refrescante", "postobon", 2000, 12);
		//assertTrue(miproduct.get, message);
	}

	// agregar un producto de categoria alimentos al arbol cuando hay otros productos en el
	@Test
	public void TestaddProductAliments() {
	}

	// agregar un producto de categoria clothes al arbol cuando hay otros productos en el
	@Test
	public void TestaddProductClothes() {
	}
	// agregar un producto de categoria Limpieza  al arbol cuando hay otros productos en el
	@Test
	public void TestaddProductCleaning() {
	}

	@Test
	public void TestaddProductMedicines() {
	}

	@Test
	public void TestaddProductOthers() {
	}
	
	@Test
	public void TestSearchProductByName() {
		
		
	}
	
	

	@Test
	public void TestSearchProductByIdR() {
		
	}
	
	// agrega un Usuario a una lista vacia
	@Test
	public void TestaddUsersR() throws UserExistException, ValueIsEmptyException {
		control.addUser("123", "sebastian", "PASAPORTE", "123", User.ADMINISTRADOR);
		
		assertTrue(false, "Agregado");
	}
	// elimina a un usuario 
	
		@Test
	public void TestDeleleUserR() {
		
		
	}
		
		// verifica el login
		@Test
	public void TestLogin() {
	
		
	}
	
	
	
		@Test
	public void TestUserArray() {
		}
	
	// duda
	public void GenerateProductsArray() {}
	
	
	
	}
