# HW5
## Questions:
### 1. Read:https://www.interviewbit.com/multithreading-interview-questions/#class-level-lock-vs-object-level-lock

### 2. Write a thread-safe singleton class
code: /Coding/HW5/

### 3. How to createa new thread(Please also consider Thread Pool approach)?
code: /Coding/HW5/
### 4. Difference between Runnable and Callable?
**Runnable**: Cannot return values, `run()` is void

**Callable**: Can return a value from `call()`

### 5. What is the difference between t.start() and t.run()?
**`t.start()`**: Create a new thread

**`t.run()`**: Execute the codes within `run()` on current thread, it won't create a thread


### 6. Which way of creating threads is better: Thread class or Runnable interface?
Thread may be better for direct access to all Thread class methods.
But some claims Runnable is better because 
1. Composition is more flexible than inheritance 
2. Can't extend other class if extending Thread class 
3. Runnable can be lambda expressions 
4. Loose coupling

### 7. What are the thread statuses?
1. NEW
2. RUNNABLE
3. BLOCKED(request I/O, wait for a monitor lock)
4. WAITING(wait/join:enter; notify/notifyAll: leave) 
5. TIMED_WAITING(wait/join/sleep)
6. TERMINATED(cannot be restarted)

### 8. Demonstrate deadlock and how to resolve it in Java code.
code: /Coding/HW5/

### 9. How do threads communicate each other?
1. `wait()`: temporarily suspend the execution of a thread, causes the current thread to release the lock and it enters a waiting state and allows other threads to proceed until the object state changes.
2. `notify()`: Wakes up a single waiting thread; that thread will continue execution after it re-acquires the lock.
3. `notifyAll()`: Wakes up all waiting threads, but only one will proceed after acquiring the lock

### 10. What’s the difference between class lock and object lock?
**class lock**: a unique lock for every class. Make static data thread-safe.

**object lock**: a unique lock for every object. Used when one wants to synchronize a non-static method or block.


### 11. What is join() method?
`join()`: wait for a thread to finish its execution before the next thread continues or timeout is reached

### 12. what is yield() method
`yield()` is a static method of Thread class and it pauses the current thread and allow other waiting threads of the same priority.

### 13. What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool?
A thread pool manages a set of anonymous threads that perform work on request.

Three types of ThreadPool:
1. **FixedThreadPool**: Owns and reuses a fixed number of threads for tasks.
2. **CachedThreadPool**: Creates threads as needed, reuses idle ones.
3. **SingleThreadExecutor**: Executes tasks in a single thread.

TaskQueue is the place to store tasks when a task is submitted to the thread pool,

### 14. Which Library is used to create ThreadPool? Which Interface provide main functions of thread-pool?
`java.util.concurrent` library is used to create and manage thread pools.

`ExecutorService` interface provides the main functions for managing thread pools.

### 15. How to submit a task to ThreadPool?
- Use `submit()` method of the ExecutorService service (also implemented from `ThreadPoolExecutor`)
- Use `execute()` method implemented from `ThreadPoolExecutor`

### 16. What is the advantage of ThreadPool?
Thread Pools manage resources in a multithreaded application and to contain the parallelism in certain predefined limits (e.g number of threads).

### 17. Difference between shutdown() and shutdownNow() methods of executor
- `shutdown()`: method will allow previously submitted tasks to execute before terminating the `ExecutorService`
- `shutdownNow()`: method prevents waiting tasks from starting and attempts to stop currently executing tasks.

### 18. What is Atomic classes? How many types of Atomic classes? Give me some code example of Atomic classes and its main methods. when to use it?
The atomic classes provide a lock-free and thread-safe environment on a single variable.
Types of Atomic classes: 
1. primitive types (AtomicInteger, AtomicLong, AtomicBoolean) 
2. Array (AtomicIntegerArray, AtomicLongArray, ...) 
3. Reference (AtomicReference)

code: /Coding/HW5/

### 19. What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)
- `CopyOnWriteArrayList`: for ArrayList
- `ConcurrentHashMap`: for HashMap
- `CopyOnWriteArraySet`: for HashSet
- `ArrayBlockingQueue` and `LinkedBlockingQueue`: for ArrayDeque / LinkedList


### 20. What kind of locks do you know? What is the advantage of each lock?
1. **ReentrantLock** (`Lock` Interface): A lock that allows a thread to reacquire it multiple times. Use `tryLock()` to attempt acquiring the lock without blocking indefinitely. For fairness or interruptibility.
2. **ReadWriteLock** (`Lock` Interface): Read-Write Separation: Multiple readers can access the resource simultaneously if no write is happening. Good for read > write condition.
3. **StampedLock** (Optimistic): Non-blocking lock: Does not block threads unless a conflict is detected. Can write while reading. High-performance scenarios with minimal write contention.
4. **Semaphore**: restrict for limiting access to a fixed number of resources.


### 21. What is future and completableFuture? List some main methods of ComplertableFuture.
`Future` is an object (from submitted tasks to Thread pool) of result of an asynchronous computation. `get()` method retrieves the result, blocking if necessary.

`CompletableFuture` Provides a **non-blocking** and functional programming approach to handle asynchronous computations. Support callbacks and chain operation.
1. `supplyAsync`: Creates a `CompletableFuture` that asynchronously returns a result.
2. `thenApply()`: Transforms the result of the CompletableFuture
3. `thenAccept()`: Consumes the result without returning anything.
4. `exceptionally()`: Handles exceptions and provides a fallback result.
5. `anyOf()`, `allOf()`: Waits for any/all given CompletableFuture instances to complete and return.

### 22. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
code: com.chuwa.tutorial.t08_multithreading/

### 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
1. One solution use synchronized and wait notify
2. One solution use ReentrantLock and await,signal
code: /Coding/HW5/

### 24. create 3 threads, one thread output 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
code: /Coding/HW5/

### 25. completable future:
code: /Coding/HW5/

1. Homework1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
2. Homework2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
   1. Sign In to Developer.BestBuy.com
   2. Best Buy Developer API Documentation(bestbuyapis.github.io)
   3. 可以用fakeapi https://jsonplaceholder.typicode.com/
   4. Github public api:https://api.github.com/users/your-user-name/repos
3. Homework3: For Homework 2,implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.