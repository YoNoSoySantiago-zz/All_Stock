package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));

		//fxmlLoader.setController(RsGUI);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("imgns/iconos.css").toExternalForm());
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("All stock");
		//RsGUI.loadSurvey(null);
		primaryStage.show();
		
		
	
		

	}
	
	

}
