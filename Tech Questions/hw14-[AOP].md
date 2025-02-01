1. List all of the annotations you learned from class and homework to annotaitons.md
2. Briefly reading: https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions
3. What is the Aspect Oriented Programming, explain it with detailed use cases? 
>AOP allows you to define "aspects" (i.e., behaviors that apply to different parts of your program) and apply them to existing code without modifying the code itself.
> 
> logging
> 
> Transaction Management
> 
> security

4. What are the advantages and disadvantages of Spring AOP?
> AOP allows you to keep the core business logic clean and separate from cross-cutting concerns (logging, security, transactions). This promotes cleaner and more maintainable code.
>
> Since AOP involves creating proxy objects to intercept method calls, it can add some performance overhead. This is particularly noticeable when using Around advice where method execution is wrapped.
5. Explain following concept in your own words, you may include code snippet as part of your answer.
   1. Aspect
   2. PointCut
   3. JoinPoint
   4. Advice
   5. weaving
> Aspect: a cross-cutting concern.
A modularization of a concern that cuts across multiple classes.
Example: Logging aspect, security aspect.
Join Point:
A point in the execution of a program where an aspect can be applied.
Example: Method execution, exception handling.
Advice:
The action taken by an aspect at a particular join point.
Types: Before, After (finally), Around, AfterReturning, AfterThrowing.
Pointcut:
A predicate that matches join points. Point cut determines when advice runs or where the aspect should be applied. It marks the precise location to "cut in" and inject functionality.
Example: All methods in a service layer.
Weaving:
The process of applying aspects to target objects to create advised objects.
Can be done at compile time, load time, or runtime.
> 
> Join points, matched by pointcuts. Pointcuts enable advice to be targeted independently of the Object-Oriented hierarchy.

6. How do we declare a pointcut, can we declare it without annotating an empty method? Name some
   expressions to do it.
>No, in Spring AOP, a pointcut must be associated with a method, even if the method is empty.
>The method name serves as a reference to the pointcut, which can be reused in advice annotations
> 
> @Pointcut("execution(* com.example.service.*.*(..))")
>public void allMethodsInServicePackage() {}
> 
> @Pointcut("execution(* com.example.service.UserService.getUser(..))")
>public void getUserMethod() {}
> 
> @Pointcut("execution(String com.example.service.*.*(..))")
>public void methodsReturningString() {}
> 
> @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
>public void transactionalMethods() {}



7. Compare different types of advices in Spring AOP.
>Types: Before, After (finally), Around, AfterReturning, AfterThrowing.
>@Before	Runs before the target method executes.	Before method execution.	Logging, security checks.
>@AfterReturning	Runs after the target method successfully returns a value.	After method execution (if no exception).	Logging successful executions.
>@AfterThrowing	Runs if the target method throws an exception.	Only when an exception is thrown.	Error handling, logging failures.
>@After	Runs after the method completes (whether success or failure).	Always executes after method execution.	Resource cleanup, auditing.
>@Around	Wraps around the target method (can modify input/output).	Before & after method execution.	Performance monitoring, modifying return values.

8. On top of your Spring application which you did in Assignment #11,
   1. Implement a customized logger using Spring AOP, your logger should be able to log your code and
      also external code.
   2. Your AOP logger should log method execution time, Rest API request details and response details.
   3. Your AOP logger should log with all possible joint points (before method execution, after method
      execution etc...)
   4. Your should bind jointPoints with your AOP code directly, instead of binding it with an empty
      method.
   5. Be ready to demo your implementation and prove it works in class