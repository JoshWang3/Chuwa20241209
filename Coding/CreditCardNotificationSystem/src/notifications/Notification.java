package CreditCardNotificationSystem.src.notifications;

import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;

public interface Notification {
    void send(User user, NotificationContent content);
}



