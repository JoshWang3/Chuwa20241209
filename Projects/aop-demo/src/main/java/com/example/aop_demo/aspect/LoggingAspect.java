package com.example.aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

//    @Pointcut("execution(* com.example.aop_demo.controller.*.*(..))")
//    public void controllerMethods() {}


    @Around("execution(* com.example.aop_demo.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature() + ": " + (endTime - startTime) + "ms");
        return result;
    }


    @Before("execution(* com.example.aop_demo.controller.*.*(..))")
    public void logMethodDetails(JoinPoint joinPoint) {
        System.out.println("Before execution of method: " + joinPoint.getSignature());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }


    @After("execution(* com.example.aop_demo.controller.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        System.out.println("After execution of method: " + joinPoint.getSignature());
    }
}
