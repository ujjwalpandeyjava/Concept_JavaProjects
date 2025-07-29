# ExecutorService

The `ExecutorService` is part of the `java.util.concurrent` package and provides a higher level API for managing threads in a more flexible and robust way

It abstracts the creation, scheduling, and execution of tasks, making it easier to manage thread lifecycle and improve the scalability and performance of your applications.

## Use case:
| Scenario                    | Why ExecutorService?                 | Example                      |
| --------------------------- | ------------------------------------ | ---------------------------- |
| ✅ Multiple background tasks | Reuses threads (thread pool)         | Sending 100 emails           |
| ✅ Controlled concurrency    | Limits number of threads             | 5 DB calls in parallel       |
| ✅ Submit + Future result    | Get result back from task            | Web scraping or calculations |
| ✅ Task queueing             | Queues if all threads busy           | Image processing queue       |
| ✅ Graceful shutdown         | `shutdown()` or `awaitTermination()` | Clean exit of app            |


## Key Concepts

1. **Executor Interface**: The base interface which provides a single method `execute(Runnable command)` to execute the given command at some future time.

   ```java
   Executor executor = new Executor() {
       @Override
       public void execute(Runnable command) {
           new Thread(command).start();
       }
   };
   executor.execute(() -> System.out.println("Task executed"));
   ```

2. **ExecutorService Interface**: Extends `Executor` and provides methods for managing the lifecycle of tasks and the executor itself:
   - `submit()`: Submits a task for execution and returns a `Future` representing the task.
   - `shutdown()`: Initiates an orderly shutdown in which previously submitted tasks are executed but no new tasks will be accepted.
   - `shutdownNow()`: Attempts to stop all actively executing tasks and halts the processing of waiting tasks.
   - `awaitTermination()`: Blocks until all tasks have completed execution after a shutdown request.

### Creating ExecutorService

There are several factory methods in the `Executors` class to create different types of `ExecutorService`:

1. **Fixed Thread Pool**:

   ```java
   ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
   ```

2. **Cached Thread Pool**:

   ```java
   ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
   ```

3. **Single Thread Executor**:

   ```java
   ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
   ```

4. **Scheduled Thread Pool**: For tasks that need to be scheduled to run after a delay or to execute periodically.
   ```java
   ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);
   ```

### Using ExecutorService

Here’s an example demonstrating how to use `ExecutorService`:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Task executed by: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorService.shutdown(); // Initiates an orderly shutdown

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Forces shutdown if tasks don't finish in time
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
```

### Benefits of Using ExecutorService

1. **Thread Management**: Automatically manages a pool of threads.
2. **Task Scheduling**: Easier to schedule tasks for execution at fixed rates or delays.
3. **Scalability**: Helps to improve the scalability of applications by efficiently managing thread resources.
4. **Graceful Shutdown**: Provides methods for gracefully shutting down and managing task completion.

Using `ExecutorService` makes concurrent programming more manageable and helps to write more efficient and maintainable code. It's especially useful for handling large numbers of short-lived tasks or for applications where the number of concurrent tasks can vary dynamically.

If you have more questions or need specific examples, feel free to ask!
