package pandey.ujjwal.concepts.threads;

// Virtual threads are managed by the Java runtime and are not bound to specific OS threads.
// Same sintex as Thread

public class VirtualThreadsEg {
	public static void main(String[] args) {
		traditionalThreadM();
		virtualThreadM();
	}

	public static void traditionalThreadM() {
		// Create a traditional thread
		Thread traditionalThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Traditional Thread: " + i);
				try {
					Thread.sleep(500); // Simulate work with sleep
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		// Start the traditional thread
		traditionalThread.start();

		// Wait for the thread to finish
		try {
			traditionalThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread finished.");
	}

	public static void virtualThreadM() {
		// Create and start a virtual thread
		Thread virtualThread = Thread.ofVirtual().start(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Virtual Thread: " + i);
				try {
					Thread.sleep(500); // Simulate work with sleep
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		// Wait for the virtual thread to finish
		try {
			virtualThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread finished.");
	}
}