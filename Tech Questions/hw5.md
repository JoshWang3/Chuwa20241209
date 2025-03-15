## HW5: HW_MultiThreading

### 1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

### 2. Write a thread-safe singleton class

```
	Thread-Safe Singleton (Lazy Initialization with Double-Checked Locking)

	public class Singleton {
		private static volatile Singleton instance;
		private Singleton() {}

		public static Singleton getInstance() {
			if (instance == null) {
	 //  first check: make sure only synchronize one thread, because synchronization is expensive
				synchronized (Singleton.class) {
					if (instance == null) {    //  second check, ensure only one creation
						instance = new Singleton();
					}
				}
			}
			return instance;
		}
	}
```

### 3. How to create a new thread(Please also consider Thread Pool approach)?

```
	(1)  Extending the Thread Class
	Create a new class that extends the Thread class.
	Override the run() method to define the code that the thread should execute.	
	
	class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("This is MyThread running.");
		}
	}

	public class Main {
		public static void main(String args) {
			MyThread thread = new MyThread();
			thread.start(); 
		}
	}
	
	(2) Implementing the Runnable Interface

	Create a class that implements the Runnable interface.
	Implement the run() method to define the code that the thread should execute.
	Create a Thread object and pass the Runnable instance to its constructor.
	
	class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("This is MyRunnable running.");
		}
	}

	public class Main {
		public static void main(String args) {
			MyRunnable runnable = new MyRunnable();
			Thread thread = newThread(runnable);
			thread.start();
		}
	}	
	
	(3)  Using a Thread Pool (Recommended)
	ExecutorService: Java provides ExecutorService for managing a pool of threads.
	This is highly recommended for better resource utilization and performance.
	
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.TimeUnit;

	public class Main {
		public static void main(String args) throws InterruptedException {
			ExecutorService executor = Executors.newFixedThreadPool(5); // Create a pool of 5 threads

			for (int i = 0; i < 10; i++) {
				executor.submit(() -> { 
					System.out.println("Thread " + Thread.currentThread().getName() + " is running."); 
				});
			}

			executor.shutdown(); 
			executor.awaitTermination(60, TimeUnit.SECONDS); 
		}
	}
```

### 4. Difference between Runnable and Callable?

```
Runnable: 
	It is used for tasks that execute without returning a result.
	Has an abstract method: run(). It has no return type (void) and cannot throw checked exceptions.
	Executed using Thread or ExecutorService.execute().

Callable:
	It is Used for tasks that return a result or may throw checked exceptions.	
	Has an abstract method: call(). It can return a value of any type and can throw checked exceptions.
	Executed using ExecutorService.submit(). It returns a Future object, which allows us to retrieve the result of the task asynchronously.

Example:
	
	Runnable task1 = () -> {
		System.out.println("Running a task..."); 
	};


	Callable<Integer> task2 = () -> {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i;
		}
		return sum;
	};
```

### 5. What is the difference between t.start() and t.run()?

```
t.start(): 
	Create a new thread. Calls the run() method of the thread object t.

t.run(): 
	Execute the codes within run() on current thread, it won't create a thread
```

### 6. Which way of creating threads is better: Thread class or Runnable interface?

```
 Runnable is better.
 Runnable allows more flexibility. Java doesn't allow multiple inheritance.
 The same Runnable object can be used to create multiple threads. 
 Runnable can use lambda expressions.
 
 Use Runnable when it needs to inherit other classes, and want to reuse the samet ask with multiple threads.
 Use Thread when it doesn't need to inherit other classes.
```

### 7. What are the thread statuses?

```
	1,New: A thread is created but has not started yet. It exists only in memory.
	2,Runnable: A thread is running or ready to run. It is waiting for the CPU to become available.
	3,Blocked: A thread is waiting for a monitor lock to enter or re-enter a synchronized block or method.
	4,Waiting: A thread is waiting for another thread to perform a particular action without any time limit.
	5,Timed Waiting: A thread in this state is waiting for another thread to perform a specific action for a specified period.
	6,Terminated: A thread in this state has completed its execution or has been stopped
```

