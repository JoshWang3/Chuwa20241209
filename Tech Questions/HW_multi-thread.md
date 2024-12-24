## 1.Read  
https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

## 2. write a thread-safe singleton class  
```
public class Singleton {

    // Private constructor to prevent instantiation
    private Singleton() {
        // Prevent instantiation through reflection
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Static nested class responsible for holding the Singleton instance
    private static class Holder {
        // The instance is created only when the nested class is loaded
        private static final Singleton INSTANCE = new Singleton();
    }

    // Public method to provide access to the Singleton instance
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    // Example method for demonstration purposes
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
```
## 3.How to create a new thread?  
1.extend the Thread Class  

2.implement the Runnable Interface   

3.use ExecutorService to create thread pool  

4.use Callable Interface  
## 4. What is the difference between Runnable and Callable?  

Runnable: Cannot return values, run() is void  

Callable: Can return a value from call(), returns a result of type T. Suitable for computation tasks.

## 5.What is the difference between t.start() and t.run()?  
t.start(): Starts a new thread of execution managed by the JVM.  
t.run(): Executes the run() method in the current thread's call stack.  

## 6.Which way of creating threads is better: Thread class or Runnable interface?  

Prefer Runnable for most scenarios, especially for scalable and reusable designs or when using thread pools (ExecutorService).
Extend Thread only when you need thread-specific customizations or when dealing with simple, one-off threads.  

## 7.What are the thread statuses?  

1.NEW
2.RUNNABLE
3.BLOCKED(request I/O, wait for a monitor lock)
4.WAITING(wait/join:enter; notify/notifyAll: leave)
5.TIMED_WAITING(wait/join/sleep)
6.TERMINATED(cannot be restarted)  

## 8.Demonstrate deadlock and how to resolve it in Java code.  

### DeadLock Example  
```
public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
// Thread 1 acquires lock1 and then tries to acquire lock2.
Thread 2 acquires lock2 and then tries to acquire lock1.
Both threads are waiting for each other to release the locks, resulting in a deadlock.
```
### How to resolve deadlocks  
```
// avoid Nested locks

// Always acquire locks in the same order
synchronized (lock1) {
    synchronized (lock2) {
        // Critical section
    }
}
//use tryLock()
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockResolved {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock() && lock2.tryLock()) {
                    try {
                        System.out.println("Thread 1: Acquired both locks!");
                    } finally {
                        lock1.unlock();
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Thread 1: Could not acquire all locks, avoiding deadlock.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock() && lock1.tryLock()) {
                    try {
                        System.out.println("Thread 2: Acquired both locks!");
                    } finally {
                        lock2.unlock();
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Thread 2: Could not acquire all locks, avoiding deadlock.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
```
## 9. How do threads communicate each other?
wait(): temporarily suspend the execution of a thread, causes the current thread to release the lock and it enters a waiting state and allows other threads to proceed until the object state changes.  

notify(): Wakes up a single waiting thread; that thread will continue execution after it re-acquires the lock.  

notifyAll(): Wakes up all waiting threads, but only one will proceed after acquiring the lock

## 10. What’s the difference between class lock and object lock?  
object lock: An object lock is associated with a specific instance of a class.
It is used to synchronize non-static methods or blocks.  
class lock: A class lock is associated with the class itself, not an instance.  

## 11. What is join() method?  
wait for a thread to finish its execution before the next thread continues or timeout is reached  

## 12.what is yield() method?  
a static method of Thread class and it pauses the current thread and allow other waiting threads of the same priority.  

## 13.What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?  

A thread pool manages a set of anonymous threads that perform work on request.
Three types of ThreadPool:
FixedThreadPool: Owns and reuses a fixed number of threads for tasks.
CachedThreadPool: Creates threads as needed, reuses idle ones.
SingleThreadExecutor: Executes tasks in a single thread.
TaskQueue is the place to store tasks when a task is submitted to the thread pool  

## 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?  

java.util.concurrent library is used to create and manage thread pools, and ExecutorService interface provides the main functions for managing thread pools.  

## 15. How to submit a task to ThreadPool?  

Use submit() method of the ExecutorService service (also implemented from ThreadPoolExecutor), and Use execute() method implemented from ThreadPoolExecutor  

## 16. What is the advantage of ThreadPool?  

Thread Pools manage resources in a multithreaded application and to contain the parallelism in certain predefined limits.  

## 17. Difference between shutdown() and shutdownNow() methods of executor  

shutdown(): method will allow previously submitted tasks to execute before terminating the ExecutorService
shutdownNow(): method prevents waiting tasks from starting and attempts to stop currently executing tasks.  

## 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?  

Atomic classes are part of the java.util.concurrent.atomic package and provide a way to perform thread-safe operations on single variables without using explicit synchronization (synchronized blocks or locks).  

1. Atomic Primitives. 2. Atomic Arrays. 3. Atomic References. 4.Atomic Accumulators

```
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        // Increment and get the value
        System.out.println("Incremented Value: " + atomicInteger.incrementAndGet());

        // Decrement and get the value
        System.out.println("Decremented Value: " + atomicInteger.decrementAndGet());

        // Add and get the value
        System.out.println("Added Value: " + atomicInteger.addAndGet(10));

        // Get and set the value
        System.out.println("Old Value: " + atomicInteger.getAndSet(5));
        System.out.println("New Value: " + atomicInteger.get());

        // Compare and set
        boolean isUpdated = atomicInteger.compareAndSet(5, 20);
        System.out.println("Was the value updated? " + isUpdated);
        System.out.println("Final Value: " + atomicInteger.get());
    }
}
```

