package pandey.ujjwal.concepts.threads;

// How to fix deadlock in Java?
// A deadlock occurs when two or more threads are blocked forever, waiting for each other.
// To avoid deadlock, we can ensure that all threads acquire resources in a consistent order.

// In this example, thread1 holds resourceA and waits for resourceB, while thread2 holds resourceB and waits for resourceA.
public class Deadlock_Eg {
	private static final Object resourceA = new Object();
	private static final Object resourceB = new Object();

	public static void main(String[] args) {

		Thread thread1 = new Thread(() -> {
			synchronized (resourceA) {
				Thread t1 = Thread.currentThread();
				System.out.println("Thread 1: Acquired Resource A, by thread: " + t1.getName());
				try {
					Thread.sleep(100); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (resourceB) {
					System.out.println("Thread 1: Acquired Resource B");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (resourceB) {
				Thread t2 = Thread.currentThread();
				System.out.println("Thread 2: Acquired Resource B, by thread: " + t2.getName());
				synchronized (resourceA) {
					System.out.println("Thread 2: Acquired Resource A");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
