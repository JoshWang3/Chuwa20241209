## 1. Read:https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lo ck

---

## 2. Write a thread-safe singleton class

```java
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

---

## 3. How to create a new thread (Please also consider Thread Pool approach)?

### Creating a thread using `Thread` class:
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

### Creating a thread using `Runnable` interface:
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

### Using Thread Pool:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> System.out.println("Thread is running: " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}
```

---

## 4. Difference between Runnable and Callable?

| Feature             | Runnable                      | Callable                 |
|---------------------|-------------------------------|--------------------------|
| Return Type         | `void`                       | `Future<T>`             |
| Exception Handling  | Cannot throw checked exceptions | Can throw checked exceptions |
| Method              | `run()`                      | `call()`                |
| Used With           | `Thread` or ExecutorService   | ExecutorService         |

---

## 5. What is the difference between `t.start()` and `t.run()`?

- `t.start()`:
    - Creates a new thread and executes the `run()` method in that thread.
    - Actual multithreading happens.

- `t.run()`:
    - Executes the `run()` method in the current thread as a normal method call.
    - No multithreading occurs.

---

## 6. Which way of creating threads is better: Thread class or Runnable interface?

- **Runnable interface is generally better**:
    - Allows extending other classes since Java does not support multiple inheritance.
    - Decouples the task from the thread, promoting reusability and better design.

---

## 7. What are the thread statuses?

1. **New**: Thread is created but not started.
2. **Runnable**: Thread is ready to run and waiting for CPU time.
3. **Running**: Thread is executing.
4. **Blocked**: Waiting to acquire a lock or resource.
5. **Waiting**: Indefinitely waiting for another thread to perform a specific action.
6. **Timed Waiting**: Waiting for a specified time.
7. **Terminated**: Thread has completed execution.

---

## 8. Demonstrate deadlock and how to resolve it in Java code.

### Example of Deadlock:
```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Holding lock on A");
        synchronized (b) {
            System.out.println("Thread 1: Acquired lock on B");
        }
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Holding lock on B");
        synchronized (a) {
            System.out.println("Thread 2: Acquired lock on A");
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> a.methodA(b));
        Thread t2 = new Thread(() -> b.methodB(a));

        t1.start();
        t2.start();
    }
}
```

### Resolving Deadlock:
- Use a consistent lock order:
```java
synchronized void methodA(B b) {
    synchronized (this) {
        synchronized (b) {
            // Code
        }
    }
}
```

---

## 9. How do threads communicate with each other?

- **Using `wait()`, `notify()`, and `notifyAll()`**:
```java
class Shared {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producing...");
        wait();
        System.out.println("Resumed");
    }

    synchronized void consume() {
        System.out.println("Consuming...");
        notify();
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread t1 = new Thread(() -> {
            try {
                shared.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(shared::consume);

        t1.start();
        t2.start();
    }
}
```

---

## 10. What’s the difference between class lock and object lock?

| Feature       | Class Lock                              | Object Lock                       |
|---------------|----------------------------------------|-----------------------------------|
| Scope         | Entire class (shared across all objects)| Specific instance of the class   |
| Achieved By   | `synchronized` on static methods or `class` object | `synchronized` on instance methods or `this` |
| Use Case      | Protects static data shared among threads | Protects instance data of an object |

### Example:
```java
class Example {
    synchronized static void classLock() {
        // Class-level lock
    }

    synchronized void objectLock() {
        // Object-level lock
    }
}
```

---

## 11. What is `join()` method?
The `join()` method in Java is used to make the current thread wait until the thread on which the method is called has finished execution. It ensures that a thread's execution completes before other threads continue.

### Example:
```java
Thread t = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        System.out.println("Thread running: " + i);
    }
});
t.start();
t.join(); // Main thread waits for `t` to finish
System.out.println("Main thread continues.");
```

---

## 12. What is `yield()` method?
The `yield()` method in Java is used to hint to the thread scheduler that the current thread is willing to yield its current use of the CPU. It moves the thread from running to a ready state.

### Example:
```java
Thread t = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        System.out.println("Thread running: " + i);
        Thread.yield();
    }
});
t.start();
```

---

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
- **ThreadPool**: A ThreadPool in Java is a pool of pre-created worker threads that efficiently execute tasks. It reduces the overhead of thread creation and destruction.
- **Types of ThreadPools**:
  - `FixedThreadPool`
  - `CachedThreadPool`
  - `SingleThreadExecutor`
  - `ScheduledThreadPool`
- **TaskQueue**: It's a blocking queue that holds tasks before they are executed by the threads in the pool.

---

