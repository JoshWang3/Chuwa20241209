package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private FieldInjectionController fieldController;

    @Autowired
    private SetterInjectionController setterController;

    @Autowired
    private ConstructorInjectionController constructorController;

    @Autowired
    private ScopeController scopeController;

    @Autowired
    private AmbiguityController ambiguityController;

    @Autowired
    private BeanController beanController;

    @Override
    public void run(String... args) {
        System.out.println("=== Dependency Injection ===");
        fieldController.printMessage();
        setterController.printMessage();
        constructorController.printMessage();

        System.out.println("\n=== Bean Scopes ===");
        scopeController.demonstrateScopes();

        System.out.println("\n=== Resolving Ambiguity ===");
        ambiguityController.resolveAmbiguity();

        System.out.println("\n=== Bean Registration ===");
        beanController.displayBeanTypes();
    }
}
