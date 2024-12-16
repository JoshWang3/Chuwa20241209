package CreditCardNotificationSystem.src.notifications;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;

public class SMSNotification implements Notification {
    @Override
    public void send(User user, NotificationContent content) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + content.getMessage());
    }
}
