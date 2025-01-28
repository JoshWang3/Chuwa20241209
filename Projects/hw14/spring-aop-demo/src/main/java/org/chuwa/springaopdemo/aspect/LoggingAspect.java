package org.chuwa.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* org.chuwa.springaopdemo.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature());
    }

    @After("execution(* org.chuwa.springaopdemo.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* org.chuwa.springaopdemo.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + joinPoint.getSignature() + " with value: " + result);
    }

    @AfterThrowing(pointcut = "execution(* org.chuwa.springaopdemo.controller.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Method threw exception: " + joinPoint.getSignature() + ", Error: " + error.getMessage());
    }

    @Around("execution(* org.chuwa.springaopdemo.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature() + " was " + (endTime - startTime) + "ms");
        return result;
    }
}
