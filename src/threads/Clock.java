package threads;

import java.time.LocalDateTime;

public class Clock extends Thread {
	
	private LocalDateTime systemDate;
	
	public Clock () {
		systemDate = LocalDateTime.now();
	}
	
	public void run() {
		
	}
	
	public LocalDateTime getDate() {
		
		return null;
	}
}
