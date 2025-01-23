1. List all the annotations you learned from this class session.
>@Qualifier @Primary
2. Explain circular dependencies scenario in dependency injection with your code, how do we resolve it?
> A has B and B has A. Use constructor injection instead of method injection, so the exception can be caught.
3. Explain tight coupling vs loose coupling and what does Spring IOC do?
>The degree of dependence between components. One change in a component is less likely to affect another(loose coupling).
>Instead of objects creating their dependencies, spring injects dependencies into objects, typically done through constructor injection, field injection, setter injection.
>Spring manages the beans lifecycle, including creation, initialization and destruction.
4. What is MVC pattern?
>Model-data
>View-presentation
>Controller-interpret the model and deliver the view, take user input and update view/model
5. What is Front-Controller?
>design pattern, centralized place to handle http requests
>In Spring MVC and Spring Boot, the front-controller is the DispatcherServlet. It receives all HTTP requests and delegates them to appropriate controllers for processing.
6. Explain DispatcherServlet and how it works, demonstrate the existence of dispatcherServlet in your
   IDE (JetBrains IntelliJIdea)
>Dispatcher Servlet acts as a front controller.
> Receive requests, delegate to HandlerMapping, invoke controller, process business logic, return a ModelAndView, delegate to ViewResolver

7. What is JSP and What is Model And View？
>JavaServer Pages, server-side tech allowing embedded java inside html to generate dynamic web pages.
>ModelAndView contains data that needs to be displayed.
8. Explain servlet and servlet container , name some servlet implementations and servlet containers
   other than tomcat
>servlet is a java class that processes client requests and generates dynamic responses.
>servlet container aka web container is part of a web server that manages servlet lifecycle, handles http requests and responses, provide security and session management.
>Like a hotel management system, verify users with login credentials and controls access to different parts of a web application. After checking in, the hotel gives you a room key. Even if you leave and return later, 
> you don't need to check in again - key keeps session active. servlet container manages a session via cookies or session ids so server remembers the user across multiple requests.
9. clone this repo, and run it on you local,
1. https://github.com/CTYue/springmvc5-demo
2. Notice that you need to configure the Tomcat by yourself.
3. find out the APIs in controller and call some APIs, In slides, I also list some API.
4. remember to setup mysql database for this project
5. Test APIs (controllers) in postman