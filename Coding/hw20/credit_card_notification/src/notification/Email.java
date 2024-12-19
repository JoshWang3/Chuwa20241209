package notification;

import static constant.Constants.EMAIL_TYPE;

public class Email extends AbstractNotification {
    private static Email instance = new Email(EMAIL_TYPE);

    private Email(String type) {
        super(type);
    }

    public static Email getInstance() {
        return instance;
    }
}
