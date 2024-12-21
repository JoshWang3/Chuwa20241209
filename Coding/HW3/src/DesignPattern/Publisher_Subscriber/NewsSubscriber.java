package DesignPattern.Publisher_Subscriber;

public class NewsSubscriber implements Subscriber{
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}
