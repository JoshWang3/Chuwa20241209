### annotations.md

##### Entity Annotations

###### @Entity

```
Marks a class as a JPA entity, mapping to a table in database.
Used at the class level.

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    
    // Getters and Setters
}
```


###### @Id

```
Specifies the primary key of the entity.
used at the field level.

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    
    // Getters and Setters
}

```

###### @GeneratedValue

```
Specifies how the primary key should be generated. Used on the primary key field

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    // Getters and Setters
}
```

###### @Column

```
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 100, nullable = false)
    private String name;   

}

```

###### @Table

```
Specifies the table name in the database

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;

}

```
##### Controller Annotations

###### @RestController

```
Marks the class as a RESTful web service controller.
It is combination of @Controller and @ResponseBody
Used at the class level.

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {        
        return new Product(id, "Jacket", 99);
    }
}



```

###### @RequestMapping

```
Used to map HTTP requests to handler methods of MVC and REST controllers. 
Used at the class or method level.

import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable Long id) {
        // Logic to fetch product by id
        return new Product(id, "Jean", 78);
    }
}

```

###### @GetMapping, @PostMapping, @PutMapping, @DeleteMapping

```

Defines the mapping of specific HTTP methods (GET, POST, PUT, DELETE).
Used at the method level to map specific HTTP methods.

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {        
        return new Product(id, "Keyboard", 129);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {        
        return product;
    }
}

```

###### @PathVariable

```

Extracts values from the URI path. 
Used to bind method parameters to path variables in the URL.

@GetMapping("/products/{id}")
public Product getProduct(@PathVariable Long id) {    
    return new Product(id, "Mouse", 29);
}

```

###### @RequestBody

```

Binds the body of the HTTP request to a method parameter in the controller.
Used when the client sends data in the body

@PostMapping("/products")
public Product createProduct(@RequestBody Product product) {    
    return product;
}

```

#####  Service and Repository Annotations

###### @Service

```

Marks a class as a service provider.
Used at the class level to define service beans.

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    // Business logic methods
}
```

###### @Repository

```

Marks a class as a data repository. It is a special type of @Component.
Used at the class level to mark a repository class.

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

}

```

###### @Autowired

```

Automatically injects dependencies into Spring beans. 
Used to automatically inject dependencies into fields or constructors.

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

}


```


###### @Transactional

```

Used to define that a method or class should run within a transaction.

@Service
public class ProductService {

    @Transactional
    public void updateProductPrice(Long id, double newPrice) {
        
    }
}

```




##### Configuration Annotations

###### @SpringBootApplication

```
It marks the main class of a Spring Boot application.
It is a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```

###### @Configuration

```

Marks that this class contains bean definitions.
Used to configure beans in a Spring application.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductService productService() {
        return new ProductService();
    }
}
```

#####  Validation Annotations

###### @NotNull

```
Used on fields, parameters, or method return values to enforce that the value cannot be null.

import javax.validation.constraints.NotNull;

public class Product {
    @NotNull
    private String name;
 
}

```

###### @Size

```
Used to restrict the length of a string or size of a list.

import javax.validation.constraints.Size;

public class Product {
    @Size(min = 5, max = 100)
    private String name;

}

```


###### @Email

```
Used for fields that should contain an email address.

import javax.validation.constraints.Email;

public class User {
    @Email

}

```

###### @Valid

```
Indicates that the validation should be performed recursively on nested objects.

 
import javax.validation.Valid;

@PostMapping
public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) { // Validation before entering the method    
    return ResponseEntity.ok(product);
}

```