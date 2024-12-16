package CreditCardNotificationSystem.src.notifications;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;

public class EmailNotification implements Notification {
    @Override
    public void send(User user, NotificationContent content) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + content.getMessage());
    }
}
