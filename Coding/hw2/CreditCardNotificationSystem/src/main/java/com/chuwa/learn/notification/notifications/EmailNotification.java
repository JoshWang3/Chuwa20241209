package com.chuwa.learn.notification.notifications;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.exception.NotificationException;

public class EmailNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        System.out.println("Send EMAIL to " + user.getEmail());
        System.out.println("Subject: Credit Card Notification");
        System.out.println("Content: " + message);
        System.out.println("Email sent successfully.\n");
    }
}
