## 1. List all of the annotations you learned from class and homework to annotations.md
    see Tech\ Question/hw14
## 2. Briefly reading: https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions
## 3. What is the Aspect Oriented Programming, explain it with detailed use cases?
    Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase the modularity of an application 
    by separating cross-cutting concerns from the main business logic. Cross-cutting concerns are functionalities 
    that are used across various parts of an application but are not the main focus of the business logic.
    For example:
        1. Logging. In service and controller layers, logging is a common things we need to record important information
            and monitor whether the program works as we expected. However, it is not the business logic we should focus on.
        2. Transaction Management
            Handling transactions is another typical cross-cutting concern. 
            With AOP, you can define a transaction aspect that automatically starts and commits/rolls back transactions around specific methods.
        3. Security (Authorization)
            AOP can also be used to check permissions or roles before allowing access to certain methods or classes.
        4. Caching
            Another common use case is caching results of expensive operations. 
            AOP can be used to check if the result is already cached before calling the method, 
            and then cache the result after the method executes.
## 4. What are the advantages and disadvantages of Spring AOP?
    Advantages of AOP
        Separation of Concerns: AOP allows you to separate cross-cutting concerns (like logging, security, etc.) from your business logic, making the codebase more modular and easier to maintain.
        Cleaner Code: By moving repetitive tasks like logging or transaction management into aspects, the core business logic becomes cleaner and easier to read.
        Reduced Redundancy: You don't need to repeatedly write the same logic (e.g., logging, security) across multiple methods or classes. You define the logic in one aspect and apply it wherever needed.
        Flexible and Dynamic: AOP allows you to define behavior dynamically at runtime, providing flexibility in how and when aspects are applied.
## 5. Explain following concept in your own words, you may include code snippet as part of your answer.
    1. Aspect: A module that encapsulates a concern that cuts across multiple classes (e.g., logging, security, caching).
    2. PointCut: A set of criteria that determines where and when the advice should be applied (i.e., specifies the join points).
    3. JoinPoint: A point in the execution of the program where an aspect can be applied (e.g., method execution, field access).
    4. Advice: The action taken at a join point. It is the code that is executed when a certain condition (defined by pointcut) is met. There are different types of advice:
        Before: Executed before the join point.
        After: Executed after the join point finishes (whether normally or with an exception).
        Around: Wraps the join point, allowing control over when the join point executes.
        AfterReturning: Executed only if the join point completes successfully.
        AfterThrowing: Executed if the join point throws an exception.
```java
// Marks this class as an Aspect for AOP functionality
@Aspect

// Marks this class as a Spring-managed component so it can be autowired into the application context
@Component
public class LoggingAspect {

    // Defines a reusable pointcut expression for all method executions within the com.example.service package and its sub-packages
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceLayer() {}

    // Advice to log a message before methods matching the serviceLayer() pointcut are executed
    @Before("serviceLayer()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        // Logs the name of the method being executed
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }

    // Advice to log a message after methods matching the serviceLayer() pointcut return successfully
    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // Logs the name of the method and the result it returned
        System.out.println("Method returned: " + result);
    }

    // Advice to log a message when a method matching the serviceLayer() pointcut throws an exception
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        // Logs the name of the method and the exception message
        System.out.println("Exception thrown: " + ex.getMessage());
    }

    // Advice to log messages both before and after methods matching the serviceLayer() pointcut are executed
    @Around("serviceLayer()")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // Logs the method name before execution
        System.out.println("Before method: " + joinPoint.getSignature().getName());
        
        // Proceeds with the method execution and captures the result
        Object result = joinPoint.proceed();
        
        // Logs the method name after execution
        System.out.println("After method: " + joinPoint.getSignature().getName());
        
        // Returns the result of the method execution
        return result;
    }
}
```
## 6. How do we declare a pointcut, can we declare it without annotating an empty method? Name some expressions to do it.
    To declare a pointcut without annotating an empty method, you can directly use the pointcut expression within an @Before, @After, @Around, or @AfterReturning annotation.
```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))") // Pointcut directly in annotation
    @Before("execution(* com.example.service.*.*(..)) && within(com.example.service.UserService)")
    @Before("execution(* com.example.service.*.*(..)) || execution(* com.example.dao.*.*(..))")
    @Before("execution(* com.example.service.*.*(..)) && !execution(* com.example.service.UserService.get*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
    }
}
```
## 7. Compare different types of advices in Spring AOP.
```java
/**
* @Before
* Defines advice that runs before a matched method execution.
  */
  @Before("execution(* com.example.service.*.*(..))")
  public void logBeforeMethod(JoinPoint joinPoint) {
  System.out.println("Executing: " + joinPoint.getSignature());
  }

/**
* @After
* Defines advice that runs after a matched method execution, regardless of its outcome (success or exception).
  */
  @After("execution(* com.example.service.*.*(..))")
  public void logAfterMethod(JoinPoint joinPoint) {
  System.out.println("Completed: " + joinPoint.getSignature());
  }

/**
* @AfterReturning
* Defines advice that runs after a method returns successfully.
  */
  @AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
  System.out.println("Method returned: " + result);
  }

/**
* @AfterThrowing
* Defines advice that runs if a method throws an exception.
  */
  @AfterThrowing(pointcut = "execution(* com.example.service.*.*(..))", throwing = "ex")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
  System.out.println("Exception thrown: " + ex.getMessage());
  }

/**
* @Around
* Defines advice that runs before and after the method execution.
* It provides the most control because you can decide whether to proceed with the method execution.
  */
  @Around("execution(* com.example.service.*.*(..))")
  public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
  System.out.println("Before method: " + joinPoint.getSignature());
  Object result = joinPoint.proceed(); // Proceed with method execution
  System.out.println("After method: " + joinPoint.getSignature());
  return result;
  }
```
## 8. On top of your Spring application which you did in Assignment #11
    See Coding/hw14/redbook
    1. Implement a customized logger using Spring AOP, your logger should be able to log your code and also external code.
    2. Your AOP logger should log method execution time, Rest API request details and response details.
    3. Your AOP logger should log with all possible joint points (before method execution, after method execution etc...)
    4. Your should bind jointPoints with your AOP code directly, instead of binding it with an empty method.
    5. Be ready to demo your implementation and prove it works in class.
    
    