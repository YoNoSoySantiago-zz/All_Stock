package CustomExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CompanyExistException extends Exception {
	public CompanyExistException() {
		// TODO Auto-generated constructor stub
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("ALL STOCK");
		alert.setContentText("LA EMPRESA A REGISTRAR YA EXISTE ");

		alert.showAndWait();
	}

}
