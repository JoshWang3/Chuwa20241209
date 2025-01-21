package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScopeController {
    @Autowired
    private SingletonService singletonService1;

    @Autowired
    private SingletonService singletonService2;

    @Autowired
    private PrototypeService prototypeService1;

    @Autowired
    private PrototypeService prototypeService2;

    public void demonstrateScopes() {
        System.out.println("Singleton Instances:");
        System.out.println(singletonService1);
        System.out.println(singletonService2);

        System.out.println("Prototype Instances:");
        System.out.println(prototypeService1);
        System.out.println(prototypeService2);
    }
}
