package CreditCardNotificationSystem.src.utils;

import CreditCardNotificationSystem.src.notifications.EmailNotification;
import CreditCardNotificationSystem.src.notifications.Notification;
import CreditCardNotificationSystem.src.notifications.SMSNotification;
import CreditCardNotificationSystem.src.notifications.WhatsAppNotification;

public class NotificationFactory {
    public static Notification getNotification(String preference) {
        switch (preference.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "whatsapp":
                return new WhatsAppNotification();
            default:
                throw new IllegalArgumentException("Unsupported notification type: " + preference);
        }
    }
}
