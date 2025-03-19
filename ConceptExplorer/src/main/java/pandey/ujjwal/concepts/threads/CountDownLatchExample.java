package pandey.ujjwal.concepts.threads;

import java.util.concurrent.CountDownLatch;

/*
 * Use CountDownLatch:
 * When you need to wait for multiple threads or tasks to complete before proceeding to next task,
 * 
 * Eg: 
 * As initializing resources or coordinating thread execution. 
 * It is ideal for scenarios like waiting for worker threads to finish or ensuring dependencies are resolved before continuing.
 */
public class CountDownLatchExample {
	public static void main(String[] args) {
		// Create a CountDownLatch initialized count to 2 (the main thread will wait for
		// mentioned count thread to finish)
		CountDownLatch latch = new CountDownLatch(2);

		// Create 3 worker threads
		for (int i = 0; i < 3; i++) {
			final int workerId = i + 1;
			new Thread(() -> {
				try {
					// Simulate some work with sleep
					Thread.sleep(1000 * workerId);
					System.out.println("Worker " + workerId + " has completed work.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					latch.countDown(); // Decrement the count of the latch
				}
			}).start();
		}

		try {
			// Main thread waits until the count (mentioned latch count) reaches zero
			latch.await();
			System.out.println("All workers have completed their tasks. Proceeding...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
