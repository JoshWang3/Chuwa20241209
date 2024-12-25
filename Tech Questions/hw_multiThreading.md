## 1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock
## 2. Write a thread-safe singleton class
    see /Coding/hw5/thread_safe_singleton/
## 3. How to create a new thread(Please also consider Thread Pool approach)?

```java
import java.util.concurrent.Callable;
import java.util.concurrent.Runnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1. Extend Thread() class
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("***");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// 2. Implement Runnable()
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("***");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        t1.start();

        // Lambda
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("***");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
    }
}


// 3. Implement Callable();
public class MyCallable implements Callable<String> {
    @Override
    public String call() {
        for (int i = 0; i < 10; i++) {
            System.out.println("***");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Task completed";
    }

    public static void main(String[] args) {
        MyCallable mr = new MyCallable();
        Thread t1 = new Thread(mr);
        t1.start();

        // Lambda
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("***");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "Task completed";
        });
        t2.start();
    }
}
// 4. Thread Pool
public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable task = () -> System.out.println("Task " + i + " executed by: " + Thread.currentThread().getName());
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}

```

## 4. Difference between Runnable and Callable?
    1. Runnable: no return. Method name run
    2. Callable: with return. Mehtod name call
## 5. What is the difference between t.start() and t.run()?
    1. t.start(): starts a new thread to excute the task（run()）
    2. t.run(): excute the task in the current thread.
## 6. Which way of creating threads is better: Thread class or Runnable interface?
    In most cases, implementing the Runnable interface is the preferred way to create threads in Java. Here's why:
    Advantages of Runnable:
    Flexibility:
        Implementing Runnable allows your class to extend other classes, which is not possible if you extend Thread.
    Code Reusability:
        You can easily share the same Runnable object with multiple threads, allowing for better resource utilization.
    Encapsulation:
        Separating the task logic (in the Runnable implementation) from the thread management (in the Thread class) leads to cleaner and more maintainable code.
    Composition over Inheritance:
        Using Runnable promotes composition over inheritance, which is generally considered a better design principle in object-oriented programming.
    When to use Thread:
        Customizing Thread Behavior: If you need to modify the fundamental behavior of the thread itself, like overriding methods other than run(), then extending Thread might be necessary. However, this is rare.
    In summary:
        For most cases, implement Runnable.
        Extend Thread only if you need to customize the thread's behavior beyond the run() method.

## 7. What are the thread statuses?
    There are multiple states of the thread in a lifecycle as mentioned below:
    1. New Thread: When a new thread is created, it is in the new state. The thread has not yet started to run when the thread is in this state. When a thread lies in the new state, its code is yet to be run and hasn’t started to execute.
    2. Runnable State: A thread that is ready to run is moved to a runnable state. In this state, a thread might actually be running or it might be ready to run at any instant of time. It is the responsibility of the thread scheduler to give the thread, time to run.
    3. A multi-threaded program allocates a fixed amount of time to each individual thread. Each and every thread runs for a short while and then pauses and relinquishes the CPU to another thread so that other threads can get a chance to run. When this happens, all such threads that are ready to run, waiting for the CPU and the currently running thread lie in a runnable state.
    4. Blocked: The thread will be in blocked state when it is trying to acquire a lock but currently the lock is acquired by the other thread. The thread will move from the blocked state to runnable state when it acquires the lock.
    5. Waiting state: The thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated.
    6. Timed Waiting: A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a conditional wait, it is moved to a timed waiting state.
    7. Terminated State: A thread terminates because of either of the following reasons:
        7.1 Because it exits normally. This happens when the code of the thread has been entirely executed by the program.
        7.2 Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.

