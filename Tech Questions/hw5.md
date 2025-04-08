## 1. Read:

https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

## 2. Write a thread-safe singleton class

## 2. Write a Thread-Safe Singleton Class

A thread-safe singleton ensures that only one instance of a class is created, even when multiple threads try to access it simultaneously. Below is an example using double-checked locking and the `volatile` keyword.

---

### Thread-Safe Singleton using Double-Checked Locking

```java
public class Singleton {

    // Volatile ensures changes are visible across threads
    private static volatile Singleton instance;

    // Private constructor prevents instantiation from outside
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

---

### Usage Example

```java
public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true
    }
}
```

## 3. How to create a new thread(Please also consider Thread Pool approach)?

### 1. Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
new MyThread().start();
```

### 2. Implementing Runnable Interface

```java
Runnable task = () -> System.out.println("Runnable running");
new Thread(task).start();
```

### 3. Using Thread Pool (ExecutorService)

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Task running in thread pool"));
executor.shutdown();
```

Use `ExecutorService` for better thread management in real-world applications.

## 4. Difference between Runnable and Callable?

- `Runnable` and `Callable` are both used to define tasks that can run on separate threads, but they have key differences.

---

### Runnable

- Introduced in Java 1.0
- Cannot return a result
- Cannot throw a checked exception

```java
Runnable task = () -> System.out.println("Running a task");
new Thread(task).start();
```

---

### Callable

- Introduced in Java 5
- Can return a result (`V`)
- Can throw a checked exception

```java
Callable<String> task = () -> "Task result";
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(task);
String result = future.get(); // blocks until result is available
executor.shutdown();
```

---

### Summary Table

| Feature                  | Runnable         | Callable          |
| ------------------------ | ---------------- | ----------------- |
| Returns a result         | No               | Yes               |
| Throws checked exception | No               | Yes               |
| Used with                | Thread, Executor | Executor + Future |

- **Callable** can throw checked exceptions and return a result after execution, while **Runnable** cannot.

## 5. What is the difference between t.start() and t.run()?

- `t.start()` and `t.run()` are both methods of the `Thread` class, but they behave differently.

---

### t.start()

- Creates a **new thread** and executes the `run()` method in that new thread.
- Enables **multithreading**.
- Thread scheduling is handled by the JVM.

---

### t.run()

- Simply **calls the `run()` method** like a normal method.
- Runs in the **current thread**, not a new one.
- Does **not start a new thread**.

---

## 6. Which way of creating threads is better: Thread class or Runnable interface?

Using the **Runnable interface** is generally better than extending the **Thread class**, for the following reasons:

---

### Runnable Interface

- Allows your class to **extend other classes** (Java supports only single inheritance).
- Promotes **separation of task and thread logic**.
- More **flexible and reusable**, especially with thread pools.

```java
Runnable task = () -> System.out.println("Running task");
Thread thread = new Thread(task);
thread.start();
```

---

### Thread Class

- Use only when you need to **override additional methods** in the `Thread` class (rare).
- Less flexible, as it ties task logic directly to the thread.

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running thread");
    }
}
new MyThread().start();
```

---

## 7. What are the thread statuses?

In Java, a thread can be in one of the following **states**, represented by the `Thread.State` enum:

---

### 1. NEW

- A thread that has been created but **not yet started** using `start()`.

---

### 2. RUNNABLE

- The thread is **ready to run** or is **running**, depending on the thread scheduler.

---

### 3. BLOCKED

- The thread is **waiting to acquire a lock** held by another thread.

---

### 4. WAITING

- The thread is **waiting indefinitely** for another thread to perform a specific action (e.g., using `wait()` without timeout).

---

### 5. TIMED_WAITING

- The thread is **waiting for a specific amount of time** (e.g., `sleep(ms)`, `join(ms)`, `wait(ms)`).

---

### 6. TERMINATED

- The thread has **completed execution** or has been **abruptly stopped** due to an exception.

---

