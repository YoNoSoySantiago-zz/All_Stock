package threads;

import java.time.LocalTime;

import javafx.application.Platform;
import ui.AllstockGUI;

public class Clock extends Thread {
	
	private AllstockGUI allStockGUI;
	private LocalTime localTime;
	public Clock (AllstockGUI allStockGUI) {
		this.allStockGUI = allStockGUI;
		
	}
	
	public void run() {
		while(allStockGUI.isMenuIsRunning()) {
			localTime = LocalTime.now();
			int h =localTime.getHour();
			int m = localTime.getMinute();
			int s = localTime.getSecond();
			Platform.runLater(new Thread() {
				public void run() {
					allStockGUI.updateTime(h, m, s);
				}
			});
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
