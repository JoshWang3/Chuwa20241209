package com.example.HelloWorldAOP.service;

import com.example.HelloWorldAOP.aspects.LogExecution;
import com.external.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@LogExecution
public class MyService {
    @Autowired
    private ExternalService externalService;

    public void doSomething() {
        System.out.println("Calling MyService here.");
        externalService.externalMethod();
    }
}