## 8. Demonstrate deadlock and how to resolve it in Java code.

### What is Deadlock?

A **deadlock** occurs when two or more threads are blocked forever, each waiting for a resource held by the other.

**Example scenario:**

- Thread 1 holds `resource1` and waits for `resource2`
- Thread 2 holds `resource2` and waits for `resource1`

---

### Deadlock Example

```java
public class DeadlockExample {

    static final Object resource1 = new Object();
    static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked resource 1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println("Thread 1 locked resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked resource 2");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resource1) {
                    System.out.println("Thread 2 locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

---

### Ways to Resolve Deadlock

#### 1. Use `Thread.join()`

Ensure threads finish one by one to avoid overlap.

```java
t1.start();
t1.join(); // Waits for t1 to finish before t2 starts
t2.start();
```

#### 2. Use Lock Ordering

Always acquire locks in the same order to avoid circular waiting.

```java
synchronized (resource1) {
    synchronized (resource2) {
        // consistent lock order
    }
}
```

#### 3. Avoid Unnecessary Locks

Reduce the number of synchronized blocks or shared resources when possible.

---

## 9. How do threads communicate each other?

In Java, threads communicate with each other primarily through **shared objects** and use **synchronization techniques** to coordinate their actions. Common Mechanism: `wait()`, `notify()`, and `notifyAll()`

## 10. What’s the difference between class lock and object lock?

In Java, synchronization can be applied to either an **object** or a **class**, and each has a different locking mechanism.

---

### Object Lock

- Applied when synchronizing **non-static methods** or code blocks using `synchronized(this)`.
- Lock is associated with a **specific instance** of the class.
- Only one thread can execute a synchronized block on the same object at a time.

```java
public synchronized void instanceMethod() {
    // Object lock - tied to the instance
}
```

```java
synchronized(this) {
    // Also uses object lock
}
```

---

### Class Lock

- Applied when synchronizing **static methods** or using `synchronized(ClassName.class)`.
- Lock is associated with the **class object itself**, not any instance.
- Useful for synchronizing shared static data.

```java
public static synchronized void staticMethod() {
    // Class lock - tied to the Class object
}
```

```java
synchronized(MyClass.class) {
    // Also uses class lock
}
```

---

## 11. What is join() method?

The `join()` method in Java is used to **pause the current thread** until the thread on which `join()` is called **finishes execution**.

It helps in **thread coordination**, ensuring that one thread completes before another starts or continues.

## 12. what is yield() method?

- The `yield()` method is a static method in the `Thread` class that causes the **currently executing thread** to **pause** and give a chance for other threads of the **same priority** to execute.

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

### What is ThreadPool?

A **ThreadPool** is a pool of reusable threads used to execute tasks efficiently without the overhead of creating new threads for every task.

It is part of `java.util.concurrent` and managed via the `ExecutorService`.

---

### Types of ThreadPool (via `Executors` class):

1. **FixedThreadPool**

   - A fixed number of threads.
   - Best for consistent workload.

   ```java
   ExecutorService pool = Executors.newFixedThreadPool(5);
   ```

2. **CachedThreadPool**

   - Creates new threads as needed and reuses idle threads.
   - Suitable for short-lived, high-volume tasks.

   ```java
   ExecutorService pool = Executors.newCachedThreadPool();
   ```

3. **SingleThreadExecutor**

   - One thread processes tasks sequentially.
   - Useful for background tasks that must not overlap.

   ```java
   ExecutorService pool = Executors.newSingleThreadExecutor();
   ```

4. **ScheduledThreadPool**

   - For scheduling tasks with delay or periodic execution.

   ```java
   ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
   ```

---

### What is TaskQueue in ThreadPool?

- The **TaskQueue** is a **blocking queue** that holds submitted tasks before they are executed by threads.
- If all threads are busy, tasks are added to this queue.
- Backed by implementations like `LinkedBlockingQueue` or `ArrayBlockingQueue`.

---

### Example:

```java
ExecutorService pool = Executors.newFixedThreadPool(3);

