package org.example.notification.service;

import org.example.notification.exception.NotificationException;
import org.example.notification.model.User;

public interface NotificationService {
    void sendNotification(User user, String message) throws NotificationException;
}