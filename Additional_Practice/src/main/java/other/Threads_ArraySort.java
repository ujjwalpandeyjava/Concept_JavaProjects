package other;

public class Threads_ArraySort {

	public static void main(String[] ar) {
		viaThreadExtend();
//		viaRunnable();
	}

	private static void viaThreadExtend() {
		ThreadExample threadExample = new ThreadExample();
		threadExample.setName("T1");
		threadExample.setPriority(1);
		threadExample.start();
		ThreadExample threadExample2 = new ThreadExample();
		threadExample2.setName("T2");
		threadExample2.setPriority(2);
		threadExample2.start();
		for (int i = 1; i <= 5; i++)
			System.out.println("Main Thread Value " + i);
	}

	private static void viaRunnable() {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		thread1.setName("T-1");
		thread2.setName("T-2");
		thread1.start();
		thread2.start();
		for (int i = 1; i <= 5; i++)
			System.out.println("Main Thread Value " + i);
	}
}

class ThreadExample extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("ID: " + Thread.currentThread().getId() + ", priority:  "
					+ Thread.currentThread().getPriority() + ", name: " + Thread.currentThread().getName() + " | " + i);
			try {
				if (Thread.currentThread().getPriority() == 1)
					Thread.currentThread().sleep(100);
				if (Thread.currentThread().getPriority() == 2)
					Thread.currentThread().sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("ThreadID: " + Thread.currentThread().getId() + ", priority:  "
					+ Thread.currentThread().getPriority() + ", name: " + Thread.currentThread().getName() + ", value "
					+ i);
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