### 8. Demonstrate deadlock and how to resolve it in Java code.

```
	public class DeadlockExample {
		private static final Object lock1 = new Object();
		private static final Object lock2 = new Object();

		public static void main(String[] args) {
			Thread thread1 = new Thread(() -> {
				synchronized (lock1) {
					System.out.println("Thread 1: Holding lock 1...");
					try { Thread.sleep(100); }
					catch (InterruptedException e) {}
					System.out.println("Thread 1: Waiting for lock 2...");
					synchronized (lock2) {
						System.out.println("Thread 1: Holding lock 1 and lock 2...");
					}
				}
			});

			Thread thread2 = new Thread(() -> {
				synchronized (lock2) {
					System.out.println("Thread 2: Holding lock 2...");
					try { Thread.sleep(100); }
					catch (InterruptedException e) {}
					System.out.println("Thread 2: Waiting for lock 1...");
					synchronized (lock1) {
						System.out.println("Thread 2: Holding lock 1 and lock 2...");
					}
				}
			});

			thread1.start();
			thread2.start();
		}
	}
	
	Deadlock happens when thread1 holds lock1 and waits for lock2, while thread2 holds lock2 and waits for lock1.
	
	Below is a solution that make both threads acquire locks in the same order (lock1 then lock2), preventing the circular wait condition.
	
	public class DeadlockResolution {
		private static final Object lock1 = new Object();
		private static final Object lock2 = new Object();

		public static void main(String[] args) {
			Thread thread1 = new Thread(() -> {
				synchronized (lock1) {
					System.out.println("Thread 1: Holding lock 1...");
					try { Thread.sleep(100); }
					catch (InterruptedException e) {}
					System.out.println("Thread 1: Waiting for lock 2...");
					synchronized (lock2) {
						System.out.println("Thread 1: Holding lock 1 and lock 2...");
					}
				}
			});

			Thread thread2 = new Thread(() -> {
				synchronized (lock1) {  // Changed to lock1
					System.out.println("Thread 2: Holding lock 1...");
					try { Thread.sleep(100); }
					catch (InterruptedException e) {}
					System.out.println("Thread 2: Waiting for lock 2...");
					synchronized (lock2) {
						System.out.println("Thread 2: Holding lock 1 and lock 2...");
					}
				}
			});

			thread1.start();
			thread2.start();
		}
	}
```

### 9. How do threads communicate each other?

```	
	1, Shared Variables: Threads can share data by accessing common variables1. However, this requires proper synchronization to avoid race conditions.
	2, Thread Control Methods, such as wait(), notify(), and notifyAll()
		wait(): Causes the current thread to wait until another thread invokes notify() or notifyAll()
		notify(): Wakes up a single waiting thread
		notifyAll(): Wakes up all waiting threads
	3, Concurrency Utilities:		
		Semaphores: Control access to a shared resource by multiple threads
		CountDownLatch:
		Mutexes: Ensure mutual exclusion, allowing only one thread to access a shared resource at a time
		Condition Variables: Allow threads to wait for specific conditions to be met
	4, Locks: Provide a way for threads to acquire exclusive access to shared resources
```

### 10. What’s the difference between class lock and object lock?

```	
	Object locks provide instance-level synchronization, while class locks offer class-wide synchronization.
		
	Object Lock:
		Applied to non-static methods or code blocks.
		Each object instance has its own lock.
		Only one thread can execute a synchronized method on a given object instance at a time.
		Used to make instance-level data thread-safe.

	Class Lock:
		Applied to static methods or code blocks.
		There is only one lock per class, shared across all instances.
		Only one thread can execute a static synchronized method of the class at a time.
		Used to make static data thread-safe1.
	
	Their Key differences are:
		(1)Scope: Object locks are instance-specific, while class locks affect all instances of the class.
		(2)Usage: Object locks use "synchronized" keyword or synchronized blocks on "this", while class locks use "static synchronized" or synchronized blocks on "ClassName.class".
		(3)Concurrency: Multiple threads can execute synchronized methods on different object instances simultaneously, but only one thread can execute a static synchronized method across all instances.
```

