package com.example.hw11project.service.scopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class SessionScopedService {
    public SessionScopedService() {
        System.out.println("SessionScopedService instance created");
    }

    public String getMessage() {
        return "SessionScopedService message: " + this;
    }
}
