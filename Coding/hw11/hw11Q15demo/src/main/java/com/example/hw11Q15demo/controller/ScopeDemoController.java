package com.example.hw11Q15demo.controller;

import com.example.hw11Q15demo.beanscopes.PrototypeBean;
import com.example.hw11Q15demo.beanscopes.RequestScopedBean;
import com.example.hw11Q15demo.beanscopes.SessionScopedBean;
import com.example.hw11Q15demo.beanscopes.SingletonBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeDemoController {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;

    public ScopeDemoController(SingletonBean singletonBean, PrototypeBean prototypeBean,
                               RequestScopedBean requestScopedBean, SessionScopedBean sessionScopedBean) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
        this.requestScopedBean = requestScopedBean;
        this.sessionScopedBean = sessionScopedBean;
    }

    @GetMapping("/scopes")
    public String demonstrateScopes() {
        return "Singleton: " + singletonBean.incrementAndGet() + "<br>" +
                "Prototype: " + prototypeBean.incrementAndGet() + "<br>" +
                "Request: " + requestScopedBean.incrementAndGet() + "<br>" +
                "Session: " + sessionScopedBean.incrementAndGet();
    }
}