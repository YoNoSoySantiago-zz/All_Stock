package CustomExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UserExistException extends Exception{
	public UserExistException() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("ALL STOCK");
		alert.setContentText("EL USUARIO YA EXISTE ");

		alert.showAndWait();

	}

}
