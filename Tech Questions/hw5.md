# hw4

---

### 1. Write a thread-safe singleton class
    class Singleton {
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

### 2. How to create a new thread (Please also consider Thread Pool approach)?
1. Using `Thread` class:
    ```
    class MyThread extends Thread {
        public void run() {
            System.out.println("Thread is running...");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }
    
    ```
2. Using `Runnable` interface:
    ```
    class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Runnable is running...");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }
    
    ```
3. Using `Thread` Pool:
    ```
    public class Main {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(() -> System.out.println("Task executed by Thread Pool"));
            executor.shutdown();
        }
    }
    
    ```
   
### 3. Difference between Runnable and Callable?
- `Runnable`: Does not return a result and cannot throw checked exceptions.
- `Callable`: Returns a result (`Future<V>`) and can throw checked exceptions.
    ```
    public class Main {
        public static void main(String[] args) throws Exception {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Callable<Integer> task = () -> 123;
            Future<Integer> future = executor.submit(task);
            System.out.println("Result: " + future.get());
            executor.shutdown();
        }
    }
    ```
  
### 4. What is the difference between `t.start()` and `t.run()`?
- `t.start()`: Starts a new thread and invokes `run()` in that thread.
- `t.run()`: Runs the code in the current thread without starting a new thread.

### 5. Which way of creating threads is better: `Thread` class or `Runnable` interface?
Using the `Runnable` interface is better for:

1. Code reusability (since it can implement other interfaces).
2. Decoupling task logic from thread control.

### 6. What are the thread statuses?
- **NEW**: Not started yet.
- **RUNNABLE**: Running or ready to run.
- **BLOCKED**: Waiting for a monitor lock.
- **WAITING/TIMED_WAITING**: Waiting indefinitely or for a specific time.
- **TERMINATED**: Execution finished.

### 7. Demonstrate deadlock and how to resolve it in Java code.

    class Deadlock {
        static final Object lock1 = new Object();
        static final Object lock2 = new Object();
    
        public static void main(String[] args) {
            new Thread(() -> {
                synchronized (lock1) {
                    try { Thread.sleep(100); } catch (Exception ignored) {}
                    synchronized (lock2) {
                        System.out.println("Thread 1 finished");
                    }
                }
            }).start();
    
            new Thread(() -> {
                synchronized (lock2) {
                    try { Thread.sleep(100); } catch (Exception ignored) {}
                    synchronized (lock1) {
                        System.out.println("Thread 2 finished");
                    }
                }
            }).start();
        }
    }

**Resolution**: Avoid nested locks or use `tryLock()` from `ReentrantLock`.

### 8. How do threads communicate each other?
Threads communicate using methods like `wait()`, `notify()`, `notifyAll()`.
    
    class Communication {
        public static void main(String[] args) {
            Object lock = new Object();
            new Thread(() -> {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println("Thread notified");
                    } catch (InterruptedException ignored) {}
                }
            }).start();
    
            new Thread(() -> {
                synchronized (lock) {
                    lock.notify();
                    System.out.println("Thread notifying");
                }
            }).start();
        }
    }

### 9. What’s the difference between class lock and object lock?
- **Class lock**: Achieved by synchronizing static methods or using `Class.class` as a lock.
- **Object lock**: Achieved by synchronizing instance methods or a specific object.

### 10. join() method
- Waits for a thread to die before continuing the current thread.

### 11. yield() method
- Gives the CPU to other threads of equal priority.

### 12. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
- A ThreadPool is a pool of pre-created and reusable threads used to execute tasks. It helps manage multiple threads efficiently by reusing existing threads instead of creating new ones, reducing the overhead of thread creation and destruction.


What is ThreadPool?
- A ThreadPool is a pool of pre-created and reusable threads used to execute tasks. It helps manage multiple threads efficiently by reusing existing threads instead of creating new ones, reducing the overhead of thread creation and destruction.

Types of ThreadPool
1. **FixedThreadPool**:

   - A pool with a fixed number of threads.
   - New tasks wait in the queue if all threads are busy.
   - Example: `Executors.newFixedThreadPool(5)`
2. **CachedThreadPool**:

   - A pool with an unlimited number of threads.
   - Threads are created as needed but reused when available.
   - Example: `Executors.newCachedThreadPool()`
3. **SingleThreadExecutor**:

   - A pool with a single thread to execute tasks sequentially.
   - Example: `Executors.newSingleThreadExecutor()`
4. **ScheduledThreadPool**:

   - A pool for scheduling tasks with a fixed delay or at a fixed rate.
   - Example: `Executors.newScheduledThreadPool(3)`

What is the TaskQueue in ThreadPool?
- The **TaskQueue** is a queue that holds tasks waiting to be executed by threads in the pool. If all threads are busy, new tasks are added to the queue until a thread becomes available.

  - Example of a queue used in ThreadPools:
    - **BlockingQueue**, such as `LinkedBlockingQueue` or `ArrayBlockingQueue`.
    - The queue ensures thread-safe task management and execution order.


### 13. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
- The `java.util.concurrent` library is used to create ThreadPools in Java.
- The `ExecutorService` interface provides the main functions of a ThreadPool, such as task submission (`submit`), shutdown management (`shutdown`, `shutdownNow`), and task execution control (`invokeAll`, `invokeAny`).

