package HW2.CreditCardNotification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationManager {
    private static final Map<String, NotificationService> services = new HashMap<>();

    static {
        services.put("email", new EmailNotification());
        services.put("phone", new SMSNotification());
        services.put("whatsapp", new WhatsAppNotification());
    }

    public static void notifyUser(UserInfo userInfo, String message) {
        String preference = userInfo.getPreference();
        NotificationService service = services.get(preference.toLowerCase());

        if(service != null) {
            service.sendNotification(userInfo, message);
        } else {
            sendAllNotification(userInfo, message);
        }
    }

    public static void broadcastNotification(List<UserInfo> users, String broadcastMessage) {
        for (UserInfo user : users) {
            String preference = user.getPreference();
            NotificationService service = services.get(preference.toLowerCase());

            if (service != null) {
                System.out.println(broadcastMessage);
            }
        }
    }

    private static void sendAllNotification(UserInfo userInfo, String message) {
        for (NotificationService service : services.values()) {
            service.sendNotification(userInfo, message);
        }
    }
}