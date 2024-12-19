package notifications;

import model.User;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending EMAIL to " + user.getFirstName() + ": " + content);
    }
}
