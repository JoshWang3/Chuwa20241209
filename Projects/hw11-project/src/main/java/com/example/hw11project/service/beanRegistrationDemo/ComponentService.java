package com.example.hw11project.service.beanRegistrationDemo;

import org.springframework.stereotype.Component;

@Component // @Component是类级别注解，Spring会自动扫描这个类并创建一个bean
public class ComponentService {
    public String getMessage() {
        return "Message from ComponentService";
    }
}
