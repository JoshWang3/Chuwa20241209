package com.example.hw11project.client;

import com.example.hw11project.service.injectionDemo.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionClient {
    private final NotificationService notificationService;

    public ConstructorInjectionClient(@Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public void process(String message) {
        notificationService.sendNotification(message);
    }
}