for (int i = 0; i < 10; i++) {
    int taskId = i;
    pool.submit(() -> {
        System.out.println("Executing task " + taskId);
    });
}

pool.shutdown();
```

---

### Summary:

- ThreadPool = Reuse threads to handle multiple tasks efficiently.
- Types: Fixed, Cached, Single, Scheduled.
- TaskQueue holds pending tasks when all threads are busy.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

### Library:

- Java provides the **`java.util.concurrent`** package to create and manage thread pools.
- The `Executors` utility class is commonly used to create different types of thread pools.

```java
import java.util.concurrent.Executors;
```

---

### Interface:

- The main interface that provides thread pool functionality is **`ExecutorService`**.
- It provides methods like:
  - `submit(Runnable task)`
  - `shutdown()`
  - `invokeAll(...)`
  - `awaitTermination(...)`

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService pool = Executors.newFixedThreadPool(3);
pool.submit(() -> System.out.println("Running task"));
pool.shutdown();
```

---

## 15. How to submit a task to ThreadPool?

To submit a task to a ThreadPool in Java, use the **`submit()`** or **`execute()`** method of the `ExecutorService` interface.

---

### Step-by-Step:

1. Import the required classes.
2. Create a thread pool using `Executors`.
3. Submit tasks using `submit()` or `execute()`.
4. Shutdown the pool after tasks are submitted.

---

## 16. What is the advantage of ThreadPool?

A **ThreadPool** is a pool of pre-created worker threads used to execute tasks efficiently. It offers several advantages over creating new threads manually.

---

### Advantages of ThreadPool:

1. **Better Performance**

   - Reuses existing threads instead of creating new ones for each task, reducing overhead.

2. **Resource Management**

   - Limits the number of concurrent threads, preventing system overload.

3. **Task Queueing**

   - Excess tasks are placed in a queue and executed as threads become available.

4. **Simplified Thread Management**

   - Managed lifecycle (start, reuse, shutdown) using `ExecutorService`.

5. **Scalability**
   - Suitable for high-volume, concurrent applications.

---

## 17. Difference between shutdown() and shutdownNow() methods of executor

Both `shutdown()` and `shutdownNow()` are methods of the `ExecutorService` interface used to terminate a thread pool, but they behave differently.

---

### shutdown()

- **Initiates an orderly shutdown**: previously submitted tasks are executed, but no new tasks will be accepted.
- **Does not interrupt** currently running tasks.
- Thread pool remains alive until all tasks complete.

```java
executor.shutdown();
```

---

### shutdownNow()

- **Attempts to stop all actively executing tasks** and halts the processing of waiting tasks.
- **Returns a list of tasks** that were submitted but not yet started.
- Interrupts all running threads (using `Thread.interrupt()`), but they may or may not stop depending on the task implementation.

```java
List<Runnable> pendingTasks = executor.shutdownNow();
```

---

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

### What Are Atomic Classes?

Atomic classes in Java (`java.util.concurrent.atomic` package) provide **lock-free**, **thread-safe operations** on single variables (like int, long, reference types).

They use **low-level atomic CPU instructions (CAS - Compare and Swap)** for high-performance concurrent updates.

---

### When to Use Atomic Classes?

- When multiple threads need to **update shared variables safely** without using `synchronized`.
- Ideal for **counters**, **flags**, or **reference updates** in multithreaded applications.

---

### Common Types of Atomic Classes:

1. `AtomicInteger` – for `int` values
2. `AtomicLong` – for `long` values
3. `AtomicBoolean` – for boolean flags
4. `AtomicReference<T>` – for object references
5. `AtomicIntegerArray`, `AtomicLongArray`, etc.

---

