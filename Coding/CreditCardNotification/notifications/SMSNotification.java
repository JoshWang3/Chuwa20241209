package notifications;

import model.User;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending SMS to " + user.getFirstName() + ": " + content);
    }
}
