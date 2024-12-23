### Read: https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lo
ck
### Write a thread-safe singleton class
```
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
### How to create a new thread(Please also consider Thread Pool approach)?
```
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); 

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {System.out.println("Executing task ")});
    }
}
```
### Difference between Runnable and Callable?
```
runnable
1.not return any result
2.cannot throw checked exceptions
3.used when no result is needed

callable
1.returns a result via Future
2.can throw checked exceptions
3.used when a result is need after execution
```
### What is the difference between t.start() and t.run()?
```
t.start()
starts a new thread and executes the run() method in a new thread

t.run()
Does not create a new thread.
```

### Which way of creating threads is better: Thread class or Runnable interface?
```
thread is better.Thread contains some implementations and the code can be reused.
```
### What are the thread statuses?
```
NEW: Thread is created but not yet started using start()
RUNNABLE: Thread is ready to run or is running
BLOCKED: Thread is waiting to acquire a monitor lock to enter a synchronized block
WAITING: Thread is waiting indefinitely for another thread’s signal using methods like wait()
TIMED_WAITING: Thread is waiting for a specific time using methods like sleep()
TERMINATED: Thread has completed its execution
```
### Demonstrate deadlock and how to resolve it in Java code.
```
A deadlock occurs when two or more threads are waiting for each other to release locks, causing a permanent halt.
```
### How do threads communicate each other?
```
threads communicate with each other mainly using shared objects and synchronization mechanisms provided by the Java language
like join(), notify()
```
### What’s the difference between class lock and object lock?
```
Object Lock: Locks on an instance of a class
Class Lock: Locks on the class itself
```
### What is join() method?
```
The join() method in Java is used to pause the execution of the current thread until another thread  completes its execution
```

### what is yield() method
```
The yield() method temporarily pauses the current thread, allowing other threads of equal or higher priority to execute, but thread scheduling is not guaranteed
```
### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
```
A ThreadPool reuses threads to execute tasks efficiently
 A TaskQueue stores pending tasks for execution when threads are available
```
### Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
```
Is used to create ThreadPools. The ExecutorService interface provides the main functions of a thread pool, such as submit(), shutdown()
```
### How to submit a task to ThreadPool?
```
To submit a task to a ThreadPool, use the submit() or execute() methods of the ExecutorService

ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> System.out.println("start"));
```
### What is the advantage of ThreadPool?
```
Reuses threads, avoiding the overhead of thread creation
Manages the number of concurrent threads efficiently
Prevents overloading the system with too many threads
Queues and schedules tasks automatically
```
### Difference between shutdown() and shutdownNow() methods of executor
```
shutdown()
Allows currently running tasks to complete
Pending tasks remain in the queue
shutdownNow()
Attempts to stop all running tasks immediately
May interrupt running tasks
```
### What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic
classes and its main methods. when to use it?
```
Atomic class provide thread-safe operations on single variables without synchronization
AtomicInteger, AtomicLong...

AtomicInteger counter = new AtomicInteger(0)
counter.incrementAndGet()
counter.addAndGet(1)

When thread-safe updates on shared variables are needed
```

### What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
```
Concurrent Collections are thread-safe data structures in java.util.concurrent for concurrent access

ConcurrentHashMap
CopyOnWriteArrayList
CopyOnWriteArraySet
```

### What kind of locks do you know? What is the advantage of each lock?
```
ReentrantLock: Fair locking and reentrant behavior
ReadWriteLock: Separate locks for read and write, boosting read performance
Synchronized: Simple and JVM-managed
```

### What is future and completableFuture? List some main methods of ComplertableFuture.
```
Future handles asynchronous results but lacks chaining or combining tasks
CompletableFuture extends Future with non-blocking, chaining, and combining capabilities

thenApply()
thenAccept()
thenRun()
```
### Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
### Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in
com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
1. One solution use synchronized and wait notify
2. One solution use ReentrantLock and await, signal


