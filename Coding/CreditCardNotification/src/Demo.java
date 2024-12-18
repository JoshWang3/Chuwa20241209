public class Demo {
    public static void main(String[] args) {

        String userPreference = "email"; // can be "email", "sms", or "whatsapp"
        String firstName = "Sherry"; //
        String message = "\nHey " + firstName + ", you have successfully registered to add and here is your , please use this for\n" +
                "future references.\n" +
                "Special Announcement: Enjoy 40% off when you purchase Popeyes between 06/13 - 06/19.";

        try {
            Notification notification = NotificationService.getNotification(userPreference);
            notification.sendNotification(firstName, message);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
