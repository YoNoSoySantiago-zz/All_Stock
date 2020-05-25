package CustomExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ValueIsEmptyException extends Exception {

	public ValueIsEmptyException() {
	
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("ALL STOCK");
		alert.setContentText("INFORMACION INCORRECTA ");

		alert.showAndWait();
	
	}
}
