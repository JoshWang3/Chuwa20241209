package notification.service;

import notification.exception.NotificationException;
import notification.factory.NotificationFactory;
import notification.model.User;
import notification.sender.NotificationSender;

import java.util.List;

public class BroadcastService {
    public void broadcastNotification(List<User> userList, String message) {
        for (User user : userList) {
            try {
                NotificationSender sender = NotificationFactory.getNotificationSender(user.getPreferredNotificationType());
                sender.sendNotification(user, message);
            } catch (NotificationException e) {
                System.err.println("Failed to broadcast to " + user.getFirstName() + ": " + e.getMessage());
            }
        }
    }
}
