package com.chuwa.learn;

public class Email implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending EMAIL to " + firstName + ": " + String.format(message, firstName));
    }

    @Override
    public String name() {
        return "EMAIL";
    }
}
