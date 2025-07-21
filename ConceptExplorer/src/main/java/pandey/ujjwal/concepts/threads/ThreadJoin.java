package pandey.ujjwal.concepts.threads;

// Java program to explain the concept of joining a thread.

// Custom thread class that defines the task to run in each thread
class ThreadJoiningEg extends Thread {
	// The run() method defines what this thread does when started
	@Override
	public void run() {
		// Loop to simulate some repetitive work
		for (int i = 0; i < 2; i++) {
			try {
				// Sleep for 500ms to mimic work and let thread scheduler switch context
				Thread.sleep(500);
				// Print the name of the currently executing thread
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			} catch (Exception ex) {
				System.out.println("Exception has been caught" + ex);
			}
			System.out.println(i + 1);
		}
	}
}

// Join (join new thread with main) puts the thread execution in LIFO stack for execution completion
public class ThreadJoin {
	public static void main(String[] args) {

		// Create instances of our custom thread
		var t1 = new ThreadJoiningEg();
		var t2 = new ThreadJoiningEg();
		var t3 = new ThreadJoiningEg();

		try {
			// Print the name of the starting (main) thread
			System.out.println("Current Thread: " + Thread.currentThread().getName());

			// Start t3 and t1 almost simultaneously
			t1.start(); // t1 is started
			t2.start(); // t2 is started

			// main thread (the caller) waits for t1 to finish before moving forward
			// t1 is not joined, so it runs in the background and may finish anytime
			t2.join(); // Ensures main waits for t2 to finish

			// Starts only after t2 has completed
			t3.start();

			// main again waits for t3 to finish before moving forward
			// t3.join();

		} catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}
		System.out.println("Now the main will work.");
	}
}