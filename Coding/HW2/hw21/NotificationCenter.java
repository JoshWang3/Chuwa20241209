package Chuwa20241209.Coding.HW2.hw21;

import java.util.List;

public class NotificationCenter {
    private NotificationCenter(){};

    public Notification getNotification(String notificationPreference) {
        switch (notificationPreference.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            // If 3 ways above not available -> throw error
            default:
                throw new IllegalArgumentException("Invalid notification preference: " + notificationPreference);
        }
    }

    public void notifyUser(User user, String notificationPreference, String notificationType) {
        try {
            NotificationCenter notificationCenter = NotificationCenter.getInstance();
            Notification notification = getNotification(notificationPreference);
            String message;
            if (notificationType.toUpperCase().equals("BROADCAST")) {
                // General broadcast message
                message = "40% off when you buy Popeyes between 06/13 - 06/19";
            } else {
                // Personalized message
                message = "Hey " + user.getFirstName() +
                        ", you have successfully registered to add and here is your , please use this for future references.";
            }
            notification.sendNotification(user, message);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    public void broadcast(List<User> users) {
        System.out.println("Here's the broadcasting: ");
        for (User user : users) {
            notifyUser(user, user.getNotificationPreference(), "Broadcast");
        }
    }

    private static class NotificationCenterHolder{
        private static final NotificationCenter INSTANCE = new NotificationCenter();
    }

    public static NotificationCenter getInstance(){
        return NotificationCenterHolder.INSTANCE;
    }
}
