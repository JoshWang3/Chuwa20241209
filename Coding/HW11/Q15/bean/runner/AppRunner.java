package com.example.learn.bean.runner;

import com.example.learn.bean.service.DependencyInjectionService;
import com.example.learn.bean.scope.PrototypeBean;
import com.example.learn.bean.scope.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private DependencyInjectionService dependencyInjectionService;

    @Autowired
    private SingletonBean singletonBean1;

    @Autowired
    private SingletonBean singletonBean2;

    @Autowired
    private PrototypeBean prototypeBean1;

    @Autowired
    private PrototypeBean prototypeBean2;

    @Override
    public void run(String... args) {
        System.out.println("=== Dependency Injection Demo ===");
        dependencyInjectionService.displayMessages();

        System.out.println("\n=== Bean Scope Demo ===");
        System.out.println("Singleton Beans (Same Instance): " + (singletonBean1 == singletonBean2));
        System.out.println("Prototype Beans (Different Instances): " + (prototypeBean1 != prototypeBean2));
    }
}
