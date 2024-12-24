# Homework 5

## 2. Write a thread-safe singleton class 
```
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { 
            synchronized (Singleton.class) {
                if (instance == null) { 
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

## 3. How to create a new thread(Please also consider Thread Pool approach)?
- **Using ```Thread``` Class:** You can extend the Thread class and override its run() method:
    ```
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        }
    }

    public class ThreadExample {
        public static void main(String[] args) {
            MyThread thread = new MyThread();
            thread.start(); 
        }
    }
    ```
- **Using ```Runnable``` Interface:** You can implement the Runnable interface and pass it to a Thread:
    ```
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable thread is running: " + Thread.currentThread().getName());
        }
    }

    public class RunnableExample {
        public static void main(String[] args) {
            Thread thread = new Thread(new MyRunnable());
            thread.start(); 
        }
    }

    // Using Lambda expression:
    public class LambdaThreadExample {
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                System.out.println("Lambda thread is running: " + Thread.currentThread().getName());
            });
            thread.start(); 
        }
    }
    ```

- **Using Thread Pool (```ExecutorService```):
```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool (Runnable implementation)
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskNumber + " by thread: " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor service
        executor.shutdown();
    }
}
```

` **Using Callable to Create a Thread:** The FutureTask class wraps a Callable and implements Runnable, so it can be used with a Thread.
```
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThreadExample {
    public static void main(String[] args) {
        // Create a Callable task
        Callable<String> callableTask = () -> {
            Thread.sleep(1000); // Simulate some work
            return "Result from Callable thread: " + Thread.currentThread().getName();
        };

        // Wrap the Callable in a FutureTask
        FutureTask<String> futureTask = new FutureTask<>(callableTask);

        // Create a thread with the FutureTask
        Thread thread = new Thread(futureTask);

        // Start the thread
        thread.start();

        try {
            // Get the result of the Callable task
            String result = futureTask.get(); // Waits if necessary
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 4. Difference between Runnable and Callable?
| Aspect            | Runnable                                      | Callable                               |
|-------------------|-----------------------------------------------|----------------------------------------|
| **Method**        | `void run()`                                  | `V call() throws Exception`            |
| **Result**        | No result                                     | Returns a result                       |
| **Exception**     | Cannot throw checked exceptions               | Can throw checked exceptions           |
| **Return Type**   | `void`                                        | Generic (`V`)                          |
| **Direct Usage**  | Can be passed directly to a `Thread`          | Needs `FutureTask` or `Executor`       |
| **When to Use**   | When no result or exception is needed         | When a result or exception is needed   |

## 5. What is the difference between t.start() and t.run()?
| Aspect                    | `t.start()`                                       | `t.run()`                                   |
|---------------------------|---------------------------------------------------|---------------------------------------------|
| **Thread Creation**       | Creates a new thread                              | Does not create a new thread                |
| **Execution Context**     | `run()` is executed in a separate thread          | `run()` is executed in the calling thread   |
| **Asynchronous**          | Yes                                               | No                                          |
| **Thread Independence**   | Current thread continues running                  | Current thread blocks until `run()` finishes|
| **Usage**                 | To properly execute a thread                      | For testing or debugging `run()` logic      |

## 6. Which way of creating threads is better: Thread class or Runnable interface?
| Aspect               | Runnable Interface                              | Thread Class                               |
|----------------------|-------------------------------------------------|--------------------------------------------|
| **Inheritance**      | Allows extending another class                  | Cannot extend another class                |
| **Code Reusability** | High (task logic is separate from thread)       | Low (thread and task logic are coupled)    |
| **Thread Pools**     | Compatible (used with `ExecutorService`)        | Not compatible                             |
| **Complexity**       | Slightly more boilerplate                       | Simple for small tasks                     |
| **Best Practice**    | Encourages separation of concerns               | Combines thread and task logic             |

## 7. What are the thread statuses?
- NEW: The thread is created but not started.
- RUNNABLE: The thread is ready to run but not necessarily running.
- BLOCKED: The thread is waiting for a monitor lock.
- WAITING: The thread is waiting indefinitely for another thread's action.
- TIMED_WAITING: The thread is waiting for a specified time.
- TERMINATED: The thread has completed execution.

## 8. Demonstrate deadlock and how to resolve it in Java code.
- Deadlock occurs when two or more threads are waiting for each other to release resources, and neither can proceed. 
- **Resolving Deadlock:**
    - **Use Lock Ordering:** Always acquire locks in a consistent order. For example, ensure both threads acquire lock1 before lock2.
    - **Use tryLock with Timeout:** Use ReentrantLock to try acquiring locks with a timeout, allowing threads to back off and avoid deadlock.

## 9. How do threads communicate each other?
- Shared Objects: Threads communicate by accessing shared variables or objects.
- Synchronization: Use synchronized, wait(), notify(), or explicit locks to avoid race conditions.
- Coordination: Use join() to ensure threads run in a specific order.
- Advanced APIs: Use Lock and Condition for more control over thread communication.

## 10. What’s the difference between class lock and object lock?
| Aspect                 | Object Lock                                      | Class Lock                                      |
|------------------------|--------------------------------------------------|------------------------------------------------|
| **Scope**              | Specific to an object instance                   | Applies to the entire class                    |
| **Methods Synchronized**| Instance methods (`synchronized`)               | Static methods (`synchronized static`)         |
| **Lock Association**   | Tied to `this` or a specific object instance     | Tied to the `Class` object of the class        |
| **Simultaneous Access**| Different instances can execute in parallel      | No two threads can execute synchronized static methods of the same class concurrently |
| **Use Case**           | Synchronize instance-specific resources          | Synchronize class-level resources              |

## 11. What is ```join()``` method?
The ```join()``` method is a way to pause the execution of the current thread until another thread has finished its execution. It allows one thread to wait for the completion of another thread.

## 12. what is ```yield()``` method
The ```yield()``` method is a way for a thread to pause execution temporarily, suggesting to the thread scheduler that other threads of the same or higher priority should execute. It does not guarantee the thread will stop, as it merely acts as a hint to the scheduler. When invoked, ```yield()``` moves the current thread from the RUNNING state to the RUNNABLE state, allowing other eligible threads to run, but the thread may re-enter the RUNNING state immediately if no other thread is ready. Being a static method, ```yield()``` always operates on the currently executing thread.

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
- A ThreadPool is a pool of pre-created threads. It allows reusing threads for multiple tasks, minimizing the overhead of thread creation and destruction. Thread pools are part of the java.util.concurrent package and are managed using the ExecutorService interface and its implementations.
- A TaskQueue is a queue used in a thread pool to hold tasks waiting to be executed. It serves as a buffer between task submission and execution, decoupling the two processes. This decoupling ensures efficient task scheduling and optimal thread utilization in the pool.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
The ExecutorService interface in the java.util.concurrent package provides the main functions for managing a thread pool. It extends the Executor interface and adds additional methods for thread pool management and task lifecycle control.

## 15. How to submit a task to ThreadPool?
To submit a task to a ThreadPool in Java, you use the ```submit()``` or ```execute()``` methods provided by the ExecutorService interface.
- Use the Executors utility class to create a ThreadPool.
- Use ```submit()``` for tasks that return a Future or ```execute()``` for tasks that do not return a result.
- The task can be an implementation of Runnable or Callable.
- Use ```shutdown()``` or ```shutdownNow()``` to cleanly shut down the ThreadPool when all tasks are complete.

## 16. What is the advantage of ThreadPool?
- Improved Performance: Faster task execution due to thread reuse.
- Resource Efficiency: Prevents excessive thread creation and resource contention.
- Simplified Management: Handles task scheduling and thread lifecycle internally.
- Scalability: Adapts to workload dynamically.
- Error Handling: Centralized exception and result tracking.

## 17. Difference between ```shutdown()``` and ```shutdownNow()``` methods of executor
| Feature                | `shutdown()`                                   | `shutdownNow()`                               |
|------------------------|-----------------------------------------------|-----------------------------------------------|
| **Behavior**           | Initiates an orderly shutdown of the executor. | Attempts to stop all actively executing tasks.|
| **Queued Tasks**       | Allows queued tasks to complete.              | Discards queued tasks.                        |
| **Running Tasks**      | Running tasks continue until completion.       | Interrupts running tasks.                     |
| **Returns**            | No immediate effect on running tasks.         | Returns a list of tasks that were not executed.|
| **Is Executor Terminated?** | Executor continues until all tasks finish. | Executor stops immediately.                   |

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
Atomic classes provide a way to perform operations on variables atomically (indivisibly). They belong to the java.util.concurrent.atomic package and are designed for use in multithreaded environments. These classes ensure that read-modify-write operations (like incrementing or updating values) are thread-safe without requiring explicit synchronization.

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
Concurrent collections in Java (java.util.concurrent package) are special data structures made for multithreaded programs. They allow multiple threads to access or modify them at the same time safely, without needing you to add synchronized blocks. These collections are faster and better for multithreaded environments because they use advanced techniques like fine-grained locking (locking only small parts of data) or non-blocking algorithms (avoiding locks entirely) to ensure both safety and speed.
- **Lists:** CopyOnWriteArrayList
- **Maps:** ConcurrentHashMap, ConcurrentSkipListMap
- **Queues:** ConcurrentLinkedQueue, LinkedBlockingQueue
- **Sets:** ConcurrentSkipListSet, CopyOnWriteArraySet

## 20. What kind of locks do you know? What is the advantage of each lock?
| Lock Type         | Advantages                                               | Use Case                                      |
|-------------------|----------------------------------------------------------|-----------------------------------------------|
| **Intrinsic Lock**| Simple to use, automatically released.                   | Basic thread synchronization.                |
| **ReentrantLock** | Interruptible acquisition, fairness, timeouts.           | Complex multithreading scenarios.            |
| **ReadWriteLock** | Concurrent reads, exclusive writes.                      | Read-heavy workloads.                        |
| **StampedLock**   | Non-blocking optimistic reads, efficient upgrades to write locks. | High-performance systems with rare writes. |
| **SpinLock**      | Lightweight, no blocking overhead.                       | Ultra-low latency systems.                   |
| **Fair Lock**     | Ensures fairness, prevents starvation.                   | Applications where fairness is required.     |
| **Optimistic Lock**| Non-blocking, relies on conflict resolution.             | High-contention environments like databases. |

## 21. What is future and completableFuture? List some main methods of ComplertableFuture.
- Future is a class in Java's java.util.concurrent package that represents the result of an asynchronous computation. It provides methods to check if the computation is complete, retrieve the result, or cancel the computation.
- CompletableFuture is an extension of Future introduced in Java 8. It is part of the java.util.concurrent package and provides a more powerful and flexible API for asynchronous programming. Unlike Future, it supports non-blocking operations, chaining, and handling exceptions.
- Main Methods of CompletableFuture:
    - Task Creation:
        - `supplyAsync(Supplier<T>)`: Runs a task asynchronously and returns a result.
        - `runAsync(Runnable)`: Runs a task asynchronously without a return value.
    - Chaining:
        - `thenApply(Function<T, R>)`: Transforms the result of a task.
        - `thenAccept(Consumer<T>)`: Consumes the result of a task without returning a value.
        - `thenCompose(Function<T, CompletionStage<R>>)`: Chains dependent tasks.
    - Combining Futures:
        - `thenCombine(CompletionStage<U>, BiFunction<T, U, R>)`: Combines the results of two tasks.
        - `allOf(CompletableFuture<?>...)`: Runs multiple tasks in parallel and waits for all to complete.
        - `anyOf(CompletableFuture<?>...)`: Runs multiple tasks in parallel and returns the result of the first completed task.
    - Exception Handling:
        - `exceptionally(Function<Throwable, T>)`: Handles exceptions by returning a fallback value.
        - `handle(BiFunction<T, Throwable, R>)`: Handles both results and exceptions.
    - Completion:
        - `complete(T)`: Completes the CompletableFuture with a result.
        - `completeExceptionally(Throwable)`: Completes the CompletableFuture with an exception.





































