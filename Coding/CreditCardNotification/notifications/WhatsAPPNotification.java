package notifications;

import model.User;

public class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending WhatsApp message to " + user.getFirstName() + ": " + content);
    }
}
