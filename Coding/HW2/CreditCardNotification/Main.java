package HW2.CreditCardNotification;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserInfo> users = Arrays.asList(
                new UserInfo("A", "User", "a@example.com", "1234567890", "whatsappId", "email"),
                new UserInfo("B", "User", "b@example.com", "2345678901", "whatsappId", "sms")
        );
        String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19!";
        String emailMessage = "receipt";
        NotificationManager.notifyUser(users.get(0), emailMessage);
        System.out.print("---------------\n");
        NotificationManager.broadcastNotification(users, broadcastMessage);

    }
}
