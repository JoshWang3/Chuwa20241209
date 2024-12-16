import java.util.List;

public class NotificationService {

    /**
     * Sends a notification to a single user based on their preference.
     * @param user The user to notify.
     * @param message The message content.
     */
    public void notifyUser(User user, String message) {
        try {
            Notification notification = NotificationFactory.createNotification(user.getNotificationPreference());
            notification.send(user, message);
        } catch (InvalidNotificationTypeException | NotificationException e) {
            System.err.println("Error sending notification to " + user.getFirstName() + ": " + e.getMessage());
            // Additional error handling (e.g., logging) can be done here
        }
    }

    /**
     * Broadcasts a notification message to all users.
     * @param users The list of users to notify.
     * @param message The message content.
     */
    public void broadcast(List<User> users, String message) {
        for(User user : users) {
            notifyUser(user, message);
        }
    }
}