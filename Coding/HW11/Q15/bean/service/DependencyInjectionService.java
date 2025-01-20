package com.example.learn.bean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionService {
    private final ServiceA serviceA;  // Constructor Injection
    private ServiceB serviceB;        // Setter Injection

    @Autowired
    @Qualifier("serviceBBean")        // Field Injection with Qualifier
    private ServiceB qualifiedServiceB;

    @Autowired
    public DependencyInjectionService(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void displayMessages() {
        System.out.println("Constructor Injection: " + serviceA.getMessage());
        System.out.println("Setter Injection: " + serviceB.getMessage());
        System.out.println("Field Injection with Qualifier: " + qualifiedServiceB.getMessage());
    }
}
