package CreditCardNotificationSystem.src.notifications;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;

public class WhatsAppNotification implements Notification {
    @Override
    public void send(User user, NotificationContent content) {
        System.out.println("Sending WhatsApp message to user "
                + user.getPhoneNumber() + ": " + content.getMessage());
    }
}
