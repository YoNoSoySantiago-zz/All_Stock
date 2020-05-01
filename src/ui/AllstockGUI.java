package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class AllstockGUI {
	
	@FXML
	private BorderPane mainPane;
	
	public AllstockGUI() {
		
	}
	
	@FXML
	public void verifyLogin(ActionEvent event) throws IOException {
		loadMenuOptions();
	}
	
	private void loadMenuOptions() throws IOException {
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
}
