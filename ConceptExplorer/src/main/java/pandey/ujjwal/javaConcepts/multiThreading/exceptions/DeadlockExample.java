package pandey.ujjwal.javaConcepts.multiThreading.exceptions;

public class DeadlockExample {
	private static final Object resourceA = new Object();
	private static final Object resourceB = new Object();

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			synchronized (resourceA) {
				Thread t1 = Thread.currentThread();
				System.out.println("Thread 1: Acquired Resource A, by thread: " + t1.getName());
				try {
					// Simulate some work
					Thread.sleep(100);
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
