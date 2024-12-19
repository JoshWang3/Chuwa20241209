package Chuwa20241209.Coding.HW2.hw21;

import java.util.ArrayList;

public class CreditCardNotificationDemo {
    public static void main(String[] args) {
        User user1 = new User("Amy", "Antonie", "a.a@gmail.com", "6139203382", "Email");
        User user2 = new User("Benson", "Bochestain", "b.b@gmail.com", "8939203972", "SMS");
        User user3 = new User("Cindy", "Cinderella", "c.c@gmail.com", "3329204421", "WhatsAPP");
        User user4 = new User("Diane", "Diaz", "d.d@gmail.com", "332319423", "5M5");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        NotificationCenter notificationCenter = NotificationCenter.getInstance();
        notificationCenter.notifyUser(user1, user1.getNotificationPreference(), "Direct notification");
        notificationCenter.notifyUser(user2, user2.getNotificationPreference(), "Direct notification");
        notificationCenter.notifyUser(user3, user3.getNotificationPreference(), "Direct notification");
        notificationCenter.notifyUser(user4, user4.getNotificationPreference(), "Direct notification");

        for (User user : userList) {
            System.out.println("user:" + user.getFirstName());
        }

        notificationCenter.broadcast(userList);

    }
}
