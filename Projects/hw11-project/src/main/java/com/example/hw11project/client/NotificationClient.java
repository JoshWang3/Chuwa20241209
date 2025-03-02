package com.example.hw11project.client;

import com.example.hw11project.service.injectionDemo.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationClient {
    private final NotificationService defaultNotificationService;
    private final NotificationService emailNotificationService;
    private final NotificationService smsNotificationService;

    @Autowired
    public NotificationClient(
            @Qualifier("emailNotification") NotificationService emailNotificationService,
            @Qualifier("smsNotification") NotificationService smsNotificationService,
            NotificationService defaultNotificationService) {
        this.defaultNotificationService = defaultNotificationService;
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    public void sendDefaultNotification(String message) {
        defaultNotificationService.sendNotification(message);
    }

    public void sendEmailNotification(String message) {
        emailNotificationService.sendNotification(message);
    }

    public void sendSMSNotification(String message) {
        smsNotificationService.sendNotification(message);
    }

    @Autowired
    public void printAllNotifications(List<NotificationService> notificationServices) {
        System.out.println("All notifications:");
        for (NotificationService notificationService : notificationServices) {
            System.out.println("- " + notificationService.getClass().getSimpleName());
        }
    }

}
