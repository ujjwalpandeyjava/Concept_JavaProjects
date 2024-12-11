package pandey.ujjwal.javaConcepts.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * "synchronized (objeABC)" -- Here the synchorized keyword is used to aquire a
 * lock on the object.
 * 
 * If one thread has already aquired the lock then other threads will wait for
 * their turn or until the lock is free.
 * 
 * Release Lock: After the thread completes the execution
 */

/*
 * synchronized (Obj) { // Shared resource operations go here.
 * 
 * // Critical section: Only one thread can execute this code at a time when
 * holding the lock on obj. }
 */
class DualList {
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	// Two lock objects
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	// Add to list1
	public void addToList1() {
		Random random = new Random();
		int value = random.nextInt(100); // Generate a random value between 0 and 99
		synchronized (lock1) {
			list1.add(value);
		}
	}

	// Add to list2
	public void addToList2() {
		Random random = new Random();
		int value = random.nextInt(100); // Generate a random value between 0 and 99
		synchronized (lock2) {
			list2.add(value);
		}
	}

	// Get from list1
	public int getFromList1(int index) {
		synchronized (lock1) {
			return list1.get(index);
		}
	}

	// Get from list2
	public int getFromList2(int index) {
		synchronized (lock2) {
			return list2.get(index);
		}
	}

	// Get size of list1
	public int sizeOfList1() {
		synchronized (lock1) {
			return list1.size();
		}
	}

	// Get size of list2
	public int sizeOfList2() {
		synchronized (lock2) {
			return list2.size();
		}
	}
}

/**
 * Without locks the lists can loose data.
 * 
 * Why to use this lock code (synchonized) system instead of the method
 * synchonized?
 * 
 * -- It allows threads to get into the method, and make them wait until the
 * lock is free. 
 * 
 * -- Where the code on mehtod sync make the whole thread wait and
 * increases time.
 * 
 * Lock Objects: The two lock objects (lock1 and lock2) are used to synchronize
 * access to list1 and list2 respectively.
 * 
 * Concurrency: Different threads can independently add random values to list1
 * and list2, improving concurrency without blocking each other.
 */
public class MultipleLocks {
	public static void main(String[] args) {
		DualList dualList = new DualList();

		// Creating threads to work on the lists
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				dualList.addToList1();
			}
		});

		// Same as >> new Thread(new Runnable(){publid void run(){...}});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				dualList.addToList2();
			}
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

		// Print final sizes
		System.out.println("Final size of list1: " + dualList.sizeOfList1());
		System.out.println("Final size of list2: " + dualList.sizeOfList2());
	}
}
