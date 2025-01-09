package com.chuwa.learn.notification;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.service.NotificationService;

public class CreditCardNotificationSystem {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        User userA = new User("Alice", "alice@example.com", "1234567890", "1234567890", "EMAIL");
        User userB = new User("Bob", "bob@example.com", "0987654321", "0987654321", "SMS");
        User userC = new User("Charlie", "charlie@example.com", "1122334455", "1122334455", "WHATSAPP");
        User userD = new User("David", "david@example.com", "6677889900", "6677889900", "PIGEON");

        notificationService.addUser(userA);
        notificationService.addUser(userB);
        notificationService.addUser(userC);
        notificationService.addUser(userD);

        System.out.println("=== Send a notification to a single user ===\n");
        notificationService.sendNotification(userA);
        notificationService.sendNotification(userB);
        notificationService.sendNotification(userC);
        notificationService.sendNotification(userD);

        System.out.println("=== Send a broadcast notification ===\n");
        notificationService.sendBroadcast();
    }
}
