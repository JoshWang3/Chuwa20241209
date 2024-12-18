package PubSub;

public class Client {
    public static void main(String[] args) {
        // Create Subject (WeChat Public Account)
        SubscriptionSubject wechatPublicAccount = new SubscriptionSubject();

        // Create Observers (WeChat Users)
        Observer user1 = new WeixinUser("User A");
        Observer user2 = new WeixinUser("User B");
        Observer user3 = new WeixinUser("User C");

        // Attach users to the subject
        wechatPublicAccount.attach(user1);
        wechatPublicAccount.attach(user2);
        wechatPublicAccount.attach(user3);

        // Publish a message
        wechatPublicAccount.notify("New article published!");

        // Detach one user
        wechatPublicAccount.detach(user2);

        // Publish another message
        wechatPublicAccount.notify("New video uploaded!");
    }
}

