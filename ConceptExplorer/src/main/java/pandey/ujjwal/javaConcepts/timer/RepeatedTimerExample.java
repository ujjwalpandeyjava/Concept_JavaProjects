package pandey.ujjwal.javaConcepts.timer;

import java.util.Timer;
import java.util.TimerTask;

public class RepeatedTimerExample {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Repeated task executed every 28 minutes.");
			}
		};

		timer.scheduleAtFixedRate(task, 0, 28 * 60 * 1000); // milliseconds)
	}
}
