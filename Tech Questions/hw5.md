
## 1. Read:
   https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock
## 2. Write a thread-safe singleton class
- Lazy Initialization
```
public Class Singleton {
    public static Singleton instance {}
    private Singleton() {
    }
    public static sychronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
}
```
-Double-checked Locking
```
public Class Singleton {
    public static violate Singleton Instance;
    private Singleton() {
    }
    public static sychronized Singleton getInstance() {
        if (instance == null) {
            sychronized(Singleton.class) {
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
- Extending the Thread class
- Implementing the Runnable interface
- Implementing the Callable interface with Future
- utilizing thread pools via ExecutorService
## 4. Difference between Runnable and Callable?
- **Callable** can throw checked exceptions and return a result after execution, while **Runnable** cannot.
## 5. What is the difference between t.start() and t.run()?
- **t.start()** is used to establish a new thread, while **t.run()** is used to begin running that thread.
## 6. Which way of creating threads is better: Thread class or Runnable interface?
-Runnable interface
- When you extend Thread class, you can’t extend any other class which you require.When you implement Runnable, you can save a space for your class to extend any other class in future or now.

- When you extends Thread class, each of your thread creates unique object and associate with it. When you implements Runnable, it shares the same object to multiple threads.
## 7. What are the thread statuses?
- Each state represents a specific phase in the thread's lifecycle,there are 6 following states:
- NEW
- RUNNABLE
- BLOCKED
- WAITING
- TIMED_WAITING
- TERMINATED

## 8. Demonstrate deadlock and how to resolve it in Java code.
- If thread1 acquires resource1 and thread2 acquires resource2 before either thread can acquire the other resource, they will both be blocked.
- ways to resolve it:
- Using Thread.join() Method
- Use Lock Ordering
- Avoiding unnecessary Locks
## 9. How do threads communicate each other?
- By using thread control method:
- wait()
- notify()
- notifyAll()
## 10. What’s the difference between class lock and object lock?
- **Object Level Locks**: It can be used when you want non-static method or non-static block of the code should be accessed by only one thread.
```
public class ClassLevelLockExample {
   public void classLevelLockMethod() {
      synchronized (ClassLevelLockExample.class) {
         //DO your stuff here
      }
   }
}
```
- **Class Level locks**: It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.
```
public class ObjectLevelLockExample {
   public void objectLevelLockMethod() {
      synchronized (this) {
         //DO your stuff here
      }
   }
}
```
## 11. What is join() method?
- It allows one thread to wait until another thread completes its execution.
## 12. what is yield() method?
- The yield() basically means that the thread is not doing anything particularly important and if any other threads or processes need to be run, they should run. Otherwise, the current thread will continue to run.
## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
- **ThreadPool** is a software design pattern used to manage and reuse threads efficiently. It maintains a pool of worker threads that are ready to execute tasks concurrently. Instead of creating and destroying threads for each task, the ThreadPool reuses existing threads, reducing overhead and improving performance.
- **Fixed-size ThreadPool**
- **Cached ThreadPool**
- **Scheduled ThreadPool**
- The **TaskQueue** is an internal data structure within a ThreadPool that holds the tasks waiting to be executed. When a task is submitted to the ThreadPool, it is added to the TaskQueue. The worker threads in the pool continuously monitor the TaskQueue and pick up tasks for execution.
## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
- **Library:** java.util.concurrent
- **Interface:** ExecutorService
- **Implementation Class:** ThreadPoolExecutor
## 15. How to submit a task to ThreadPool?
- Using execute(Runnable task)
- Using submit(Runnable task) or submit(Callable<T> task)
## 16. What is the advantage of ThreadPool?
- It reduces the overhead associated with creating and destroying threads.
- It allows for efficient management of threads by recycling them instead of constantly creating new ones.
## 17. Difference between shutdown() and shutdownNow() methods of executor
- The shutdown() method will allow previously submitted tasks to execute before terminating, while the shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.
## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
- "Atomic classes" are a set of classes within the java.util.concurrent.atomic package that allow for thread-safe, atomic operations on primitive data types, meaning a single operation happens completely without interruption from other threads.
- AtomicInteger
- AtomicLong
- AtomicBoolean
- AtomicReference
```
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet(); // Atomically increments the count by 1 and returns the new value
    }

    public int getCount() {
        return count.get(); // Returns the current value of count
    }
}
```
## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
- The java.util.concurrent package includes a number of additions to the Java Collections Framework. These are most easily categorized by the collection interfaces provided:
- BlockingQueue
- ConcurrentMap
- ConcurrentNavigableMap
## 20. What kind of locks do you know? What is the advantage of each lock?
- **synchronized**	Simple to use, automatic lock management, built-in support
- **ReentrantLock**	Flexible locking strategies, fairness policies, reentrancy
- **ReadWriteLock**	Increased concurrency for read-heavy operations, separation of read/write access
- **Semaphore**	Controls access to a limited number of resources, versatile for signaling and resource pooling
- **StampedLock**	Optimistic reads for better performance, higher throughput, flexible locking mechanisms
## 21. What is future and completableFuture? List some main methods of ComplertableFuture.
- Future is a simple representation of an asynchronous task. It is a type that holds the result from a task that may not have finished yet but may be some time in future.
- Completable Future is a concrete type that implements that Future interface which is required to build a simple asynchronous application.
- thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn, Executor executor)
- thenRun(Runnable action)
- thenRunAsync(Runnable action)
## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
### 1. One solution use synchronized and wait notify
```
public class OddEvenPrinter {
    private static final Object lock = new Object();
    private static boolean isOddTurn = true; // 控制轮到奇数线程还是偶数线程

