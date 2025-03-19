# Difference

_What to use when for thread work?_

## For sync code

### Comparison: `synchronized` vs. `ReentrantLock`

#### **1. Simplicity**

- **`synchronized`**: Easier to use and understand; automatically handles locking and unlocking.
- **`ReentrantLock`**: More complex; requires explicit lock and unlock calls.

#### **2. Flexibility**

- **`synchronized`**: Limited to intrinsic locking; cannot interrupt or timeout.
- **`ReentrantLock`**: Supports features like timed locks, interruptible locks, and multiple condition variables.

#### **3. Performance**

- **`synchronized`**: Generally slower in high contention scenarios due to JVM overhead.
- **`ReentrantLock`**: Can be more performant in high contention due to reduced blocking.

#### **4. Fairness**

- **`synchronized`**: No fairness policy; threads acquire locks in an unpredictable order.
- **`ReentrantLock`**: Can be configured for fairness, allowing FIFO access.

#### **5. Condition Variables**

- **`synchronized`**: Uses `wait()` and `notify()` methods for thread communication.
- **`ReentrantLock`**: Provides `Condition` objects for more flexible thread communication.

#### **5. When to Use ReentrantLock**

Advanced Locking Needs: When you need features like fairness, timed locks, or interruptible locks.

Explicit Control: When you want finer control over locking than synchronized provides.

Non-Blocking Attempts: When you want to try acquiring a lock without blocking indefinitely.

### Conclusion

Use **`synchronized`** for simple cases where ease of use is a priority. Opt for **`ReentrantLock`** when you need advanced features like timeouts, interruptibility, or better performance in complex multi-threaded scenarios.

```Example
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
```

## sync block & sync method with synchronization

### Difference Between Synchronized Code Block and Synchronized Method

| Feature         | Synchronized Code Block                                                          | Synchronized Method                                                      |
| --------------- | -------------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| **Scope**       | Locks a specific block of code.                                                  | Locks the entire method.                                                 |
| **Granularity** | More granular; allows finer control over locking.                                | Less granular; locks the whole method.                                   |
| **Performance** | Potentially better performance if only part of the method needs synchronization. | Can lead to unnecessary blocking if only part of the method is critical. |
| **Flexibility** | Can lock on any object (not just `this`).                                        | Locks on the instance (`this`) or class (for static methods).            |

### Use Cases

- **Synchronized Code Block**:

  - **When to Use**:
    - When only a portion of the method requires synchronization.
    - When you want to lock on a specific object rather than the instance.
  - **Example Use Case**: Updating a shared resource within a complex method where most operations do not require locking.

- **Synchronized Method**:
  - **When to Use**:
    - When the entire method needs to be thread-safe.
    - When simplicity is preferred, and all operations in the method should be synchronized.
  - **Example Use Case**: A simple getter or setter for a shared resource where all access needs to be synchronized.

### Summary

- Use **synchronized code blocks** for fine-grained control and better performance when only part of the code needs synchronization.
- Use **synchronized methods** for simplicity when the entire method needs to be thread-safe.

```Example
public class Counter {
    private int count = 0;

    // Only block is synchronized
    public void increment() {
        synchronized (this) {
            count++;
        }
    }
    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

    // Entire method is synchronized
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

## Thread pool

Basically a way of handling multiple threads at same time.

- ThreadPool: pool of worker threads that are efficiently managed to execute tasks.
- Using a thread pool can improve performance by reusing existing threads rather than creating new ones for every task.
- Example using the ExecutorService and Executors classes in ThreadPool.java
