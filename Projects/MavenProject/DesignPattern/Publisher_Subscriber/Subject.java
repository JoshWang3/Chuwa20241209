package Chuwa20241209.MavenProject.DesignPattern.Publisher_Subscriber;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
