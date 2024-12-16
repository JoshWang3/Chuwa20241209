package CreditCardNotificationSystem.src.handlers;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;
import CreditCardNotificationSystem.src.notifications.EmailNotification;

public class NotificationErrorHandler {
    public static void handleError(User user, NotificationContent content) {
        System.out.println("Defaulting to Email for user: " + user.getFirstName());
        new EmailNotification().send(user, content);
    }
}
