package threads;

import javafx.application.Platform;
import ui.AllstockGUI;

public class ValuesEmptyThread extends Thread{
	private AllstockGUI allStockGUI;
	
	public ValuesEmptyThread(AllstockGUI allStockGUI) {
		this.allStockGUI = allStockGUI;
	}
	
	@Override
	public void run() {
		
		if(allStockGUI.getLoginIsRunning()) {
			while(allStockGUI.getLoginIsRunning()) {
				Platform.runLater(new Thread() {
					public void run() {
						allStockGUI.verifyValesEmptyLogin();
					}
				});
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(allStockGUI.isRegisterIsRunnning()) {
			while(allStockGUI.isRegisterIsRunnning()) {
				Platform.runLater(new Thread() {
					public void run() {
						allStockGUI.verifyValuesEmptyRegister();
					}
				});
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else if(allStockGUI.isProductIsRunning()) {
			while(allStockGUI.isProductIsRunning()) {
				Platform.runLater(new Thread() {
					public void run() {
						allStockGUI.verifyValuesEmptyProduct();
					}
				});
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
