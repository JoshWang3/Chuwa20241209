@Entity: an entity, used to map with database

@Table: used to locate the database table name

@Id: this column is a primary key

@GeneratedValue(strategy = GenerationType.IDENTITY): this column is auto-incremented

@Column(name="column_name", nullable=false): used to map the column name. cannot be null

@RequestMapping: map HTTP requests to handler methods of MVC and REST controllers

@GetMapping: maps HTTP GET requests onto specific handler methods

@PostMapping: maps HTTP POST requests onto specific handler methods

@PutMapping: maps HTTP PUT requests onto specific handler methods

@DeleteMapping: maps HTTP DELETE requests onto specific handler methods

@PathVariable: extracts values from the URI

@RequestBody: binds the HTTP request body to the domain object

@Service: marks the class as a service provider

@Repository: marks the class as a data access object

@Transactional: used to manage transactions

@Autowired: used to auto wire bean on the setter method

