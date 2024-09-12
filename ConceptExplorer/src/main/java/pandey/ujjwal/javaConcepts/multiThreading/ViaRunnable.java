package pandey.ujjwal.javaConcepts.multiThreading;

public class ViaRunnable {
	public static void main(String[] args) {
		TopClass c1 = new TopClass();
		Thread thread = new Thread(c1);
		thread.start();
		System.out.println("Main thread is still running");
	}
}

class TopClass implements Runnable {
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("My thread is in running state." + thread.getName() + ", p: " + thread.getPriority());
	}
}
