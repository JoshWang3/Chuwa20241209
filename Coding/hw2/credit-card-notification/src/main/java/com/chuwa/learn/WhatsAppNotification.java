package com.chuwa.learn;

// Step 4: Implement WhatsAppNotification class
// Sends a notification via WhatsApp
class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String content) {
        System.out.println("Sending WhatsApp message to " + user.getPhoneNumber() + ": " + content);
    }
}
