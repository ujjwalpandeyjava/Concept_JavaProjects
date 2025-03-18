package pandey.ujjwal.javaConcepts.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * Without locks the lists can loose data.
 * 
 * Why to use this lock system instead of the simple synchronized keyword.
 * 
 * -- It allows threads to get into the method, and make them wait until the
 * lock is free.
 * 
 * -- Where the code on method sync make the whole thread wait and
 * increases time.
 * 
 * Lock Objects: The two lock objects (lock1 and lock2) are used to synchronize
 * access to list1 and list2 respectively.
 * 
 * Concurrency: Different threads can independently add random values to list1
 * and list2, improving concurrency without blocking each other.
 */
@Slf4j
public class MultipleLocks {
	public static void main(String[] args) {
		goodWorking();
		notGoodWorking();
	}

	private static void goodWorking() {
		DualLists dualList = new DualLists();

		// Creating threads to work on the lists
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToList1();
		});

		// Same as >> new Thread(new Runnable(){public void run(){...}});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToList1();
		});

		t1.start();
		t2.start();

		// Wait for both threads to finish
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("Final size of list1: {} (Correct working)", dualList.sizeOfList1());
	}

	private static void notGoodWorking() {
		var dualList = new DualLists();

		// Creating threads to work on the lists
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToList2();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToList2();
		});

		t1.start();
		t2.start();

		// Wait for both threads to finish
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print final sizes, which may be inconsistent due to lack of synchronization
		log.info("Final size of list2: {} (With issue)}", dualList.sizeOfList2());
	}
}

/**
 * "synchronized (objectABC)" -- Here the synchronized keyword is used to
 * acquire a lock on the object.
 * 
 * If one thread has already acquired the lock then other threads will wait for
 * their turn or until the lock is free.
 * 
 * Release Lock: After the thread completes the execution
 * 
 * 
 * synchronized (Obj) { // Shared resource operations go here.
 * // Critical section: Only one thread can execute this code at a time when
 * holding the lock on obj. }
 * 
 * // new Random().nextInt(100) -- Generate a random value between 0 and 99
 */
class DualLists {
	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private final Object lockObj = new Object();

	public void addToList1() {
		synchronized (lockObj) {
			list1.add(random.nextInt(100));
		}
	}

	// Get size of list1
	public int sizeOfList1() {
		synchronized (lockObj) {
			return list1.size();
		}
	}

	// Will cause issue
	public void addToList2() {
		list2.add(random.nextInt(100));
	}

	public int sizeOfList2() {
		return list2.size();
	}
}