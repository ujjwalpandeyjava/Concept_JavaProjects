package pandey.ujjwal.concepts.threads;

import java.util.LinkedList;
import java.util.Queue;

class SharedResource {
	private final Queue<Integer> queue = new LinkedList<>();
	private final int LIMIT = 5; // Limit for the queue size

	// Method for the producer to add items
	public void produce(int value) throws InterruptedException {
		synchronized (this) {
			while (queue.size() == LIMIT) {
				System.out.println("Queue is full. Producer is waiting...");
				wait(); // Wait until space is available (next line will now execute)
			}
			queue.add(value);
			System.out.println("Produced: " + value);
			notify(); // Notify the consumer that an item has been produced
		}

	}

	// Method for the consumer to remove items
	public int consume() throws InterruptedException {
		synchronized (this) {
			while (queue.isEmpty()) {
				System.out.println("Queue is empty. Consumer is waiting...");
				wait(); // Wait until an item is available (next line will now execute)
			}
			int value = queue.poll();
			System.out.println("Consumed: " + value);
			notify(); // Notify the producer that space is available
			return value;
		}
	}
}

class Producer implements Runnable {
	private final SharedResource sharedResource;

	public Producer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				sharedResource.produce(i);
				Thread.sleep(120); // Simulate time taken to produce an item
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

class Consumer implements Runnable {
	private final SharedResource sharedResource;

	public Consumer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sharedResource.consume();
				Thread.sleep(300); // Simulate time taken to consume an item
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

public class ThreadWaitNotify {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();

		Thread producerThread = new Thread(new Producer(sharedResource));
		Thread consumerThread = new Thread(new Consumer(sharedResource));

		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Production and consumption completed.");
	}
}
