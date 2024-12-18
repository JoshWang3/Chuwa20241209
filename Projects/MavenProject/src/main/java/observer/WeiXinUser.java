package observer;

public class WeiXinUser {
    private String name;
    public WeiXinUser(String name) {
        this.name = name;
    }
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
