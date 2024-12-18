package notification.sender;

import notification.exception.NotificationException;
import notification.model.User;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getPhone() == null || user.getPhone().isEmpty()) {
            throw new NotificationException("User phone number is not provided.");
        }
        System.out.println("Sending SMS to " + user.getPhone() + ": " + message);
    }
}
