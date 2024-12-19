import notification.Email;
import notification.Notification;
import notification.Sms;
import notification.WhatsApp;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.Constants.*;

public class Main {
    public static void main(String[] args) {
         Map<String, Notification> map  = new HashMap<>();
         map.put(EMAIL_TYPE, Email.getInstance());
         map.put(SMS_TYPE, Sms.getInstance());
         map.put(WHATSAPP_TYPE, WhatsApp.getInstance());

         List<User> users = new ArrayList<>();
         users.add(new User("zifwang", "aaa", "bbb", "aabb@gmail.com", EMAIL_TYPE));
         users.add(new User("insanewang", "bb", "ccc", "cccbb@gmail.com", WHATSAPP_TYPE));
         users.add(new User("zifanw", "ccc", "ddd", "cccddd@gmail.com", SMS_TYPE));

         // Register
         for (User user : users) {
             try {
                 Notification notification = map.get(user.getPreferredNotificationType());
                 String message = notification.generateRegistrationMessage(user);
                 notification.pushNotification(user, message);
             } catch (Exception e) {
                 System.out.println("Notification type " + user.getPreferredNotificationType() + " not supported");
             }
         }

         // Push Discount
        for (User user : users) {
            try {
                Notification notification = map.get(user.getPreferredNotificationType());
                String message = "40% off when you buy Popeyes between 06/13 - 06/19";
                notification.pushNotification(user, message);
            } catch (Exception e) {
                System.out.println("Notification type " + user.getPreferredNotificationType() + " not supported");
            }
        }
    }
}