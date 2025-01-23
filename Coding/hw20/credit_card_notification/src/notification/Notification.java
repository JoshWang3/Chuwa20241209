package notification;

import user.User;

public interface Notification {
    public void pushNotification(User user, String message);

    public String generateRegistrationMessage(User user);

    public String sendBy();
}
