package pandey.ujjwal.javaConcepts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * There are 4 different ways to run a code in different thread.
 * 
 * Ways to run a class <br/>
 * - Extend Thread <br/>
 * - Implement Runnable<br/>
 * - Using Lambda (for one in-line method)<br/>
 * - Using ExecutorService<br/>
 */
public class Thread_Use_Ways {

	public static void main(String[] ar) {
		// Don't use same object in different threads, as they will start working on
		// same object reference and manipulate same instance.
		// viaThreadExtend();
		// viaRunnable();
		// viaLambdaExpression();
		viaExecutorService();
	}

	/**
	 * Best of thread working with lot of advanced controls.
	 * 
	 * Part of java concurrent package.
	 * 
	 * Provides a higher level API for managing threads in a more flexible and
	 * robust way.
	 * 
	 * It abstracts the creation, scheduling, and execution of tasks, making it
	 * easier to manage thread lifecycle and improve the scalability and performance
	 * of the applications.
	 * 
	 * Theory in ExecutorTheory.md
	 */
	private static void viaExecutorService() {
		System.out.println("ExecutorService started...");
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			// Ensures service will not shut down until all submitted tasks are completed.
			executorService.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Task executed by: " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
			if (i == 1) {
				// Optionally submit more tasks
				executorService.execute(() -> {
					System.out.println("Additional task executed by: " + Thread.currentThread().getName());
				});
			}
		}

		// Optionally submit more tasks
		executorService.execute(() -> {
			System.out.println("Additional task executed by: " + Thread.currentThread().getName());
		});

		executorService.shutdown(); // Initiates an orderly shutdown
		// Keeping this block will block the further code execution.
		// try {
		// // Used to block until all tasks have completed execution after a shutdown
		// // request, or the timeout occurs.
		// if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
		// executorService.shutdownNow(); // Forces shutdown if tasks don't finish in
		// time.
		// }
		// } catch (InterruptedException e) {
		// executorService.shutdownNow();
		// }

		System.out.println("ExecutorService code executed work in threads.");
	}

	// Rearly used
	private static void viaLambdaExpression() {
		// Example 1
		Runnable runnable = () -> {
			System.out.println("Thread is running...");
		};
		Thread thread = new Thread(runnable);
		thread.start(); // Start the thread

		// Example 2
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					System.out.println("Thread on loop: " + i);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();

		Runnable runnable2 = () -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread on loop2: " + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable2).start();
		new Thread(runnable2).start();
	}

	private static void viaThreadExtend() {
		// Thread 1
		ThreadExample threadExample = new ThreadExample();
		threadExample.setName("T1");
		threadExample.setPriority(1);
		threadExample.start();

		// Thread 2
		ThreadExample threadExample2 = new ThreadExample();
		threadExample2.setName("T2");
		threadExample2.setPriority(2);
		threadExample2.start();

		// Main thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("Main Thread Value " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void viaRunnable() {
		var obj1 = new MyRunnable2(10);
		Thread thread1 = new Thread(obj1);
		thread1.setName("t1");
		thread1.setPriority(1);

		var obj2 = new MyRunnable2(10);
		Thread thread2 = new Thread(obj2);
		thread2.setName("t2");
		thread2.setPriority(2);

		thread1.start();
		thread2.start();

		for (int i = 1; i <= 5; i++) {
			System.out.println("Main Thread Value " + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadExample extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			var currentThread = Thread.currentThread();
			System.out.println("Name: " + currentThread.getName() + ", Id: " + currentThread.getId() + ", priority: "
					+ currentThread.getPriority() + " | " + i);
			try {
				if (currentThread.getPriority() == 1) {
					Thread.sleep(100);
				}
				if (Thread.currentThread().getPriority() == 2) {
					Thread.sleep(150);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}

class MyRunnable2 implements Runnable {

	private int val = 0;

	public MyRunnable2(int val) {
		this.val = val;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			var currentThread = Thread.currentThread();
			System.out.println("Name: " + currentThread.getName() + ", Id: " + currentThread.getId() + ", priority:  "
					+ currentThread.getPriority() + " | " + i + " = " + this.val++);

			try {
				if (Thread.currentThread().getPriority() == 1)
					Thread.currentThread().sleep(100);
				if (Thread.currentThread().getPriority() == 2)
					Thread.currentThread().sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
