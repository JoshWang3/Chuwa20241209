package com.chuwa.learn.notification.notifications;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.exception.NotificationException;

public class WhatsAppNotification implements Notification {
    @Override
    public void send(User user, String message) throws NotificationException {
        System.out.println("Send WhatsApp message to " + user.getWhatsAppNumber());
        System.out.println("Message: " + message);
        System.out.println("WhatsApp message sent successfully.\n");
    }
}
