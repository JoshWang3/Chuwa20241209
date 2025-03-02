package com.example.hw11project.service.scopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class RequestScopedService {
    public RequestScopedService() {
        System.out.println("RequestScopedService instance created");
    }

    public String getMessage() {
        return "RequestScopedService message: " + this;
    }
}
