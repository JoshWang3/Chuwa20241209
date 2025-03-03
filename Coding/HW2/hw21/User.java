package Chuwa20241209.Coding.HW2.hw21;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String notificationPreference;

    public User(String firstName, String lastName, String email, String phoneNumber, String notificationPreference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }



}
