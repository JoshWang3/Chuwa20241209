public class EmailNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new NotificationException("Email address is missing for user: " + user.getFirstName());
        }
        // Simulate sending an email
        System.out.println("Sending EMAIL to " + user.getEmail() + ": " + message);
        // Integrate with an actual email service here
    }
}
