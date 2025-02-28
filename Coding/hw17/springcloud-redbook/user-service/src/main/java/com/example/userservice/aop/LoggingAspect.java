package com.example.userservice.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(org.springframework.stereotype.Service.*)")
    public void springBeanLogging() {}

    // Pointcut that matches all controller layers
    @Pointcut("within(com.example.userservice.controller.*)")
    public void controllerLayerLogging() {}

    // Pointcut that matches all service layers
    @Pointcut("execution(* com.example.userservice.service.*.*(..))")
    public void serviceLayerLogging() {}

    @Before("serviceLayerLogging()")
    public void logBeforeServiceLayer(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("Log before - service layer by AOP - Start");
        logger.info("Method Name: {}, args: {}", name, Arrays.toString(joinPoint.getArgs()));
        logger.info("Log before service layer info by AOP - Done");
    }

    // Advice to log a message after methods matching the serviceLayer() pointcut return successfully
    @AfterReturning(pointcut = "serviceLayerLogging()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        logger.info("Log success - after service layer info by AOP - Start");
        logger.info("Method Name: {}, args: {}, service return: {}", name, Arrays.toString(joinPoint.getArgs()), result);
        logger.info("Log success after service layer info by AOP - Done");
    }

    // Advice to log a message when a method matching the serviceLayer() pointcut throws an exception
    @AfterThrowing(pointcut = "serviceLayerLogging()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String name = joinPoint.getSignature().getName();
        logger.info("Log fail - after service layer by AOP - Start");
        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), ex.getCause() != null ? ex.getCause() : "NULL");
        logger.info("Log fail after service layer info by AOP - Done");
    }
    
    @Around("controllerLayerLogging()")
    public Object controllerLayerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Log round - controller layer by AOP - Start");
        // 获取当前请求
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        logger.info("[{}], request method: {}, request url: {}", joinPoint.getSignature().getName(), request.getMethod(), request.getRequestURI());

        // Define start time
        long start = System.currentTimeMillis();

        // Proceeds with the method execution and captures the result
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("[{}], throw message: {}",
                    joinPoint.getSignature().getName(),
                    throwable.getMessage());
            throw throwable;
        }

        // Define output time
        long end = System.currentTimeMillis();
        logger.info("[{}], response details: {}", joinPoint.getSignature().getName(), convertResponseEntityToString(result));
        logger.info("Execution time of {}: {} ms", joinPoint.getSignature().getName(), end - start);
        logger.info("Log round - controller layer by AOP - Done");
        // Returns the result of the method execution
        return result;
    }

    @Around("springBeanLogging()")
    public Object springBeanAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Inside springBeanAround @Around");

        if (logger.isDebugEnabled()) {
            logger.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (logger.isDebugEnabled()) {
                logger.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }

    // 将 ResponseEntity 转换为字符串
    private String convertResponseEntityToString(Object result) {
        if (result instanceof ResponseEntity<?> responseEntity) {
            return "Status: " + responseEntity.getStatusCode() + "; " +
                    "Headers: " + responseEntity.getHeaders() + "; " +
                    "Body: " + Objects.requireNonNull(responseEntity.getBody()).toString();
        }
        return result != null ? result.toString() : "null";
    }

}
