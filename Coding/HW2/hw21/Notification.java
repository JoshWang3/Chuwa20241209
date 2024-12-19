package Chuwa20241209.Coding.HW2.hw21;

enum notificationType {
    EMAIL, SMS, WHATSAPP;
}

interface Notification {
    void sendNotification(User user, String message);
}

class EmailNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Send Email message to " + user.getEmail() + ": " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Send SMS message to " + user.getPhoneNumber() + ": " + message);
    }
}

class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Send WhatsApp message to " + user.getPhoneNumber() + ": " + message);
    }
}

