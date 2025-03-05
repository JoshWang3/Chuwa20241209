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