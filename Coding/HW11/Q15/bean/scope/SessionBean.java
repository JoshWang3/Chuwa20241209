package com.example.learn.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionBean {
    public String getScope() {
        return "It's a Session Bean";
    }
}
