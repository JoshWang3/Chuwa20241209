public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending WhatsApp to " + firstName + ": " + message);
    }
}
