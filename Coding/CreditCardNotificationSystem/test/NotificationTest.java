package CreditCardNotificationSystem.test;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;
import CreditCardNotificationSystem.src.notifications.EmailNotification;
import CreditCardNotificationSystem.src.notifications.Notification;
import CreditCardNotificationSystem.src.notifications.SMSNotification;

public class NotificationTest {
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        email.send(new User("Test", "test@example.com", "123456", "email"), new NotificationContent("Test Email"));

        Notification sms = new SMSNotification();
        sms.send(new User("Test", "test@example.com", "123456", "sms"), new NotificationContent("Test SMS"));
    }
}
