package com.example.hw11project.service.injectionDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// EmailNotification bean
@Component("emailNotification")
@Primary
public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification: " + message);
    }
}
