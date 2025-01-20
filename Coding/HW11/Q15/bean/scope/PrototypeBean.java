package com.example.learn.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    public String getScope() {
        return "It's a Prototype Bean";
    }
}
