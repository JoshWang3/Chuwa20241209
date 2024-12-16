package com.chuwa.learn;

// Step 6: Create the NotificationFactory class
// This class returns the correct Notification implementation based on user preference.
class NotificationFactory {
    public static Notification getNotification(String preference) {
        if (preference == null) {
            throw new IllegalArgumentException("Preference cannot be null");
        }
        // Choose the appropriate notification type
        // Handle invalid preferences
        return switch (preference.toUpperCase()) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SMSNotification();
            case "WHATSAPP" -> new WhatsAppNotification();
            default -> throw new IllegalArgumentException("Invalid Notification Preference: " + preference);
        };
    }
}
