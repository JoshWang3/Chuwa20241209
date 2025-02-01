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