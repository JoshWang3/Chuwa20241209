package service;

import notifications.Notification;
import model.User;

public class NotificationService {
    private Notification notification;

    public void setNotificationMethod(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(User user, String content) {
        if (notification != null) {
            notification.sendNotification(user, content);
        } else {
            System.out.println("No notification method set for user: " + user.getFirstName());
        }
    }
}
