## HW5: HW_MultiThreading

### 1. Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

### 2. Write a thread-safe singleton class

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


### 3. How to create a new thread(Please also consider Thread Pool approach)?

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




### 4. Difference between Runnable and Callable?

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

### 5. What is the difference between t.start() and t.run()?

t.start(): 
	Create a new thread. Calls the run() method of the thread object t.

t.run(): 
	Execute the codes within run() on current thread, it won't create a thread

### 6. Which way of creating threads is better: Thread class or Runnable interface?

 Runnable is better.
 Runnable allows more flexibility. Java doesn't allow multiple inheritance.
 The same Runnable object can be used to create multiple threads. 
 Runnable can use lambda expressions.
 
 Use Runnable when it needs to inherit other classes, and want to reuse the samet ask with multiple threads.
 Use Thread when it doesn't need to inherit other classes.

### 7. What are the thread statuses?

	1,New: A thread is created but has not started yet. It exists only in memory.
	2,Runnable: A thread is running or ready to run. It is waiting for the CPU to become available.
	3,Blocked: A thread is waiting for a monitor lock to enter or re-enter a synchronized block or method.
	4,Waiting: A thread is waiting for another thread to perform a particular action without any time limit.
	5,Timed Waiting: A thread in this state is waiting for another thread to perform a specific action for a specified period.
	6,Terminated: A thread in this state has completed its execution or has been stopped

### 8. Demonstrate deadlock and how to resolve it in Java code.
	
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
	

### 9. How do threads communicate each other?
	
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

### 10. What’s the difference between class lock and object lock?
	
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

### 11. What is join() method?

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
	

### 12. what is yield() method
	
	The yield() method of is a hint to the operating system's thread scheduler that the current thread is willing to give up its current use of the processor.
	It doesn't guarantee that other threads will actually be scheduled or run immediately.
	It is often used when a thread doesn't have critical work to do for the moment but wants to be cooperative and allow other threads to execute, especially when threads have the same priority.
	
### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?


### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?


### 15. How to submit a task to ThreadPool?


### 16. What is the advantage of ThreadPool?