## 8. Demonstrate deadlock and how to resolve it in Java code.
```java
/**
 * Explanation of Deadlock:
 * In this example, two threads are trying to acquire two locks in a different order.
 *  Thread 1 acquires lock1 and then tries to acquire lock2.
 *  Thread 2 acquires lock2 and then tries to acquire lock1.
 * Both threads are now stuck waiting for the other to release the lock, creating a deadlock.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 1: Acquired lock1, waiting for lock2");
                Thread.sleep(100);
                lock2.lock();
                System.out.println("Thread 1: Acquired lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println("Thread 2: Acquired lock2, waiting for lock1");
                Thread.sleep(100);
                lock1.lock();
                System.out.println("Thread 2: Acquired lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}

/**
 * Resolve DeadLock
 * use timeout
 */
public class DeadlockSol {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("Thread 1: Acquired lock1, waiting for lock2");
                    Thread.sleep(100);
                    if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("******");
                            // Perform actions with both locks
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("Thread 2: Acquired lock2, waiting for lock1");
                    Thread.sleep(100);
                    if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("******");
                            // Perform actions with both locks
                        } finally {
                            lock1.unlock();
                        }
                    }
                } finally {
                    lock2.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

## 9. How do threads communicate each other?
    1. Shared Memory:
        Threads can share access to objects on the heap. By reading and writing to these shared objects, threads can exchange information.
        Synchronization: is crucial when using shared memory to avoid data corruption and race conditions. Use synchronized blocks or methods to ensure that only one thread accesses the shared data at a time.
    2. Wait() and Notify()/NotifyAll():
        These methods are part of the Object class and are used for thread synchronization and communication.
        wait(): A thread calls wait() on an object to release the lock on that object and enter the waiting state. It will remain in this state until another thread calls notify() or notifyAll() on the same object.
        notify(): Wakes up a single thread that is waiting on the object.
        notifyAll(): Wakes up all threads that are waiting on the object.
```java
public class Message {
    private String message;
    private boolean isMessageAvailable = false;

