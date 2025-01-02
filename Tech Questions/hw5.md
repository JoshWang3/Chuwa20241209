### Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

### Write a thread-safe singleton class
```
public class Singleton {
    // 1. static volatile variable
    private static volatile Singleton instance;
    
    // 2. make constructor be private
    private Singleton() {
    }
    
    // 3. static synchronized getInstance method
    public static Singleton getInstance() {
        
        // 4. make sure thread safe
        if(instance == null) {
            synchronized (this) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

```
### How to create a new thread(Please also consider Thread Pool approach)?
- Extends Thread class
``` 
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends");
    }
}
Thread t = new MyThread();
t.start();
```
- Implements Runnable
```
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread using runnable");
    }
}
```
- Implements Callable
``` 
public class MyCallable implements Callable<String> { 
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "start new thread using callable";
    }
}
```
### Difference between Runnable and Callable?
- runnable: 
  - has no return 
  - cannot throw a checked exception 
  - override run() 
- callable: 
  - has return 
  - can throw a checked exception 
  - override call()

### What is the difference between t.start() and t.run()?
- t.start() 
  - starts a new thread to execute the task
  - can't call start() more than once
- t.run() 
  - execute the task in the current thread
  - can call run() multiple times

### Which way of creating threads is better: Thread class or Runnable interface?
Runnable.
- When extending the Thread class, we're not overriding any of its methods. Instead, we are overriding the run() method of Runnable 
- Creating an implementation of Runnable and passing it to the Thread class utilizes aggregation/composition and not inheritance which is more flexible 
- After extending the Thread class, we can't extend any other class 
- Starting from Java 8, Runnable can be represented as lambda expressions


### What are the thread statuses?
- **_New_**：When a new thread is created, it is in the new state. The thread has not yet started to run when the thread is in this state. When a thread lies in the new state, its code is yet to be run and hasn’t started to execute.
- **_Runnable_**：A thread that is ready to run is moved to a runnable state. In this state, a thread might actually be running or it might be ready to run at any instant of time. It is the responsibility of the thread scheduler to give the thread time to run.
- **_Waiting_**: The thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated.
- **_Blocked_**:The thread will be in a blocked state when it is trying to acquire a lock but currently the lock is acquired by the other thread. The thread will move from the blocked state to runnable state when it acquires the lock.
- **_Timed Waiting_**: A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a conditional wait, it is moved to a timed waiting state.
- **_Dead_**: A thread terminates because of either of the following reasons:
  - Because it exits normally. This happens when the code of the thread has been entirely executed by the program. 
  - Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.


### Demonstrate deadlock and how to resolve it in Java code.
Deadlock occurs when two or more threads are blocked forever, waiting for each other.
This usually happens when multiple threads need the same locks but obtain them in different orders. Multithreaded Programming in Java suffers from the deadlock situation because of the synchronized keyword.
- deadlock
```
static class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
    }
}


public static void main(String[] args) {
    final Friend alphonse = new Friend("Alphonse");
    final Friend gaston = new Friend("Gaston");

    new Thread(new Runnable() {
        public void run() {
            alphonse.bow(gaston);
        }
    }).start();

    new Thread(new Runnable() {
        public void run() {
            gaston.bow(alphonse);
        }
    }).start();
}

```
- how to solve it
```
static class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void bow(Friend bower) {
        Friend first, second;
        // Determine lock order based on hash codes
        if (System.identityHashCode(this) < System.identityHashCode(bower)) {
            first = this;
            second = bower;
        } else {
            first = bower;
            second = this;
        }

        synchronized (first) {
            synchronized (second) {
                System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
                bower.bowBack(this);
            }
        }
    }

    public void bowBack(Friend bower) {
        System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
    }
}


public static void main(String[] args) {
    final Friend alphonse = new Friend("Alphonse");
    final Friend gaston = new Friend("Gaston");

    new Thread(() -> alphonse.bow(gaston)).start();
    new Thread(() -> gaston.bow(alphonse)).start();
}

```

### How do threads communicate each other?
- wait(): This method causes the current thread to release the lock. This is done until a specific amount of time has passed or another thread calls the notify() or notifyAll() method for this object.
- notify(): This method wakes a single thread out of multiple threads on the current object’s monitor.
- notifyAll(): This method wakes up all the threads that are on the current object’s monitor.

### What’s the difference between class lock and object lock?
- Object Level Locks: It can be used when you want non-static method or non-static block of the code should be accessed by only one thread.
- Class Level locks: It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime. It should always be used to make static data thread safe.

### What is join() method?
The join() method in Java is provided by the java.lang.Thread class that permits one thread to wait until the other thread finishes its execution. Suppose th is the object of the class Thread whose thread is doing its execution currently, then the th.join(); statement ensures that th is finished before the program does the execution of the next statement.

### what is yield() method
The yield() basically means that the thread is not doing anything particularly important and if any other threads or processes need to be run, they should run. Otherwise, the current thread will continue to run.

### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
- Thread pool represents a group of worker threads that are waiting for the job and reused many times.
- Types of ThreadPool
  - Fixed Size Thread Pool Executor
  - Cached Thread Pool Executor
  - Scheduled Thread Pool Executor
  - Single Thread Pool Executor
  - Work Stealing Thread Pool Executor
- The TaskQueue in a ThreadPool is a data structure that stores tasks that are waiting to be executed by the threads in the pool.

### Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
- The Java Concurrent Framework (java.util.concurrent) is used to create and manage thread pools.
- The ExecutorService interface provides the main functionalities for thread pools. 
It is part of the java.util.concurrent package and offers methods to manage and control threads.

### How to submit a task to ThreadPool?
- Using submit() Method: Returns a Future object; allows tracking or retrieving the result.
- Using execute() Method: Simply runs the task without returning a Future.

### What is the advantage of ThreadPool?
Using thread pools generally offers better performance and resource management compared to creating single
threads directly. Thread pools control the number of concurrent tasks, reduce the overhead of thread creation
and destruction, and improve performance. Moreover, thread pools allow task queuing for pending execution,
automatically manage thread lifecycles, and provide more flexible error handling mechanisms.

### Difference between shutdown() and shutdownNow() methods of executor
- shutdown() method will allow previously submitted tasks to execute before terminating, 
- shutdownNow() method prevents waiting tasks from starting and attempts to stop currently executing tasks.

### What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
- The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations.
- Types of Atomic classes: Atomic Numbers, Atomic References, Atomic Arrays, and Atomic Field Updaters
```
// thread-safe counter
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement()); 
        System.out.println(atomicInteger.get());
    }
}
``` 
- when to use atomic classes:
- Counter Scenarios: When you need thread-safe counters without explicit synchronization
- Cache Values: When implementing thread-safe caching mechanisms
- Flag Variables: For thread-safe boolean flags
- Statistics Collection: When gathering metrics in multi-threaded applications
   
### What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
Concurrent collections in Java SE are part of the java.util.concurrent package, which provides several thread-safe collection classes. 
Unlike traditional collections found in java.util (such as ArrayList and HashMap), concurrent collections are designed to allow multiple threads to access and modify the collections concurrently without the need for external synchronization.
- List -> CopyOnWriteArrayList
- Map -> ConcurrentHashMap
- Set -> CopyOnWriteArraySet
- Queue -> ArrayBlockingQueue / LinkedBlockingQueue
- Deque -> LinkedBlockingDeque

### What kind of locks do you know? What is the advantage of each lock?
- ReentrantLock: allows a thread to acquire the same lock multiple times (re-entrance) without causing a deadlock.
- ReadWriteLock: Multiple threads can acquire the read lock concurrently, provided no thread holds the write lock.
  Only one thread can acquire the write lock.
- StampedLock: designed for high-performance scenarios.

### What is future and completableFuture? List some main methods of ComplertableFuture.
- Future is an interface that belongs to java.util.concurrent package. It is used to represent the result of an asynchronous computation.
- CompletableFuture is a class in java.util.concurrent package that implements the Future and CompletionStage Interface. It represents a future result of an asynchronous computation.

### Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
### Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
- One solution use synchronized and wait notify 
```
public class OddEvenPrinter {
    private final Object lock = new Object();
    private boolean isOddTurn = true;

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }

    public void printOdd() {
        synchronized (lock) {
            for (int i = 1; i <= 9; i += 2) {
                while (!isOddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd: " + i);
                isOddTurn = false;
                lock.notify();
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            for (int i = 2; i <= 10; i += 2) {
                while (isOddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even: " + i);
                isOddTurn = true;
                lock.notify();
            }
        }
    }
}
```
- One solution use ReentrantLock and await, signal
```
public class OddEvenPrinterLock {
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private boolean isOddTurn = true;

    public static void main(String[] args) {
        OddEvenPrinterLock printer = new OddEvenPrinterLock();
        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }

    public void printOdd() {
        lock.lock();
        try {
            for (int i = 1; i <= 9; i += 2) {
                while (!isOddTurn) {
                    oddCondition.await();
                }
                System.out.println("Odd: " + i);
                isOddTurn = false;
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            for (int i = 2; i <= 10; i += 2) {
                while (isOddTurn) {
                    evenCondition.await();
                }
                System.out.println("Even: " + i);
                isOddTurn = true;
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
```

### create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
```
public class PrintNumber1 {
    private static int currentNumber = 1; 
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Create threads
        Thread thread1 = new Thread(() -> printRange(1, 10));
        Thread thread2 = new Thread(() -> printRange(11, 20));
        Thread thread3 = new Thread(() -> printRange(21, 30));

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void printRange(int start, int end) {
        while (true) {
            lock.lock();
            try {
                if (currentNumber > end) {
                    break; 
                }

                if (currentNumber >= start && currentNumber <= end) {
                    System.out.println(Thread.currentThread().getName() + " prints: " + currentNumber);
                    currentNumber++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
```