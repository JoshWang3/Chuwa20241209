## 1. List all of the annotations you learned from class and homework to annotations.md (your own cheatsheet).
    see Tech\ Questions/spring_annotations.md
## 2. Compare Spring and Springboot? What are the benefits of Springboot?
| Aspect                | Spring                                                                                                                          | Spring Boot                                                                                                                                                  |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Definition            | A comprehensive framework for building Java-based enterprise applications                                                       | An extension of Spring that simplifies the development process by offering pre-configured setups and opinionated defaults                                    |
| Setup & Configuration | Requires manual setup and configuration (XML or Java-based)                                                                     | Auto-configuration reduces the need for extensive manual configuration                                                                                       |
| Ease of Use           | Developers need to manually configure dependencies and application setups                                                       | Simplifies development with built-in starters, embedded servers, and production-ready features                                                               |
| Starter Templates     | No starter templates available; dependencies must be managed manually                                                           | Provides starter templates (e.g., spring-boot-starter-web, spring-boot-starter-data-jpa) for quick integration of libraries and dependencies                 |
| Embedded Server       | Requires external server setup (Tomcat, Jetty, etc.)                                                                            | Provides an embedded server (Tomcat, Jetty, or Undertow), allowing applications to run without deploying to an external server                               |
| Configuration Files   | XML configuration was widely used initially, but Java-based configuration is now available with annotations like @Configuration | Minimal or no configuration is required; defaults are handled automatically, with additional properties configurable in application.properties or YAML files | 
| Microservices Support | Designed for monolithic and complex enterprise apps                                                                             | Tailored for developing microservices, with features like REST support, easy actuator integration, and lightweight setup                                     |
    Benefits of Springboot:
        1. Simplified Development: Spring Boot eliminates the need for complex XML configurations and dependency management. With starter templates, setting up dependencies is quick and hassle-free & Auto-configuration sets up the required beans automatically based on the libraries in the project 
        2. Embedded Servers: Spring Boot applications can run standalone using embedded servers (e.g., Tomcat, Jetty). No need for external deployment to an application server
        3. Production-Ready Features: The Spring Boot Actuator provides built-in endpoints for health checks, metrics, and application monitoring, making it easier to deploy and manage applications in production
        4. Microservices-Friendly: Spring Boot is ideal for building lightweight, standalone microservices that can be easily deployed and scaled
        5. Faster Development: With less boilerplate code, opinionated defaults, and ready-to-use components, developers can focus on the business logic instead of spending time on configuration
        6. Externalized Configuration: Supports external configuration through application.properties or application.yml, making it easier to manage environment-specific settings
        7. Easy Testing: Spring Boot simplifies testing with features like embedded servers and test-specific configurations
        8. Compatibility with Spring: Fully compatible with Spring Framework, allowing developers to leverage the entire Spring ecosystem when needed
## 3. What is IOC and What is DI?
    1. IOC:
        Definition: Inversion of Control (IoC) is a design principle where the control of objects and their dependencies is delegated to a framework or container, instead of being managed manually by the application code.
        -- The main idea is that objects do not control their own lifecycle or dependencies
        Key Features:
            1. Decoupling: IoC promotes loose coupling by ensuring that objects do not create or manage their dependencies.
            2. Framework Responsibility: The framework (like Spring) is responsible for instantiating, managing, and injecting dependencies into objects.
            3. IoC Container: In Spring, the IoC Container is the module responsible for managing beans and their dependencies.
    2. DI:
        Definition: Dependency Injection (DI) is a specific implementation of IoC where an object’s dependencies are provided (or "injected") by a container instead of being instantiated by the object itself.
            - "Dependency" refers to the required components or objects an object needs to function.
            - "Injection" refers to the process of supplying these dependencies.
## 4. What is @ComponentScan?
    @ComponentScan is an annotation in Spring used to specify the packages that should be scanned for Spring-managed components (beans) and register them as beans.
    Purpose of @ComponentScan
        - Automatically detects and registers beans in the Spring container.
        - Simplifies the configuration by eliminating the need to explicitly declare beans in a @Configuration class or XML file.
    When Spring initializes, it scans the specified package(s) for classes annotated with:
        - @Component (generic Spring-managed bean).
        - @Service (service layer bean).
        - @Repository (data access layer bean).
        - @Controller or @RestController (web layer bean for handling HTTP requests).
