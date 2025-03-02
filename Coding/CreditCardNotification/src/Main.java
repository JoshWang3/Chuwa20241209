import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService();
        User user1 = new User("X", NotificationType.SMS);
        User user2 = new User("Y", NotificationType.EMAIL);
        User user3 = new User("Z", NotificationType.WHATSAPP);

        notificationService.sendNotification(user1);
        notificationService.sendNotification(user2);
        notificationService.sendNotification(user3);

        notificationService.broadcastNotification(Arrays.asList(user1, user2, user3));
    }
}