package com.example.hw11project.service.scopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopedService {
    public RequestScopedService() {
        System.out.println("RequestScopedService instance created");
    }

    public String getMessage() {
        return "RequestScopedService message: " + this;
    }
}
