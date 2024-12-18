package HW2.CreditCardNotification;

import java.util.List;
import java.util.stream.Collectors;

public class WhatsAppNotification implements NotificationService {

    @Override
    public void sendNotification(UserInfo userInfo, String message) {
        System.out.println("WhatsAppNotification sendNotification");
    }

    @Override
    public void broadcastNotification(List<UserInfo> users, String broadcastMessage) {
        for (UserInfo user : users.stream().filter(u -> "email".equalsIgnoreCase(u.getPreference())).collect(Collectors.toList())) {
            System.out.println(broadcastMessage);
        }
    }
}
