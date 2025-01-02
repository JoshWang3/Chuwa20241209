# HW5
____
### 2. Write a thread-safe singleton class
```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### 3. How to create a new thread (Please also consider ThreadPool approach)?
- Use `Thread` class
```java
public class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadExample thread = new ThreadExample();
        thread.start(); // Starts the thread
    }
}
```

- Use `Runnable` interface
```java
public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableExample task = new RunnableExample();
        Thread thread = new Thread(task);
        thread.start(); // Starts the thread
    }
}
```

- Use ThreadPool
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i; // Use a final or effectively final variable
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running on: " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown(); // Initiates an orderly shutdown
    }
}
// output:
// Task 1 is running on: pool-1-thread-1
// Task 2 is running on: pool-1-thread-2
// Task 3 is running on: pool-1-thread-3
// Task 4 is running on: pool-1-thread-1
// Task 5 is running on: pool-1-thread-2
```

### 4. Difference between Runnable and Callable?

- `Runnable` returns `void` and cannot throw checked exceptions, while `Callable` returns a result and can throw checked exceptions.
- `Runnable` cannot throw checked exceptions, while `Callable` can throw checked exceptions.

### 5. What is the difference between t.start() and t.run()?
`t.start()` creates a new thread and executes the `run()` method in a separate thread, while `t.run()` simply calls the `run()` method in the current thread.

### 6. Which way of creating threads is better: Thread class or Runnable interface?

Runnable interface is better:
- Runnable separates the task from the thread, which is a better object-oriented design.
- Runnable can be reused by multiple threads, while Thread is a single-use class.

### 7. What are the thread statuses?
1. New: When a thread is created but not started yet.
2. Runnable: When a thread is ready to run but waiting for CPU time.
3. Blocked: When a thread is waiting for a monitor lock to enter a synchronized block or method.
4. Waiting: When a thread is waiting indefinitely for another thread to perform a particular action.
5. Timed Waiting: When a thread is waiting for a specified amount of time.
6. Terminated: When a thread has completed its execution or terminated due to an uncaught exception.

### 8. Demonstrate deadlock and how to resolve it in Java code.
Two threads are waiting for each other to release a lock, causing a deadlock.
```java
public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

### 9. How do threads communicate each other?
- Shared memory and synchronization mechanisms like locks, semaphores, and monitors.
- wait(), notify(), and notifyAll() methods in Java.
- join() method to wait for a thread to complete.

### 10. What’s the difference between class lock and object lock?
- Class Lock: In java, each and every class has a unique lock usually referred to as a class level lock. These locks are achieved using the keyword ‘static synchronized’ and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block. 
- Object Lock: In java, each and every object has a unique lock usually referred to as an object-level lock. These locks are achieved using the keyword ‘synchronized’ and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.

### 11. What is join() method?
The `join()` method is used to wait for a thread to complete its execution. It makes the current thread wait until the thread on which it is called is terminated.

### 12. what is yield() method?
The `yield()` method is used to signal the thread scheduler that the current thread is willing to yield its current use of the CPU. The thread calling yield() temporarily pauses its execution and moves from the RUNNING state to the READY state.

### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A ThreadPool is a group of worker threads that are waiting for tasks and execute them. It is used to manage the execution of tasks in a multithreaded environment.
There are different types of ThreadPool implementations in Java:
1. `FixedThreadPool`: A fixed-size thread pool that reuses a fixed number of threads.
2. `CachedThreadPool`: A thread pool that creates new threads as needed but reuses previously constructed threads when they are available.
3. `SingleThreadPool`: A single-threaded executor that uses a single worker thread operating off an unbounded queue.

### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
The `java.util.concurrent` package provides classes and interfaces for creating and managing thread pools. The `ExecutorService` interface provides the main functions of a thread pool.

### 15. How to submit a task to ThreadPool?
You can submit a task to a ThreadPool using the `submit()` or `execute()` method of the `ExecutorService` interface.

### 16. What is the advantage of ThreadPool?
- Reuse threads, better performance
- Limit the number of Threads, efficient resource management
- Handles thread lifecycle, simplifies thread management

### 17. Difference between shutdown() and shutdownNow() methods of executor
- Use shutdown() when you want to complete all tasks gracefully while preventing new tasks.
- Use shutdownNow() for emergency shutdowns where ongoing and waiting tasks need to be stopped immediately.

### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
Atomic classes in Java are part of the java.util.concurrent.atomic package and provide a way to perform atomic (thread-safe) operations on single variables without the need for explicit synchronization.

Types of Atomic classes:
- AtomicInteger
- AtomicLong
- AtomicBoolean

Example:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        // Retrieves the current value and then increments it
        System.out.println(atomicInteger.getAndIncrement());
        // output: 1
        
        // Retrieves the current value after the increment performed by getAndIncrement
        System.out.println(atomicInteger.get());
        // output: 2
    }
}
```





























