package ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import CustomExceptions.AlreadyProductExistException;
import CustomExceptions.CompanyExistException;
import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Admin;
import model.AllStock;
import model.Employee;
import model.Product;
import model.User;
import threads.AnimationThread;
import threads.ValuesEmptyThread;

public class AllstockGUI {

	@FXML
	private BorderPane mainPane, registerPane;
	
	private Stage window;
	private AllStock allStock;
	private AnimationThread animation;
	private ValuesEmptyThread empty;
	private boolean loginIsRunning;
	private boolean registerIsRunning;
	private boolean productIsRunning;
	private int upBox;
	private User userActual;
	
	
	
	public AllstockGUI(Stage win,AllStock allStock) {
		this.allStock = allStock;
		window = win;
		setRegisterIsRunnning(false);
		loginIsRunning= true;
		setProductIsRunning(false);
		animation = new AnimationThread(this);
		empty = new ValuesEmptyThread(this);
		upBox = 1;
	}

	// login
	
	@FXML
	private Button verifyLogin;

	@FXML
	private Button btLogin;

	@FXML
	private TextField userTextField;

	@FXML
	private PasswordField passwordField;
	
    @FXML
    private AnchorPane frame;

    @FXML
    private ImageView boxImageView;

	// Log Up
	@FXML
	private TextField txtSignName;

	@FXML
	private TextField txtSignID;

	@FXML
	private PasswordField passFieldPassword1;

	@FXML
	private PasswordField passFieldPassword2;

	@FXML
	private Button btRegister;

	@FXML
	private CheckBox adminSelect;

	@FXML
	private CheckBox clientSelect;

	@FXML
	private CheckBox employeeSelect;
	
	@FXML
	private ComboBox<String> idTypeComboBox;
	// ProductRegister
    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtCantidad;

	@FXML
	private Button btRegisterProduct;

	@FXML
	private TextField txtNameProduct;

	@FXML
	private TextField txtBrand;

	@FXML
	private RadioButton rdYesCategory;

	@FXML
	private ToggleGroup TGCategory;

	@FXML
	private RadioButton rdNOCategory;

	@FXML
	private ComboBox<String> cbCategory;

	@FXML
	private TextArea txtDescription;

	@FXML
	private Button btSearchImageProduct;

	@FXML
	private ImageView imageViewProdcut;

	@FXML
	private Button btHelpProdcut;
	
	@FXML
	private Pane alimentsPane;
	
	@FXML
	private Pane clothesPane;
	
	@FXML
	private Pane medicinePane;
	
	@FXML
	private Pane othersPane;
	
	@FXML
	private TextField txtTipoMedicine;
	
	@FXML
	private TextField txtTipo;
	
	// registro empresa
	
    @FXML
    private Button btFinishCreateCompany;
    // este me reggistra namecompany,nit,location,telephoneCompany;
    @FXML
    private Button btRegisterBasicCompany;

	///register place 2
    @FXML
    private TextField txtNameCompany;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txttelephoneCompany;

    // register place 3
    @FXML
    private CheckBox chBoxAliments;

    @FXML
    private CheckBox chBoxClothes;

    @FXML
    private CheckBox chBoxLimpieza;

    @FXML
    private CheckBox chBoxMedicines;

    @FXML
    private CheckBox chBoxOthers;

	// Tabla
    
	@FXML
	private TableView<Product> tableInventary;
	@FXML
	private TableColumn<Product,String> idCol;
	@FXML
	private TableColumn<Product,String> nameCol;
	@FXML
	private TableColumn<Product,String> category;
	@FXML
	private TableColumn<Product,Double> priceCol;
	@FXML
	private TableColumn<Product,Integer> cantCol;
    @FXML
    private Label totalLabel;	

	@FXML
	private TextField txtSearchTable;

	@FXML
	private TextField txtTotal;

	// menu de registro

	@FXML
	private Button btnReports;

	@FXML
	private Button btnInventory;

