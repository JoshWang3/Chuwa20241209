package com.example.HelloWorldAOP.aspects;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("@within(LogExecution) || @annotation(LogExecution) || execution(* com.example.HelloWorldAOP.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before executing: {}", joinPoint.getSignature().toShortString());
    }

    @After("@within(LogExecution) || @annotation(LogExecution) || execution(* com.example.HelloWorldAOP.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After executing: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "@within(LogExecution) || @annotation(LogExecution) || execution(* com.example.HelloWorldAOP.controller.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        try {
            logger.info("Method {} returned: {}", joinPoint.getSignature().toShortString(), result);
        } catch (Exception e) {
            logger.error("Error in logAfterReturning: ", e);
        }
    }

    @AfterThrowing(pointcut = "@within(LogExecution) || @annotation(LogExecution) || execution(* com.example.HelloWorldAOP.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in {}: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @Around("execution(* com.external..*.*(..))") // directly bind with AOP
    public Object logExternalMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("--------------------------------------------");
        logger.info("Entering external method: {}.{}", className, methodName);
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info("Exiting external method: {}.{}. Execution time: {} ms", className, methodName, (endTime - startTime));

        return result;
    }


/*
    @Pointcut("@within(LogExecution) || @annotation(LogExecution)")
    public void logExecutionPointcut() {}

    @Pointcut("execution(* com.external..*.*(..))")
    public void externalCodePointcut() {}

    @Pointcut("execution(* com.example.HelloWorldAOP.controller.*.*(..))")
    public void controllerMethods() {}

    // 3. Your AOP logger should log with all possible joint points (before method execution, after method execution etc...)
    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        // Implementation
        logger.info("Before executing: {}", joinPoint.getSignature().toShortString());
    }

    @After("controllerMethods()")
    public void logAfter(JoinPoint joinPoint) {
        // Implementation
        logger.info("After executing: {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // Implementation
        // logger.info("Method {} returned: {}", joinPoint.getSignature().toShortString(), result);
        try {
            logger.info("Method {} returned: {}", joinPoint
            .getSignature().toShortString(), result);
        } catch (Exception e) {
            logger.error("Error in logAfterReturning: ", e);
        }
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in {}: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @Around("externalCodePointcut()")
    public Object logExternalMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.info("Entering external method: {}.{}", className, methodName);
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logger.info("Exiting external method: {}.{}. Execution time: {} ms", className, methodName, (endTime - startTime));

        return result;
    }
 */

    /*
    @Around("logExecutionPointcut() || externalCodePointcut()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.info("Entering: {}.{}", className, methodName);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        logger.info("REST API Request - Method: {}, URL: {}", request.getMethod(), request.getRequestURL());
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        logger.info("Method: {}.{} executed in {} ms", className, methodName, (endTime - startTime));
        logger.info("REST API Response: {}", result);

        logger.info("Exiting: {}.{}", className, methodName);

        return result;
    }
    */
}