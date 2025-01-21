1. List all of the annotations you learned from class and homework to annotaitons.md (your own
   cheatsheet).
2. Compare Spring and Springboot? What are the benefits of springboot?
> Spring is like a kitchen with all cooking tools for you to make meals.
> But sb is like meal kits, giving you pre-configured ingredients so you can cook quickly, making life easier
> S needs XML or java based config while sb is autoconfigured.
> S needs an external server while sb has an embedded Tomcat server.
> S needs to add dependency manually while sb use spring-boot-starter dependencies.

3. What is IOC and What is DI?
> Inversion of control -> spring boot handles the object creation
> Dependency injection -> dependencies provided automatically
4. What is @ComponentScan ?
>It's like a metal detector to scan a package for specific items(beans). The package indicates where to look for beans.
5. What is @SpringbootApplication ?
> It’s like a Swiss Army knife—it combines three annotations:
>@Configuration → Declares configuration.
>@EnableAutoConfiguration → Enables automatic config.
>@ComponentScan → Scans for beans.It's the entry point of an application.

6. How many ways to define a bean? Provide code examples.
>@Component, class level, mark it as a spring-managed component. Spring's component scanning mechanism automatically detects classes annotated with @Component, @Service, @Repository, and @Controller (which are specializations of @Component) and creates beans for them.
>@Bean, method level, in a class with @Configuration
> XML way
7. What is default bean name for @Component and @Bean ? Also compare @Component and @Bean .
>@Component, class name with the first letter lowercase
>@Bean method name
>@Component is autodetected and used when you control the class while @Bean can be used when you cannot control the class.

@Configuration
public class AppConfig {
@Bean
public MyService customBean() { // Bean name is "customBean"
return new MyService();
}
}

8. Compare @component and @service , @repository , @controller ?
>@Component, mark a class as a spring-managed component, indicate the class is a bean that should be instantiated and managed by spring container
> Used for any class that don't fit into @service , @repository , @controller
> 
> @Component
public class MyUtilityClass {
// ... utility methods ...
}
> 
> @Service:Purpose: Marks a class as a service component. It represents the business logic layer of your application.
> @Service
public class UserServiceImpl implements UserService {
// ... business logic methods ...
}
> 
> @Repository:
Purpose: Marks a class as a data access object (DAO) or repository. It encapsulates the logic for accessing data from a data source (e.g., database, file system, web service).
> @Repository
public interface UserRepository extends JpaRepository<User, Long> {
// ... database access methods ...
}
> 
> @Controller: Marks a class as a controller component, handling http reqs and res.
Purpose: Marks a class as a controller in a Spring MVC application. It handles incoming web requests and returns responses.


9. Explain @Autowired , @Qualifier , @Resource and @Primary ?
> @Autowired, automatically pick an ingredient, type-based injection, used together with @Qualifier to resolve ambiguity
> @Primary, if there are more than one ingredient, pick this one by default
> @Qualifier, give me this ingredient, I tell the chef(spring boot). When multiple beans exist, you want to choose one.
> @Resource, similar to @Autowired, but follows JAVA EE standards, name-based injection
10. How many annotaitons we can use to inject a bean?
   > @Autowired
    @Qualifier
    @Primary
    @Resource
    @Inject (JSR-330, similar to @Autowired)
11. Explain and compare different types of dependency injection, their pros and cons, and use cases.
> constructor injection -> get coffee with milk already mixed in( mandatory injection ), immutability. good for testing, boilerplate code
> field injection -> get instant coffee mix, convenient but hard to test
> setter injection -> get black coffee, optionally add milk later, objects can be misconfigured

12. If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to
    inject if no primary, demo with code examples.
>@Primary annotation added to the class which will be used as the default bean.
> 
>@Qualifier to specify name after @Autowired in constructor injectoin
> 
> @Resource to inject by name
> 
> code below
13. Compare BeanFactory and ApplicationContext in Spring framework?
> BeanFactory is like a grocery store, which loads beans lazily on demand, lightweight while ApplicationContext is like a supermarket, full featured, which loads beans eagerly on startup.
14. Explain bean scope in Spring IOC? List bean scopes with explanations and code examples if possible.
>singleton (Default Scope):Behavior: Only one instance of the bean is created per Spring IoC container. This single instance is shared across all requests for that bean.
```java
@Component
@Scope("Singleton") //default, can be omitted
public class SingletonBean{
    
}
```
> prototype: a new bean is created when requested
```java
@Component
@Scope("Prototype")
public class PrototypeBean{
    
}
```
> request: a new bean is created per HTTP request
```java
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyRequestScopedBean {
    // ...
}

@Component
public class MyService {

    @Autowired
    private MyRequestScopedBean requestScopedBean; // Injects the proxy

    // ...
}
```
> session: a new bean is created per session
> application: a new bean is created per application
> websocket: a new bean is created per websocket



