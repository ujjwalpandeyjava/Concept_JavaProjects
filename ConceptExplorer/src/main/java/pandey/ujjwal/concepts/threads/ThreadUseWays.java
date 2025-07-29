package pandey.ujjwal.concepts.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates different ways to run code in separate threads:
 * - Extend Thread
 * - Implement Runnable
 * - Using Lambda (for one in-line method)
 * - Using ExecutorService
 */
@Slf4j
public class ThreadUseWays {

	public static void main(String[] ar) {
		// Don't use same object in different threads, as they will start working on
		// same object reference and manipulate same instance.
		// viaThreadExtend();
		// viaRunnable();
		// viaLambdaExpression();
		viaExecutorService();

		// More
		// viaThreadExtend2();
		// viaRunnable2();
		// viaLambdaExpression2();
		// viaExecutorService2();
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
		for (int i = 1; i <= 5; i++) {
			// Ensures service will not shut down until all submitted tasks are completed.
			// Future<?> future =
			executorService.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("Task executed by: " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
			// With try-catch
			// Object result = future.get(); // waits for result
			// System.out.println("Result: " + result);

			if (i == 1) { // Optionally submit more tasks
				executorService.execute(() -> {
					System.out.println("Additional task by: " + Thread.currentThread().getName());
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

	// Rarely used
	private static void viaLambdaExpression() {
		// Example 1
		Runnable runnable = () -> {
			System.out.println("Thread is running...");
		};
		Thread thread = new Thread(runnable);
		thread.start();

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
		Thread thread1 = new Thread(obj1, "t1");
		thread1.setPriority(1);

		var obj2 = new MyRunnable2(10);
		Thread thread2 = new Thread(obj2, "t2");
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

	/**
	 * Example: Extending the Thread class.
	 */
	private static void viaThreadExtend2() {
		log.info("Using Thread Extension:");
		Thread thread1 = new ThreadExample2();
		thread1.setName("Thread-1");
		Thread thread2 = new ThreadExample2();
		thread2.setName("Thread-2");

		thread1.start();
		thread2.start();
	}

	/**
	 * Example: Implementing the Runnable interface.
	 */
	private static void viaRunnable2() {
		log.info("\nUsing Runnable Interface:");
		Runnable task = new RunnableExample2();

		Thread thread1 = new Thread(task, "Runnable-1");
		Thread thread2 = new Thread(task, "Runnable-2");

		thread1.start();
		thread2.start();
	}

	/**
	 * Example: Using Lambda Expressions for simple tasks.
	 */
	private static void viaLambdaExpression2() {
		log.info("\nUsing Lambda Expressions:");
		Runnable task = () -> {
			for (int i = 0; i < 5; i++) {
				log.info(Thread.currentThread().getName() + " - Count: " + i);
				sleep(100);
			}
		};

		new Thread(task, "Lambda-1").start();
		new Thread(task, "Lambda-2").start();
	}

	/**
	 * Example: Using ExecutorService for advanced thread management.
	 */
	private static void viaExecutorService2() {
		log.info("\nUsing ExecutorService:");
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				log.info(Thread.currentThread().getName() + " is executing a task.");
				sleep(200);
			});
		}

		executorService.shutdown(); // Gracefully shuts down the executor service
	}

	/**
	 * Utility method to sleep for a given duration.
	 */
	private static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // Restore interrupted status
			System.err.println("Thread interrupted: " + e.getMessage());
		}
	}
}

class ThreadExample extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			var currentThread = Thread.currentThread();
			System.out.println("Name: " + currentThread.getName() + ", Id: " + currentThread.threadId() + ", priority: "
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
			System.out.println("Name: " + currentThread.getName() + ", Id: " + currentThread.threadId()
					+ ", priority:  " + currentThread.getPriority() + StringUtils.SPACE + "|" + StringUtils.SPACE + i
					+ " = " + this.val++);
			try {
				if (Thread.currentThread().getPriority() == 1) {
					// Thread.currentThread();
					Thread.sleep(100);
				}
				if (Thread.currentThread().getPriority() == 2) {
					// Thread.currentThread();
					Thread.sleep(150);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 2
/**
 * Example of extending the Thread class.
 */
@Slf4j
class ThreadExample2 extends Thread {
	// public ThreadExample(String name) {
	// super(name);
	// }

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			log.info("{} - Count: {}", getName(), i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				log.error("{} interrupted:{} ", getName(), e.getMessage());
			}
		}
	}
}

/**
 * Example of implementing the Runnable interface.
 */
@Slf4j
class RunnableExample2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			log.info(Thread.currentThread().getName() + " - Count: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
			}
		}
	}
}
