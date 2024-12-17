package org.example.notification.factory;

import org.example.notification.enums.NotificationType;
import org.example.notification.exception.NotificationException;
import org.example.notification.service.EmailNotificationService;
import org.example.notification.service.NotificationService;
import org.example.notification.service.SMSNotificationService;
import org.example.notification.service.WhatsAppNotificationService;

public class NotificationFactory {
    public static NotificationService getNotificationService(NotificationType type)
            throws NotificationException {
        switch (type) {
            case EMAIL:
                return new EmailNotificationService();
            case SMS:
                return new SMSNotificationService();
            case WHATSAPP:
                return new WhatsAppNotificationService();
            default:
                throw new NotificationException("Unsupported notification type: " + type);
        }
    }
}