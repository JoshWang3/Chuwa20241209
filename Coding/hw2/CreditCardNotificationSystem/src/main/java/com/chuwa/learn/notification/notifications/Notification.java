package com.chuwa.learn.notification.notifications;

import com.chuwa.learn.notification.model.User;
import com.chuwa.learn.notification.exception.NotificationException;

public interface Notification {
    void send(User user, String message) throws NotificationException;
}
