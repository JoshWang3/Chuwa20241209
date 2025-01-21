package org.chuwa.iocdi;

import org.springframework.stereotype.Component;

@Component
public class ComponentService {
    public String getName() {
        return "Registered with @Component";
    }
}
