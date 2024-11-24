package pandey.ujjwal.javaConcepts.threads;

import java.util.Map;

/**
 * 
 * Use ThreadLocal in Java for:<br/>
 * Thread-specific storage: Each thread gets its own copy of data, simplifying
 * access and avoiding synchronization overhead.<br />
 * Reduced parameter overload: Store frequently used thread-specific data (like
 * user ID) centrally, eliminating the need to pass it everywhere.
 */
public class Eg_LocalData {

	private static ThreadLocal<Map<Object, Object>> userContext = new ThreadLocal<>();

	public static void main(String[] args) {
		setUserContext(Map.of("data", "aaa")); // Set user context for the main thread (thread 1)
		System.out.println("Main thread context: " + getUserContext()); // Output: Main thread context: 1

		// Via lambda expression
		new Thread(() -> {
			setUserContext(Map.of("data", "bbb")); // Set user context for the new thread (thread 2)
			System.out.println("Thread 2 context: " + getUserContext()); // Output: Thread 2 context: 2
		}).start();
		System.out.println("Main thread context after new thread: " + getUserContext());
		// Output: Main thread context after new thread: 1
	}

	public static void setUserContext(Map<Object, Object> d) {
		userContext.set(d);
	}

	public static Map<Object, Object> getUserContext() {
		return userContext.get();
	}
}
