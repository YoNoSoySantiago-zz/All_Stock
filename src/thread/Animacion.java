package thread;

import com.sun.istack.internal.logging.Logger;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Animacion extends Thread {
	
	// atributos
	
	
int c;
ImageView box= new ImageView();
AnchorPane cuadrante;

private boolean direccion;


public Animacion (	ImageView box, Boolean direccion) {
	
	
	c=10;
	this.direccion= direccion; // false arriba, true abajo
	
}


public void run () {
	
	while (true) {
		if (box.getLayoutY()+ box.getFitHeight() > cuadrante.getHeight() || box.getLayoutY()< 0){
			
			c*=(-1);
			
		}
		
		try {
			Platform.runLater(() -> box.setLayoutY(box.getLayoutY()+c));
			sleep(40);
		} catch (Exception e) {
			//Logger.getLogger(arg0)
		}
		}		
	}
}
// en la gui

/*
 * Animacion b1= new Movimiento (fxidImageView, cuadrante, false);
 * 
 * 
 * b1.start();
 * 
 */
 */

