package notifications;

import model.User;

public interface Notification {
    void sendNotification(User user, String content);
}
