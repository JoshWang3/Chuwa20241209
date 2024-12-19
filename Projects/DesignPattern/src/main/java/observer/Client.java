package observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WechatUser("孙悟空"));
        subject.attach(new WechatUser("黑悟空"));
        subject.attach(new WechatUser("孙大圣"));

        subject.notify("专栏更新了");
    }
}
