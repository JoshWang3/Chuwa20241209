package com.chuwa.learn;

// Step 2: Implement EmailNotification class
// Sends a notification via Email
class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + content);
    }
}
