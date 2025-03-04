# Homework 5
## Questions

### 1. Read:https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

### 2. Write a thread-safe singleton class

   ```java
   public class Singleton {
   
       private Singleton() {}
       private static volatile Singleton instance;
   
       public static synchronized Singleton getInstance() {
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

### 3. How to create a new thread (Please also consider ThreadPool approach)?

   Traditionally, to create a new thread, create an object that implements the `Runnable` interface and then use the `Thread` class to encapsulate it, calling its `start()` method to begin execution. For better performance and resource management, we can use ThreadPool approach where we create a pool of pre-existing threads that can be reused to execute tasks instead of creating new threads for each operation.

### 4. Difference between Runnable and Callable?

   - **Running Interface** is basically available in Java right from the beginning. It is simply used to execute code on a concurrent thread.  
   - **Callable Interface** is basically a new one that was introduced as a part of the concurrency package. It addresses the limitation of runnable interfaces along with some major changes like generics, enum, static imports, variable argument method, etc. It uses generics to define the return type of object.  

### 5. What is the difference between t.start() and t.run()?

   Both `t.start()` and `t.run()` are methods associated with the `Thread` class. `t.start()` creates a new thread and executes the `run()` method in that thread. `t.run()` executes the `run()` method in the current thread, without creating a new thread.

### 6. Which way of creating threads is better: Thread class or Runnable interface?

   Using Runnable interface to create threads is better. 
   - When extending the *Thread* class, we’re not overriding any of its methods. Instead, we override the method of *Runnable*. This is a clear violation of IS-A *Thread* principle. After extending the *Thread* class, we can’t extend any other class
   - Creating an implementation of *Runnable* and passing it to the *Thread* class utilizes composition and not inheritance – which is more flexible. From Java 8 onwards, *Runnables* can be represented as lambda expressions

### 7. What are the thread statuses?

   1. New State
   2. Runnable State
   3. Blocked State
   4. Waiting State
   5. Timed Waiting State
   6. Terminated State

### 8. Demonstrate deadlock and how to resolve it in Java code.

   Deadlock is a situation where multiple threads are blocked forever. It generally occurs when multiple threads hold locks on different resources and are waiting for other resources to complete their task.

   ```java
   import java.util.concurrent.locks.Lock;
   import java.util.concurrent.locks.ReentrantLock;
   
   public class DeadlockExample {
   
       private static final Lock lock1 = new ReentrantLock();
       private static final Lock lock2 = new ReentrantLock();
   
       public static void main(String[] args) {
           Thread thread1 = new Thread(() -> {
               try {
                   lock1.lock();
                   System.out.println("Thread 1: Acquired lock1, waiting for lock2...");
                   Thread.sleep(100);
                   lock2.lock();
                   System.out.println("Thread 1: Acquired lock2.");
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
                   System.out.println("Thread 2: Acquired lock2, waiting for lock1...");
                   Thread.sleep(100);
                   lock1.lock();
                   System.out.println("Thread 2: Acquired lock1.");
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
   ```

### 9. How do threads communicate each other?

    All the threads in the same program share the same memory space. If an object is accessible to various threads then these threads share access to that object's data member and thus communicate each other. The second way for threads to communicate is by **using thread control methods**: "wait()", "notify()", and "notifyAll()".

### 10. What’s the difference between class lock and object lock?

    - **Class Lock**: In java, each and every class has a unique lock usually referred to as a class level lock. These locks are achieved using the keyword ‘static synchronized’ and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block. 

    - **Object Lock**: In java, each and every object has a unique lock usually referred to as an object-level lock. These locks are achieved using the keyword ‘synchronized’ and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.  

### 11. What is join() method?

    **join()** method is generally used to pause the execution of a current thread unless and until the specified thread on which join is called is dead or completed. To stop a thread from running until another thread gets ended, this method can be used. It joins the start of a thread execution to the end of another thread’s execution. It is considered the final method of a thread class.

### 12. what is yield() method?

    **yield()** provides a mechanism to inform the “scheduler” that the current thread is willing to relinquish its current use of processor but it’d like to be scheduled back soon as possible. The “scheduler” is free to adhere or ignore this information and in fact, has varying behavior depending upon the operating system.

### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?

    A Thread pool is simply a collection of pre-initialized or worker threads at the start-up that can be used to execute tasks and put back in the pool when completed.The TaskQueue (often implemented using a `BlockingQueue`) is a data structure that holds tasks waiting to be executed by the thread pool's worker threads. Some common types are "fixed thread pool", "chache thread pool", "single thread pool", "scheduled thread pool", and "custom thread pools".

### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

    In Java, the "java.util.concurrent" library is used to create thread pools, and the primary interface providing the main functions for managing a thread pool is "ExecutorService".

### 15. How to submit a task to ThreadPool?

    We can submit a task to a `ThreadPool` using the `ExecutorService` interface. It takes a callable object as an argument and returns a Future object that allows us to check on the task's status and retrieve its result when it finishes execution.

### 16. What is the advantage of ThreadPool?

    1. Better performance
    2. Saves time
    3. No need to create a thread again and again
    4. Easy to access
    5. Real-time usage

### 17. Difference between shutdown() and shutdownNow() methods of executor

    In general, the *ExecutorService* will not be automatically destroyed when there is no task to process. It will stay alive and wait for new work to do. The ***shutdown()*** method doesn’t cause immediate destruction of the *ExecutorService*. It will make the *ExecutorService* stop accepting new tasks and shut down after all running threads finish their current work. The ***shutdownNow()*** method tries to destroy the *ExecutorService* immediately, but it doesn’t guarantee that all the running threads will be stopped at the same time.

### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

    In Java, "Atomic classes" are a set of classes within the `java.util.concurrent.atomic` package that allow for atomic operations on variables, meaning that updates to these variables happen as a single, indivisible unit, ensuring thread safety without explicit synchronization mechanisms like locks in multithreaded environments. The most common Atomic classes are `AtomicInteger`, `AtomicLong`, `AtomicBoolean`, and `AtomicReference`.

    ```java
    import java.util.concurrent.atomic.AtomicInteger;
    
    public class CounterExample {
        private static AtomicInteger count = new AtomicInteger(0);
        
      public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    count.incrementAndGet(); 
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    count.incrementAndGet(); 
                }
            });
            thread1.start();
            thread2.start();
    
            // Wait for threads to finish
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            System.out.println("Final count: " + count.get()); // Read the final count [1, 2, 3]
        }
    }
    ```

### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

    Concurrent collections are data structures designed to allow multiple threads to access and modify a collection safely and concurrently, without the need for explicit synchronization in user code. They are thread-safe, meaning they handle the necessary locking and synchronization internally to prevent race conditions when multiple threads access the same collection. Some common data structures are "ConcurrentHashMap", "CopyOnWriteArrayList", "ConcurrentSkipListMap", "BlockingQueue", and "ConcurrentBag" etc.

### 20. What kind of locks do you know? What is the advantage of each lock?

    A lock is a more flexible and sophisticated thread synchronization mechanism than the standard *synchronized* block. The most common locks are:

    - *ReentrantLock* class implements the *Lock* interface and offers the same concurrency and memory semantics.
    - *ReentrantReadWriteLock* class implements the *ReadWriteLock* interface.
    - *StampedLock* supports both read and write locks.

### 21. What is future and completableFuture? List some main methods of ComplertableFuture.

    - Future are basically placeholders for a result of an operation that hasn't finished yet. Once the operation finishes, the `Future` will contain that result. 
    - ComparatableFuture are an evolution of regular Futures that also allow us to string tasks together in a chain.
    - Main methods of CompletableFuture are `supplyAsync(Supplier<U> supplier)`, `thenApply(Function<T,U> fn)`, and `get()`, `join()` etc.

### 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

### 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
#### 1. One solution use synchronized and waitnotify
#### 2. One solution use ReentrantLock and await, signal

### 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)

### 25. completable future:

#### 1. Homework1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
#### 2. Homework2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
##### 1. SignIntoDeveloper.BestBuy.com
##### 2. BestBuyDeveloperAPIDocumentation(bestbuyapis.github.io)
##### 3. 可以用fake api https://jsonplaceholder.typicode.com/
##### 4. Githubpublicapi:https://api.github.com/users/your-user-name/repos
#### 3. Homework3: For Homework2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.