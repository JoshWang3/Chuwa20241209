package notification;

import static constant.Constants.SMS_TYPE;

public class Sms extends AbstractNotification {
    private static Sms instance = new Sms(SMS_TYPE);

    private Sms(String type) {
        super(type);
    }

    public static Sms getInstance() {
        return instance;
    }
}
