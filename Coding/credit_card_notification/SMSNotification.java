package credit_card_notification;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending SMS to " + user.getPhoneNumber());
        System.out.println("SMS notification: " + message);
    }
}
