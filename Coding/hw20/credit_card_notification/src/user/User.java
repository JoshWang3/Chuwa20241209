package user;

public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String preferredNotificationType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferredNotificationType() {
        return preferredNotificationType;
    }

    public void setPreferredNotificationType(String preferredNotificationType) {
        this.preferredNotificationType = preferredNotificationType;
    }

    public User(String userName, String firstName, String lastName, String email, String preferredNotificationType) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.preferredNotificationType = preferredNotificationType;
    }
}
