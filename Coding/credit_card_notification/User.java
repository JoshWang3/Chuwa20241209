package credit_card_notification;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String preference;

    public User (String name, String email, String phoneNumber, String preference) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPreference() {
        return preference;
    }
}
