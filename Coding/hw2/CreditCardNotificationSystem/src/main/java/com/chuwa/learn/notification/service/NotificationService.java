package com.chuwa.learn.notification.service;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.factory.NotificationFactory;
import com.chuwa.learn.notification.notifications.Notification;
import com.chuwa.learn.notification.exception.UnsupportedNotificationException;
import com.chuwa.learn.notification.exception.NotificationException;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<User> users;

    public NotificationService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendNotification(User user) {
        String message = generateUserNotificationMessage(user);
        try {
            Notification notification = NotificationFactory.getNotification(user.getNotificationPreference());
            notification.send(user, message);
        } catch (UnsupportedNotificationException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NotificationException e) {
            System.err.println("Failed to send notification: " + e.getMessage());
        }
    }

    public void sendBroadcast() {
        String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            try {
                Notification notification = NotificationFactory.getNotification(user.getNotificationPreference());
                notification.send(user, broadcastMessage);
            } catch (UnsupportedNotificationException e) {
                System.err.println("Error broadcasting to " + user.getFirstName() + ": " + e.getMessage());
            } catch (NotificationException e) {
                System.err.println("Failed to send broadcast to " + user.getFirstName() + ": " + e.getMessage());
            }
        }
    }

    private String generateUserNotificationMessage(User user) {
        return "Hey " + user.getFirstName() + ", you have successfully registered your credit card. Please use this for future references.";
    }
}
