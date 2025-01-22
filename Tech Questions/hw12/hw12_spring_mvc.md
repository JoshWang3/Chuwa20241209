## 1. List all of the annotations you learned from this class session.
    @GetMapping - R
    @PutMapping - U
    @PostMapping - C
    @DeleteMapping - D
    @RequestMapping(method=RequestMethod.GET)
    @Controller
    @ResponseBody
## 2. Explain circular dependencies scenario in dependency injection with your code, how do we resolve it?
```java
/**
 * When Spring tries to initialize ServiceA, it needs ServiceB. 
 * However, to initialize ServiceB, it needs ServiceA, leading to a circular dependency error.
 */
@Component
public class ServiceA {
    private final ServiceB serviceB;

    @Autowired
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}

@Component
public class ServiceB {
    private final ServiceA serviceA;

    @Autowired
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
```
    Solution:
```java
/**
 * Use @Lazy Annotation
 * The @Lazy annotation delays the initialization of one of the dependencies until it is needed, breaking the circular dependency.
 */
@Component
public class ServiceA {
    private final ServiceB serviceB;

    @Autowired
    public ServiceA(@Lazy ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}

@Component
public class ServiceB {
    private final ServiceA serviceA;

    @Autowired
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}

/**
 * Use Setter Injection
 * Instead of constructor injection, you can use setter injection to break the circular dependency.
 */
@Component
public class ServiceA {
    private ServiceB serviceB;

    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}

@Component
public class ServiceB {
    private ServiceA serviceA;

    @Autowired
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}

/**
 * Use an Interface or Abstract Class
 * Refactor the dependencies to depend on an interface or an abstract class to decouple them.
 */
public interface CommonService {
    void doSomething();
}

@Component
public class ServiceA implements CommonService {
    @Override
    public void doSomething() {
        System.out.println("ServiceA doing something");
    }
}

@Component
public class ServiceB {
    private final CommonService service;

    @Autowired
    public ServiceB(CommonService service) {
        this.service = service;
    }
}
```
## 3. Explain tight coupling vs loose coupling and what does Spring IOC do?
    1. Tight Coupling
        Tight coupling occurs when classes or components are heavily dependent on each other. 
        Changes in one component often require changes in the other, making the system harder to maintain, extend, and test.
    2. Loose Coupling
        Loose coupling reduces dependencies between components. 
        Components interact through abstractions (e.g., interfaces) or rely on external mechanisms (e.g., Dependency Injection) to provide dependencies. 
        This improves flexibility, testability, and maintainability.
    What Does Spring IoC Do?
        Spring's Inversion of Control (IoC) container manages dependencies and promotes loose coupling by using Dependency Injection (DI). 
        Instead of classes controlling their dependencies, the IoC container takes responsibility for creating and injecting them.
        Key Features of Spring IoC:
            Dependency Injection:
                Spring resolves and injects dependencies into components at runtime.
                It supports different types of DI:
                    Constructor Injection
                    Setter Injection
                    Field Injection (via @Autowired)
            Centralized Dependency Management:
                All dependencies are configured centrally (e.g., through annotations, XML, or Java configuration).
            Decoupling Components:
                By using interfaces and dependency injection, components can work with abstractions rather than concrete implementations, reducing tight coupling.
            Bean Lifecycle Management:
                The IoC container manages the lifecycle of beans, including their instantiation, initialization, and destruction.
## 4. What is MVC pattern?
    Spring Web MVC is the original web framework built on the Servlet API and has been included inthe Spring Framework from the very beginning.
    Components of MVC Pattern
        Model
            - Represents the application's data and business logic.
            - Directly manages the data, logic, and rules of the application.
            - Notifies the View when there is a change in the data.
            Responsibilities:
                - Encapsulates data.
                - Handles business rules.
                - Notifies changes via observers or events.
        View
            - The presentation layer responsible for displaying data to the user.
            - It listens to updates from the Model and renders data accordingly.
            - It does not contain business logic.
            Responsibilities:
                - Presents data from the Model.
                - Sends user input to the Controller.
        Controller
            - Acts as the intermediary between the Model and the View.
            - Handles user input, updates the Model, and changes the View accordingly.
            - Ensures proper coordination between the components.
            Responsibilities:
                - Processes user input.
                - Updates the Model and View.
## 5. What is Front-Controller?
    The Front Controller is a design pattern used in web applications to centralize and standardize the processing of incoming requests. 
    Instead of having multiple controllers handle requests independently, a single front controller acts as the entry point for all client requests and delegates the processing to the appropriate handler or controller.
    Components of the Front Controller Pattern    
    -Front Controller:
        The main entry point for all requests. It handles initial processing, such as parsing requests and applying global logic (e.g., authentication, logging).
    -Dispatcher:
        Responsible for routing the request to the appropriate handler or controller. Often, this is implemented as part of the front controller.
    -View:
        The presentation layer that renders the output for the client. The controller typically selects which view to render.
    -Helpers/Services:
        Additional components like services, utilities, or middleware that assist in processing the request.
