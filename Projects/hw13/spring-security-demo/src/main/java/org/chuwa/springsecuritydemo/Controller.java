package org.chuwa.springsecuritydemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/api/test")
    public ResponseEntity<Void> testEndpoint() {
        return ResponseEntity.ok().build();
    }
}
