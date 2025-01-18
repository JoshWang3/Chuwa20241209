package com.example.logdemo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * This method handles IllegalArgumentException globally.
     * When this exception occurs, we return an HTTP status 400 (Bad Request).
     *
     * @param ex The exception object.
     * @return ResponseEntity with an appropriate error message and HTTP status.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException caught: {}", ex.getMessage());

        return new ResponseEntity<>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST); // 400 (Bad Request).
    }

    /**
     * This method handles InterruptedException globally.
     * When this exception occurs, we return an HTTP status 500 (Internal Server Error).
     *
     * @param ex The exception object.
     * @return ResponseEntity with an appropriate error message and HTTP status.
     */
    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<String> handleInterruptedException(InterruptedException ex) {
        logger.error("InterruptedException caught: {}", ex.getMessage());

        return new ResponseEntity<>("Request was interrupted: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 (Internal Server Error)
    }

    /**
     * This method handles all other exceptions (catch-all).
     * We return an HTTP status 500 (Internal Server Error) for any unhandled exception.
     *
     * @param ex The exception object.
     * @return ResponseEntity with an appropriate error message and HTTP status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.error("Exception caught: {}", ex.getMessage());

        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 (Internal Server Error)
    }

}