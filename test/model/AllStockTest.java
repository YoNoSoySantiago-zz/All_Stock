package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CustomExceptions.AlreadyProductExistException;
import CustomExceptions.CompanyExistException;
import CustomExceptions.ValueIsEmptyException;

class AllStockTest {
	
private AllStock control;
Product miproduct;
private Company miCompany;
ArrayList<String> arr;


// CREACION DE EMPRESAS
	public void setup1() throws ValueIsEmptyException, CompanyExistException {

// TODO Auto-generated method stub
control.addCompanyList("Chocolixie", "0878", "Cali", "3224548", arr);
control.addCompanyList("Tienda paquita", "4524", "Cali", "3365448", arr);
	}
	
	
void setup2() throws ValueIsEmptyException, AlreadyProductExistException  {
	control.addProduct("agua", "botella 400", "manantial", 1500, 42);
	control.addProduct("pastel", "rico pastel, suave ", "Compan", 700, 8);
	
}
	@Test
	public void TestaddCompanyList() throws ValueIsEmptyException, CompanyExistException {
		control.addCompanyList("DROGERUIA", "1234", "CALI", "45454", arr);
assertTrue(control.getActualCompany().getNextCompany().equals(miCompany));
	}

	// duda eliminar esa comp;ia del setup1 
	@Test
	public void TestDeleteCompanyR() {
		//setup1();
  // assertNull("4524", control.DeleteCompany(control.getActualCompany().getNit());
	}

	

	@Test
	public void TestSearchCompanyR() throws ValueIsEmptyException, CompanyExistException {
		setup1();
assertEquals("Chocolixie", control.getActualCompany().getName() );

	}

	@Test
	public void TestaddProduct() throws ValueIsEmptyException, AlreadyProductExistException {
		// control.addProduct("gaseosa", "bebida refrescante", "postobon", 2000, 12);
		//assertTrue(miproduct.get, message);
	}

	@Test
	public void TestaddProductAliments() {
	}

	@Test
	public void TestaddProductClothes() {
	}

	@Test
	public void TestaddProductCleaning() {
	}

	@Test
	public void TestaddProductMedicines() {
	}

	@Test
	public void TestaddProductOthers() {
	}
	
	
	public void TestSearchProductByName() {
		
		
	}
	
	

	
	public void TestSearchProductByIdR() {
		
	}
	

public void TestaddUsersR() {
	
}



public void TestDeleleUserR() {
	
	
}

public void TestLogin() {
	
	
}




public void TestUserArray() {
	}

// duda
public void GenerateProductsArray() {}



}
