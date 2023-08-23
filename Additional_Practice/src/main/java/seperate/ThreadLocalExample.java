package seperate;
// not wokring

class ThreadLocalExample implements Runnable {

	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

	public static void main(String[] args) {
		System.out.println("fsf");
		Runnable task = () -> {
			threadLocal.set((int) (Math.random() * 100)); // Set a random value for the current thread
			System.out.println("Thread " + Thread.currentThread().getId() + ": " + threadLocal.get()); // Get the value
																										// for the
																										// current
																										// thread
			threadLocal.remove(); // Remove the value for the current thread
		};

		// Create and start multiple threads
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(task);
			thread.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
