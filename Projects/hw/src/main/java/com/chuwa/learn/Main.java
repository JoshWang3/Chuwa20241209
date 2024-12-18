package com.chuwa.learn;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("a", new Email()),
                new User("b", new SMS()),
                new User("c", new WhatsApp())
        );

        String message = "Hey firstName, you have successfully registered to add and here is your %s, please use this for" +
                " future references. Broadcast public notification to all users 40%% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            user.getPreference().sendNotification(user.getFirstName(), message);
        }
    }
}
