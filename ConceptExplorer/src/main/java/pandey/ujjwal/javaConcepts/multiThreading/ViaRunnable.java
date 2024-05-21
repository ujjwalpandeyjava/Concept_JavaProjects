package pandey.ujjwal.javaConcepts.multiThreading;

public class ViaRunnable {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("Main thread is still running");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("My thread is in running state." + thread.getName() + ", p: " + thread.getPriority());
	}
}
