package pandey.ujjwal.concepts.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

public class LocksEg2 {
	public static void main(String[] args) {
		new CalculationsSyncIssue().startWork();
		new CalculationsTimeIssue().startWork();
		new Calculations().startWork();
	}
}

/**
 * Best: This is uses less time
 */
@Slf4j
class Calculations {
	private Random random = new Random();
	private Object firstLock = new Object();
	private Object secondLock = new Object();

	private List<Integer> firstList = new ArrayList<>();
	private List<Integer> secondList = new ArrayList<>();

	public void startWork() {
		log.info("Started Calculations...");
		long started = System.currentTimeMillis();
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				calculating();
			}
		});
		Thread thread2 = new Thread(() -> calculating());
		// Thread thread3 = new Thread(this::calculating);

		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long ended = System.currentTimeMillis();
		System.out.println("Duration: " + (ended - started));
		System.out.println("First List: " + firstList.size() + "; Second List: " + secondList.size());
	}

	public void calculating() {
		for (int i = 0; i < 1000; i++) {
			firstCalculation();
			secondCalculation();
		}
	}

	public void firstCalculation() {
		synchronized (firstLock) { // Instead of using this keyword, we use an object to let it work separately
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			firstList.add(random.nextInt(200));
		}

	}

	public void secondCalculation() {
		synchronized (secondLock) { // Instead of using this keyword, we use an object to let it work separately
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			secondList.add(random.nextInt(200));
		}

	}
}

/**
 * Good: This takes combined time to work
 */
@Slf4j
class CalculationsTimeIssue {

	private Random random = new Random();

	private List<Integer> firstList = new ArrayList<>();
	private List<Integer> secondList = new ArrayList<>();

	public void startWork() {
		log.info("Started CalculationsTimeIssue...");
		long started = System.currentTimeMillis();

		// All 3 threads are same
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				calculating();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				calculating();
			}
		});
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long ended = System.currentTimeMillis();
		System.out.println("Duration: " + (ended - started));
		System.out.println("First List: " + firstList.size() + "; Second List: " + secondList.size());
	}

	public void calculating() {
		for (int i = 0; i < 1000; i++) {
			firstCalculation();
			secondCalculation();
		}
	}

	public void firstCalculation() {
		synchronized (this) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			firstList.add(random.nextInt(200));
		}
	}

	public void secondCalculation() {
		synchronized (this) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			secondList.add(random.nextInt(200));
		}
	}
}

/**
 * Bad: Data is not synced
 */
@Slf4j
class CalculationsSyncIssue {

	private Random random = new Random();

	private List<Integer> firstList = new ArrayList<>();
	private List<Integer> secondList = new ArrayList<>();

	public void startWork() {
		log.info("Started CalculationsSyncIssue...");
		long started = System.currentTimeMillis();

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				calculating();
			}
		});
		Thread thread2 = new Thread(() -> calculating());
		try {
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long ended = System.currentTimeMillis();
		System.out.println("Duration: " + (ended - started));
		System.out.println("First List: " + firstList.size() + "; Second List: " + secondList.size());
	}

	public void calculating() {
		for (int i = 0; i < 1000; i++) {
			firstCalculation();
			secondCalculation();
		}
	}

	public void firstCalculation() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		firstList.add(random.nextInt(200));
	}

	public void secondCalculation() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		secondList.add(random.nextInt(200));
	}
}