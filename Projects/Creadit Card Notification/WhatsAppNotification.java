public class WhatsAppNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        if (user.getWhatsAppNumber() == null || user.getWhatsAppNumber().isEmpty()) {
            throw new NotificationException("WhatsApp number is missing for user: " + user.getFirstName());
        }
        // Simulate sending a WhatsApp message
        System.out.println("Sending WhatsApp message to " + user.getWhatsAppNumber() + ": " + message);
        // Integrate with an actual WhatsApp service here
    }
}