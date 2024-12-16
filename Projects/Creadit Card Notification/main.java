import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        // Create users
        User userA = new User("Alice", "alice@example.com", "1234567890", "1112223333", "email");
        User userB = new User("Bob", null, "0987654321", "4445556666", "sms");
        User userC = new User("Charlie", "charlie@example.com", null, "7778889999", "whatsapp");
        User userD = new User("David", "david@example.com", "1122334455", null, "push"); // Invalid preference

        // Individual Notifications
        String registrationMessageTemplate = "Hey %s, you have successfully registered to add and here is your , please use this for future references.";
        notificationService.notifyUser(userA, String.format(registrationMessageTemplate, userA.getFirstName()));
        notificationService.notifyUser(userB, String.format(registrationMessageTemplate, userB.getFirstName()));
        notificationService.notifyUser(userC, String.format(registrationMessageTemplate, userC.getFirstName()));
        notificationService.notifyUser(userD, String.format(registrationMessageTemplate, userD.getFirstName())); // Should handle error

        // Broadcast Notification
        String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        List<User> allUsers = Arrays.asList(userA, userB, userC, userD);
        notificationService.broadcast(allUsers, broadcastMessage);
    }
}
