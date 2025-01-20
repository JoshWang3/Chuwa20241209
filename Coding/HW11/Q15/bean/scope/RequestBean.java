package com.example.learn.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class RequestBean {
    public String getScope() {
        return "It's Request Bean";
    }
}
