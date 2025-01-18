package com.example.logging_multithread.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//When an exception occurs in a controller method,
// @ControllerAdvice can intercept that exception and modify the response
// before sending it back to the client.
//@ControllerAdvice indicates that the GlobalExceptionHandler class will be responsible for
// handling exceptions thrown from any controller within the application
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    // Handles NullPointerException specifically. 500
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex, WebRequest request) {
        logger.error("NullPointerException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("A required value was missing.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handles IllegalArgumentException specifically. 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        logger.error("IllegalArgumentException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("Invalid input provided.", HttpStatus.BAD_REQUEST);
    }

    // Handles a custom exception. 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleCustomException(ResourceNotFoundException ex, WebRequest request) {
        logger.error("CustomException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Spring will evaluate exception handlers in the order they appear in the class,
    // from top to bottom. It will attempt to match the most specific exception first
    // and fall back to broader exceptions if no handler for the specific one is found.
    // Handles all uncaught exceptions. 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("An error occurred: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
