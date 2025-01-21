package org.chuwa.iocdi;
import org.springframework.stereotype.Service;

@Service
public class InjectionService {
    public String getMessage() {
        return "Hello from InjectionService!";
    }
}