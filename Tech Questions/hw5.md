## HW5

### Write a thread-safe singleton class
``` java
public class Singleton {

    private static volatile Singleton instance;

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

###  How to create a new thread(Please also consider Thread Pool approach)?  
``` java
// Implementing Runnable to define a task
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Method 1: Create a single thread
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // Start the thread

        // Method 2: Use a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5); // Create a thread pool with 5 threads

        for (int i = 0; i < 10; i++) {
            executor.execute(new MyRunnable()); // Submit tasks to the thread pool
        }

        executor.shutdown(); // Shutdown the thread pool
    }
}
``` 

### Difference between Runnable and Callable?
- Return Type:
  - Runnable: The run() method does not return any result (void).
  - Callable: The call() method returns a result of a generic type (T).
- Exception Handling:
  - Runnable: Cannot throw checked exceptions directly. You must handle exceptions inside the run() method.
  - Callable: Can throw checked exceptions, making it more flexible for error-prone tasks.
- Method Names:
  - Runnable: Uses the run() method.
  - Callable: Uses the call() method.
- Integration with Threading:
  - Runnable: Can be executed directly by a Thread or submitted to an ExecutorService. It does not return results.
  - Callable: Must be submitted to an ExecutorService and is typically used with a Future to retrieve the result or handle exceptions.

### What is the difference between t.start() and t.run()?
- Use t.start() to execute a thread asynchronously in a multithreaded environment.
- Use t.run() only if you need to call the run() method directly without creating a new thread (typically for testing or debugging).

### Which way of creating threads is better: Thread class or Runnable interface?
Runnable interface is better.
- More flexibility: You can extend other classes while implementing Runnable, but extending Thread restricts inheritance.
- Decoupled code: Separates task logic from thread management, making the code more reusable and maintainable.
- Thread pool support: Runnable works seamlessly with ExecutorService and other thread-pooling frameworks.
- Lightweight: Only creates a task object, without the overhead of creating additional thread objects.

### What are the thread statuses?
These statuses are defined in the Thread.State enum
- NEW: The thread has been created but has not started yet. This happens after the Thread object is instantiated but before start() is called.
- RUNNABLE: The thread is ready to run but may not yet be executing. After calling start(), the thread enters this state and is waiting for CPU time.
- BLOCKED: The thread is waiting to acquire a lock to enter a synchronized block or method. It cannot proceed until the lock becomes available.
- WAITING: The thread is waiting indefinitely for another thread to notify it or signal an action. This happens when methods like Object.wait() or Condition.await() are used without a timeout.
- TIMED_WAITING: Similar to WAITING, but with a specified waiting time. The thread moves to this state when methods like Thread.sleep() or Object.wait(timeout) are called.
- TERMINATED: The thread has completed execution. This state is reached when the run() method finishes or the thread exits due to an exception.

### Demonstrate deadlock and how to resolve it in Java code
``` java
public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
``` 
- Thread 1 locks lock1 and waits to acquire lock2.
- Thread 2 locks lock2 and waits to acquire lock1.
- Both threads wait indefinitely for each other to release their locks, resulting in a deadlock.

Resolving Deadlock:
- Use consistent lock acquisition order: Ensure all threads acquire locks in the same order.
- Use tryLock with a timeout: This avoids indefinite blocking.
``` java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockResolvedWithTryLock {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Thread 1: Holding lock1...");
                        Thread.sleep(100);
                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Thread 1: Acquired lock2!");
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Thread 1: Couldn't acquire lock2, releasing lock1.");
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Thread 2: Holding lock2...");
                        Thread.sleep(100);
                        if (lock1.tryLock()) {
                            try {
                                System.out.println("Thread 2: Acquired lock1!");
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Thread 2: Couldn't acquire lock1, releasing lock2.");
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
    }
}
``` 
### How do threads communicate each other
1. Shared Memory:
- Threads share variables or objects.
- Use synchronized or other mechanisms to ensure thread safety.
2. wait() and notify():
- wait(): Makes a thread wait until another thread calls notify() or notifyAll().
- Useful for producer-consumer problems.
3. ReentrantLock and Condition:
- Provides more control than wait()/notify().
- Use Condition.await() and Condition.signal() for thread coordination.

### What’s the difference between class lock and object lock
**Object Lock:**
- Synchronizes instance methods or blocks using this.
- Each object instance has its own lock.
- Different instances can execute synchronized methods concurrently.
**Class Lock:**
- Synchronizes static methods or blocks using ClassName.class.
- Shared across all instances of the class.
- Ensures only one thread accesses static synchronized methods at a time.

### What is join() method
- Thread Synchronization: Ensures that one thread waits for another to complete before proceeding.
- Blocking Method: The current thread is blocked until the target thread finishes.

### what is yield() method
- Static Method: Called using Thread.yield().
- Voluntary Action: A thread voluntarily pauses its execution to allow other threads to run.
- No Guarantee: The thread scheduler may or may not pause the current thread or switch to another thread.
- Non-blocking: Unlike sleep() or wait(), yield() does not block the thread; it remains in a runnable state.

### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
ThreadPool manages a pool of reusable threads to execute tasks efficiently.  

Types of ThreadPools:
- FixedThreadPool
- CachedThreadPool
- SingleThreadExecutor
- ScheduledThreadPool
- WorkStealingPool

TaskQueue:
- Holds tasks waiting to be executed.
- Different ThreadPools use different types of queues (e.g., LinkedBlockingQueue, SynchronousQueue).

### Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
- Library: `java.util.concurrent` is used to create and manage thread pools.
- Main Interface: `ExecutorService` provides the core functionality of thread pools, including task submission and pool management.

### How to submit a task to ThreadPool?
- Use execute() for fire-and-forget tasks where you don't need a result or status tracking.
- Use submit() when you need to:
  - Track the task's status.
  - Retrieve a result (Callable).
  - Handle potential exceptions gracefully.

### What is the advantage of ThreadPool?
- Performance: Reduces the cost of thread creation and destruction.
- Resource Management: Avoids excessive thread creation and manages concurrency effectively.
- Ease of Use: Simplifies thread lifecycle and task execution management.
- Scalability: Handles variable workloads efficiently.
- Prevents Resource Exhaustion: Avoids system overloading with a fixed or managed number of threads.

### Difference between shutdown() and shutdownNow() methods of executor
**shutdown():**
- Graceful shutdown.
- Running tasks complete, and queued tasks are executed.
- Use when tasks need to finish before shutdown.
**shutdownNow():**
- Abrupt shutdown.
- Interrupts running tasks and discards queued tasks.
- Use in emergency scenarios where immediate termination is required.

### What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
Atomic Classes are thread-safe, non-blocking, and provide atomic operations on variables.  

Examples of Atomic Classes:
1. Using AtomicInteger
``` java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                int value = atomicInteger.incrementAndGet(); // Atomically increments and gets the value
                System.out.println(Thread.currentThread().getName() + " incremented value to: " + value);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
``` 
2. Using AtomicReference
``` java
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>("Initial Value");

        Thread t1 = new Thread(() -> {
            atomicReference.compareAndSet("Initial Value", "Updated by Thread-1");
            System.out.println("Thread-1 updated value to: " + atomicReference.get());
        });

        Thread t2 = new Thread(() -> {
            atomicReference.compareAndSet("Initial Value", "Updated by Thread-2");
            System.out.println("Thread-2 updated value to: " + atomicReference.get());
        });

        t1.start();
        t2.start();
    }
}
``` 
3. Using AtomicIntegerArray
``` java
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayExample {
    public static void main(String[] args) {
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(5);

        Runnable task = () -> {
            for (int i = 0; i < atomicArray.length(); i++) {
                int value = atomicArray.incrementAndGet(i); // Atomically increments the value at index i
                System.out.println(Thread.currentThread().getName() + " incremented index " + i + " to: " + value);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
``` 

### What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
- Concurrent Collections are thread-safe, high-performance data structures in the java.util.concurrent package.
- Examples of Thread-Safe Data Structures:
  - Lists: CopyOnWriteArrayList
  - Maps: ConcurrentHashMap, ConcurrentSkipListMap
  - Queues: ConcurrentLinkedQueue, LinkedBlockingQueue
  - Sets: ConcurrentSkipListSet, CopyOnWriteArraySet

### What kind of locks do you know? What is the advantage of each lock? 
- Intrinsic Locks: Simple, built-in, suitable for basic use cases.
- ReentrantLock: More flexible, supports fairness and timeout.
- ReadWriteLock: Improves read performance by allowing concurrent reads.
- StampedLock: Adds optimistic read locks for better read-heavy performance.
- Optimistic Locks: Non-blocking, high performance for low-contention environments.
- Fair Locks: Prevents starvation but may reduce throughput.

### What is future and completableFuture? List some main methods of ComplertableFuture.
- Future is a basic mechanism for asynchronous computation but has limitations.
- CompletableFuture enhances Future with powerful features like task chaining, error handling, and task combination.
- Main Methods: supplyAsync, thenApply, thenCombine, exceptionally, allOf.

### Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
1. One solution use synchronized and wait notify
2. One solution use ReentrantLock and await, signal
Please refer to repo/Coding/Multithreading

### create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.
Please refer to repo/Coding/Multithreading

### completable future
Please refer to repo/Coding/Multithreading