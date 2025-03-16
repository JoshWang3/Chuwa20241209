package com.example.logdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/logdemo1")
    public String demo1() throws InterruptedException {
        logger.info("Processing request on thread: {}", Thread.currentThread().getName());

        Thread.sleep(2000);
        return "Hello from " + Thread.currentThread().getName();
    }

    /**
     * A demo endpoint that processes a request.
     * This will randomly throw exceptions to test global exception handling.
     */
    @GetMapping("/logdemo2")
    public String demo2() throws InterruptedException {

        logger.info("Processing request on thread: {}", Thread.currentThread().getName());

        Thread.sleep(2000);

        if (Math.random() > 0.5) {
            throw new IllegalArgumentException("Illegal argument!");
        } else {
            throw new InterruptedException("Request was interrupted!");
        }
    }
}