    public static void main(String[] args) {
        // 创建奇数线程
        Thread oddThread = new Thread(() -> printNumber(1, 9, 2, true), "OddThread");

        // 创建偶数线程
        Thread evenThread = new Thread(() -> printNumber(2, 10, 2, false), "EvenThread");

        // 启动线程
        oddThread.start();
        evenThread.start();
    }

    private static void printNumber(int start, int end, int step, boolean isOdd) {
        for (int i = start; i <= end; i += step) {
            synchronized (lock) {
                while (isOddTurn != isOdd) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
                isOddTurn = !isOddTurn;
                lock.notify();
            }
        }
    }
}
```
### 2. One solution use ReentrantLock and await, signal
```
   Thread-0: 1
   Thread-1: 2
   Thread-0: 3
   Thread-1: 4
   Thread-0: 5
   Thread-1: 6
   Thread-0: 7
   Thread-1: 8
   Thread-0: 9
   Thread-1: 10
   Process finished with exit code 0
```
```
public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();//t0
        new Thread(runnable).start();//t1
    }

    static class PrintRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        @Override
        public void run() {
            // synchronized : 门
            // 门里有资源
            // 买一把锁 monitor
            lock.lock();
            try   {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signalAll();
                    try {
                        condition.await(); // 解锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

```
## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
```
    Thread-0: 1
    Thread-0: 2
    Thread-0: 3
    Thread-0: 4
    Thread-0: 5
    Thread-0: 6
    Thread-0: 7
    Thread-0: 8
    Thread-0: 9
    Thread-0: 10
    Thread-2: 11
    Thread-2: 12
    Thread-2: 13
    Thread-2: 14
    Thread-2: 15
    Thread-2: 16
    Thread-2: 17
    Thread-2: 18
    Thread-2: 19
    Thread-2: 20
    Thread-1: 21
    Thread-1: 22
    Thread-1: 23
    Thread-1: 24
    Thread-1: 25
    Thread-1: 26
    Thread-1: 27
    Thread-1: 28
    Thread-1: 29
    Thread-1: 30
 ```
```
public class PrintNumber1 {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintNumber1.class.notifyAll();
    }
}
```
## 25. completable future:
## 1. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
## 2. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products,reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
### 1.Sign In to Developer.BestBuy.com
### 2.Best Buy Developer API Documentation (bestbuyapis.github.io)
### 3. 可以⽤fake api
   https://jsonplaceholder.typicode.com/
### 4. Github public api:
   https://api.github.com/users/your-user-name/repos

## 3. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information
=======
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






