## 5. What is @SpringbootApplication?
    The @SpringBootApplication annotation is a convenience annotation in Spring Boot that is used to bootstrap and configure a Spring Boot application. 
    It combines several commonly used annotations into a single one to simplify the setup process.
    Key Features of @SpringBootApplication:
        It is a meta-annotation that combines the following three annotations:
            1. @Configuration: 
                - Marks the class as a source of bean definitions.
                - Equivalent to defining beans in an XML file.
                - Allows you to define application-specific configuration and beans.
            2. @EnableAutoConfiguration:
                - Enables Spring Boot’s auto-configuration feature.
                - Automatically configures the application based on the dependencies present in the classpath.
            3. @ComponentScan:
                - Automatically scans the package where the main application class is located and its sub-packages for Spring components (e.g., @Component, @Service, @Repository, and @Controller).
                - This ensures all Spring-managed beans in your application are registered.
## 6. How many ways to define a bean? Provide code examples.
```java
/**
 * @Component and its Variants (@Service, @Repository, and @Controller
 * Configuration: You need to use @ComponentScan (or rely on @SpringBootApplication, which includes it by default) to enable scanning for these components.
 */
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}

@Component
public class MyBean {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

public interface MyService {
    public void doSomething();    
}

@Service
public class MyServiceImpl implements MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

@Repository
public interface MyRepo extends JpaRepository<Department, Long> {
}

@RestController
@RequestMapping("/test")
public class MyController {
    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("Hello Spring");
        return "Hello Spring";
    }
}

/**
 * @Bean
 * You can explicitly define beans using the @Bean annotation within a Java configuration class.
 */
@Configuration
public class AppConfig {

    // This approach provides greater control over the bean creation process.
    @Bean
    public MyBean myBean() { // The method name (myBean) serves as the bean ID.
        return new MyBean(); // The return type is the type of the bean.
    }

    @Bean
    public DependentBean dependentBean(MyBean myBean) {
        return new DependentBean(myBean); // Injecting MyBean into DependentBean
    }
}

/**
 * Using XML Configuration
 * This is the traditional way of defining beans in Spring, using an XML file. While less common now, it is still supported.
 * beans.xml example:
 *  <beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://www.springframework.org/schema/beans
 http://www.springframework.org/schema/beans/spring-beans.xsd">
 <bean id="myBean" class="com.example.MyBean"/>
 </beans>
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyBean myBean = context.getBean(MyBean.class);
        myBean.doSomething();
    }
}
```
## 7. What is default bean name for @Component and @Bean? Also compare @Component and @Bean.
    1. @Component: The default bean name is the class name with the first letter in lowercase.
