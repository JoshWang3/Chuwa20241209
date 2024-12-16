package credit_card_notification;

public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending WhatsApp to " + user.getPhoneNumber());
        System.out.println("WhatsApp notification: " + message);
    }
}
