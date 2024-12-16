package com.chuwa.learn.notification.model;

public class User {
    private String firstName;
    private String email;
    private String phoneNumber;
    private String whatsAppNumber;
    private String notificationPreference;

    public User(String firstName, String email, String phoneNumber, String whatsAppNumber, String notificationPreference) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.whatsAppNumber = whatsAppNumber;
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }
}