### 11. What is join() method?

```
	The join() method  allows one thread to wait for the completion of another thread.
	Its purpose is to ensure that a specific thread finishes its execution before the current thread proceeds.

	The join() method has a void return type.

	Example:
	
	class MyThread extends Thread {
		public void run() {
			// ... a task ...
		}
	}

	public class Main {
		public static void main(String[] args) throws InterruptedException {
			MyThread thread = new MyThread();
			thread.start();
			// Wait for the thread to finish
			thread.join(); 
			System.out.println("Thread has finished."); 
		}
	}
	
	The main thread will pause until the MyThread completes its execution.
	
	join() is used for synchronization.
	It can also be used for data dependency, When the current thread relies on the results or side effects of another thread, the join() method ensures that the necessary data is available before proceeding.
```	

### 12. what is yield() method

```	
	The yield() method of is a hint to the operating system's thread scheduler that the current thread is willing to give up its current use of the processor.
	It doesn't guarantee that other threads will actually be scheduled or run immediately.
	It is often used when a thread doesn't have critical work to do for the moment but wants to be cooperative and allow other threads to execute, especially when threads have the same priority.
```	

### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
``` 
	 Instead of creating new threads for every task (which can be resource-intensive), a thread pool reuses existing threads, improving performance and resource management. 
	 When a task is submitted, the thread pool assigns it to an available worker thread, and once the task is completed, the worker thread is returned to the pool to be reused for other tasks.
	 
	 Types of ThreadPools in Java:
	 - FixedThreadPool: 
		Fixed number of threads. Tasks wait in a queue if all threads are busy. Good for predictable workloads.
		Executors.newFixedThreadPool(int nThreads)

		Use case: When we know exactly how many threads are needed, and the workload is steady.
	
	 - CachedThreadPool:
		Dynamically adjusts the number of threads. No task queue—tasks are assigned directly to threads.
		Executors.newCachedThreadPool()
		Jobs are either assigned immediately to an available worker, or a new worker is hired.
		Idle threads are terminated after 60 seconds of inactivity.
		Use case: When tasks come and go unpredictably, and we don’t want to waste resources by keeping unnecessary threads alive.

	 - SingleThreadExecutor:
		Has only one thread that executes tasks sequentially.
		Ensures tasks are executed in the order they are submitted.
		Executors.newSingleThreadExecutor()
	
	- ScheduledThreadPool:
		Executors.newScheduledThreadPool(int corePoolSize)
		Used for scheduling tasks to run after a delay or at fixed intervals.
		Supports periodic or delayed execution of tasks.
		
	- WorkStealingPool (introduced in Java 8):
		Created using Executors.newWorkStealingPool().
		
	
The TaskQueue is used in a thread pool to hold tasks that are waiting to be executed.
When all threads in the pool are busy, new tasks are placed in the task queue until a thread becomes available to process them.
	When a task is submitted to the thread pool, it is assigned to an available thread.
	If no threads are available, the task is added to the task queue.
	Threads in the pool continuously poll the queue for new tasks.
	Once a thread finishes executing a task, it retrieves the next task from the queue.

There are 3 types of TaskQueue.
	- Unbounded Queue:
		Can grow indefinitely as tasks are added.
		Used in thread pools like CachedThreadPool or FixedThreadPool when no limit is set on the queue size.
	- Bounded Queue:
		Has a fixed capacity.
		Used in thread pools like ThreadPoolExecutor with a bounded queue size.
		If the queue is full, new tasks are rejected based on the Rejection Policy.
	- SynchronousQueue:
		A special queue that holds no tasks.
		Tasks are directly handed off to available threads.
		If no thread is available, a new thread is created.
	- PriorityQueue:
		Tasks are ordered based on priority.
		Useful when tasks have different levels of importance.

Thread pools improve performance by reusing threads.
The task queue holds tasks when all threads are busy.
Different types of thread pools are suited for different workloads.
The choice of task queue (bounded, unbounded, or priority) affects the behavior of the thread pool.	
```

### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?

```
The library used to create a ThreadPool is the java.util.concurrent package.

The main interface that provides main functions of a thread pool is ExecutorService.

Executors is a utility class that provides factory methods to create different types of thread pools.
ThreadPoolExecutor is a more flexible and customizable implementation of a thread pool.

Key Methods of ExecutorService interface:
	submit(Runnable task): Submits a task for execution and returns a Future representing the task.
	execute(Runnable command): Executes the given command at some time in the future.
	shutdown(): Initiates an orderly shutdown of the thread pool, allowing previously submitted tasks to execute.
	shutdownNow(): Attempts to stop all actively executing tasks and halts the processing of waiting tasks.
	awaitTermination(long timeout, TimeUnit unit): Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs.

Sample:

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            executor.submit(task);
        }

        // Shutdown the thread pool
        executor.shutdown();
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
    }
}


```
### 15. How to submit a task to ThreadPool?
```
The ExecutorService interface provides methods to submit tasks for execution. 
1, Use the Executors utility class to create a thread pool.
2, Use Runnable or Callable interface to implement a task.
3, Use the submit() or execute() method of the ExecutorService to submit the task to the thread pool.
4, Shut down the thread pool using shutdown().

There are 3 ways to sumit a task:
	submit(Runnable): When you want to submit a task and optionally check its completion status.
	submit(Callable): When you want to submit a task and retrieve its result later.
	execute(Runnable): When you just want to submit a task and don’t care about its status or result.

Use submit() for both Runnable and Callable tasks if no need to track the task’s status or result.
Use execute() for Runnable tasks if it doesn’t need to track the task’s status or result.
Always shut down the thread pool using shutdown() after submitting all tasks to release resources.

Examples:
1. Using Runnable
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new Task(i);
            executor.submit(task); // or executor.execute(task);
        }

        // Shutdown the thread pool
        executor.shutdown();
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() { // no returning value
        System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate task execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

2. Using Callable (to get a result)
import java.util.concurrent.*;

public class ThreadPoolCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a fixed thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a Callable task
        Future<Integer> future = executor.submit(new CallableTask(10));

        // Retrieve the result (this will block until the task completes)
        int result = future.get();
        System.out.println("Result of the task: " + result);

        // Shutdown the thread pool
        executor.shutdown();
    }
}

class CallableTask implements Callable<Integer> {
    private int number;

    public CallableTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        // Simulate a computation
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;	// Callable have a returning value
    }
}
```

### 16. What is the advantage of ThreadPool?
```
	Advantage						Description
Improved Performance			Reduces overhead of thread creation and destruction.
Better Resource Management		Limits the number of threads and prevents resource exhaustion.
Scalability						Handles large workloads efficiently.
Simplified Thread Management	Automates thread lifecycle and provides high-level APIs.
Task Queueing					Balances workload and supports prioritization.
Error Handling					Centralized exception handling and task retry mechanisms.
Asynchronous Programming		Supports Future, Callable, and CompletableFuture.
Flexibility						Customizable and supports different types of thread pools.
Improved Responsiveness			Keeps the main thread responsive by offloading tasks.
Avoids Thread Explosion			Prevents unlimited thread creation.
```

### 17. Difference between shutdown() and shutdownNow() methods of executor

