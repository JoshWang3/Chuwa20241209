package com.chuwa.learn;

// Step 1: Define the Notification interface
// This interface ensures all notification types implement the sendNotification method.
interface Notification {
    void sendNotification(User user, String content);
}
