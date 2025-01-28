package org.chuwa.springaopdemo.controller;

import org.chuwa.springaopdemo.scopes.PrototypeScopedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    @Autowired
    private PrototypeScopedBean prototypeScopedBean1;

    @Autowired
    private PrototypeScopedBean prototypeScopedBean2;

    @GetMapping("/scopes")
    public String checkScope() {
        return prototypeScopedBean1 == prototypeScopedBean2
                ? "Singleton Scope"
                : "Prototype Scope (Different Instances)";
    }
}
