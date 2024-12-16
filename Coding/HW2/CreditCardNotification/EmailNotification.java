package HW2.CreditCardNotification;

import java.util.List;
import java.util.stream.Collectors;

public class EmailNotification implements NotificationService{

    @Override
    public void sendNotification(UserInfo userInfo, String message) {
        String emailContent = String.format(
                "Hey %s, you have successfully registered to add and here is your %s. Please use this for future references.",
                userInfo.getFirstName(),
                message
        );
        System.out.println(emailContent);
    }

    @Override
    public void broadcastNotification(List<UserInfo> users, String broadcastMessage) {
        for (UserInfo user : users.stream().filter(u -> "email".equalsIgnoreCase(u.getPreference())).toList()) {
            System.out.println(broadcastMessage);
        }
    }


}
