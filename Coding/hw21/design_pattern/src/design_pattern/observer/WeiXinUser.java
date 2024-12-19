package design_pattern.observer;

public class WeiXinUser implements Observer {
    private String userName;

    public WeiXinUser(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println(userName + ", " + message);
    }
}
