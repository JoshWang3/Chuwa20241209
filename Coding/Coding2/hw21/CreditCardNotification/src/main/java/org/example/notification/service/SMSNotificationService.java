package org.example.notification.service;

import org.example.notification.exception.NotificationException;
import org.example.notification.model.User;

public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new NotificationException("Phone number is missing for user: " + user.getName());
        }
        System.out.println("SMS sent to " + user.getPhoneNumber());
        System.out.println("Message: " + message);
    }
}