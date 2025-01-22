package com.example.hw11project.service.scopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeService {
    public PrototypeService() {
        System.out.println("PrototypeService instance created");
    }

    public String getMessage() {
        return "PrototypeService message: " + this;
    }
}
