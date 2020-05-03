package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AllStock;

public class Main extends Application {
	
	private AllstockGUI allStockGUI;
	private AllStock allStock;
	
	public Main() {
		allStock = new AllStock();
		allStockGUI = new AllstockGUI(allStock);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
				
//		FileInputStream fis = new FileInputStream("imgs/Icon.png");
		FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("WelcomeFX.fxml"));
		fxmlLoad.setController(allStockGUI);
		Parent root = fxmlLoad.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setMinHeight(600);
		stage.setMinWidth(1000);
//		stage.getIcons().add(new Image(fis));
		stage.setTitle("All Stock");
		stage.show();

	}

}