## 14. Which library is used to create ThreadPool? Which interface provides the main functions of ThreadPool?
- **Library**: `java.util.concurrent` package.
- **Interface**: The `ExecutorService` interface provides the main functionalities of ThreadPool.

---

## 15. How to submit a task to ThreadPool?
You can submit a task using `execute()` or `submit()` methods provided by the `ExecutorService`.

### Example:
```java
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Task executed"));
executor.shutdown();
```

---

## 16. What is the advantage of ThreadPool?
- **Improved performance**: Reuses threads, reducing the overhead of thread creation and destruction.
- **Better resource management**: Controls the number of active threads.
- **Scalability**: Handles a large number of tasks efficiently.

---

## 17. Difference between `shutdown()` and `shutdownNow()` methods of executor
- **`shutdown()`**: Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
- **`shutdownNow()`**: Attempts to stop all actively executing tasks and halts the processing of waiting tasks.

---

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. When to use it?
- **Atomic classes**: They provide thread-safe operations on single variables like integers, booleans, or references without using locks.
- **Types**:
  - `AtomicInteger`
  - `AtomicLong`
  - `AtomicBoolean`
  - `AtomicReference`
- **Example**:
```java
AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet(); // Atomically increments and returns the new value
System.out.println(count.get());
```
- **Usage**: When you need thread-safe operations without the overhead of locks.

---

## 19. What is the concurrent collections? Can you list some concurrent data structures (Thread-safe)?
- **Concurrent collections**: These are collections designed for concurrent access by multiple threads without requiring synchronization.
- **Examples**:
  - `ConcurrentHashMap`
  - `ConcurrentLinkedQueue`
  - `CopyOnWriteArrayList`
  - `ConcurrentSkipListMap`

---

## 20. What kind of locks do you know? What is the advantage of each lock?
- **Types of locks**:
  - `ReentrantLock`: Allows a thread to re-acquire the same lock it already holds.
  - `ReadWriteLock`: Allows multiple threads to read concurrently but writes are exclusive.
  - `StampedLock`: Provides optimistic locking for better performance.
- **Advantages**:
  - **ReentrantLock**: Fine-grained control over locking and unlocking.
  - **ReadWriteLock**: Improves read concurrency.
  - **StampedLock**: Optimizes performance in high-read, low-write scenarios.

---

## 21. What is `Future` and `CompletableFuture`? List some main methods of `CompletableFuture`.

### Future
- **Definition**: `Future` is an interface in Java used to represent the result of an asynchronous computation. It provides methods to check if the computation is complete, retrieve the result, or cancel the computation.
- **Limitations**:
  - Cannot manually complete the `Future`.
  - Lacks advanced features for chaining and combining tasks.

### CompletableFuture
- **Definition**: `CompletableFuture` is a class in Java that implements the `Future` interface and provides additional methods to support asynchronous programming with better control and functionality.
- **Advantages over Future**:
  - Supports non-blocking operations.
  - Can chain multiple asynchronous tasks.
  - Can handle exceptions and combine multiple tasks.

### Main Methods of `CompletableFuture`
1. **Task Completion**:
  - `complete(T value)`: Completes the future with the given value.
  - `completeExceptionally(Throwable ex)`: Completes the future with an exception.

2. **Combining Futures**:
  - `thenCombine()`: Combines the results of two futures.
  - `thenAcceptBoth()`: Consumes results of two futures.

3. **Chaining**:
  - `thenApply(Function<T, R>)`: Transforms the result of the future.
  - `thenAccept(Consumer<T>)`: Consumes the result without returning anything.
  - `thenRun(Runnable)`: Executes a task after the future completes.

4. **Exception Handling**:
  - `exceptionally(Function<Throwable, T>)`: Handles exceptions.
  - `handle(BiFunction<T, Throwable, T>)`: Handles the result or exception.

5. **Asynchronous Execution**:
  - `runAsync(Runnable)`: Runs a task asynchronously.
  - `supplyAsync(Supplier<T>)`: Executes a Supplier task asynchronously.

6. **Combining Multiple Futures**:
  - `allOf(CompletableFuture<?>... cfs)`: Waits for all provided futures to complete.
  - `anyOf(CompletableFuture<?>... cfs)`: Waits for any one of the provided futures to complete.

### Example:
```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    return "Result from async computation";
});

future.thenApply(result -> "Processed: " + result)
      .thenAccept(System.out::println)
      .exceptionally(ex -> {
          System.out.println("Exception occurred: " + ex.getMessage());
          return null;
      });
```

---

## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

---

## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
**1. One solution use synchronized and wait notify**
**2. One solution use ReentrantLock and await,signal**

---

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

---

## 25. completable future:

[Link to the code](../Coding/Multithreading/)