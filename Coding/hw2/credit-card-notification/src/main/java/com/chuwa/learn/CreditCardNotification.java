package com.chuwa.learn;

// Step 7: Main class to test the system
public class CreditCardNotification {
    public static void main(String[] args) {
        // Create user objects with their details
        User user1 = new User("John Doe", "john@example.com", "1234567890", "EMAIL");
        User user2 = new User("Jane Doe", "jane@example.com", "9876543210", "SMS");
        User user3 = new User("Alice", "alice@example.com", "1122334455", "WHATSAPP");
        User user4 = new User("Bob", "bob@example.com", "9988776655", "INVALID");

        // Send personalized notifications based on user preferences
        sendNotification(user1); // Sends Email
        sendNotification(user2); // Sends SMS
        sendNotification(user3); // Sends WhatsApp
        sendNotification(user4); // Invalid preference - Error handling

        // Broadcast a common notification to all users
        broadcastNotification("40% off when you buy Popeyes between 06/13 - 06/19");
    }

    // Method to send notifications based on user preference
    public static void sendNotification(User user) {
        // Notification content to be sent
        String content = "Hey " + user.getName() + ", you have successfully registered. Use this for future references.";
        try {
            // Get the appropriate notification implementation from the factory
            Notification notification = NotificationFactory.getNotification(user.getPreference());
            notification.sendNotification(user, content);
        } catch (IllegalArgumentException e) {
            // Handle invalid preferences gracefully
            System.out.println("Error for user " + user.getName() + ": " + e.getMessage());
        }
    }

    // Method to broadcast a message to all users
    public static void broadcastNotification(String message) {
        System.out.println("\nBroadcasting to all users: " + message);
    }
}
