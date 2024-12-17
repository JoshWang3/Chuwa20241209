import java.util.List;

public class NotificationService {

    public void sendNotification(User user) {
        try {
            String message = "Hey " + user.getFirstName() + ", you have successfully registered and here is your , please use this for future references.";
            NotificationFactory.getNotification(user.getNotificationPreference()).sendNotification(user.getFirstName(), message);
        } catch (Exception e) {
            System.out.println("Error sending notification to " + user.getFirstName() + ": " + e.getMessage());
        }
    }

    public void broadcastNotification(List<User> users) {
        String message = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            try {
                NotificationFactory.getNotification(user.getNotificationPreference()).sendNotification(user.getFirstName(), message);
            } catch (Exception e) {
                System.out.println("Error broadcasting notification to " + user.getFirstName() + ": " + e.getMessage());
            }
        }
    }
}
