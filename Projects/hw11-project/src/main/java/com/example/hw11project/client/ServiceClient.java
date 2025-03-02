package com.example.hw11project.client;

import com.example.hw11project.service.beanRegistrationDemo.BeanService;
import com.example.hw11project.service.beanRegistrationDemo.ComponentService;
import org.springframework.stereotype.Component;

@Component
public class ServiceClient {
    // 此处ComponentService是通过@Component注册，BeanService是通过@Bean注册
    private final ComponentService componentService;
    private final BeanService beanService;

    public ServiceClient(ComponentService componentService, BeanService beanService) {
        this.componentService = componentService;
        this.beanService = beanService;
    }

    public void printMessages() {
        System.out.println(componentService.getMessage());
        System.out.println(beanService.getMessage());
    }
}
