package Chuwa20241209.MavenProject.DesignPattern.Publisher_Subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("User1"));
        subject.attach(new WeiXinUser("User2"));
        subject.attach(new WeiXinUser("User3"));

        // Notify user about the update
        subject.notify("Updated!");
    }
}
