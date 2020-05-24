package Thread;

import java.time.LocalDateTime;

public class Clock extends Thread {
	
	private Long systemDate;
	
	public Clock () {
		systemDate = System.currentTimeMillis();
	}
	
	public void run() {
		
	}
	
	public LocalDateTime getDate() {
		return null;
		
		
	}
}
