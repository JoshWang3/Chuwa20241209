package credit_card_notification;

import java.util.List;

public class NotificationService {
    private Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public void send(User user, String message) {
        if (notification == null) {
            throw new IllegalStateException("No notification method set");
        }
        notification.sendNotification(user, message);
    }

    public void broadCast(List<User> users, String message) {
        System.out.println("\n--- Broadcasting Notification to All Users ---");
        for (User user : users) {
            try {
                send(user, message);
            } catch (Exception e) {
                System.out.println("Error sending notification to " + user.getName() + ": " + e.getMessage());
            }
        }
        System.out.println("--- Broadcast Completed ---\n");
    }
}
