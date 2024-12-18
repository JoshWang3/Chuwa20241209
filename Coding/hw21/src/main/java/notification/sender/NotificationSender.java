package notification.sender;

import notification.exception.NotificationException;
import notification.model.User;

public interface NotificationSender {
    void sendNotification(User user, String message) throws NotificationException;
}
