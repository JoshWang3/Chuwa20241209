## 1. Is System.out.print thread safe? Write code using thread pool and multi-thread to answer this question.
    System.out.print is thread safe. This is because this method uses synchronized keyword and grabs lock to make sure the method is thread safe.
```java
// The following code is copy from Java
private void write(String s) {
    try {
        if (lock != null) {
            lock.lock();
            try {
                implWrite(s);
            } finally {
                lock.unlock();
            }
        } else {
            synchronized (this) {
                implWrite(s);
            }
        }
    }
    catch (InterruptedIOException x) {
        Thread.currentThread().interrupt();
    }
    catch (IOException x) {
        trouble = true;
    }
}
```
    See Coding/thread_pool_and_sys_print/src/Example
## 2. Why do we NOT use System.out.print for logging in Spring? Why do we use loggers such as Log4j?
    1. No Control over Log Levels
        System.out.print Problem: It doesn't allow you to categorize logs (e.g., DEBUG, INFO, WARN, ERROR). You can't easily filter messages based on their severity.
        Logging Frameworks Advantage: They provide fine-grained control over log levels, allowing you to easily enable or disable certain types of logs (e.g., enable only ERROR logs in production and DEBUG logs in development).
    2. No Log Formatting
        System.out.print Problem: It provides no structured formatting or timestamp capabilities. This makes it hard to track when a log was created or in what context.
        Logging Frameworks Advantage: Loggers allow customizable formats with useful metadata like:
            Timestamp
            Thread name
            Class or method name
            Log level
            Message
    3. Garbled out put
        Concurrent calls to System.out.print may result in garbled or interleaved output.
        Logging Frameworks Advantage: Logging frameworks handle thread safety and ensure consistent, clear output even in multi-threaded environments.
    4. Performance
        System.out.print Problem: Writing to the console is a blocking I/O operation and can significantly degrade application performance. It doesn't support log buffering or efficient management of log outputs.
        Logging Frameworks Advantage: They use asynchronous or buffered logging, minimizing the performance impact of log generation.
    5. Configuration
        System.out.print Problem: It can't be dynamically configured. You can't redirect logs to files, control log levels, or enable/disable specific logs without modifying the code.
        Logging Frameworks Advantage: Loggers allow extensive configuration:
        Log rotation (to avoid file size bloat)
        Logging to multiple outputs (e.g., console, file, database, or external monitoring systems)
        Changing configurations without restarting the application.
    6. Log Management in Production
        System.out.print Problem: It makes log management cumbersome. In production, you often need logs to be stored in files or external systems, but System.out dumps everything to the console, which may not be monitored efficiently.
        Logging Frameworks Advantage: They integrate with monitoring and log aggregation tools like ELK Stack (Elasticsearch, Logstash, Kibana), Splunk, or AWS CloudWatch, making it easy to monitor logs in real-time.
## 3. If System.out.print is thread-safe, is there any other reason why we dislike it?
    For professional applications like those built in Spring, using a logging framework like Log4j or SLF4J is essential. It offers flexibility, efficiency, and robustness that System.out.print simply cannot provide.
## 4. Explain slf4j logging levels, and what is included in slf4j logs.
    1. TRACE
        Purpose:
            The most detailed logging level.
            Used to log highly granular and fine-grained information that is useful for debugging low-level application behavior.
        Use Cases:
            Debugging specific algorithms.
            Verifying variable values or control flow in critical sections.
    2. DEBUG
        Purpose:
            Used to log detailed information that is useful during development and debugging but not generally needed in production.
        Use Cases:
            Debugging application logic.
            Identifying issues in test environments.
    3. INFO
        Purpose:
            Used for general application information and significant events that highlight the normal operation of the application.
        Use Cases:
            Logging application startup and shutdown events.
            Recording high-level application state transitions.
    4. WARN
        Purpose:
            Indicates a potential problem or unexpected situation that might require attention but does not stop the application.
        Use Cases:
            Deprecated API usage.
            Recoverable issues.
    5. ERROR
        Purpose:
            Logs severe issues that result in the application encountering errors but not necessarily crashing.
        Use Cases:
            Exceptions that prevent a certain operation.
            Critical application failures.
    What is included in slf4j logs?
        Example: 2025-01-16 12:45:00 [main] INFO com.example.MyClass - Application started successfully.
            1. 2025-01-16 12:45:00: Timestamp.
            2. [main]: Thread name.
            3. INFO: Log level.
            4. com.example.MyClass: Logger name (usually the class name).
            5. Application started successfully: Message.
## 5. Write a Spring boot Rest application (using Spring Web starter on ) from Scratch, prove it is a multithreaded application by nature (without explicit configuration) according to logs.
    See Coding/hw10/spring-multi-thread/
    In the HelloController, the spring will recive this hello call from postman and wait 3 seconds to process it. You can see from Tech\ Question/hw10/spring-multi-thread-proof.png. The spring uses three threads to process those two requests.
## 6. For your application in 5, make packaging type to war, deploy it to an external tomcat server, document how to deploy it, upload screenshot of each steps.
    1. Generate War File: Tech\ Question/hw10/package-generate-war.png. Use maven plug and click package option to generate war file
    2. Write Dockerfile and docker-compse.yml. See Coding/hw10/spring-multi-thread/Dockerfile and Coding/hw10/spring-multi-thread/docker-compse.yml
    3. In terminal: $docker compose up -- see Tech\ Question/hw10/start-web-app.png
    4. Spring start: see Tech\ Question/hw10/spring-start.png
## 7. For your application in 5, write a global exception handler to render java exceptions to corresponding http statuses, explain your code with comments.
```java
package com.chuwa.springmultithread.excpetion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle IllegalArgumentException and return HTTP 400 (Bad Request).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        logger.error("IllegalArgumentException occurred: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * Handle NullPointerException and return HTTP 500 (Internal Server Error).
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        logger.error("NullPointerException occurred: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected null value encountered.");
    }

    /**
     * Handle custom exceptions (e.g., ResourceNotFoundException) and return HTTP 404 (Not Found).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        logger.error("ResourceNotFoundException occurred: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Handle all other exceptions and return HTTP 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("An unexpected error occurred: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }

    /**
     * Utility method to build the error response structure.
     *
     * @param status  HTTP status to return.
     * @param message Custom error message.
     * @return ResponseEntity with structured error details.
     */
    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", status.value());
        errorDetails.put("error", status.getReasonPhrase());
        errorDetails.put("message", message);

        return new ResponseEntity<>(errorDetails, status);
    }
}
```