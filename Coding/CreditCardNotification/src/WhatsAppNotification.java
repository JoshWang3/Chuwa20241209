public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending WhatsApp message to " + firstName + ": " + message);
    }
}
