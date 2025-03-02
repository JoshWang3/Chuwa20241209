package com.example.hw11project.client;

import com.example.hw11project.service.injectionDemo.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionClient {

    @Qualifier("smsNotification")
    @Autowired
    private NotificationService notificationService;

    public void process(String message) {
        notificationService.sendNotification(message);
    }
}
