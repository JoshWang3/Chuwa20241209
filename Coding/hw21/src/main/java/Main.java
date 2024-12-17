import notification.model.NotificationType;
import notification.model.User;
import notification.service.BroadcastService;
import notification.service.NotificationService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some users with different preferences
        User userA = new User("Alice", "alice@example.com", "1234567890", NotificationType.EMAIL);
        User userB = new User("Bob", null, "0987654321", NotificationType.SMS);
        User userC = new User("Charlie", null, "1112223333", NotificationType.WHATSAPP);
        User userD = new User("David", "david@example.com", "", NotificationType.SMS);

        // Personalized notification
        NotificationService notificationService = new NotificationService();

        String referenceCode = "XYZ123";
        String personalMessage = "Hey %s, you have successfully registered to add and here is your %s, please use this for future references.";
        notificationService.notifyUser(userA, String.format(personalMessage, userA.getFirstName(), referenceCode));
        notificationService.notifyUser(userB, String.format(personalMessage, userB.getFirstName(), referenceCode));
        notificationService.notifyUser(userC, String.format(personalMessage, userC.getFirstName(), referenceCode));
        notificationService.notifyUser(userD, String.format(personalMessage, userD.getFirstName(), referenceCode));

        // Broadcast notification
        List<User> allUsers = Arrays.asList(userA, userB, userC, userD);
        BroadcastService broadcastService = new BroadcastService();
        String broadcastMessage = "40% off at Popeyes between 06/13 - 06/19! Don’t miss out.";
        broadcastService.broadcastNotification(allUsers, broadcastMessage);
    }

}
