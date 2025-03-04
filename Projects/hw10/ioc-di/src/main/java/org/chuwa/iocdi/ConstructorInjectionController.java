package org.chuwa.iocdi;

import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectionController {
    private final InjectionService injectionService;

    public ConstructorInjectionController(InjectionService injectionService) {
        this.injectionService = injectionService;
    }

    public void printMessage() {
        System.out.println("Constructor Injection: " + injectionService.getMessage());
    }
}
