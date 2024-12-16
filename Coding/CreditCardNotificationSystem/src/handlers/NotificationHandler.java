package CreditCardNotificationSystem.src.handlers;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;
import CreditCardNotificationSystem.src.notifications.Notification;
import CreditCardNotificationSystem.src.utils.NotificationFactory;

public class NotificationHandler {
    public void sendNotification(User user, NotificationContent content) {
        try {
            Notification notification = NotificationFactory.getNotification(user.getPreference());
            notification.send(user, content);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            NotificationErrorHandler.handleError(user, content);
        }
    }
}


