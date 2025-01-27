## **Annotations Used by Controller**
- `@RestController`: Combines `@Controller` and `@ResponseBody`, simplifying the creation of RESTful web services by automatically converting return values into JSON or XML.
- `@RequestMapping("/users")`: Maps HTTP requests to specific URL paths for classes or methods. In this case, it maps to `/users`.
- `@GetMapping`: Maps HTTP GET requests to specific handler methods for fetching resources.
- `@PostMapping`: Maps HTTP POST requests to specific handler methods for creating resources.
- `@DeleteMapping`: Maps HTTP DELETE requests to specific handler methods for deleting resources.
- `@PutMapping`: Maps HTTP PUT requests to specific handler methods for updating resources.

## **Annotations Used by Entity**
- `@Entity`: Indicates that a class is a JPA entity and is mapped to a database table.
- `@Id`: Specifies the primary key of the entity.
- `@GeneratedValue(strategy=...)`: Defines the strategy for generating primary key values, such as `GenerationType.IDENTITY`, `GenerationType.SEQUENCE`, or `GenerationType.AUTO`.

## **Annotations Used by Configurations**
- `@Value`: Injects property values from application properties or YAML files into fields.
- `@ConfigurationProperties`: Binds external configuration properties from application properties or YAML files to a Java class.
