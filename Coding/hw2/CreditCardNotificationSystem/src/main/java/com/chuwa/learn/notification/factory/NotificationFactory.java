package com.chuwa.learn.notification.factory;

import com.chuwa.learn.notification.notifications.*;
import com.chuwa.learn.notification.exception.UnsupportedNotificationException;

public class NotificationFactory {
    public static Notification getNotification(String preference) throws UnsupportedNotificationException {
        if (preference == null) {
            throw new UnsupportedNotificationException("Notification preference is empty.");
        }
        switch (preference.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            default:
                throw new UnsupportedNotificationException("Unsupported notification preference: " + preference);
        }
    }
}
