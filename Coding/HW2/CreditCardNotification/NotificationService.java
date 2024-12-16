package HW2.CreditCardNotification;

import java.util.List;

// OCP -- according to new requirements the module should be open for extension but closed for modification
public interface NotificationService {
    void sendNotification(UserInfo userInfo, String message);

    void broadcastNotification(List<UserInfo> users, String broadcastMessage);
}
