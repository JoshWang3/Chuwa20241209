public class User {
    private String firstName;
    private NotificationType notificationPreference;

    public User(String firstName, NotificationType notificationPreference) {
        this.firstName = firstName;
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public NotificationType getNotificationPreference() {
        return notificationPreference;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNotificationPreference(NotificationType notificationPreference) {
        this.notificationPreference = notificationPreference;
    }
}
