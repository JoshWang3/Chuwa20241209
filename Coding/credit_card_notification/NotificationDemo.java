package credit_card_notification;

import java.util.Arrays;
import java.util.List;

public class NotificationDemo {
    public static void main(String[] args) {
        // User preferences
        User user1 = new User("John", "john@example.com", "1234567890", "EMAIL");
        User user2 = new User("Alice", "alice@example.com", "9876543210", "SMS");
        User user3 = new User("Bob", "bob@example.com", "5556667777", "WHATSAPP");
        User user4 = new User("Charlie", "charlie@example.com", "4443332222", "INVALID");

        // Notification service
        NotificationService service = new NotificationService();

        String templateMessage = "Hey %s, you have successfully registered!";

        // Send notifications based on preference
        sendNotificationBasedOnPreference(service, user1, templateMessage);
        sendNotificationBasedOnPreference(service, user2, templateMessage);
        sendNotificationBasedOnPreference(service, user3, templateMessage);
        sendNotificationBasedOnPreference(service, user4, templateMessage);

        List<User> userList = Arrays.asList(user1, user2, user3, user4);
        service.broadCast(userList, "40% off when you buy Popeyes between 06/13 - 06/19");
    }

    // Send notification based on user preference
    public static void sendNotificationBasedOnPreference(NotificationService service, User user, String templateMessage) {
        try {
            String message = String.format(templateMessage, user.getName());
            switch (user.getPreference().toUpperCase()) {
                case "EMAIL":
                    service.setNotification(new EmailNotification());
                    break;
                case "SMS":
                    service.setNotification(new SMSNotification());
                    break;
                case "WHATSAPP":
                    service.setNotification(new WhatsAppNotification());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid notification preference for user: " + user.getName());
            }
            service.send(user, message);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

