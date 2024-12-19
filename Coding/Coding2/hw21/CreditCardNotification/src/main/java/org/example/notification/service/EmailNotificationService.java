package org.example.notification.service;

import org.example.notification.exception.NotificationException;
import org.example.notification.model.User;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new NotificationException("Email address is missing for user: " + user.getName());
        }
        System.out.println("Email sent to " + user.getEmail());
        System.out.println("Message: " + message);
    }
}