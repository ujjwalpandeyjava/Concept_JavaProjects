package pandey.ujjwal.javaConcepts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing " + name);
		try {
			Thread.sleep(1000); // Simulate some work with sleep
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " finished --- " + name);
	}
}

public class ThreadPool_Eg {
	public static void main(String[] args) {
		// Create a thread pool with 3 threads
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Submit tasks to the thread pool
		for (int i = 1; i <= 10; i++) {
			Task task = new Task("Task" + i);
			executorService.submit(task);
		}

		// Shutdown the executor service
		executorService.shutdown();
	}
}
