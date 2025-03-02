package com.example.hw11project.controller;

import com.example.hw11project.service.scopeDemo.PrototypeService;
import com.example.hw11project.service.scopeDemo.RequestScopedService;
import com.example.hw11project.service.scopeDemo.SessionScopedService;
import com.example.hw11project.service.scopeDemo.SingletonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ScopeController {
    private final SingletonService singletonService;
    private final PrototypeService prototypeService;
    private final RequestScopedService requestScopedService;
    private final SessionScopedService sessionScopedService;

    public ScopeController(SingletonService singletonService, PrototypeService prototypeService, RequestScopedService requestScopedService, SessionScopedService sessionScopedService) {
        this.singletonService = singletonService;
        this.prototypeService = prototypeService;
        this.requestScopedService = requestScopedService;
        this.sessionScopedService = sessionScopedService;
    }

    @GetMapping("/scopes")
    public Map<String, String> getScopes() {
        Map<String, String> scopes = new HashMap<>();
        // 无论调用多少次，SingletonService的实例都是同一个
        scopes.put("Singleton", singletonService.getMessage());

        // 每次调用PrototypeService的实例都是新的
        scopes.put("Prototype", prototypeService.getMessage());

        // RequestScopedService的实例在同一个HTTP请求中是同一个
        scopes.put("Request", requestScopedService.getMessage());

        // 同一用户的多个请求共享同一个SessionScopedService实例
        scopes.put("Session", sessionScopedService.getMessage());
        return scopes;
    }
}
