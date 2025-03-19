package pandey.ujjwal.concepts.threads;

/**
 * Used to sync threads to a basic level.
 * 
 * Share/allows a thread to read the changes by another thread.
 */
public class VolatileKW {
	private static volatile String workHere = "The work"; // Volatile variable

	public static void main(String[] args) {
		// Create a thread that modifies the volatile variable
		Thread writerThread = new Thread(() -> {
			try {
				// Simulate some work before changing the value
				Thread.sleep(1000);
				workHere = "The work has been updated"; // Update the volatile variable
				System.out.println("Writer Thread: Updated workHere to: " + workHere);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// Create a thread that reads the volatile variable
		Thread readerThread = new Thread(() -> {
			String localCopy;
			while (true) {
				localCopy = workHere; // Read the volatile variable
				System.out.println("Reader Thread: Current value of workHere: " + localCopy);

				// Break the loop if the value has been updated
				if (!localCopy.equals("The work")) {
					break;
				}
			}
		});

		// Start both threads
		readerThread.start();
		writerThread.start();

		// Wait for both threads to finish
		try {
			writerThread.join();
			readerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final value: " + workHere);
	}
}
