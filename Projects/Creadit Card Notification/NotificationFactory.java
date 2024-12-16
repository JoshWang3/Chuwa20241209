public class NotificationFactory {
    public static Notification createNotification(String type) throws InvalidNotificationTypeException {
        if (type == null) {
            throw new InvalidNotificationTypeException("Notification type cannot be null");
        }
        switch(type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "whatsapp":
                return new WhatsAppNotification();
            default:
                throw new InvalidNotificationTypeException("Invalid notification type: " + type);
        }
    }
}
