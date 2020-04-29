package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
//		MainController mC = new MainController(usAc);
		
		try {
			FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("Window.fxml"));
//			fxmlLoad.setController(mC);
			Parent root = fxmlLoad.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.centerOnScreen();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome!");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}


