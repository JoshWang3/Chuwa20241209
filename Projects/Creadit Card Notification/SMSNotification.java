public class SMSNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new NotificationException("Phone number is missing for user: " + user.getFirstName());
        }
        // Simulate sending an SMS
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + message);
        // Integrate with an actual SMS service here
    }
}