    public synchronized String readMessage() {
        while (!isMessageAvailable) {
            try {
                wait(); // Wait for message
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isMessageAvailable = false;
        notifyAll(); // Notify sender
        return message;
    }

    public synchronized void sendMessage(String msg) {
        while (isMessageAvailable) {
            try {
                wait(); // Wait until message is read
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message = msg;
        isMessageAvailable = true;
        notifyAll(); // Notify reader
    }
}
```
    3. Blocking Queues:
       The java.util.concurrent package provides blocking queues like BlockingQueue, LinkedBlockingQueue, and ArrayBlockingQueue.
       These queues allow threads to safely add and remove elements in a thread-safe manner.
       If a thread attempts to remove an element from an empty queue, it will block until another thread adds an element.
    4. Volatile Variables:
        Declaring a variable as volatile ensures that changes to the variable are immediately visible to all threads.
        This is useful for simple communication between threads, but it does not provide the same level of synchronization as synchronized blocks.

## 10. What’s the difference between class lock and object lock?
    Class Lock: In java, each and every class has a unique lock usually referred to as a class level lock. These locks are achieved using the keyword ‘static synchronized’ and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block. 
    Object Lock: In java, each and every object has a unique lock usually referred to as an object-level lock. These locks are achieved using the keyword ‘synchronized’ and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.  

## 11. What is join() method?
    t.join() -- Main thread wait for t thread end. main thread's status is Timed Waiting.

## 12. what is yield() method?
    Thread.yield(); // Suggest to the scheduler to give other threads a chance

## 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
    1. A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing.
    2. There are various thread pools in java:
        Single Thread Executor : A thread pool with only one thread. So all the submitted tasks will be executed sequentially. Method : Executors.newSingleThreadExecutor()
        Cached Thread Pool : A thread pool that creates as many threads it needs to execute the task in parrallel. The old available threads will be reused for the new tasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. Method : Executors.newCachedThreadPool()
        Fixed Thread Pool : A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for an other task to ends. Method : Executors.newFixedThreadPool()
        Scheduled Thread Pool : A thread pool made to schedule future task. Method : Executors.newScheduledThreadPool()
        Single Thread Scheduled Pool : A thread pool with only one thread to schedule future task. Method : Executors.newSingleThreadScheduledExecutor()
    3. In Java's ThreadPoolExecutor, the TaskQueue is a BlockingQueue that holds tasks waiting to be executed by the thread pool's worker threads.

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
    1. java.util.concurrent
    2. java.util.concurrent.ExecutorService && java.util.concurrent.Executors

## 15. How to submit a task to ThreadPool?
    1. executor.submit(() -> {//Your function});

## 16. What is the advantage of ThreadPool?
    Resource Management:
        Reduced Overhead:
            Creating and destroying threads is expensive. ThreadPools reuse existing threads, minimizing this overhead and improving performance, especially for applications with many short-lived tasks.
        Controlled Resource Usage:
            ThreadPools limit the number of active threads, preventing resource exhaustion and improving application stability.
        Improved Performance:
            Faster Task Execution: Tasks can be executed immediately without the delay of thread creation.
        Efficient Task Scheduling: 
            ThreadPools manage task queues and assign tasks to threads efficiently, maximizing resource utilization.
    Simplified Development:
        Easy to Use:
            ThreadPools provide a high-level API for managing threads, simplifying development and reducing the risk of errors.
        Better Scalability:
            Applications can easily adapt to varying workloads by dynamically adjusting the pool size.
    Common Use Cases:
        Web Servers: Handling multiple client requests concurrently.
        Database Applications: Executing multiple database queries in parallel.
        Background Tasks: Performing time-consuming operations without blocking the main thread.

## 17. Difference between shutdown() and shutdownNow() methods of executor
    shutdown():
        Graceful shutdown: Allows previously submitted tasks to complete before terminating the executor.
        No new tasks: Prevents new tasks from being submitted.
        Returns immediately: Does not wait for tasks to complete.
        Use case: When you want to ensure all submitted tasks are finished before shutting down.
    shutdownNow():
        Immediate shutdown: Attempts to stop currently executing tasks immediately.
        No new tasks: Prevents new tasks from being submitted.
        Returns a list: Returns a list of tasks that were interrupted.
        May not interrupt: Doesn't guarantee that all running tasks will be interrupted.
        Use case: When you need to stop the executor immediately, even if some tasks might not complete.

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

```java

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * What is Atomic classes?
 *  In Java, "Atomic classes" refer to a set of classes within the java.util.concurrent.atomic package 
 *  that allow for thread-safe operations on single variables without the need for explicit locking, 
 *  ensuring that any update to the variable happens as a single, indivisible action, 
 *  even when accessed by multiple threads simultaneously; essentially providing atomic operations on variables 
 *  like integers, longs, booleans, and references, significantly improving performance in concurrent programming scenarios.
 *
 * How many types of Atomic classes? -- 4: AtomicInteger, AtomicLong, AtomicBoolean, and AtomicReference
 */

// AtomicInteger
public class AtomicIntDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}

// AtomicLong
public class AtomicLongDemo {
    private static AtomicLong atomicLong = new AtomicLong(1);

    public static void main(String[] args) {
        System.out.println(atomicLong.getAndIncrement());
        System.out.println(atomicLong.get());
    }
}

// AtomicBoolean
public class AtomicBooleanDemo {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean();

    public static void main(String[] args) {
        System.out.println(atomicBoolean.set(true));
        System.out.println(atomicBoolean.get());
    }
}

// AtomicReference
public class AtomicDemo {

    private static AtomicReference<User> reference = new AtomicReference<>();

    public static void main(String[] args) {
        User user1 = new User("a", 1);
        reference.set(user1);
        User user2 = new User("b",2);
        User user = reference.getAndSet(user2);
        System.out.println(user);
        System.out.println(reference.get());
    }

    static class User {
        private String userName;
        private int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
```

## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
    1. What is the concurrent collections? -- In Java, "concurrent collections" are a set of collection classes specifically designed to allow multiple threads to access and modify a collection concurrently without the need for explicit synchronization
    2. CopyOnWriteArrayList && ConcurrentHashMap && CopyOnWriteArraySet && ArrayBlockingQueue / LinkedBlockingQueue && LinkedBlockingDeque

## 20. What kind of locks do you know? What is the advantage of each lock?
    1. Synchronized Block/Method
        What It Is: Implicit locking mechanism using synchronized keyword.
        Advantages:
            Ease of Use: Built-in and simple to implement.
            Thread Safety: Automatically prevents thread interference and memory consistency errors.
            Reentrant: A thread can re-enter the lock it already holds.
            Automatic Release: Lock is automatically released when execution exits the block or method.
    2. Explicit Locks (from java.util.concurrent.locks.Lock)
       a. ReentrantLock
           What It Is: Explicit locking mechanism with more flexibility than synchronized.
           Advantages:
               Fairness Policy: Allows you to specify whether the lock should favor the longest-waiting thread (true) or not (false).
               Interruptibility: Can interrupt threads waiting for the lock.
               Try-Lock: Offers a non-blocking attempt to acquire the lock (tryLock()), avoiding deadlocks.
               Condition Variables: Supports multiple conditions for signaling threads (newCondition()).
       b. ReadWriteLock
           What It Is: A pair of locks: one for read operations (readLock) and one for write operations (writeLock).
           Advantages:
                Improved Concurrency: Multiple threads can acquire the readLock simultaneously if no thread holds the writeLock.
                Read-Write Separation: Ensures write operations are thread-safe while allowing more flexibility for reads.
       c. StampedLock
            What It Is: A lightweight lock introduced in Java 8, designed for higher concurrency.
            Advantages:
                Optimistic Reads: Provides an optimisticRead() mode for non-blocking reads when there are no write operations.
                Explicit Lock State: Allows checking if a lock is held or validating optimistic reads (validate()).
                Performance: Reduces contention compared to ReentrantLock or ReadWriteLock.
    3. SpinLocks (Custom Implementations or via java.util.concurrent Classes)
        What It Is: Threads repeatedly check a condition (spinning) instead of sleeping or waiting.
        Advantages:
            Low Latency: Suitable for short critical sections where waiting threads can acquire the lock quickly without context switching.
            CPU Efficiency: Avoids the overhead of OS-level thread scheduling.

## 21. What is future and completableFuture? List some main methods of CompletableFuture.
    1. Future
        What It Is:
            Future is an interface introduced in Java 5 that represents the result of an asynchronous computation. 
            It provides a way to retrieve the result or check the status of the computation once.
        Example:
```java
public class MyClass {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            // Simulate a long-running computation
            Thread.sleep(2000);
            return 42;
        });

        // Do something else while the task is running

        if (!future.isDone()) {
            System.out.println("Task is still running...");
        }

        try {
            Integer result = future.get(); // Blocks until the result is available
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
```
        Limitations:
            Blocking: get() blocks the calling thread until the computation is complete.
            No Chaining: You cannot attach callbacks to execute once the task is done.
            Error Handling: Error propagation is not straightforward.
            Completion Notification: No built-in mechanism to notify when the computation is complete.
    
    2. CompletableFuture
        What It Is:
            CompletableFuture is a class introduced in Java 8 that implements both Future and the CompletionStage interface. 
            It enhances Future by providing a more powerful, non-blocking, and functional way to handle asynchronous computations.
        Advantages of CompletableFuture:
            Non-Blocking: Allows chaining of dependent tasks without blocking.
            Callback Support: Use methods like thenApply, thenAccept, and thenRun to define actions upon task completion.
            Exception Handling: Built-in methods like exceptionally and handle simplify error handling.
            Combining Futures: Allows combining multiple CompletableFuture objects (e.g., thenCombine, allOf, anyOf).
        Key Methods in CompletableFuture:
            supplyAsync(Supplier<T>): Runs a task asynchronously and returns a CompletableFuture.
            thenApply(Function<T, R>): Transforms the result of the future.
            thenAccept(Consumer<T>): Consumes the result of the future without returning a value.
            thenRun(Runnable): Runs a task after the future is complete.
            exceptionally(Function<Throwable, T>): Handles exceptions in the computation.

## 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter) 
    1. One solution use synchronized and wait notify: see Coding/hw5/odd_even_printer/synchronized_keyword/
    2. One solution use ReentrantLock and await, signal: see Coding/hw5/odd_even_printer/reentrant_lock/

## 24. create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
    see Coding/hw5/print_numer/

## 25. completable future:
    1. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
        see Coding/hw5/sum_product/

    2. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
        1. Sign In to Developer.BestBuy.com
        2. Best Buy Developer API Documentation (bestbuyapis.github.io)
        3. 可以⽤fake api https://jsonplaceholder.typicode.com/
        4. Github public api: https://api.github.com/users/your-user-name/repos
        3. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.
        see Coding/hw5/online_store/