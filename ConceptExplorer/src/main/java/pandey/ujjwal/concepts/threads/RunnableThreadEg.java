package pandey.ujjwal.concepts.threads;

public class RunnableThreadEg {

	public static void main(String[] args) {
		// Using Runnable
		Thread runnableThread = new Thread(new MyRunnable());
		runnableThread.start();

		// Using Thread
		MyThread thread = new MyThread();
		thread.start();
	}
}

/**
 * Using Runnable interface
 * - Task logic separate from thread,
 * - Can extend other classes,
 * - More flexible, reusable,
 * - Recommended for most cases
 */

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable running in: " + Thread.currentThread().getName());
	}
}

/**
 * Extending Thread class
 * - Generally discouraged
 * - Uses up your one class inheritance
 * - Less reusable (tight coupling)
 * - Thread logic mixed with task logic
 */
class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread running in: " + Thread.currentThread().getName());
	}
}
