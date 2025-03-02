package HW2.CreditCardNotification;

import java.util.List;

public class SMSNotification implements NotificationService{

    @Override
    public void sendNotification(UserInfo userInfo, String message) {
        System.out.println("SMS Notification");
    }

    @Override
    public void broadcastNotification(List<UserInfo> users, String broadcastMessage) {
        for (UserInfo user : users.stream().filter(u -> "email".equalsIgnoreCase(u.getPreference())).toList()) {
            System.out.println(broadcastMessage);
        }
    }
}