```java
// Default bean name: myService
@Component
public class MyService {
}
```
    2. @Bean: The default bean name is the name of the method that defines the bean.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() { // Default bean name: myService
        return new MyService();
    }
}
```
| Aspect                     | @Component                                                                                       | @Bean                                                                                      |
|----------------------------|--------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| Definition                 | Used to define a bean at the class level                                                         | Used to define a bean at the method level                                                  |
| Scope                      | Scans and registers the bean automatically when annotated classes are in the component-scan path | Requires explicit bean definition in a configuration class                                 |
| Control Over Bean Creation | Limited control over instantiation (e.g., no ability to configure arguments)                     | Full control over how the bean is created and initialized                                  |
| Default Bean Name          | Lowercased class name (e.g., myService for MyService)                                            | Method name (e.g., myService for the method myService())                                   |
| Customization              | Requires the use of additional annotations like @Qualifier for customization                     | Provides full flexibility by allowing custom initialization logic in the method            |
| Usage                      | Suitable for simple or generic Spring components                                                 | Suitable for complex bean creation logic or external library beans that cannot be modified |
| Dependencies Injection     | Managed automatically via constructor or field injection                                         | Dependencies can be explicitly passed as method arguments in the @Bean method              |
## 8. Compare @component and @service, @repository, @controller?
| Aspect                 | @Component                                                                                                     | @Service                                                                                  | @Repository                                                                                             | @Controller                                                                                |
|------------------------|----------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| Purpose                | A generic stereotype for any Spring-managed component                                                          | Specifically for the service layer (business logic)                                       | Specifically for the data access layer (DAOs)                                                           | Specifically for the web layer (controllers)                                               |
| Semantic Meaning       | Generic annotation, can be used anywhere in the application                                                    | Indicates a class is performing business logic or acting as a service                     | Indicates a class is responsible for data persistence (e.g., interacting with the database).            | Indicates a class is handling HTTP requests as part of the web layer.                      |
| Use Case	              | Any type of Spring-managed bean that doesn't fall into specific layers like service, repository, or controller | Used for implementing business logic or interacting between controllers and repositories. | Used for managing database-related operations (e.g., CRUD operations).                                  | Used to handle HTTP requests and responses in a Spring MVC application.                    |
| Additional Features    | None (general-purpose)                                                                                         | None (semantic only).                                                                     | Adds exception translation (@Repository applies Spring's PersistenceExceptionTranslationPostProcessor). | Works with Spring MVC to map HTTP requests to handler methods (e.g., @GetMapping).         |
## 9. Explain @Autowired, @Qualifier, @Resource and @Primary?
    1. @Autowired
        Purpose: Automatically injects a bean by type.
        It works by searching the Spring container for a bean of the required type and injecting it into the dependent class.
    2. @Qualifier
        Purpose: Resolves ambiguity when there are multiple beans of the same type by specifying which bean to inject.
        Used alongside @Autowired to define which specific bean should be injected.
    3. @Resource
        Purpose: Injects a bean by name (default) or type.
        It's part of the Java EE specification (javax.annotation.Resource) and works slightly differently than Spring's @Autowired.
        Comparison with @Autowired:
            @Resource primarily resolves dependencies by name, whereas @Autowired resolves by type.
    4. @Primary:
        Purpose: Marks a bean as the primary candidate when multiple beans of the same type exist. Spring will prefer the @Primary bean unless explicitly overridden by @Qualifier.
## 10. How many annotations we can use to inject a bean?
    1. @Autowired
        Injects a bean by type.
        Can be used on constructors, fields, setter methods, or even on multi-argument constructors.
    2. @Resource
        Injects a bean by name.
    3. @Value
        Injects primitive values, properties, or expressions (e.g., values from application.properties or application.yml).
    4. @Inject (Java EE standard / JSR 330)
        Comes from Java Dependency Injection (JSR 330) and is vendor-neutral.
        Works similarly to @Autowired, injecting beans by type.
    5. @Lookup (Spring-specific)
        Injects a prototype-scoped bean into a singleton-scoped bean by deferring the lookup to the Spring container at runtime.
    6. Injected by setter method
    7. Injected by constructor 
## 11. Explain and compare different types of dependency injection, their pros and cons, and use cases.
    1. Constructor Injection
        Advantages
            Immutability: Dependencies are set during object creation and cannot be changed later, making the object immutable.
            Mandatory dependencies: Guarantees that all required dependencies are provided.
            Easier to test: Dependencies can be explicitly passed in tests, promoting better testability.
            Compatible with Dependency Injection frameworks like Spring and Guice.
        Disadvantages
            Boilerplate code: Classes with many dependencies may have constructors with long parameter lists, reducing readability.
            Difficult to maintain: Refactoring or adding dependencies may lead to changing constructor signatures in multiple places.
        Use Cases
            Prefer when all dependencies are mandatory.
            Suitable for immutable objects or service classes where dependencies should not be changed after initialization.
    2. Setter Injection
        Advantages
            Optional dependencies: Allows injecting optional dependencies since setters can be called conditionally.
            Easier to manage: Dependencies can be added or removed without modifying constructor signatures.
            Flexible configuration: Dependencies can be set or modified after object creation.
        Disadvantages
            Lack of immutability: Dependencies can be modified after object creation, making the object mutable.
            Incomplete object state: The object may remain in an incomplete or invalid state if the setter is not called.
            More prone to NullPointerExceptions if dependencies are not properly set.
        Use Cases
            When dependencies are optional or may be set conditionally.
            Use when you need to modify dependencies dynamically after object creation.
    3.  Field Injection
        Advantages
            Simpler syntax: Requires the least amount of boilerplate code.
            Easier and faster to implement, especially for small classes with fewer dependencies.
            No need for constructors or setters, making code concise.
        Disadvantages
            Testing difficulties: Dependencies are private and cannot be directly set in unit tests. Requires reflection or frameworks like Mockito.
            No immutability: Fields can be modified at runtime, leading to potential bugs.
            Violates the principle of Encapsulation: Dependencies are injected directly into private fields.
            Makes dependencies less visible: Hard to identify what dependencies a class requires at a glance.
        Use Cases
            Use in small or simple applications where testability and immutability are less critical.
            Avoid in complex, highly testable, or large-scale applications.
## 12. If we have multiple beans for one type, how to set one is primary? and how Spring IOC picks one bean to inject if no primary, demo with code examples.
```java
/**
 * @Primary
 * The @Primary annotation is used to mark one of the beans as the primary bean when there are multiple candidates of the same type. When Spring encounters multiple beans of the same type, it will choose the one marked with @Primary by default.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
class Car {
    public void drive() {
        System.out.println("Driving a generic car...");
    }
}

@Component
@Primary // This marks Sedan as the primary bean when there are multiple beans of type Car
class Sedan extends Car {
    @Override
    public void drive() {
        System.out.println("Driving a Sedan...");
    }
}

@Component
class SUV extends Car {
    @Override
    public void drive() {
        System.out.println("Driving an SUV...");
    }
}

@Component
class Driver {
    private Car car;

    // Spring will inject the primary bean, which is Sedan in this case
    @Autowired
    public Driver(Car car) {
        this.car = car;
    }

    public void start() {
        car.drive();
    }
}

@Configuration
@ComponentScan(basePackages = "com.example")
class Config {
    // The configuration class doesn't require explicit bean definitions
}

/**
 * @Qualifier
 * When you have multiple beans of the same type and you want to specify which one to inject, you can use the @Qualifier annotation to resolve the ambiguity.
 */
