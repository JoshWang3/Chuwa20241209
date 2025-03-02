package com.example.hw11project.service.scopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class SingletonService {
    public SingletonService() {
        System.out.println("SingletonService instance created");
    }

    public String getMessage() {
        return "SingletonService message: " + this;
    }
}