	@FXML
	private Button btnSettings;

	@FXML
	private Button btnProducts;

	@FXML
	private Button btnGraphics;
	
	//settings
    @FXML
    private Button btCreateCompany;

    @FXML
    private Button btDeleteUser;

    

	public void initialize() {
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				loginIsRunning = false;
				registerIsRunning = false;
				setProductIsRunning(false);
				System.out.println("Closing the window!");
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/allStock.sds"));
					oos.writeObject(allStock);
					oos.close();
				} catch (FileNotFoundException e) {
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	@FXML
	public void verifyLogin(ActionEvent event) throws IOException{
			
			String id = userTextField.getText();

			String password = passwordField.getText();

			Boolean validate = false;
			try {
				validate = allStock.loginUser(id, password);
			} catch (ValueIsEmptyException e) {
				e.printStackTrace();
			}

			if (validate == true) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("INGRESO");
				alert.setHeaderText("ALL STOCK");
				alert.setContentText("CONFIRMACION COMPLETA" +"\n"+ " BIENVENIDO " + id );

				alert.showAndWait();
				userActual = allStock.searchUserR(id);
				loginIsRunning = false;
				if(allStock.getActualCompany()==null)
					LoadRegister(event);
				else
					loadMenuOptions(event);
			} else {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("INGRESO");
				alert.setHeaderText("ALL STOCK");
				alert.setContentText("USUARIO NO REGISTRADO" );

				alert.showAndWait();
				
				userTextField.clear();
				passwordField.clear();
			}
	}

