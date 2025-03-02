package com.chuwa.learn;

// Step 3: Implement SMSNotification class
// Sends a notification via SMS
class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + content);
    }
}
