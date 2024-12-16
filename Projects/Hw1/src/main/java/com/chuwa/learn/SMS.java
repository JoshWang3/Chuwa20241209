package com.chuwa.learn;

public class SMS implements Notification{
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending SMS to " + firstName + ": " + String.format(message, firstName));
    }

    @Override
    public String name() {
        return "SMS";
    }
}
