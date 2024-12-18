package notification.sender;

import notification.exception.NotificationException;
import notification.model.User;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new NotificationException("User email is not provided.");
        }
        System.out.println("Sending EMAIL to " + user.getEmail() + ": " + message);
    }

}
