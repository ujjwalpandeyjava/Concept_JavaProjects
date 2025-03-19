package pandey.ujjwal.concepts.threads;

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
public class LocksEg {
	public static void main(String[] args) {
		notGoodWorking();
		goodWorking();
	}

	private static void goodWorking() {
		ListsWorking dualListWork = new ListsWorking();

		// Creating threads to work on the lists
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualListWork.addToList();
		});

		// Same as >> new Thread(new Runnable(){public void run(){...}});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualListWork.addToList();
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

		log.info("Final size of list1: {} (Correct working)", dualListWork.sizeOfList());
	}

	private static void notGoodWorking() {
		var dualList = new ListsWorking();

		// Creating threads to work on the lists
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToIssueList();
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++)
				dualList.addToIssueList();
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
		log.info("Final size of list2: {} (With issue)}", dualList.sizeOfIssuedList());
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
class ListsWorking {
	private Random random = new Random();

	private List<Integer> workingList = new ArrayList<>();
	private List<Integer> issuedList = new ArrayList<>();

	private final Object lockObj = new Object();

	// In sync with lock
	public void addToList() {
		synchronized (lockObj) {
			workingList.add(random.nextInt(100));
		}
	}

	public int sizeOfList() {
		synchronized (lockObj) {
			return workingList.size();
		}
	}

	// Will cause issue
	public void addToIssueList() {
		issuedList.add(random.nextInt(100));
	}

	public int sizeOfIssuedList() {
		return issuedList.size();
	}
}