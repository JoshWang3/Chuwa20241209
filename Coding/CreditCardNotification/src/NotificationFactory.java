public class NotificationFactory {

    public static Notification getNotification(NotificationType pref) throws Exception {

        switch (pref) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case WHATSAPP:
                return new WhatsAppNotification();
            default:
                throw new Exception("Invalid notification preference: " + pref);
        }
    }
}