@Component
class Car {
    public void drive() {
        System.out.println("Driving a generic car...");
    }
}

@Component
@Qualifier("sedan") // This marks Sedan with a specific identifier
class Sedan extends Car {
    @Override
    public void drive() {
        System.out.println("Driving a Sedan...");
    }
}

@Component
@Qualifier("suv") // This marks SUV with a specific identifier
class SUV extends Car {
    @Override
    public void drive() {
        System.out.println("Driving an SUV...");
    }
}

@Component
class Driver {
    private Car car;

    // Use @Qualifier to specify which bean to inject
    @Autowired
    @Qualifier("suv") // We specify the bean to inject by its identifier
    public Driver(Car car) {
        this.car = car;
    }

    public void start() {
        car.drive();
    }
}

@Configuration
@ComponentScan(basePackages = "com.example")
class Config {
    // The configuration class doesn't require explicit bean definitions
}

/**
 * If there is no @Primary annotation and no @Qualifier annotation, Spring will throw an exception due to ambiguity.
 */
```
## 13. Compare BeanFactory and ApplicationContext in Spring framework?
| Feature                 | BeanFactory                                   | ApplicationContext                               |
|-------------------------|-----------------------------------------------|--------------------------------------------------|
| Initialization          | Lazy initialization (beans created on demand) | Eager initialization (beans created at startup)  |
| Event Handling          | 	Not supported                                | Supported (with ApplicationEventPublisher)       |
| Internationalization    | Not supported                                 | 	Supported (via MessageSource)                   |
| AOP Support             | Not supported	                                | Supported (via Spring AOP)                       |
| Bean Post Processors    | Limited support                               | Fully supported                                  |
| ApplicationContextAware | Not available                                 | Available                                        |
| Performance             | Faster startup and lower memory usage         | Slightly slower startup with higher memory usage |
| Use Case                | Lightweight, low-memory applications          | Full-featured enterprise and web applications    |
## 14. Explain bean scope in Spring IOC? List bean scopes with explanation and code examples if possible.
```java
/**
 * Singleton
 * A single instance is created and shared across the container
 * Shared resources, stateless beans
 */
@Component
@Scope("singleton")  // Request scope
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean created!");
    }

    public void showMessage() {
        System.out.println("SingletonBean: Hello, World!");
    }
}

@Component
public class SingletonScopeExample {
    @Autowired
    private SingletonBean singletonBean1;

    @Autowired
    private SingletonBean singletonBean2;

    public void print(){
        System.out.println(singletonBean1 == singletonBean2); // true
    }
}

/**
 * Prototype
 * A new instance is created each time a bean is requested
 * Beans that maintain state, user-specific data
 */
@Component
@Scope("prototype")  // Request scope
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("PrototypeBean created!");
    }

    public void showMessage() {
        System.out.println("PrototypeBean: Hello, World!");
    }
}

