package org.example;

import org.example.notification.enums.NotificationType;
import org.example.notification.manager.NotificationManager;
import org.example.notification.model.User;

public class Main {
    public static void main(String[] args){

        User[] users = {
                new User("Alice", "alice@example.com", "1234567890", "alice_wa", NotificationType.EMAIL),
                new User("Bob", null, "9876543210", "bob_wa", NotificationType.SMS),
                new User("Charlie", "charlie@example.com", null, "charlie_wa", NotificationType.WHATSAPP)
        };

        // Notification manager
        NotificationManager notificationManager = new NotificationManager();

        // Registration Notification Template
        String registrationMessage = "Hey %s, you have successfully registered. " +
                "Please use this for future references.";

        // Broadcast Promotional Notification
        String promotionalMessage = "40% off when you buy Popeyes between 06/13 - 06/19.";

        // Send individual registration notifications
        System.out.println("--- Individual Registration Notifications ---");
        for (User user : users) {
            notificationManager.sendIndividualNotification(
                    user,
                    String.format(registrationMessage, user.getName())
            );
        }

        // Broadcast promotional notification
        System.out.println("\n--- Broadcast Promotional Notifications ---");
        notificationManager.broadcastNotification(users, promotionalMessage);

    }
}