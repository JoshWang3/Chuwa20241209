package notification.sender;

import notification.exception.NotificationException;
import notification.model.User;

public class WhatsAppNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(User user, String message) throws NotificationException {
        if (user.getPhone() == null || user.getPhone().isEmpty()) {
            throw new NotificationException("User phone number is not provided for WhatsApp.");
        }
        System.out.println("Sending WhatsApp Message to " + user.getPhone() + ": " + message);
    }
}
