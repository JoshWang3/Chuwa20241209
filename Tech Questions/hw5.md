### Short Questions

#### 2. Write a thread-safe singleton class  

~~~java
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
~~~

#### 3. How to create a new thread(Please also consider Thread Pool approach)?  

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start(); 
        
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        
        Thread thread3 = new Thread(() -> {
        System.out.println("Thread running: " + Thread.currentThread().getName());
        });
        thread3.start();
        
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            System.out.println("Executing task in: " + Thread.currentThread().getName());
        });
        executorService.shutdown();
    }
}
```

#### 4. Difference between Runnable and Callable?  

```
Runnable: 
Do not return a result.
Do not throw checked exceptions.
Single abstract method: run()
Callable:
Need to return a result. (type T using Future)
May throw checked exceptions.
Single abstract method: call()
```

#### 5. What is the difference between t.start() and t.run()?  

```java
t.start()
 - starts a new thread and executes the run() method in a new thread
 - thread state changes from NEW to RUNNABLE.
 - concurrent execution
t.run()
 - does not create a new thread.
 - no state change.
 - sequential execution in the calling thread
```

#### 6. Which way of creating threads is better: Thread class or Runnable interface?  

```java
It depends.
Ruunable interface is better in:
- Decouples task logic from thread management,
- Task logic can be reused independently of thread creation.
- Works seamlessly with thread pools and other modern concurrency utilities.
- Allows us to extend other classes while still implementing Runnable

While Thread class provides methods such as:
start(),join(),interrupt(),isAlive()
These methods handle the lifecycle and behavior of the thread itself, so it is better when we need to add extra functionality to the thread itself such as overriding lifecycle methods like start() or interrupt().
```

#### 7. What are the thread statuses?  
```java
NEW: Thread is created but not yet started 'start()'
RUNNABLE: Thread is ready to run or is running
BLOCKED: Thread is waiting to acquire a monitor lock to enter a synchronized block
WAITING: Thread is waiting indefinitely for another thread’s signal 'wait()'
TIMED_WAITING: Thread is waiting for a specific time  'sleep()'
TERMINATED: Thread has completed its execution
```

#### 8. Demonstrate deadlock and how to resolve it in Java code.  

```java
private static final Object lock1 = new Object();
private static final Object lock2 = new Object();

public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock 2!");
            }
        }
    });

    Thread thread2 = new Thread(() -> {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock 1!");
            }
        }
    });

    thread1.start();
    thread2.start();
}

//one approach is all threads acquire locks in the same order.
//another approach is using concurrency utilities
private static final ConcurrentHashMap<String, String> sharedMap = new ConcurrentHashMap<>();

public static void main(String[] args) {
    Runnable task1 = () -> {
        sharedMap.put("key1", "value1");
        System.out.println("Task 1 updated key1.");
    };

    Runnable task2 = () -> {
        sharedMap.put("key2", "value2");
        System.out.println("Task 2 updated key2.");
    };

    new Thread(task1).start();
    new Thread(task2).start();
}
```

#### 9. How do threads communicate each other?  

```
using shared objects and synchronization mechanisms like wait(), notify() and join()
```

#### 10. What’s the difference between class lock and object lock?  

```
Object Lock: Locks applied to a specific instance of a class, other threads can still access synchronized methods/blocks of other instances of the same class
Class Lock: Locks on the class itself. It prevents other threads from accessing all synchronized static methods or synchronized blocks that use the class-level lock
```

#### 11. What is join() method?  

```
pause the execution of the current thread until another thread completes its execution
```

#### 12. what is yield() method  

~~~java
temporarily pauses the current thread, allowing other threads of equal or higher priority to execute, but thread scheduling is not guaranteed
~~~

#### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?  

```java
a mechanism to manage a pool of worker threads. Instead of creating and destroying threads for every task, a ThreadPool reuses a fixed or variable number of threads to execute tasks
ExecutorService fixedPool = Executors.newFixedThreadPool(3);
ExecutorService cachedPool = Executors.newCachedThreadPool();
ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
scheduledPool.schedule(() -> System.out.println("Task executed!"), 5, TimeUnit.SECONDS);
The TaskQueue is a queue used by the ThreadPool to manage tasks waiting to be executed. When all threads in the ThreadPool are busy, incoming tasks are added to the queue. Threads pick tasks from the queue when they become available.
```

#### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?  

```
java.util.concurrent library is used to create ThreadPool
ExecutorService interface provides the main functions of a ThreadPool
```

#### 15. How to submit a task to ThreadPool?  

```java
ExecutorService executorService = Executors.newFixedThreadPool(3);
executorService.submit(() -> {
    System.out.println("Executing task in: " + Thread.currentThread().getName());
});
executorService.shutdown();
```

#### 16. What is the advantage of ThreadPool?    

```java
Improved Performance: Threads are reused, reducing creation and destruction overhead.
Simplified Management: Automatically handles thread lifecycle, reducing developer effort.
Resource Management: Limits thread count to prevent system resource exhaustion.
Task Queuing: Queues tasks for orderly execution when all threads are busy.
Scalability: Dynamically adjusts threads based on workload for optimal performance.
Flexible Execution: Supports asynchronous and scheduled task execution.
```

#### 17. Difference between shutdown() and shutdownNow() methods of executor  

```java
shutdown():
Initiates an orderly shutdown. No new tasks are accepted, but already submitted tasks are executed. Allows ongoing tasks to complete.
shutdownNow():
Attempts to stop all executing tasks immediately and halts waiting tasks. Pending tasks are removed from the queue and returned as a list.
```

#### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?  

```
provide thread-safe operations for single variables without using synchronization.
AtomicInteger
AtomicLong
AtomicBoolean...
AtomicInteger counter = new AtomicInteger(0)
counter.incrementAndGet()
counter.addAndGet(1)
When multiple threads need to update a shared variable without blocking, to avoid the overhead of synchronized blocks or explicit locks.
```

#### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)  

```
thread-safe versions of data structures provided in the java.util.concurrent package.
LinkedBlockingQueue, ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet
```

#### 20. What kind of locks do you know? What is the advantage of each lock?  

```java
Intrinsic Locks (Synchronized Block/Method): simple to use, Automatically reentrant (a thread can re-acquire the lock it holds).
Explicit Locks (java.util.concurrent.locks.Lock): try-locking (tryLock()), timed locking, Fine-grained control over lock acquisition and release.
ReentrantLock: allows a thread to re-enter it multiple times if already held by the same thread, additional methods like isLocked() and getHoldCount()
ReadWriteLock: Allows multiple threads to read a resource simultaneously but only one thread to write.
Semaphore: Limits the number of threads that can access a resource simultaneously.
CountDownLatch: Ensures that a group of threads starts or finishes together.
```

#### 21. What is future and completableFuture? List some main methods of ComplertableFuture.  

```
Future is used for simple asynchronous results and basic control over task execution.
CompletableFuture provides more flexibility. It can be explicitly completed; Supports non-blocking asynchronous operations; Offers a wide range of methods for combining multiple asynchronous operations.
```

#### 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)  

#### 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
```java
Coding/HW5/Q23
```

#### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads runsequence is random.  
```
Coding/HW5/Q24
```

#### 25. completable future:  

```
Coding/HW5/Q25
```

