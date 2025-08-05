package pandey.ujjwal.concepts.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * (java.util.concurrent.Executor)
 * Demonstrates Java Executor Framework with common types of executors:
 * - SingleThreadExecutor: runs tasks sequentially
 * - FixedThreadPool: runs tasks concurrently with fixed threads
 * - CachedThreadPool: creates new threads as needed and reuses idle threads
 * - ScheduledExecutorService: schedules tasks for future or periodic execution
 */
public class ExecutorUse {
	public static void main(String[] args) throws InterruptedException {
		// A thread pool of a single thread - static .newSingleThreadExecutor()
		// Execute tasks sequentially.
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

		// Fixed thread pool with 2 threads - concurrent execution limited to 2 threads
		// If there are more task, they are stored on a LinkedBlockingQueue.
		// Used Blocking Queue.
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

		// Cached thread pool - creates new threads as needed, reuses idle threads
		// Creates a thread pool that creates new threads as needed, but will reuse
		// previously constructed threads when they are available.
		// Calls to execute will reuse previously constructed threads if available.
		// Uses a SynchronousQueue queue.
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

		// Scheduled executor - runs scheduled or periodic tasks
		// Scheduled executors are based on the interface ScheduledExecutorService which
		// extends the ExecutorService interface. This executor is used when we have a
		// task that needs to be run at regular intervals or if we wish to delay a
		// certain task.
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
		// scheduleAtFixedRate, scheduleWithFixedDelay
		// Runs task initially after 0 sec delay, then every 2 seconds (fixed rate)
		scheduledExecutor.scheduleAtFixedRate(() -> System.out.println("FixedRate Task: " + System.currentTimeMillis()),
				0, 2, TimeUnit.SECONDS);

		// Runs task initially after 0 sec delay, then waits 3 seconds for next
		scheduledExecutor.scheduleWithFixedDelay(() -> {
			System.out.println("FixedDelay Task: " + System.currentTimeMillis());
			try {
				Thread.sleep(1000); // Simulate task duration
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 3, TimeUnit.SECONDS);
		// Let the program run for 10 seconds to observe scheduled tasks
		Thread.sleep(10000);
		scheduledExecutor.shutdown();

		// The result of the task submitted for execution to an executor can be accessed
		// using the java.util.concurrent. The future object returned by the executor.
		// Future can be thought of as a promise made to the caller by the executor. The
		// future interface is mainly used to get the results of Callable results.
		// whenever the task execution is completed, it is set in this future object by
		// the executor.
		Task callableTask = new Task("Ujjwal Pandey");
		Future<String> result = fixedThreadPool.submit(callableTask);

		// Shutdown executors (important to free resources)
		singleThreadExecutor.shutdown();
		fixedThreadPool.shutdown();
		cachedThreadPool.shutdown();
		scheduledExecutor.shutdown();
	}

}

class Task implements Callable<String> {
	private String message;

	public Task(String message) {
		this.message = message;
	}

	public String call() throws Exception {
		return "Hi " + message + "!";
	}
}