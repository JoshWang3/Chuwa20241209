package com.example.logging_multithread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    @GetMapping("/hello")
    public @ResponseBody String hello() {
        logger.info("Received request - Thread: {}", Thread.currentThread().getName());
        return "Hello, World!";
//        throw new IllegalArgumentException("Simulated exception");
    }
}
