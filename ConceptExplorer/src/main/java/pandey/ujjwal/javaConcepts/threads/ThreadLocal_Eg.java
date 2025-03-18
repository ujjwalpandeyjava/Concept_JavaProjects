package pandey.ujjwal.javaConcepts.threads;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Use ThreadLocal in Java for:<br/>
 * Thread-specific storage: Each thread gets its own copy of data, simplifying
 * access and avoiding synchronization overhead.<br />
 * Reduced parameter overload: Store frequently used thread-specific data (like
 * user ID) centrally, eliminating the need to pass it everywhere.
 */
@Slf4j
public class ThreadLocal_Eg {

	private static ThreadLocal<Map<Object, Object>> threadContext = new ThreadLocal<>();

	public static void main(String[] args) {
		setUserContext(Map.of("data", "aaa")); // Set user context for the main thread (thread 1)
		log.info("Main thread context: {}", getThreadContext()); // Output: Main thread context: 1

		// Via lambda expression
		new Thread(() -> {
			setUserContext(Map.of("data", "bbb")); // Set user context for the new thread (thread 2)
			log.info("Thread 2 context: {}", getThreadContext()); // Output: Thread 2 context: 2
		}).start();
		log.info("Main thread context after new thread: {}", getThreadContext());
		threadContext.remove();
		// Output: Main thread context after new thread: 1
	}

	public static void setUserContext(Map<Object, Object> d) {
		threadContext.set(d);
	}

	public static Map<Object, Object> getThreadContext() {
		return threadContext.get();
	}
}
