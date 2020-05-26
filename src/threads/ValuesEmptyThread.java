package threads;

import ui.AllstockGUI;

public class ValuesEmptyThread extends Thread{
	private AllstockGUI allStockGUI;
	
	public ValuesEmptyThread(AllstockGUI allStockGUI) {
		this.allStockGUI = allStockGUI;
	}
}
