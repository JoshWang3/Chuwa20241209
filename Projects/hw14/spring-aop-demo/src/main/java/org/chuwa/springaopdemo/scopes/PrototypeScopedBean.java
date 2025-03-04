package org.chuwa.springaopdemo.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeScopedBean {
    public PrototypeScopedBean() {
        System.out.println("PrototypeScopedBean instance created");
    }
}
