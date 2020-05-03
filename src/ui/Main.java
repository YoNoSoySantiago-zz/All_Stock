package ui;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	private AllstockGUI allstockgui;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		allstockgui = new AllstockGUI();
		
//		FileInputStream fis = new FileInputStream("imgs/Icon.png");
		FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("SignUpFX.fxml"));
		fxmlLoad.setController(allstockgui);
		Parent root = fxmlLoad.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setMinHeight(600);
		stage.setMinWidth(900);
//		stage.getIcons().add(new Image(fis));
		stage.setTitle("All Stock");
		stage.show();

	}

}