15. Write a Spring application that registers and autowires beans,
- Demo different types of dependency injection
- Demo bean scopes.
- Demo dependency injection by type and by name, when there's ambiguity in bean definition.
- Demo bean registration by both @Component and @Bean
16. Explain builder pattern with code examples.
> Problem:
When you have a class with many optional parameters, creating objects with different combinations of these parameters can become cumbersome. You might end up with multiple constructors, each handling a different combination, leading to constructor explosion.
```java
public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String monitor;

    private Computer(ComputerBuilder builder) { // Private constructor
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.monitor = builder.monitor;
    }

    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getMonitor() { return monitor; }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", monitor='" + monitor + '\'' +
                '}';
    }

    public static class ComputerBuilder { // Builder class
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private String monitor;

        public ComputerBuilder(String cpu, String ram, String storage) { // Required parameters
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public ComputerBuilder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this; // Return the builder for chaining
        }

        public ComputerBuilder monitor(String monitor) {
            this.monitor = monitor;
            return this; // Return the builder for chaining
        }

        public Computer build() {
            return new Computer(this); // Create the Computer object
        }
    }

    public static void main(String[] args) {
        Computer computer1 = new Computer.ComputerBuilder("Intel i7", "16GB", "1TB SSD")
                .graphicsCard("Nvidia RTX 3070")
                .monitor("27 inch 4K")
                .build();

        Computer computer2 = new Computer.ComputerBuilder("AMD Ryzen 5", "8GB", "500GB HDD")
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
```
> Avoid constructor explosion.Improve readability. Step by step construction of complex objects.
> 
>use case:When to Use the Builder Pattern:
When a class has many optional parameters.
When you want to create immutable objects.
When you want to separate the construction of a complex object from its representation.
> 
> Characteristics of Immutable Objects:
> private constructor for Computer in the example above.
All fields are final: This prevents direct reassignment of the fields.
No setter methods: There are no methods that allow modifying the object's state.
Constructor initializes all fields: All necessary data is provided during object creation through the constructor.
If the object holds references to mutable objects, those references should be to immutable copies or defensive copies: This prevents indirect modification of the object's state.
17. Clone https://github.com/CTYue/springIOC, go through examples, make code in both main and
    main-loosecoupling work.
```java
@Component
interface computer{

}
@Component
@Primary
class MacBook implements computer{

}
@Component
class Desktop implements computer{

}



@Component
class Dev{
private Computer computer;
@Autowired
@Qualifier("macBook")
public Dev(Computer computer){
this.computer = computer;
}
        }
//
@Component
interface computer{

}
@Component
@Primary
class MacBook implements computer{

}
@Component
class Desktop implements computer{

}

@Component
class Dev{
private Computer computer;
@Autowired
public Dev(Computer computer){
this.computer = computer;
}
        }
//
@Component
interface computer{

}
@Component
class MacBook implements computer{

}
@Component
class Desktop implements computer{

}

@Component
class Dev{
private Computer computer;
@Resource("macBook")
public Dev(Computer computer){
this.computer = computer;
}
        }
```
setter injection with optional dependency, @Autowired(required = false)
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Optional Dependency Interface
interface EmailService {
    void sendEmail(String message);
}

// Concrete Implementation of the Optional Dependency (Could be absent)
@Component
class SimpleEmailService implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Component that has an optional dependency
@Component
public class MyService {

    private String message = "Default message";
    private EmailService emailService; // Optional dependency

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Autowired(required = false) // Setter injection with optional dependency
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void doSomething() {
        System.out.println("Doing something in MyService: " + getMessage());
        if (emailService != null) { // Check if the dependency was injected
            emailService.sendEmail("Action completed!");
        } else {
            System.out.println("Email service is not available.");
        }
    }
}

// Configuration
@Configuration
@ComponentScan
public class AppConfig {

}

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            MyService myService = context.getBean(MyService.class);
            myService.doSomething();

            // Test without email service. comment the @Component annotation in SimpleEmailService
            AnnotationConfigApplicationContext contextWithoutEmailService = new AnnotationConfigApplicationContext(AppConfig.class);
            MyService myServiceWithoutEmailService = contextWithoutEmailService.getBean(MyService.class);
            myServiceWithoutEmailService.doSomething();
        }
    }
}
```