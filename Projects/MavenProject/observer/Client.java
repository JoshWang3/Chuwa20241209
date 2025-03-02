package observer;

public class Client {
    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();
        // 创建微信用户并订阅公众号
        subject.attach(new WeixinUser("小明"));
        subject.attach(new WeixinUser("小红"));
        subject.attach(new WeixinUser("小王"));
        // 公众号更新发出消息给订阅的微信用户
        subject.notify("公众号内容更新了");
    }
}
