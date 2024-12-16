public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending SMS to " + firstName + ": " + message);
    }
}
