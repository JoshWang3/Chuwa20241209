package notification;

import user.User;

public abstract class AbstractNotification implements Notification {
    private String notificationType;

    public AbstractNotification(String notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public void pushNotification(User user, String message) {
        System.out.println("To: " + user.getEmail());
        System.out.println("Message: " + message);
    }

    @Override
    public String generateRegistrationMessage(User user) {
        return "Hey " + user.getFirstName() + ", you have successfully registered to " + notificationType +
                "and here is your, please use this for future references.";
    }

    @Override
    public String sendBy() {
        return notificationType;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
