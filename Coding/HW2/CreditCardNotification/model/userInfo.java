package HW2.CreditCardNotification.model;

public class userInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String whatsAppId;

    public userInfo() {
    }

    public userInfo(String firstName, String lastName, String email, String phone, String whatsAppId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.whatsAppId = whatsAppId;
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
}
