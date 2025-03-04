package org.chuwa.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AmbiguityController {
    @Autowired
    @Qualifier("primaryService")
    private AmbiguityService primaryService;

    @Autowired
    @Qualifier("secondaryService")
    private AmbiguityService secondaryService;

    public void resolveAmbiguity() {
        System.out.println("Using Primary Service: " + primaryService.getServiceType());
        System.out.println("Using Secondary Service: " + secondaryService.getServiceType());
    }
}
