**<p style="text-align:center;">annotations used by controller</p>**

@RestController
@RequestMapping("/users")
@GetMapping
@PostMapping
@DeleteMapping
@PutMapping


@RequestMapping

**<p style="text-align:center;">annotations used by entity</p>**

@Entity

@Id

@GeneratedValue(strategy=)

**<p style="text-align:center;">annotations used by configurations</p>**
@Value

@ConfigurationProperties


@LoadBalanced
Allow client to call services dynamically using names instead of IPs.
@EnableEurekaServer
Enable Eureka Server in Spring Boot in the main class.
@EnableDiscoveryClient / @EnableEurekaServer
Enable discovery.Pick the implementation on the path.(Eureka,consul,zookeeper)

 @PreAuthorize, @PostAuthorize
 method-level security 

@Aspect
@Before("execution(* com.example.service.*.*(..))")
@AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
Scenario: You want to log method executions, parameters, and return values in your application, but you don't want to scatter logging code across your business logic.

@Transactional
Scenario: In applications with database interactions, you need to manage transactions consistently (e.g., begin, commit, or rollback).

@Pointcut("execution(* com.example.service.*.*(..))")
public void serviceMethods() {}
@Pointcut("execution(* com.example.service.UserService.getUser(..))")
@Pointcut("bean(userService)")
@Pointcut("execution(* com.example.service.*.*(..)) && within(com.example.service..*)")

Advice
@Around is the most powerful advice type, as it can control whether the method executes and modify the return value.

@Before and @After are used for simple pre- and post-processing.

@AfterReturning and @AfterThrowing are used for handling successful and exceptional outcomes, respectively.

**<p style="text-align:center;">test</p>**
@Test
@Mock @InjectMocks
@BeforeEach
@Spy
**<p style="text-align:center;">microservice</p>**

```java
// use hystrix,🔥 Issue: Hystrix is deprecated and no longer actively maintained.

@HystrixCommand(fallbackMethod = "fallbackResponse")
public String getUserData() {
    return restTemplate.getForObject("http://user-service/api/users", String.class);
}

public String fallbackResponse() {
    return "User service is currently unavailable. Please try again later.";
}
// use resilience4J
@CircuitBreaker(name = "userService", fallbackMethod = "fallbackResponse")
public String getUserData() {
 return restTemplate.getForObject("http://user-service/api/users", String.class);
}

public String fallbackResponse(Exception e) {
 return "User service is currently unavailable. Please try again later.";
}

```
>@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
  public static void main(String[] args) {
     SpringApplication.run(EurekaServerApplication.class, args);
  }
}

>@SpringBootApplication
@EnableEurekaClient
public class MyServiceApplication {
public static void main(String[] args) {
SpringApplication.run(MyServiceApplication.class, args);
}
}

>@SpringBootApplication
@EnableGateway
public class ApiGatewayApplication {
public static void main(String[] args) {
SpringApplication.run(ApiGatewayApplication.class, args);
}
}

>@EnableOAuth2Sso
