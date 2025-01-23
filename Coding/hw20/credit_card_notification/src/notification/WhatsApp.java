package notification;

import static constant.Constants.WHATSAPP_TYPE;

public class WhatsApp extends AbstractNotification {
    private static WhatsApp instance = new WhatsApp(WHATSAPP_TYPE);

    private WhatsApp(String type) {
        super(type);
    }

    public static WhatsApp getInstance() {
        return instance;
    }
}
