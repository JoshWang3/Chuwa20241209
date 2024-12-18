package com.chuwa.learn;

class User {
    private String firstName;
    private Notification preference;

    public User(String firstName, Notification preference) {
        this.firstName = firstName;
        this.preference = preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public Notification getPreference() {
        return preference;
    }
}
