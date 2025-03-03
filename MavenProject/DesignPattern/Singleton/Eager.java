package Chuwa20241209.MavenProject.DesignPattern.Singleton;

public class Eager {
    private Eager(){}

    private static Eager instance = new Eager();

    private static Eager getInstance(){
        return instance;
    }
}
