package com.chuwa.learn;

// Step 5: Define the User class
// This class encapsulates user details, including name, email, phone number, and notification preference.
class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String preference;

    // Constructor to initialize user details
    public User(String name, String email, String phoneNumber, String preference) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preference = preference;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for notification preference
    public String getPreference() {
        return preference;
    }
}
