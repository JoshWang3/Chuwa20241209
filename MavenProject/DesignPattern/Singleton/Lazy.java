package Chuwa20241209.MavenProject.DesignPattern.Singleton;

public class Lazy {

    private Lazy() {}

    private static Lazy instance;

    public static Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
