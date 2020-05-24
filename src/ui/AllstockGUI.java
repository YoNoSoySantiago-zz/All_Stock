package ui;

import java.io.IOException;

import CustomExceptions.UserExistException;
import CustomExceptions.ValueIsEmptyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.AllStock;
import model.User;

public class AllstockGUI {

	@FXML
	private BorderPane mainPane, registerPane;

	private AllStock allStock;
	// private Exception exceptions;

	public AllstockGUI(AllStock allStock) {
		this.allStock = allStock;

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
	private TextField txtPasword1;

	@FXML
	private TextField txtPasword2;

	@FXML
	private Button btRegister;

	@FXML
	private CheckBox adminSelect;

	@FXML
	private CheckBox clientSelect;

	@FXML
	private CheckBox employeeSelect;
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
	public void verifyLogin(ActionEvent event) throws Exception, IOException, ValueIsEmptyException {

		String id = userTextField.getText();

		String password = passwordField.getText();

		Boolean validate = allStock.loginUser(id, password);

		if (validate == true) {

			allStock.loginUser(id, password);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("INGRESO");
			alert.setHeaderText("ALL STOCK");
			alert.setContentText("CONFIRMACION COMPLETA");

			alert.showAndWait();
			loadMenuOptions();

		} else {

			throw new ValueIsEmptyException();

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

	public void loadMenuOptions() throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);

	}

	@FXML
	public void loadSignIn(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("SignUpFX.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
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
	void btnRegister(ActionEvent event) throws UserExistException {
		String name = txtSignName.getText();
		String id = txtSignID.getText();
		String password = txtPasword1.getText();
		String confirmPassword = txtPasword2.getText();
		String idType = adminSelect.isSelected() ? User.ADMINISTRADOR
				: clientSelect.isSelected() ? User.CLIENT : User.EMPLOYEE;
		if (password.equals(confirmPassword)) {
			allStock.addUser(id, name, idType, password, "falta en la GUI");
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("password differents");
			alert.setHeaderText("the password are not the same");
			alert.showAndWait();
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

}
