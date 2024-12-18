package com.chuwa.learn;

public class WhatsApp implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        System.out.println("Sending WhatsApp to " + firstName + ": " + String.format(message, firstName));
    }

    @Override
    public String name() {
        return "WhatsApp";
    }
}
