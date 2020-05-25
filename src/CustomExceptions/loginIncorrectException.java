package CustomExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class loginIncorrectException extends Exception {
public loginIncorrectException() {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("ERROR");
	alert.setHeaderText("ALL STOCK");
	alert.setContentText("CONFIRMACION INCOMPLETA."
			+ " DATOS ERRONEOS \n");

	alert.showAndWait();
}

}
