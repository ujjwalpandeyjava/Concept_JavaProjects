package pandey.ujjwal.concepts.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Task code executed after 28 minutes.");
			}
		};

		timer.schedule(task, 28 * 60 * 1000); // milliseconds)
	}
}
