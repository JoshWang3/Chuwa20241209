package model;

public class User {
    private String firstName;
    private String preference;

    public User(String firstName, String preference) {
        this.firstName = firstName;
        this.preference = preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPreference() {
        return preference;
    }
}