```
The shutdown() and shutdownNow() methods in the ExecutorService interface are used to shut down a thread pool, 
but they behave differently in terms of how they handle ongoing and pending tasks.

Key Differences
Feature					shutdown()								shutdownNow()
Behavior		Graceful shutdown; allows tasks to complete.	Forceful shutdown; tries to stop tasks immediately.
New Tasks		Rejects new tasks.								Rejects new tasks.
Active Tasks	Allows active tasks to complete.				Attempts to interrupt active tasks.
Queued Tasks	Processes all queued tasks.						Returns a list of unprocessed tasks.
Use Case		Graceful shutdown.								Immediate shutdown.
Interruption	Does not interrupt tasks.						Interrupts tasks (if they handle it).

Use case of shutdown():
	When we want to ensure all submitted tasks are completed before shutting down.
	For graceful termination of the thread pool.

Use case of shutdownNow():
	When we need to stop the thread pool immediately, even if some tasks are not completed.
	For emergency shutdowns or when tasks are non-critical.

Combining shutdown() and awaitTermination() to shut down gracefully within a specified time limit, and if not, it forces a shutdown.

	executor.shutdown(); // Initiate graceful shutdown
	if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
		executor.shutdownNow(); // Force shutdown if timeout is reached
	}
```

### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?

```
Atomic classes in Java are part of the java.util.concurrent.atomic package.
Atomic operations are thread-safe and ensure that operations like read-modify-write are performed atomically, even in a multi-threaded environment.
Atomic classes are built using low-level hardware support to ensure thread safety and high performance.

Common types include AtomicInteger, AtomicLong, AtomicReference, atomic arrays, Atomic Field Updaters.
Use atomic classes for counters, shared variables, and non-blocking algorithms.
They are ideal for scenarios where we need high performance and thread safety without locks.

Example 1: AtomicInteger

	import java.util.concurrent.atomic.AtomicInteger;

	public class AtomicIntegerExample {
		public static void main(String[] args) {
			AtomicInteger atomicInt = new AtomicInteger(0);

			// Increment and get
			System.out.println("Incremented value: " + atomicInt.incrementAndGet()); // Output: 1

			// Add and get
			System.out.println("Added value: " + atomicInt.addAndGet(5)); // Output: 6

			// Compare and set
			boolean success = atomicInt.compareAndSet(6, 10);
			System.out.println("Compare and set successful: " + success); // Output: true
			System.out.println("Current value: " + atomicInt.get()); // Output: 10
		}
	}

Example 2: AtomicReference

	import java.util.concurrent.atomic.AtomicReference;

	public class AtomicReferenceExample {
		public static void main(String[] args) {
			AtomicReference<String> atomicRef = new AtomicReference<>("Initial Value");

			// Set a new value
			atomicRef.set("New Value");
			System.out.println("Current value: " + atomicRef.get()); // Output: New Value

			// Compare and set
			boolean success = atomicRef.compareAndSet("New Value", "Updated Value");
			System.out.println("Compare and set successful: " + success); // Output: true
			System.out.println("Current value: " + atomicRef.get()); // Output: Updated Value
		}
	}

Example 3: AtomicIntegerArray

	import java.util.concurrent.atomic.AtomicIntegerArray;

	public class AtomicIntegerArrayExample {
		public static void main(String[] args) {
			AtomicIntegerArray atomicArray = new AtomicIntegerArray(5); // Array of size 5

			// Set value at index 2
			atomicArray.set(2, 10);
			System.out.println("Value at index 2: " + atomicArray.get(2)); // Output: 10

			// Increment value at index 2
			int oldValue = atomicArray.getAndIncrement(2);
			System.out.println("Old value at index 2: " + oldValue); // Output: 10
			System.out.println("New value at index 2: " + atomicArray.get(2)); // Output: 11
		}
	}

```

### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)

```
Concurrent collections in Java are part of the java.util.concurrent package. 
They are designed to support multi-threaded environments and provide thread-safe data structures. 
concurrent collections allow multiple threads to access and modify the collection simultaneously 
without causing data corruption or requiring explicit synchronization.

Some concurrent data structures are:
1, ConcurrentHashMap
2: CopyOnWriteArrayList
3: ArrayBlockingQueue

Use cases are:
Use concurrent collections when multiple threads need to access or modify the collection simultaneously.
Avoiding Explicit Synchronization
Use CopyOnWriteArrayList or CopyOnWriteArraySet for scenarios where reads are frequent and writes are rare.
Use blocking queues, such as ArrayBlockingQueue, LinkedBlockingQueue, for real-time processing.
Use ConcurrentHashMap for scalable, thread-safe maps.




```

