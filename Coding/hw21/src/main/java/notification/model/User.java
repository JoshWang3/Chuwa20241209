package notification.model;

public class User {
    private String firstName;
    private String email;
    private String phone;
    private NotificationType preferredNotificationType;

    public User(String firstName, String email, String phone, NotificationType preferredNotificationType) {
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.preferredNotificationType = preferredNotificationType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public NotificationType getPreferredNotificationType() {
        return preferredNotificationType;
    }
}
