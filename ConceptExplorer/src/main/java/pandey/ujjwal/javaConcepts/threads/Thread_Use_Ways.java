package pandey.ujjwal.javaConcepts.threads;

public class Thread_Use_Ways {

	public static void main(String[] ar) {
		// Don't use same object in different threads, as they will start working on
		// same object reference.

		viaThreadExtend();
//		viaRunnable();
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