	@FXML
	void btn(ActionEvent event) throws IOException {
		setLoginIsRunning(true);
		FXMLLoader fL = new FXMLLoader(getClass().getResource("Login.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
		animation.start();
	}

	public void loadMenuOptions(ActionEvent event) {
		try {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
			setProductIsRunning(false);
			if(userActual instanceof Admin) {
				initAdmin();
			}else if(userActual instanceof Employee) {
				initEmployee();
			}else {
				initUser();
			}
		}catch(IOException e) {
			System.out.println(e.getStackTrace());
		}

	}

	@FXML
	public void loadSignIn(ActionEvent event){
		try {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("SignUpFX.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
			idTypeComboBox.getItems().addAll("CEDULA DE CUIDADANIA","TARJETA IDENTIDAD","PASAPORTE","CEDULA EXTRANJERA");
			setRegisterIsRunnning(true);
			loginIsRunning=false;
			System.out.println("empezo");
			ValuesEmptyThread valuesEmptyThread = new ValuesEmptyThread(this);
			valuesEmptyThread.start();
		}catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	
	}

	// MenuOptions
	@FXML
	void btnGraphics(ActionEvent event) {
		try {
			// grafica de barras
			//aqui puse fue una grafica de pastel
			
			graphicsofPie();
			FXMLLoader fL = new FXMLLoader(getClass().getResource("GraficasFX.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
		}catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	@FXML
	void btnInventory(ActionEvent event) throws IOException {
		
			FXMLLoader fL = new FXMLLoader(getClass().getResource("tabla.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
			tableInventary = new TableView<Product>();
			ObservableList<Product> observableList;
			observableList = FXCollections.observableArrayList(allStock.productInsertionSortByName());
			tableInventary.setItems(observableList);
			idCol.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
			
			
			/*
			 * listContact = new TableView<Contact>();
    	 ObservableList<Contact> observableList;
    	 	observableList = FXCollections.observableArrayList(contactManager.getContacts());
    			listContact.setItems(observableList);
    			listName.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
    			listEmail.setCellValueFactory(new PropertyValueFactory<Contact,String>("email"));		
			 */
	}

	@FXML
	void btnLogOut(ActionEvent event){
		
		try {
			registerIsRunning=false;
			loginIsRunning=true;
			animation=new AnimationThread(this);
			empty = new ValuesEmptyThread(this);
			FXMLLoader fL = new FXMLLoader(getClass().getResource("Login.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
			animation.start();
			empty.start();
		}catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Log Up
	@FXML
	 public void RegisterUser(ActionEvent event) {
		String name = txtSignName.getText();
		String id = txtSignID.getText();
		String idType = idTypeComboBox.getValue();
		String password = passFieldPassword1.getText();
		String confirmPassword = passFieldPassword2.getText();
		String userType = adminSelect.isSelected() ? User.ADMINISTRADOR
				: clientSelect.isSelected() ? User.CLIENT : User.EMPLOYEE;
		System.out.println(idType);
		if (password.equals(confirmPassword)) {
			try {
				allStock.addUser(id, name, idType, password, userType);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("USUARIO REGISTRADO ");
				alert.setHeaderText("EL USUARIO SE REGISTRO CORRECTAMENTE" );
				alert.showAndWait();
				registerIsRunning=false;
				btnLogOut(event);
			
			}catch(UserExistException e) {
				System.out.println(e.getStackTrace());
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CONTRASEÑAS DIFERENTES");
			alert.setHeaderText("LAS CONTRASEÑAS NO SON IGUALES");
			alert.showAndWait();
		}
	}

	// registrar empresa
	
	@FXML
	void registerCompany(ActionEvent event) {
		
		String nameCompany= txtNameCompany.getText();
		String nit= txtNit.getText();
		String phone=txttelephoneCompany.getText();
		String location=txtLocation.getText();
		ArrayList<String> categories = new ArrayList<String>();
		
		if(chBoxAliments.isSelected()) 
		{
			categories.add(chBoxAliments.getText());
		}
		if(chBoxClothes.isSelected()) 
		{
			categories.add(chBoxClothes.getText());
		}
		if(chBoxLimpieza.isSelected()) 
		{
			categories.add(chBoxLimpieza.getText());
		}
		if(chBoxMedicines.isSelected()) 
		{
			categories.add(chBoxMedicines.getText());
		}
		if(chBoxOthers.isSelected()) 
		{
			categories.add(chBoxOthers.getText());
		}
		System.out.println(nameCompany+nit+ phone+ location+ categories);
		try {
			allStock.addCompanyList(nameCompany,nit,location,phone,categories);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("EMPRESA REGISTRADA CORRECTAMENTE ");
			alert.setHeaderText("LA EMPRESA SE REGISTRO CORRECTAMENTE" );
			alert.showAndWait();
			loadMenuOptions(event);
		}catch(ValueIsEmptyException e) {
			e.printStackTrace();
		} catch (CompanyExistException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
 
	
	
	
	@FXML
	void adminSelect(ActionEvent event) {
		if (adminSelect.isSelected()) {
			clientSelect.setSelected(false);
			employeeSelect.setSelected(false);
		}
	}

	@FXML
	void clientSelect(ActionEvent event) {
		if (clientSelect.isSelected()) {
			adminSelect.setSelected(false);
			employeeSelect.setSelected(false);
		}
	}

	@FXML
	void employeeSelect(ActionEvent event) {
		if (employeeSelect.isSelected()) {
			clientSelect.setSelected(false);
			adminSelect.setSelected(false);
		}
	}

	@FXML
	void btnProducts(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("ProductRegister.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
		setProductIsRunning(true);
		cbCategory.getItems().addAll("Alimentos","Limpieza","Ropa","Medicina","Otra");
		empty = new ValuesEmptyThread(this);
		empty.start();
	}

	@FXML
	void btnSettings(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("Settings.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	// Product Register
	@FXML
	void btAtrasProducts(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}
	
	@FXML
	public void showExtraFields(ActionEvent event) {
		switch(cbCategory.getValue()) {
			case "Alimentos":
				alimentsPane.setVisible(true);
				clothesPane.setVisible(false);
				medicinePane.setVisible(false);
				othersPane.setVisible(false);
				break;
			case "Ropa":
				alimentsPane.setVisible(false);
				clothesPane.setVisible(true);
				medicinePane.setVisible(false);
				othersPane.setVisible(false);
				break;
			case "Medicina":
				alimentsPane.setVisible(false);
				clothesPane.setVisible(false);
				medicinePane.setVisible(true);
				othersPane.setVisible(false);
				break;
			case "Otra":
				alimentsPane.setVisible(false);
				clothesPane.setVisible(false);
				medicinePane.setVisible(false);
				othersPane.setVisible(true);
				break;
			case "Limpieza":
				alimentsPane.setVisible(false);
				clothesPane.setVisible(false);
				medicinePane.setVisible(false);
				othersPane.setVisible(false);
				break;
		}
	}
	
    @FXML
    void btRegisterProduct(ActionEvent event) throws ValueIsEmptyException, AlreadyProductExistException {
    	try {
    		String name = txtNameProduct.getText();
        	String brand  = txtBrand.getText();
        	String description = txtDescription.getText();
        	double price = Double.parseDouble(txtPrecio.getText());
        	int cant = Integer.parseInt(txtCantidad.getText());
        	if(cbCategory.getValue().equals("Alimentos")) {
        		String tipo = txtTipo.getText();
        		allStock.addProduct(name, description, brand, price, cant, 0, tipo);
        		txtTipo.clear();
        	}else if(cbCategory.getValue().equals("Limpieza")) {
        		allStock.addProduct(name, description, brand, price, cant);
        	}else if(cbCategory.getValue().equals("Ropa")) {
        		double[ ]sizes = new double[0];
        		String[]colors = new String[0];
        		allStock.addProduct(name, description, brand, price, cant, sizes, colors);
        	}else if(cbCategory.getValue().equals("Medicina")){
        		String tipo = txtTipoMedicine.getText(); 
        		allStock.addProduct(name, description, brand, price, cant, tipo);
        		txtTipoMedicine.clear();
        	}else {
        		String[][] characteristics = new String[0][0];
        		allStock.addProducts(name, description, brand, price, cant, characteristics);
        	}
        	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("EXITO");
    		alert.setHeaderText("Producto registrado con exito");
    		alert.showAndWait();
    		
    		txtNameProduct.clear();
        	txtBrand.clear();
        	txtDescription.clear();
        	txtPrecio.clear();
        	txtCantidad.clear();
    		
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("NUMBERS");
    		alert.setHeaderText("Formato invalido por favor verifica que solo sean valores numericos");
    		alert.showAndWait();
    	}
    	
    }

	// Register company

 // Pide datos basicos de empresa
    
	@FXML
	void LoadRegister(ActionEvent event) throws IOException {
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace2.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
		
	}
	
/*
	@FXML
	void btnRegisterPlace2(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace2.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		registerPane.getChildren().clear();
		registerPane.setCenter(pane);
		
	}
	*/



	// ventana que pide las categorias de la empresa a registrar
	  @FXML
	    void loadCategoriesCompany(ActionEvent event) throws IOException {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace3.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
	    }
	  
	  
	// Tabla
	@FXML
	void btnReports(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("ReporteFX.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	// manejo de tipos de usuarios en la app.

	void initAdmin() {
		// control total6
		btnGraphics.setDisable(false);
		btnInventory.setDisable(false);
		btnSettings.setDisable(false);
		btnProducts.setDisable(false);
		btnReports.setDisable(false);

	}

	void initEmployee() {
		// todo menos ajustes
		btnGraphics.setDisable(false);
		btnInventory.setDisable(false);
		btnSettings.setDisable(true);
		btnProducts.setDisable(false);
		btnReports.setDisable(false);
	}

	void initUser() {
		// usuario ve reportes e inventario
		btnGraphics.setDisable(true);
		btnInventory.setDisable(false);
		btnSettings.setDisable(true);
		btnProducts.setDisable(true);
		btnReports.setDisable(false);

	}

	public void updateBox() {
		if(boxImageView.getLayoutY()+boxImageView.getFitHeight()==frame.getHeight()||boxImageView.getLayoutY()==0) {
			upBox*=-1;
		}
		boxImageView.setLayoutY(boxImageView.getLayoutY()+upBox);
	}

	public void graphicsofPie() {
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("bolsa de leche", 13),
                new PieChart.Data("pan", 25),
                new PieChart.Data("jamon", 10),
                new PieChart.Data("pollo", 22),
                new PieChart.Data("carne", 30));
 
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(" Cantidad de productos ");
        
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        chart.getData().stream().forEach((data) ->{
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, 
            (MouseEvent e) -> {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText(String.valueOf(data.getPieValue())
                        + "%");
            });
        });
 

	}
	
	public void verifyValuesEmptyProduct() {
		String name =txtNameProduct.getText();
		String brand = txtBrand.getText();
		String description = txtDescription.getText();
		String price = txtPrecio.getText();
		String cant = txtCantidad.getText();
		String category = cbCategory.getValue();
		if(name.isEmpty()||brand.isEmpty()||description.isEmpty()||price.isEmpty()||cant.isEmpty()||category==null) {
			
			btRegisterProduct.setDisable(true);
		}else {
			btRegisterProduct.setDisable(false);
		}
		
	}
	public void verifyValesEmptyLogin() {
		if(!userTextField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
			verifyLogin.setDisable(false);
		}else {
			verifyLogin.setDisable(true);
		}
	}
	
	public void verifyValuesEmptyRegister() {
		String name = txtSignName.getText();
		String id = txtSignID.getText();
		String idType = idTypeComboBox.getValue();
		String password = passFieldPassword1.getText();
		String confirmPassword = passFieldPassword2.getText();
		String userType = adminSelect.isSelected() ? User.ADMINISTRADOR
				: clientSelect.isSelected() ? User.CLIENT :employeeSelect.isSelected()? User.EMPLOYEE:null;

		if(!id.isEmpty()&&!name.isEmpty()&&idType!=null&&!password.isEmpty()&&!confirmPassword.isEmpty()&&userType!=null) {
			System.out.println("como debe ser");
			btRegister.setDisable(false);
		}else {
			btRegister.setDisable(true);
		}
	}
	
	public Boolean getLoginIsRunning() {
		return loginIsRunning;
	}

	public void setLoginIsRunning(Boolean loginIsRunning) {
		this.loginIsRunning = loginIsRunning;
		
	}
	//Settings
	
	@FXML
	public void deleteUser(ActionEvent event) {
		
	}
	
	@FXML
	public void deleteCompany(ActionEvent event) {
		
	}
	
	@FXML
	public void resetSystem(ActionEvent event) {
		allStock = new AllStock();
		btnLogOut(event);
	}

	public boolean isRegisterIsRunnning() {
		return registerIsRunning;
	}

	public void setRegisterIsRunnning(boolean registerIsRunnning) {
		this.registerIsRunning = registerIsRunnning;
	}
	//REPORTS
	@FXML
    private Button btReportUser;

	@FXML
    private Button btReportProduct;

    @FXML
    private Button btIcreasesAndLoses;

    @FXML
    public void btIcreasesAndLoses(ActionEvent event) {
    	try{
    		allStock.generateIncreasesDecreases();
    	}
    	catch (IOException e) {
    		System.out.println("No se pueden generar los ingresos!");
    	}
    }

    @FXML
	public void btReportProduct(ActionEvent event) {
    	try {
			allStock.generateProducts();
		} catch (IOException e) {
			System.out.println("No se generó el reporte de productos");
		}
    }

    @FXML
    public void btReportUser(ActionEvent event) {
    	try {
			allStock.generateReportUsers();
		} catch (IOException e) {
			System.out.println("No se generó el reporte de usuarios");
		}
    }

	public boolean isProductIsRunning() {
		return productIsRunning;
	}

	public void setProductIsRunning(boolean productIsRunning) {
		this.productIsRunning = productIsRunning;
	}
}