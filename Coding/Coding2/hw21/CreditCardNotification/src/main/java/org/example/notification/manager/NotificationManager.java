package org.example.notification.manager;

import org.example.notification.exception.NotificationException;
import org.example.notification.factory.NotificationFactory;
import org.example.notification.model.User;
import org.example.notification.service.NotificationService;

public class NotificationManager {
    // Method to send individual user notification
    public void sendIndividualNotification(User user, String message) {
        try {
            // Get notification service based on user's preferred type
            NotificationService notificationService =
                    NotificationFactory.getNotificationService(user.getPreferredNotificationType());

            // Send notification
            notificationService.sendNotification(user, message);
        } catch (NotificationException e) {
            System.err.println("Notification Error: " + e.getMessage());
        }
    }

    // Method to broadcast notification to all users
    public void broadcastNotification(User[] users, String message) {
        for (User user : users) {
            sendIndividualNotification(user, message);
        }
    }
}