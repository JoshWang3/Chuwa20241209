package com.example.hw11project.service.injectionDemo;

import org.springframework.stereotype.Component;

// SMSNotification bean
@Component("smsNotification")
public class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification: " + message);
    }
}
