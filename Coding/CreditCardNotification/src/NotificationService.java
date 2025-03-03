public class NotificationService {
    public static Notification getNotification(String preference) throws Exception {
        if (preference == null) {
            throw new Exception("Notification preference is null");
        }
        switch (preference.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            default:
                throw new Exception("Invalid notification preference: " + preference);
        }
    }
}
