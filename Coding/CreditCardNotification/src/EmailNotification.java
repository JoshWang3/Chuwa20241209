public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending Email to " + firstName + ": " + message);
    }
}