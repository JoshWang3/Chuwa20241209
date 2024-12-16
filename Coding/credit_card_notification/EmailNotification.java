package credit_card_notification;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending Email to " + user.getEmail());
        System.out.println("Email notification: " + message);
    }
}