```java
/**
 * A single servlet acts as the front controller.
 */
@WebServlet("/controller")
public class FrontController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Dispatch request based on action
        if ("login".equals(action)) {
            new LoginController().handle(request, response);
        } else if ("register".equals(action)) {
            new RegisterController().handle(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

/**
 * SpringMVC:
 * Config file:
 * <servlet>
 <servlet-name>dispatcher</servlet-name>
 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 </servlet>
 <servlet-mapping>
 <servlet-name>dispatcher</servlet-name>
 <url-pattern>/</url-pattern>
 </servlet-mapping>
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam String username) {
        // Process registration
        return "success";
    }
}
```
## 6. Explain DispatcherServlet and how it works, demonstrate the existence of dispatcherServlet in your IDE (Jetbrain IntelliJIdea)
    DispatcherServlet is the Front Controller that handles all incoming HTTP requests and dispatches them to the appropriate components (e.g., controllers, views, and other handlers). 
    It acts as a central entry point for the application and plays a crucial role in request processing
    Steps in DispatcherServlet Workflow
    - Receives the Request:
        The DispatcherServlet intercepts the HTTP request.
    - Handler Mapping:
        It uses HandlerMapping to determine which controller method should handle the request based on the URL and HTTP method.
    - Handler Adapter:
        Once the handler (e.g., a controller) is identified, DispatcherServlet uses a HandlerAdapter to invoke the appropriate method in the controller.
    - Controller Execution:
        The controller processes the request and returns a ModelAndView object (or similar response) that contains the model data and the name of the view.
    - View Resolver:
        DispatcherServlet uses a ViewResolver to resolve the logical view name to an actual view (e.g., an HTML page, JSP, or JSON response).
    - Render View:
        The view is rendered using the data from the model, and the response is sent back to the client.
    Request Lifecycle:
        1. HTTP Request → DispatcherServlet
        2. DispatcherServlet → HandlerMapping → Identifies the appropriate controller.
        3. DispatcherServlet → HandlerAdapter → Invokes the controller method.
        4. Controller processes the request and returns a ModelAndView.
        5. ViewResolver resolves the logical view name to a view.
        6. View renders the response using the model data.
        7. HTTP Response → Sent back to the client.
    See Tech\ Question/hw12/hw12-6.png
## 7. What is JSP and What is Model And View？
    JSP (Java Server Pages) is a technology used to create dynamic web pages in Java-based web applications. It is a server-side technology that enables the creation of HTML, XML, or other types of documents with dynamic content using embedded Java code.
    Model and View are key components of the Model-View-Controller (MVC) design pattern used in web applications. 
    These terms define specific roles in the separation of concerns principle.
    Model -- data
    View -- JSP
## 8. Explain servlet and servlet container, name some servlet implementations and servlet containers other than tomcat
    Servlet    
        A Servlet is a Java class that handles HTTP requests and generates responses in a web-based application. It runs on a Servlet container (also known as a web container) and provides the server-side functionality for web applications. 
        Servlets are a key component of Java EE (Enterprise Edition) web applications.
        Servlet Lifecycle
            Loading:
                The servlet class is loaded into memory when the container starts up or when the servlet is first requested.
            Initialization:
                The init() method is called to initialize the servlet.
            Request Handling:
                The service() method is called to process each HTTP request.
            Destroying:
                When the servlet is destroyed (e.g., during server shutdown), the destroy() method is called.
    Servlet Container
        A Servlet Container (or Web Container) is a part of a web server or application server that provides the environment to execute Java servlets and manage the lifecycle of servlets. 
        It is responsible for managing HTTP requests, invoking servlets, managing session data, and sending responses to the client.
       Responsibilities of a Servlet Container
        Servlet Lifecycle Management:
            Loading, initialization, execution, and destruction of servlets.
        Request/Response Handling:
            Intercepting incoming HTTP requests, forwarding them to the appropriate servlet, and returning responses.
        Session Management:
            Managing user sessions through cookies or URL rewriting.
        Servlet Mapping:
            Mapping URL patterns to specific servlet classes via configuration (web.xml) or annotations.
        Security:
            Handling security settings like authentication and authorization. 
    Servlet Implementations:
        Apache Tomcat
        Jetty
        GlassFish
        JBoss/WildFly
        WebLogic
        WebSphere
## 9. clone this repo, and run it on you local,
    see Coding/hw12/
    See Tech\ Question/hw12/hw12-9.png or hw12-9-2.png
    1. https://github.com/CTYue/springmvc5-demo
    2. Notice that you need to configure the Tomcat by yourself.
    3. find out the APIs in controlelr and call some APIs, In slides, I also list some API.
    4. remeber to setup mysql database for this project
    5. Test APIs (controllers) in postman