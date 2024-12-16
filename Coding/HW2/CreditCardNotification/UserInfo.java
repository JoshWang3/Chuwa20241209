package HW2.CreditCardNotification;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String whatsAppId;
    private String preference;

    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String email, String phone, String whatsAppId, String preference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.whatsAppId = whatsAppId;
        this.preference = preference;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsAppId() {
        return whatsAppId;
    }

    public void setWhatsAppId(String whatsAppId) {
        this.whatsAppId = whatsAppId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