### 20. What kind of locks do you know? What is the advantage of each lock?

```
1. synchronized Keyword
Its advantages are: Simple to implement and use, Automatic Lock Management by the JVM, and is Reentrant.
A thread can re-acquire the same lock multiple times.
Its disvantages are: 
It can have performance overhead in high concurrency scenarios.

	public class SynchronizedExample {
		private int count = 0;

		public synchronized void increment() {
			count++;
		}
	}

2. ReentrantLock
It is in java.util.concurrent.locks package.
It is flexible.
It can be configured to follow first come, first serve order.
A thread can re-acquire the same lock multiple times.

Its Disadvantages are that it requires explicit lock management, and might lead to deadlock.

	import java.util.concurrent.locks.Lock;
	import java.util.concurrent.locks.ReentrantLock;

	public class ReentrantLockExample {
		private final Lock lock = new ReentrantLock();
		private int count = 0;

		public void increment() {
			lock.lock();
			try {
				count++;
			} finally {
				lock.unlock();
			}
		}
	}

3, ReadWriteLock


4, StampedLock



5, Condition



```
### 21. What is future and completableFuture? List some main methods of ComplertableFuture.

```
A Future represents the result of an asynchronous computation.
It is introduced in Java 5 as part of the java.util.concurrent package.
It has some limitations, such as Blocking, no composition(Cannot easily combine multiple Future objects), no callbacks.

Example:
	import java.util.concurrent.*;

	public class FutureExample {
		public static void main(String[] args) throws ExecutionException, InterruptedException {
			ExecutorService executor = Executors.newSingleThreadExecutor();

			Future<Integer> future = executor.submit(() -> {
				Thread.sleep(1000); // Simulate a long-running task
				return 42;
			});

			System.out.println("Result: " + future.get()); // Blocks until the result is available
			executor.shutdown();
		}
	}


A CompletableFuture is an enhanced version of Future introduced in Java 8.
It supports non-blocking operations, composition, and callbacks.
Can be manually completed and combined with other CompletableFuture objects.

Its advantages are:
	IT is non-blocking. It supports asynchronous programming without blocking threads.
	It supports Composition. Allows chaining of multiple asynchronous tasks.
	It supports Callbacks and provides methods to attach callbacks for handling completion or exceptions.
	It can be completed manually with a value or exception.

	import java.util.concurrent.CompletableFuture;

	public class CompletableFutureExample {
		public static void main(String[] args) {
			// Create a CompletableFuture
			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
				.thenApply(s -> s + " World")
				.thenApply(String::toUpperCase)
				.exceptionally(ex -> "Error: " + ex.getMessage());

			// Attach a callback
			future.thenAccept(System.out::println);

			// Wait for completion
			future.join();
		}
	}

```
### 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

```
https://github.com/CTYue/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t08_multithreading


```
### 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. 
### (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)

###	1. One solution use synchronized and wait notify

```
synchronized, wait(), and notify():

public class OddEvenPrinterWaitNotify {
    private static final int MAX = 10;
    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 == 0) { // Wait if the number is even
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Odd: " + number++);
                    }
                    lock.notify(); // Notify the even thread
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 != 0) { // Wait if the number is odd
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Even: " + number++);
                    }
                    lock.notify(); // Notify the odd thread
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
```

###	2. One solution use ReentrantLock and await, signal

```
public class OddEvenPrinterWaitNotify {
    private static final int MAX = 10;
    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 == 0) { // Wait if the number is even
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Odd: " + number++);
                    }
                    lock.notify(); // Notify the even thread
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 != 0) { // Wait if the number is odd
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (number <= MAX) {
                        System.out.println("Even: " + number++);
                    }
                    lock.notify(); // Notify the odd thread
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}

```