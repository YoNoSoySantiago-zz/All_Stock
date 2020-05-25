package threads;

import javafx.application.Platform;
import ui.AllstockGUI;

public class Animacion extends Thread {
	
	private AllstockGUI allGUI;
	
	public Animacion (AllstockGUI allGUI) {
		this.allGUI = allGUI;
	}

	@Override
	public void run () {
		while(allGUI.getLoginIsRunning()) {
			Platform.runLater(new Thread() {
				public void run() {
					allGUI.updateBox();
				}
			});
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