### 14. How to submit a task to ThreadPool?
Tasks can be submitted to a ThreadPool using the `submit()` or `execute()` methods provided by an `ExecutorService`.
```
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a ThreadPool with 3 threads

        // Submit tasks to the ThreadPool
        executor.submit(() -> System.out.println("Task 1 executed by " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 2 executed by " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 3 executed by " + Thread.currentThread().getName()));

        executor.shutdown(); // Shut down the ThreadPool
    }
}
```

### 15. What is the advantage of ThreadPool?
1. **Improved Performance**:

   - Reduces the overhead of thread creation and destruction.
   - Reuses threads, avoiding frequent allocation and deallocation.
2. **Better Resource Management**:

   - Controls the number of concurrent threads to prevent overloading the CPU or memory.
3. **Scalability**:

   - Allows efficient execution of large numbers of tasks by using a limited number of threads.
4. **Task Queueing**:

   - Maintains a queue of tasks and executes them as threads become available.
5. **Convenience**:

   - Simplifies coding for managing a large number of tasks by providing built-in mechanisms like scheduling and task cancellation.
6. **Prevents Excessive Thread Creation**:

   - Avoids issues such as memory exhaustion caused by creating too many threads.

**Key Use Cases**:

- Web servers
- File I/O operations
- Background task execution

### 16. Difference between `shutdown()` and `shutdownNow()` methods of executor
`shutdown()`: Completes all running tasks and then stops.
`shutdownNow()`: Stops all tasks immediately and returns unfinished tasks.

### 17. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
- **Atomic classes** in Java are part of the `java.util.concurrent.atomic` package. They provide thread-safe operations on single variables without using synchronization.

  **Types of Atomic Classes**
  1. **AtomicInteger**: For integers.
  2. **AtomicLong**: For long values.
  3. **AtomicBoolean**: For boolean values.
  4. **AtomicReference**: For object references.
  5. **AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray**: For arrays.
```
public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment and get
        System.out.println(atomicInt.incrementAndGet()); // Output: 1

        // Compare and set
        boolean updated = atomicInt.compareAndSet(1, 10);
        System.out.println(updated); // Output: true
        System.out.println(atomicInt.get()); // Output: 10

        // Get and add
        System.out.println(atomicInt.getAndAdd(5)); // Output: 10
        System.out.println(atomicInt.get()); // Output: 15
    }
}
```

**When to Use Atomic Classes?**
- Use **Atomic classes** when performing thread-safe operations on a single variable or array.
- Ideal for scenarios where locks would otherwise be required for simple updates (e.g., counters, flags).

### 18. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
- **Concurrent collections** are thread-safe data structures provided in the `java.util.concurrent` package, designed to handle concurrent access and modifications without the need for explicit synchronization.

**Examples of Concurrent Data Structures**

1. **ConcurrentHashMap**: A thread-safe alternative to `HashMap`.
2. **CopyOnWriteArrayList**: A thread-safe alternative to `ArrayList`.
3. **CopyOnWriteArraySet**: A thread-safe alternative to `HashSet`.
4. **ConcurrentLinkedQueue**: A thread-safe queue for FIFO operations.
5. **ConcurrentLinkedDeque**: A thread-safe deque for double-ended queue operations.
6. **LinkedBlockingQueue**: A blocking queue with thread-safe operations.
7. **PriorityBlockingQueue**: A thread-safe priority queue.
8. **ConcurrentSkipListMap**: A thread-safe sorted map.
9. **ConcurrentSkipListSet**: A thread-safe sorted set.

**Usage**

- Concurrent collections should be used in multithreaded environments where thread-safe operations on data structures are required, without the overhead of manual synchronization.

### 19. What kind of locks do you know? What is the advantage of each lock?
1. Synchronized Block/Method

   - Advantage: Easy to use and ensures mutual exclusion.
2. ReentrantLock

   - Advantage: Flexible, supports tryLock and fairness policies.
3. ReadWriteLock

   - Advantage: Allows multiple readers or one writer, improves performance in read-heavy scenarios.
4. Semaphore

   - Advantage: Controls access to a limited number of resources.
5. CountDownLatch

   - Advantage: Synchronizes threads by waiting for a specific number of signals.

### 20. What is future and completableFuture? List some main methods of ComplertableFuture.
What is `Future`?
- A `Future` represents the result of an asynchronous computation.
- Provides methods to check if the computation is complete, retrieve the result, or cancel the task.

What is `CompletableFuture`?
- A more advanced version of `Future` that allows chaining, combining tasks, and handling results asynchronously.
- Part of `java.util.concurrent`.

Main Methods of `CompletableFuture`
1. `supplyAsync()` / `runAsync()`: Start asynchronous tasks.
2. `thenApply()`: Transform the result of a task.
3. `thenAccept()`: Consume the result of a task.
4. `thenCombine()`: Combine results of two tasks.
5. `exceptionally()`: Handle exceptions.
6. `join()` / `get()`: Retrieve the result of the task.
7. `complete()`: Manually complete the task.
```
public class Main {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                         .thenApply(result -> result + " World")
                         .thenAccept(System.out::println);
    }
}
```

