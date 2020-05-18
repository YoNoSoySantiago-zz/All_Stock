package CustomExceptions;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Product;

public class AlreadyProductExistException extends Exception{
	
	public AlreadyProductExistException() {
		
			Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText("ALL STOCK");
		alert.setContentText("EL PRODUCTO YA EXISTE ");

		alert.showAndWait();
	
	}

}
