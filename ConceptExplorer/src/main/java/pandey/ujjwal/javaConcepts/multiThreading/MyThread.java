package pandey.ujjwal.javaConcepts.multiThreading;

public class MyThread {
	public static void main(String[] args) {
		Top thread = new Top();
		thread.start();
		Top thread2 = new Top();
		thread2.start();
		System.out.println("This code is outside of the thread");
	}
}

class Top extends Thread {
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("My thread is in running state." + thread.getName() + ", p: " + thread.getPriority());
	}
}
