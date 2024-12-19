package org.example.notification.service;

import org.example.notification.exception.NotificationException;
import org.example.notification.model.User;

public class WhatsAppNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getWhatsAppNumber() == null || user.getWhatsAppNumber().isEmpty()) {
            throw new NotificationException("WhatsApp number is missing for user: " + user.getName());
        }
        System.out.println("WhatsApp message sent to " + user.getWhatsAppNumber());
        System.out.println("Message: " + message);
    }
}