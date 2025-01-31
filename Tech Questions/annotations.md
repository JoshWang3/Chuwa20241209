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