public class PrototypeScopeExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean bean1 = context.getBean(PrototypeBean.class);
        PrototypeBean bean2 = context.getBean(PrototypeBean.class);

        // Checking if both beans are different instances
        System.out.println(bean1 == bean2);  // Output: false
    }
}

/**
 * Request
 * A new instance is created for each HTTP request 
 * Request-specific data in web applications (Spring MVC)
 */
@Component
@Scope("request")  // Request scope
public class RequestBean {
    public RequestBean() {
        System.out.println("RequestBean created!");
    }

    public void showMessage() {
        System.out.println("RequestBean: Hello from the request!");
    }
}

/**
 * Session
 * A new instance is created for each HTTP session
 * Session-specific data in web applications
 */
@Component
@Scope("session")  // Session scope
public class SessionBean {
    public SessionBean() {
        System.out.println("SessionBean created!");
    }

    public void showMessage() {
        System.out.println("SessionBean: Hello from the session!");
    }
}

/**
 * Global Session
 * A new instance is created for each global session in portlet applications
 * Portlet-specific use cases
 */
@Component
@Scope("globalSession")  // Global session scope
public class GlobalSessionBean {
    public GlobalSessionBean() {
        System.out.println("GlobalSessionBean created!");
    }

    public void showMessage() {
        System.out.println("GlobalSessionBean: Hello from the global session!");
    }
}

/**
 * Application Scope
 * A single instance is created and shared across the entire application	
 * Application-wide services in web applications
 */
@Component
@Scope("application")  // Application scope
public class ApplicationBean {
    public ApplicationBean() {
        System.out.println("ApplicationBean created!");
    }

    public void showMessage() {
        System.out.println("ApplicationBean: Hello from the application!");
    }
}
```
## 15. Write a Spring application that registers and autowires beans,
    - Demo different types of dependency injection: Coding/hw11/springIOCdemo/src/main/java/com/chuwa/ioc/main/injectionType/DITypeTest.java
    - Demo bean scopes: Coding/hw11/springIOCdemo/src/main/java/com/chuwa/ioc/main/jbeanScope/BeanScopeTest.java
    - Demo dependency injection by type and by name, when there's ambiguity in bean definition: Coding/hw11/springIOCdemo/src/main/java/com/chuwa/ioc/main/getBean/GetBeanByTypeAndNameTest.java
    - Demo bean registration by both @Component and @Bean: Coding/hw11/springIOCdemo/src/main/java/com/chuwa/ioc/main/beanRegistration/BeanRegistrationTest.java
## 16. Explain builder pattern with code examples.
    The Builder Pattern is a creational design pattern used to construct complex objects step by step. It allows you to create an object by specifying its type and content, but you can do so without having to deal with the complex initialization of its fields. This pattern is particularly useful when an object has many optional parameters, and the construction process can be simplified by breaking it down into a series of steps.
    Key Components of the Builder Pattern:
        - Builder: Specifies the abstract methods for creating parts of the complex object.
        - Concrete Builder: Implements the builder interface to assemble the parts of the object.
        - Product: The complex object that is being constructed.
        - Director: (Optional) Constructs the object using the builder. The director knows the order in which the parts must be built.
    Advantages:
        - Separation of concerns: The construction logic is separated from the object itself.
        - Flexible object creation: You can create different variations of an object.
        - Readable code: It’s easier to understand the object construction process through method calls.
```java
public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private boolean isBluetoothEnabled;
    private boolean isWiFiEnabled;

    // Constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWiFiEnabled = builder.isWiFiEnabled;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU 
            + ", Bluetooth=" + isBluetoothEnabled + ", WiFi=" + isWiFiEnabled + "]";
    }

    // Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private boolean isBluetoothEnabled;
        private boolean isWiFiEnabled;

        // Builder methods for setting properties
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder enableBluetooth(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Builder enableWiFi(boolean isWiFiEnabled) {
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        // Build method to construct the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the builder pattern to construct a Computer object
        Computer computer = new Computer.Builder()
                .setCPU("Intel Core i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3070")
                .enableBluetooth(true)
                .enableWiFi(true)
                .build();

        System.out.println(computer);
    }
}
```
## 17. Clone https://github.com/CTYue/springIOC, go through examples, make code in both main and main-loosecoupling work.
    1. @Primary is duplicated remove one (HibernateChuwa.java or BeanConfig.java)
    2. resource/bean.xml and bean2.xml (remove .service) have the same bean id -> change one