2. 
```Java

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

3. 
```Java

Thread thread = new Thread(() -> {
    System.out.println("Hello from a new thread!");
});
thread.start();

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        executor.submit(() -> {
            System.out.println("Task executed by thread pool");
        });
        
        executor.shutdown();
    }
}

```

4. 
   1. Runnable:
      1. Does not return a result. 
      2. Cannot throw checked exceptions. 
      3. The run() method returns void. 
   2. Callable:
      1. Returns a result via the call() method. 
      2. Can throw checked exceptions. 
      3. Often used with Future to retrieve the result.

5. 
   1. t.start():
      1. Initiates a new thread of execution and then calls the thread’s run() method internally.
   2. t.run():
      1. Simply executes the run() method in the current thread (i.e., no new thread is created).

6. Implementing Runnable is preferred. 
7. 
   1. NEW: Thread is created but not started. 
   2. RUNNABLE: Thread is ready to run or running. 
   3. BLOCKED: Thread is blocked waiting for a monitor lock. 
   4. WAITING: Thread is waiting indefinitely for another thread to perform a particular action. 
   5. TIMED_WAITING: Thread is waiting for a specified period. 
   6. TERMINATED: Thread has completed execution.
8. 

```Java

public class DeadlockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println("method1 acquired both locks");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (lock1) {
                System.out.println("method2 acquired both locks");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();
        new Thread(demo::method1).start();
        new Thread(demo::method2).start();
    }
}


```

Solution: Acquire locks in a consistent order

9. Wait/Notify/NotifyAll: Using intrinsic locks, a thread can wait() on an object and other threads can call notify() or notifyAll() to wake waiting threads.
10. 
    1. Class Lock (Static Lock):
       1. Obtained when a static synchronized method is used. It locks on the Class object, meaning all instances share the same lock.
    2. Object Lock:
       1. Obtained when an instance (non-static) synchronized method is used. It locks only that particular object instance.
11. The join() method allows one thread to wait for the completion of another. For example, if thread A calls threadB.join(), thread A will pause until thread B has finished executing.
12. The yield() method is a hint to the thread scheduler that the current thread is willing to relinquish its current use of the CPU so that other threads can execute. Note that its behavior is highly platform-dependent.
13. A pool of worker threads that efficiently executes asynchronous tasks.
14. 
    1. java.util.concurrent
    2. Main interface
15. Using the ExecutorService, you can submit tasks via:
    1. execute(): For Runnable tasks. 
    2. submit(): For both Runnable and Callable tasks, which can return a Future.
16. 
    1. Reduced Overhead: Reuses existing threads rather than creating a new thread for every task. 
    2. Resource Management: Limits the number of concurrently executing threads, preventing resource exhaustion. 
    3. Improved Performance: Better task scheduling and lower latency in executing tasks
17. 
    1. shutdown(): Initiates an orderly shutdown where previously submitted tasks are executed, but no new tasks are accepted. 
    2. shutdownNow(): Attempts to stop all actively executing tasks, halts processing of waiting tasks, and returns a list of tasks that were awaiting execution.
18. Atomic classes in the java.util.concurrent.atomic package provide lock-free thread-safe operations on single variables.
19. Concurrent Collections are data structures designed for high-concurrency in multi-threaded environments.
20. 
    1. Semaphore: Controls access to a fixed number of permits (resources), useful for limiting concurrency.
    2. Synchronized Block/Method: Simple, built-in language support.
    3. ReadWriteLock: Allows multiple readers concurrently while ensuring exclusive access for writers.
21. 
    1. Future: Represents the result of an asynchronous computation. You can use its get() method to retrieve the result, which blocks until the computation is complete. 
    2. CompletableFuture: An enhancement over Future that supports non-blocking, callback-based programming and chaining of tasks.
23. 
```Java
public class OddEvenPrinter {
    private static final Object lock = new Object();
    private static boolean oddTurn = true;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                synchronized (lock) {
                    while (!oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Thread-0: " + i);
                    oddTurn = false;
                    lock.notify();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    while (oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Thread-1: " + i);
                    oddTurn = true;
                    lock.notify();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
```

24. 

```Java
public class PrintNumbers {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "Thread-0");

        Thread t2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "Thread-1");

        Thread t3 = new Thread(() -> {
            for (int i = 21; i <= 22; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "Thread-2");

        // Start all threads (order of execution is not guaranteed)
        t1.start();
        t2.start();
        t3.start();
    }
}
```


