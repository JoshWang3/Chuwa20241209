package notification.service;

import notification.exception.NotificationException;
import notification.factory.NotificationFactory;
import notification.model.User;
import notification.sender.NotificationSender;

public class NotificationService {
    public void notifyUser(User user, String message) {
        try {
            NotificationSender sender = NotificationFactory.getNotificationSender(user.getPreferredNotificationType());
            sender.sendNotification(user, message);
        } catch (NotificationException e) {
            System.err.println("Failed to notify user " + user.getFirstName() + ": " + e.getMessage());
        }
    }
}