When to Use Atomic Classes
Multithreaded Scenarios:
When multiple threads need to update a shared variable concurrently without locking.
Non-blocking Algorithms:
Ideal for scenarios where locks might cause contention or reduce performance.
Performance-Critical Applications:
Atomic classes outperform traditional synchronized blocks or locks in highly concurrent environments.


## 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)  

CopyOnWriteArrayList: ArrayList
ConcurrentHashMap: HashMap
CopyOnWriteArraySet: HashSet
ArrayBlockingQueue and LinkedBlockingQueue: LinkedList  

## 20. What kind of locks do you know? What is the advantage of each lock?  

ReentrantLock (Lock Interface): A lock that allows a thread to reacquire it multiple times. Use tryLock() to attempt acquiring the lock without blocking indefinitely. For fairness or interruptibility.
ReadWriteLock (Lock Interface): Read-Write Separation: Multiple readers can access the resource simultaneously if no write is happening. Good for read > write condition.
StampedLock (Optimistic): Non-blocking lock: Does not block threads unless a conflict is detected. Can write while reading. High-performance scenarios with minimal write contention.
Semaphore: restrict for limiting access to a fixed number of resources.  

## 21. What is future and completableFuture? List some main methods of ComplertableFuture.  

Future is an interface in the java.util.concurrent package introduced in Java 5. It represents the result of an asynchronous computation. A Future provides methods to:

Check if the computation is complete.
Wait for its completion.
Retrieve the result of the computation once it is done.  


CompletableFuture is a class introduced in Java 8 in the java.util.concurrent package. It extends Future and provides an API for asynchronous programming with more powerful features such as:

Task chaining.
Non-blocking operations.
Combining multiple futures.
Handling exceptions.  

supplyAsync: Creates a CompletableFuture that asynchronously returns a result.
thenApply(): Transforms the result of the CompletableFuture
thenAccept(): Consumes the result without returning anything.
exceptionally(): Handles exceptions and provides a fallback result.
anyOf(), allOf(): Waits for any/all given CompletableFuture instances to complete and return.  

# 22.Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)  
code: com.chuwa.tutorial.t08_multithreading/  

# 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)  

```

public class OddEvenThreads {
    public static void main(String[] args) {
        // Shared object for synchronization
        Object lock = new Object();

        // Thread to print odd numbers
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notify(); // Notify the other thread
                    try {
                        lock.wait(); // Wait for the other thread to complete
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // Thread to print even numbers
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notify(); // Notify the other thread
                    try {
                        lock.wait(); // Wait for the other thread to complete
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // Start both threads
        oddThread.start();
        evenThread.start();
    }
}
```

# 24.create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)  
```
package com.chuwa.exercise.t08_multithreading;

public class PrintNumber1 {
    public static void main(String[] args) {
        // Create and start three threads
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep((long) (Math.random() * 100)); // Random delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep((long) (Math.random() * 100)); // Random delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-2");

        Thread thread3 = new Thread(() -> {
            for (int i = 21; i <= 22; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep((long) (Math.random() * 100)); // Random delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-3");

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
```
## 25. completable future  

```
// 1. Asynchronous Sum and Product Using CompletableFuture


import java.util.concurrent.CompletableFuture;

public class Homework1 {
    public static void main(String[] args) {
        int a = 5, b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        CompletableFuture.allOf(sumFuture, productFuture).join(); // Wait for all tasks to complete
        System.out.println("Completed all calculations!");
    }
}

// 2. Fetch and Merge Data from APIs

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Homework2 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        CompletableFuture<String> productsFuture = fetchData(client, "https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> reviewsFuture = fetchData(client, "https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> inventoryFuture = fetchData(client, "https://jsonplaceholder.typicode.com/users");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                System.out.println("Products: " + products.substring(0, 100) + "...");
                System.out.println("Reviews: " + reviews.substring(0, 100) + "...");
                System.out.println("Inventory: " + inventory.substring(0, 100) + "...");
                System.out.println("Data fetched and merged successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        allFutures.join();
    }

    private static CompletableFuture<String> fetchData(HttpClient client, String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (Exception e) {
                throw new RuntimeException("Failed to fetch data from: " + url, e);
            }
        });
    }
}
//3. Exception Handling

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Homework3 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        CompletableFuture<String> productsFuture = fetchData(client, "https://jsonplaceholder.typicode.com/posts")
                .exceptionally(e -> {
                    System.err.println("Error fetching products: " + e.getMessage());
                    return "[]"; // Default empty response
                });

        CompletableFuture<String> reviewsFuture = fetchData(client, "https://jsonplaceholder.typicode.com/comments")
                .exceptionally(e -> {
                    System.err.println("Error fetching reviews: " + e.getMessage());
                    return "[]"; // Default empty response
                });

        CompletableFuture<String> inventoryFuture = fetchData(client, "https://jsonplaceholder.typicode.com/users")
                .exceptionally(e -> {
                    System.err.println("Error fetching inventory: " + e.getMessage());
                    return "[]"; // Default empty response
                });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                System.out.println("Products: " + products.substring(0, 100) + "...");
                System.out.println("Reviews: " + reviews.substring(0, 100) + "...");
                System.out.println("Inventory: " + inventory.substring(0, 100) + "...");
                System.out.println("Data fetched and processed successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        allFutures.join();
    }

    private static CompletableFuture<String> fetchData(HttpClient client, String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (Exception e) {
                throw new RuntimeException("Failed to fetch data from: " + url, e);
            }
        });
    }
}












