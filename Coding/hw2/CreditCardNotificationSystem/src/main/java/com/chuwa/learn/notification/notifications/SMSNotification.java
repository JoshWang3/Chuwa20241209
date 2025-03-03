package com.chuwa.learn.notification.notifications;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.exception.NotificationException;

public class SMSNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        System.out.println("Send SMS to " + user.getPhoneNumber());
        System.out.println("Message: " + message);
        System.out.println("SMS sent successfully.\n");
    }
}
