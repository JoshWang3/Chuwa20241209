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
**<p style="text-align:center;">annotations used by other</p>**
@Transactional - manage sessions and transactions
@Autowired
@Valid - check request body/params
