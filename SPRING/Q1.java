/* 
Q1. What are the various annotations used in SpringBoot (explain)

Spring Boot, being a part of the larger Spring Framework ecosystem, 
makes heavy use of annotations to reduce boilerplate code and simplify configurations. 
Below are some of the most commonly used annotations in Spring Boot, along with 
explanations of what they do:


Spring Boot, being a part of the larger Spring Framework ecosystem, makes heavy use of annotations to reduce boilerplate code and simplify configurations. Below are some of the most commonly used annotations in Spring Boot, along with explanations of what they do:

1. @SpringBootApplication
This is the core annotation in Spring Boot, which is essentially a convenience annotation 
that combines three other annotations:

@Configuration: Marks the class as a source of bean definitions.
@EnableAutoConfiguration: Enables automatic configuration based on the classpath settings, 
properties, and beans.
@ComponentScan: Enables component scanning, allowing Spring to detect and register beans.


@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}

2. @RestController
This annotation is a combination of @Controller and @ResponseBody. 
It is used to create RESTful web services and automatically serializes the returned 
objects into JSON or XML.

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}


3. @RequestMapping
This annotation is used to map HTTP requests to handler methods in a controller. 
It can be applied at the class or method level, and can handle different HTTP request 
methods (GET, POST, etc.).

@RestController
@RequestMapping("/api")
public class MyController {
    
    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greet() {
        return "Greetings!";
    }
}

Shortcut Annotations:
@GetMapping: Shortcut for @RequestMapping(method = RequestMethod.GET).
@PostMapping: Shortcut for @RequestMapping(method = RequestMethod.POST).
@PutMapping: Shortcut for @RequestMapping(method = RequestMethod.PUT).
@DeleteMapping: Shortcut for @RequestMapping(method = RequestMethod.DELETE).

4. @Autowired
This annotation is used for automatic dependency injection. Spring automatically 
injects the required bean (or service) where @Autowired is placed, either on a constructor, 
setter, or directly on fields.

@Service
public class MyService {
    public String serve() {
        return "Service is working!";
    }
}

@RestController
public class MyController {
    
    @Autowired
    private MyService myService;
    
    @GetMapping("/serve")
    public String serve() {
        return myService.serve();
    }
}


5. @Service, @Component, and @Repository
These are stereotype annotations that mark a class as a Spring bean, meaning the class will
be automatically discovered and registered as a bean in the Spring application context.

@Service: Marks a class as a service, typically for business logic.
@Component: A generic annotation that can be used for any Spring-managed component.
@Repository: Used to indicate that the class is a Data Access Object (DAO) and allows 
Spring to translate database-related exceptions into Spring's DataAccessException.

@Service
public class MyService {
    // Business logic
}

@Component
public class MyComponent {
    // General component
}

@Repository
public class MyRepository {
    // Data access logic
}


6. @Configuration
This annotation is used to mark a class as a source of bean definitions. 
It's often used to define beans programmatically and to configure third-party libraries.

@Configuration
public class MyConfig {
    
    @Bean
    public MyService myService() {
        return new MyService();
    }
}

7. @Bean
This annotation is used inside a @Configuration class to define a Spring bean. 
Spring calls these methods whenever it needs an instance of that class.

@Configuration
public class MyAppConfig {
    
    @Bean
    public MyService myService() {
        return new MyService();
    }
}

8. @Entity
This annotation is used in Spring Data JPA to specify that a class is an entity and will 
be mapped to a table in the database.

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    // Getters and setters
}


9. @Id and @GeneratedValue
@Id: Marks a field as the primary key of an entity.
@GeneratedValue: Specifies how the primary key should be automatically 
generated (e.g., auto-incremented).

10.@RequestBody and @ResponseBody
@RequestBody: Binds the body of the HTTP request to a method parameter.
@ResponseBody: Converts the return value of a method into the body of the HTTP response.

@PostMapping("/addUser")
public User addUser(@RequestBody User user) {
    // user will be populated from the request body
    return user; // The object will be serialized into JSON automatically
}

11. @PathVariable and @RequestParam
@PathVariable: Binds a method parameter to a value in the URL path.
@RequestParam: Binds a method parameter to a query string parameter in the URL.

@GetMapping("/user/{id}")
public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
}

@GetMapping("/user")
public User getUserByName(@RequestParam String name) {
    return userService.getUserByName(name);
}

12. @EnableAutoConfiguration
This annotation is used to enable Spring Boot’s auto-configuration feature. 
It automatically configures beans based on the classpath, property settings, 
and other factors. It is included in @SpringBootApplication.
 */