package notification.factory;

import notification.exception.NotificationException;
import notification.model.NotificationType;
import notification.sender.EmailNotificationSender;
import notification.sender.NotificationSender;
import notification.sender.SMSNotificationSender;
import notification.sender.WhatsAppNotificationSender;

public class NotificationFactory {
    public static NotificationSender getNotificationSender(NotificationType type) throws NotificationException {
        switch (type) {
            case EMAIL:
                return new EmailNotificationSender();
            case SMS:
                return new SMSNotificationSender();
            case WHATSAPP:
                return new WhatsAppNotificationSender();
            default:
                throw new NotificationException("Unsupported notification type: " + type);
        }
    }
}
