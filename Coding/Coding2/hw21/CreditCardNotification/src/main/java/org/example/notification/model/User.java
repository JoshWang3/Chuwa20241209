package org.example.notification.model;

import org.example.notification.enums.NotificationType;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String whatsAppNumber;
    private NotificationType preferredNotificationType;

    public User(String name, String email, String phoneNumber,
                String whatsAppNumber, NotificationType preferredType) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.whatsAppNumber = whatsAppNumber;
        this.preferredNotificationType = preferredType;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getWhatsAppNumber() { return whatsAppNumber; }
    public NotificationType getPreferredNotificationType() { return preferredNotificationType; }
}