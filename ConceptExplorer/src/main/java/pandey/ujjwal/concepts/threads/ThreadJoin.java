package pandey.ujjwal.concepts.threads;

// Java program to explain the concept of joining a thread.

// Creating thread by creating the
// objects of that class
class ThreadJoining extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			} catch (Exception ex) {
				System.out.println("Exception has been caught" + ex);
			}
			System.out.println(i + 1);
		}
	}
}

// Join puts the thread execution in LIFO stack for execution completion
public class ThreadJoin {
	public static void main(String[] args) {

		// Creating two threads
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		ThreadJoining t3 = new ThreadJoining();

		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName());

			t3.start(); // Starts work
			t1.start(); // Starts work

			t1.join(); // main waits for t1 to end (but t3 has started work)

			t2.start();
			t2.join(); // main waits for t2 to end and t2 wait for t1 to end

			// t3.join(); // main waits for t3 to end after after t2 ends
		} catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}
		System.out.println("Now the main will work.");
	}
}
/**
 * The main thread prints its own name.
 * 
 * Starting Threads:
 * 
 * t1.start(): Starts the execution of thread t1.
 * 
 * t3.start(): Starts the execution of thread t3.
 * 
 * Joining Threads:
 * 
 * t1.join(): The main thread waits for thread t1 to finish before proceeding.
 * 
 * After t1 completes, it starts t2 with t2.start().
 * 
 * The main thread then waits for thread t2 to finish with t2.join().
 * 
 * Finally, it waits for thread t3 to finish with t3.join().
 */