package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.AllStock;

public class AllstockGUI {
	

    @FXML
    private BorderPane mainPane,registerPane;
	
	private AllStock allStock;
	
	public AllstockGUI(AllStock allStock) {
		this.allStock = allStock;
		
	}
	//ProductRegister
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

    
	
	//Tabla
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

    public void initializate() {
    	
    }
	
	@FXML
	public void verifyLogin(ActionEvent event) throws IOException {
		loadMenuOptions();
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
	
	//MenuOptions
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
    
	//Product Register
	@FXML
    void btAtrasProducts(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
    }
	
	//Register
	@FXML
	void btnRegister(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(pane);
	}
	
	@FXML
	void btnRegister2(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace2.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		registerPane.getChildren().clear();
		registerPane.setCenter(pane);
	}
	
	@FXML
	void btnRegister3(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RegisterPlace3.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		registerPane.getChildren().clear();
		registerPane.setCenter(pane);
	}
	
	//Tabla
	@FXML
    void btAtrasTable(ActionEvent event) {

    }
}
