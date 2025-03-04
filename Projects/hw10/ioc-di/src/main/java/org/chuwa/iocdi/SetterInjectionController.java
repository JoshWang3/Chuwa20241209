package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectionController {
    private InjectionService injectionService;

    @Autowired
    public void setInjectionService(InjectionService injectionService) {
        this.injectionService = injectionService;
    }

    public void printMessage() {
        System.out.println("Setter Injection: " + injectionService.getMessage());
    }
}
