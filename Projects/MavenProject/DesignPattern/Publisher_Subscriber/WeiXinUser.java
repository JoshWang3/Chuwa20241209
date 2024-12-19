package Chuwa20241209.MavenProject.DesignPattern.Publisher_Subscriber;

public class WeiXinUser implements Observer {
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
