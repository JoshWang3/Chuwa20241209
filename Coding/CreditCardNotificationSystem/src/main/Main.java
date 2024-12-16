package CreditCardNotificationSystem.src.main;

import CreditCardNotificationSystem.src.handlers.NotificationHandler;
import CreditCardNotificationSystem.src.models.NotificationContent;
import CreditCardNotificationSystem.src.models.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "john@example.com", "1234567890", "email");
        User user2 = new User("Jane", "jane@example.com", "0987654321", "sms");
        User user3 = new User("Alice", "alice@example.com", "5555555555", "whatsapp");
        User user4 = new User("Bob", "bob@example.com", "1111111111", "unknown");

        NotificationContent content1 = new NotificationContent("Hey" + user1.getFirstName()+", you have successfully registered!");
        NotificationContent content2 = new NotificationContent("Hey" + user2.getFirstName()+", you have successfully registered!");
        NotificationContent content3 = new NotificationContent("Hey" + user3.getFirstName()+", you have successfully registered!");
        NotificationContent content4 = new NotificationContent("Hey" + user4.getFirstName()+", you have successfully registered!");

        NotificationHandler handler = new NotificationHandler();
        handler.sendNotification(user1, content1);
        handler.sendNotification(user2, content2);
        handler.sendNotification(user3, content3);
        handler.sendNotification(user4, content4);
    }
}

