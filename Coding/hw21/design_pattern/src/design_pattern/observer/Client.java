package design_pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        WeiXinUser wx = new WeiXinUser("aaa");
        subject.attach(wx);
        subject.attach(new WeiXinUser("ccc"));
        subject.attach(new WeiXinUser("bbb"));

        subject.notify("aaasdfsadf");
    }
}

