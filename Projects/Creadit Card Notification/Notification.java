public interface Notification {
    void send(User user, String message) throws NotificationException;
}