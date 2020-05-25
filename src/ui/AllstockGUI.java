package ui;

import java.io.IOException;
import java.util.ArrayList;

import CustomExceptions.CompanyExistException;
import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.*;

public class AllstockGUI {

	@FXML
	private BorderPane mainPane, registerPane;

	private AllStock allStock;
	private Exception exceptions;

	public AllstockGUI(AllStock allStock) {
		this.allStock = allStock;
		this.exceptions=exceptions;

	}

	// login

	private Button btLogin;

	@FXML
	private TextField userTextField;

	@FXML
	private PasswordField passwordField;

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
	private Button btRegisterProduct;

	@FXML
	private TextField txtIdProduct;

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
	private ComboBox<?> cbCategory;

	@FXML
	private TextArea txtDescription;

	@FXML
	private Button btSearchImageProduct;

	@FXML
	private ImageView imageViewProdcut;

	@FXML
	private Button btHelpProdcut;
	
	
	// registro empresa
	
    @FXML
    private TextField txtNameCompany;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txttelephoneCompany;

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
	private TableView<?> tableInventary;

	@FXML
	private DatePicker txtCalendar;

	@FXML
	private Button btDescargar;

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

	public void initializate() {


	}

	@FXML
	public void verifyLogin(ActionEvent event) throws Exception, IOException {

		String id = userTextField.getText();

		String password = passwordField.getText();

		Boolean validate = allStock.loginUser(id, password);

		if (validate == true) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("INGRESO");
			alert.setHeaderText("ALL STOCK");
			alert.setContentText("CONFIRMACION COMPLETA" + "Bienvenido " + id );

			alert.showAndWait();
			
			loadMenuOptions(allStock.searchUserR(id));
		

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("ALL STOCK");
			alert.setContentText("CONFIRMACION INCOMPLETA\n");

			alert.showAndWait();

		}

	}

	@FXML
	void btn(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("Login.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	public void loadMenuOptions(User u) throws IOException {
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
		
		if(u instanceof Admin) {
			initAdmin();
		}else if(u instanceof Employee) {
			initEmployee();
		}else {
			initUser();
		}

	}

	@FXML
	public void loadSignIn(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("SignUpFX.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
		idTypeComboBox.getItems().addAll("CEDULA DE CIUDADANÍA","TARJETA IDENTIDAD","PASAPORTE","CEDULA EXTRANJERA");
		
	
	}

	// MenuOptions
	@FXML
	void btnGraphics(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("GraficasFX.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	@FXML
	void btnInventory(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("tabla.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	@FXML
	void btnLogOut(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("Login.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
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
		
		if (password.equals(confirmPassword)) {
			try {
				allStock.addUser(id, name, idType, password, userType);
			}catch(UserExistException e) {
				e.printStackTrace();
			} catch (ValueIsEmptyException e) {
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("password differents");
			alert.setHeaderText("the password are not the same");
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

	//
	@FXML
	void btnProducts(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("ProductRegister.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	@FXML
	void btnReports(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("ReporteFX.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
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

	// Register
	@FXML
	void btnRegisterPlace(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}

	@FXML
	void btnRegisterPlace2(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace2.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		registerPane.getChildren().clear();
		registerPane.setCenter(pane);
	}

	@FXML
	void btnRegisterPlace3(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace3.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		registerPane.getChildren().clear();
		registerPane.setCenter(pane);
	}

	// Tabla
	@FXML
	void btAtrasTable(ActionEvent event) {

	}

	// manejo de tipos de usuarios en la app.

	void initAdmin() {
		// control total
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
}