### Example: AtomicInteger

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increments by 1
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}

        System.out.println("Final counter: " + counter.get()); // Output: 2000
    }
}
```

---

### Key Methods in AtomicInteger:

- `get()` – returns the current value
- `set(int newValue)` – sets a new value
- `incrementAndGet()` – increments by 1 and returns the new value
- `decrementAndGet()` – decrements by 1 and returns the new value
- `compareAndSet(expected, update)` – atomically sets value if current equals expected

---

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

**Concurrent collections** are part of the `java.util.concurrent` package and are designed to be **thread-safe**. They allow multiple threads to safely access, update, or iterate over shared data structures **without needing external synchronization**.

They are more efficient and scalable than manually synchronizing standard collections like `ArrayList` or `HashMap`.

---

### Common Concurrent Data Structures in Java:

| Data Structure          | Description                                                    |
| ----------------------- | -------------------------------------------------------------- |
| `ConcurrentHashMap`     | Thread-safe version of `HashMap` (no locking full map)         |
| `CopyOnWriteArrayList`  | Safe array list where reads are fast; writes copy entire array |
| `CopyOnWriteArraySet`   | Thread-safe set backed by `CopyOnWriteArrayList`               |
| `ConcurrentLinkedQueue` | Non-blocking queue for high-concurrency scenarios              |
| `ConcurrentLinkedDeque` | Double-ended queue with non-blocking operations                |
| `LinkedBlockingQueue`   | Blocking queue with optional capacity limit                    |
| `ArrayBlockingQueue`    | Bounded blocking queue backed by array                         |
| `PriorityBlockingQueue` | Thread-safe priority queue                                     |
| `DelayQueue`            | A queue where elements become available after a delay          |
| `SynchronousQueue`      | Queue with no internal capacity (used for handoff)             |
| `BlockingDeque`         | Double-ended blocking queue interface                          |

---

## 20. What kind of locks do you know? What is the advantage of each lock?

In Java, different types of locks are used to control access to shared resources in multi-threaded environments. Each lock type offers specific benefits depending on the use case.

---

### 1. Intrinsic Lock (Synchronized)

- Built-in lock used with `synchronized` blocks/methods.
- Automatically manages acquiring and releasing the lock.

**Advantages:**

- Simple and easy to use.
- No need to manually acquire/release locks.

---

### 2. ReentrantLock (java.util.concurrent.locks)

- A flexible lock that provides more control than `synchronized`.

**Advantages:**

- Supports try-lock with timeout (`tryLock()`).
- Can interrupt waiting threads.
- Can be used with `Condition` for advanced wait/notify.

---

### 3. ReadWriteLock

- Separates **read** and **write** access using `ReadLock` and `WriteLock`.

**Advantages:**

- Multiple threads can read concurrently.
- Write lock is exclusive.
- Improves performance when reads are more frequent than writes.

---

### 4. StampedLock (Java 8+)

- Advanced version of `ReadWriteLock` that adds **optimistic locking**.

**Advantages:**

- High performance in read-heavy scenarios.
- Supports optimistic reads (no locking unless write occurs).

---

## 21. What is future and completableFuture? List some main methods of ComplertableFuture.

---

### Future

- Represents the **result of an asynchronous computation**.
- Returned by `ExecutorService.submit()`.
- You can check if the task is complete, block until it’s done, or cancel it.

---

### CompletableFuture

- An enhancement over `Future` that supports:
  - **Non-blocking callbacks**
  - **Task chaining**
  - **Combining multiple futures**
  - **Manually completing** a future

## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

This example uses `wait()` and `notify()` to coordinate two threads: one for printing odd numbers and one for even numbers.

```java
package com.chuwa.tutorial.t08_multithreading.c05_waitNotify;

public class OddEvenPrinter {

    private int count = 1;
    private final int MAX = 10;

    public void printOdd() {
        synchronized (this) {
            while (count <= MAX) {
                if (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Odd: " + count);
                    count++;
                    notify();
                }
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (count <= MAX) {
                if (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Even: " + count);
                    count++;
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}
```

### Output:

```
Odd: 1
Even: 2
Odd: 3
Even: 4
...
Odd: 9
Even: 10
```
