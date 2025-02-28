## 1. list all the new annotations you learned to your annotations.md
    see [spring_annotations.md](spring_annotations.md)
## 2. Explain monolithic architecture, service oriented architecture and Micro service architecture.
    1. Monolithic Architecture
        Definition
            A monolithic architecture is a single, unified application where all components (UI, business logic, and database) are tightly integrated and run as a single service.
        Characteristics
            Single codebase for the entire application.
            All modules (e.g., authentication, order management, billing) are within the same application.
            Typically runs on a single server or scaled vertically.
            Uses a single database.
    2. Service-Oriented Architecture (SOA)
        Definition
            SOA is an architecture where an application is divided into loosely coupled services that communicate through a message bus (Enterprise Service Bus, ESB).
        Characteristics
            Services are reusable and communicate via protocols like SOAP or REST.
            Typically relies on Enterprise Service Bus (ESB) to handle communication.
            Services share a common database or multiple databases.
    3. Microservices Architecture
        Definition
            Microservices architecture is an evolution of SOA, where applications are broken down into small, independent services that communicate using lightweight protocols (REST, gRPC, Kafka, etc.).
        Characteristics
            Each microservice owns its own database (avoids dependencies).
            Services communicate directly without an ESB.
            Decentralized and independently deployable.
            Uses containers (Docker, Kubernetes) for deployment.
## 3. Document the microservice architecture and core components
    Microservices architecture is a design pattern where an application is structured as a collection of independently deployable services that communicate through APIs. 
    Each microservice is responsible for a specific business function and operates autonomously.
    Core Characteristics
        ✔ Independently Deployable – Each service can be updated and deployed independently.
        ✔ Loosely Coupled – Services interact via lightweight communication protocols (REST, gRPC, message queues).
        ✔ Scalable – Individual services can be scaled separately based on demand.
        ✔ Resilient – Failure in one service does not impact the entire system.
        ✔ Technology Agnostic – Services can be developed using different programming languages and databases.
    Core Components of Microservice Architecture
        API Gateway
            Purpose:
                Acts as a single entry point for clients.
                Routes requests to the appropriate microservices.
                Handles authentication, rate limiting, and logging.
            Technologies:
                Spring Cloud Gateway, Kong, NGINX, AWS API Gateway
        Service Discovery (registration)
            Purpose:
                Keeps track of available microservices and their locations.
                Allows dynamic registration of services to prevent manual configuration.
            Technologies:
                Eureka (Netflix OSS), Consul, Zookeeper, Kubernetes Service Discovery
        Load Balancer
            Purpose:
                Distributes traffic among multiple instances of the same service.
                Ensures efficient resource usage and prevents overloading a single instance.
            Technologies:
                Ribbon (Netflix OSS), HAProxy, NGINX, Kubernetes Ingress
        Inter-Service Communication
            Purpose:
                Enables microservices to communicate with each other.
                Supports synchronous (REST/gRPC) and asynchronous (Message Queues, Event-Driven) communication.
            Types of Communication:
                Synchronous: REST API, gRPC
                Asynchronous: Kafka, RabbitMQ, Amazon SQS
        Database per Microservice
            Purpose:
                Each service owns and manages its own database, preventing direct database access by other services.
                Ensures high availability and independence.
            Technologies:
                MySQL, PostgreSQL, MongoDB, Cassandra
        Circuit Breaker & Resilience
            Purpose:
                Prevents a failing microservice from affecting others.
                Implements fallback mechanisms.
            Technologies:
                Resilience4j, Hystrix (Netflix OSS)
        Centralized Configuration Management
            Purpose:
                Stores configuration centrally, allowing dynamic updates without restarting services.
            Technologies:
                Spring Cloud Config, Consul, Kubernetes ConfigMaps
        Logging & Monitoring
            Purpose:    
                Tracks system health and detects issues.
                Provides observability through logging and metrics.
            Technologies:
                ELK Stack (Elasticsearch, Logstash, Kibana)
                Prometheus & Grafana
                Zipkin, Jaeger (Distributed Tracing)
        Security & Authentication
            Purpose:    
                Protects services from unauthorized access.
                Implements authentication and authorization (OAuth2, JWT).
            Technologies:
                Keycloak, Spring Security OAuth2, JWT
        Containerization & Orchestration
            Purpose:
                Manages service deployment, scaling, and networking.
                Supports automated failover and self-healing.
            Technologies:
                Docker (Containerization)
                Kubernetes (Orchestration)
                Helm (Package management for Kubernetes)
## 4. Explain Resilience patterns? Explain circuit breaker with Spring Cloud Hystrix code example.
    Resilience patterns:
        Help microservices handle failures gracefully and ensure that the system remains reliable even when components fail. 
        These patterns are critical in distributed systems where network failures, slow responses, and unexpected crashes are common.

        Key Resilience Patterns
            Circuit Breaker:
                Purpose:
                    Prevents a failing service from overwhelming the system with repeated requests.
                    Acts like an electrical circuit breaker—it "opens" when failures exceed a threshold, stopping further calls to the failing service.
                How It Works:
                    🔹 Closed State (Normal operation): Requests are allowed.
                    🔹 Open State (Failure threshold exceeded): Requests are blocked for a cooldown period.
                    🔹 Half-Open State (Test recovery): A few requests are allowed. If successful, it moves back to Closed; otherwise, it stays Open.
                Example:
```java
// Resilience4j in Java/Spring Boot
@CircuitBreaker(name = "orderService", fallbackMethod = "fallbackOrder")
public Order getOrder(Long id) {
    return orderServiceClient.getOrderById(id);
}

public Order fallbackOrder(Long id, Throwable ex) {
    return new Order(id, "Fallback Order");  // Default response when failure occurs
}

// Spring Cloud Hystrix
/**
 * Application setup
 * 
 * # Timeout before considering service unresponsive
 hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=3000
 # Minimum number of requests before circuit breaker considers failure rate
 hystrix.command.default.circuitBreaker.requestVolumeThreshold=5
 # Failure rate threshold (percentage of failed requests to trip the circuit)
 hystrix.command.default.circuitBreaker.errorThresholdPercentage=50
 # Time before trying to close the circuit again (in milliseconds)
 hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=10000
 */
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    /**
     * The @HystrixCommand annotation is used to wrap a method with circuit breaker functionality.
     * How It Works:
     If the getOrderDetails() method fails (due to timeout, network failure, etc.), Hystrix automatically calls fallbackGetOrder(), returning a default response.
     This prevents the system from hanging indefinitely and overloading the failing service.
     * @param orderId
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackGetOrder")
    public String getOrderDetails(Long orderId) {
        String url = "http://payment-service/payments/" + orderId;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackGetOrder(Long orderId) {
        return "Payment service is currently unavailable. Please try again later.";
    }
}
```
                Use Cases:
                    ✔ When a downstream service is unavailable or slow.
                    ✔ Prevents cascading failures across multiple services.
            Retry Pattern
                Purpose:
                    Retries a failed request a fixed number of times before giving up.
                    Useful for handling temporary failures like network timeouts or database connection issues.
                How It Works:
                    A request fails due to a transient issue.
                    The system waits for a brief moment before retrying.
                    If it still fails, it retries again (up to a configured limit).
                Example:
```java
@Retry(name = "paymentService", fallbackMethod = "fallbackPayment")
public Payment processPayment(PaymentRequest request) {
    return paymentClient.makePayment(request);
}

public Payment fallbackPayment(PaymentRequest request, Throwable ex) {
    return new Payment("Failed", "Retry attempts exhausted");
}
```
                Use Cases:
                    ✔ Handling temporary failures (e.g., intermittent network issues).
                    ✔ Database or external API failures where a temporary outage is expected.
            Bulkhead Pattern
                Purpose:
                    Isolates failures in one service/component so that it does not bring down the entire system.
                    Inspired by bulkheads in ships, which prevent flooding from spreading.
                How It Works:
                    Limits the number of concurrent requests to a service.
                    If the limit is exceeded, new requests are rejected, keeping the rest of the system stable.
                Example:
```java
@Bulkhead(name = "inventoryService", type = Bulkhead.Type.THREADPOOL)
public Inventory checkInventory(Long productId) {
    return inventoryClient.getInventory(productId);
}
```
                Use Cases:
                    ✔ Prevents one slow service from consuming all threads/resources.
                    ✔ Protects critical services from being overloaded.
            Timeout Pattern
                Purpose:
                    Sets a maximum wait time for a request. If the response is delayed beyond this time, the request is canceled.
                    Prevents slow responses from causing system-wide delays.
                How It Works:
                    A request is sent to a service.
                    If the service does not respond within the set time, it times out instead of waiting indefinitely.
                Example:
```java
@Timeout(name = "shippingService", fallbackMethod = "fallbackShipping")
public ShippingDetails getShipping(Long orderId) {
    return shippingClient.getShippingDetails(orderId);
}

public ShippingDetails fallbackShipping(Long orderId, Throwable ex) {
    return new ShippingDetails("Default Shipping", "Service Timeout");
}
```
                Use Cases:
                    ✔ Ensures responsive services by avoiding long waits.
                    ✔ Protects client applications from waiting indefinitely for a response. 
            Fallback Pattern
                Purpose:
                    Provides an alternative response when the primary service fails.
                    Ensures the system does not crash completely.
                How It Works:
                    When a service call fails, a predefined fallback response is returned.
                    The fallback can be static data, a default value, or a cached response.
                Example:
```java
@CircuitBreaker(name = "recommendationService", fallbackMethod = "fallbackRecommendation")
public List<Product> getRecommendations(Long userId) {
    return recommendationClient.getRecommendations(userId);
}

public List<Product> fallbackRecommendation(Long userId, Throwable ex) {
    return Arrays.asList(new Product(0L, "Default Product"));
}
```
                Use Cases:
                    ✔ When a service failure is unavoidable, but you still need a response.
                    ✔ Good for e-commerce, search recommendations, and user dashboards.
            Event-Driven Architecture (Message Queue-Based)
                Purpose:
                    Instead of synchronous service calls, services communicate asynchronously through event messages.
                    Reduces direct dependencies between services, improving resilience.
                How It Works:
                    Producer Service sends an event to a message broker (Kafka, RabbitMQ).
                    Consumer Service listens for events and processes them asynchronously.
                Example:
```java
@KafkaListener(topics = "order-events", groupId = "order-group")
public void consumeOrderEvent(String eventMessage) {
    System.out.println("Received Order Event: " + eventMessage);
}
```
                Use Cases:
                    ✔ When services should not block waiting for responses.
                    ✔ Useful for logging, notifications, and transaction processing.
## 5. Explain load balancing algorithms.
    Load balancing is the process of distributing incoming traffic across multiple servers to maximize performance, 
    reliability, and scalability. Load balancers use different algorithms to decide which server should handle a request.
    
    Algorithms:
        - Round Robin (Static)
            How It Works:
                Requests are assigned sequentially to each server in a cyclic order.
                Once the last server is reached, the cycle restarts.
            Example:
                For 3 servers (A, B, C):
                1st request → A
                2nd request → B
                3rd request → C
                4th request → A (cycle repeats)
            Use Case:
                ✔️ Simple and effective when all servers have equal capacity.
                ❌ Not ideal if servers have different processing power.
        - Weighted Round Robin (Static)
            How It Works:
                Similar to Round Robin, but assigns a weight to each server based on its processing power.
                A higher-weighted server receives more requests.
            Example:
                Assume weights:
                    A → 2, B → 1, C → 3
                Requests are assigned in this order:
                    1st → A
                    2nd → A
                    3rd → B
                    4th → C
                    5th → C
                    6th → C (cycle repeats)
                Use Case:
                    ✔️ Works well when servers have different capacities.
                    ❌ Can lead to uneven distribution if weights are not tuned properly.
        - Least Connections (Dynamic)
            How It Works:
                Requests are assigned to the server with the fewest active connections.
                Balancer continuously monitors active connections and distributes traffic accordingly.
            Example:
                If active connections are:
                    A → 3, B → 1, C → 2
                    New request goes to B (since it has the least connections).
            Use Case:
                ✔️ Works well for services where request durations vary significantly.
                ❌ Requires continuous monitoring, adding computational overhead.
        - Least Response Time (Dynamic)
            How It Works:
                Requests are sent to the server with the fastest response time (lowest latency).
                Often combined with Least Connections for better performance.
            Example:
                If response times are:
                    A → 150ms, B → 90ms, C → 200ms
                New request goes to B (fastest response time).
            Use Case:
                ✔️ Works best when server response times fluctuate.
                ❌ Requires real-time monitoring, which increases processing overhead.
        - IP Hash (Static)
            How It Works:
                Uses the client's IP address to determine which server should handle the request.
                Ensures that the same client always connects to the same server (session persistence).
            Example:
                Client 192.168.1.10 → Server B
                Client 192.168.1.20 → Server A
                (Same client IP always mapped to the same server)
            Use Case:
                ✔️ Useful when session persistence is needed (e.g., login sessions).
                ❌ Can cause uneven load if some IPs generate more traffic.
        - Random Load Balancing (Static)
            How It Works:
                Requests are randomly assigned to available servers.
            Use Case:
                ✔️ Simple and easy to implement.
                ❌ May lead to uneven distribution over time.
        - Weighted Least Connections (Dynamic)
            How It Works:
                Similar to Least Connections, but assigns a weight to servers based on capacity.
                Requests go to the server with the least connections, adjusted by weight.
            Use Case:
                ✔️ Works well when servers have different capacities and variable request durations.
        - Adaptive Load Balancing (AI/ML-Based)
            How It Works:
                Uses machine learning (ML) models to predict load patterns and adjust traffic distribution.
                Factors include CPU usage, memory, response time, and request history.
            Use Case:
                ✔️ Used in modern cloud platforms like AWS and Google Cloud for real-time optimization.
                ❌ Requires significant computational resources.
## 6. Explain API Gateway.
    An API Gateway is an entry point for all client requests in a microservices architecture.
    It acts as a reverse proxy that manages, routes, and secures API requests between clients and backend services.
    Key Responsibilities:
        Request Routing – Directs incoming requests to the appropriate microservices.
        Security & Authentication – Implements API keys, OAuth, JWT, and rate limiting.
        Load Balancing – Distributes traffic across multiple instances of a service.
        Caching – Reduces backend load by caching responses.
        Logging & Monitoring – Tracks API usage and performance metrics.
        Protocol Translation – Converts requests between REST, WebSockets, gRPC, etc.
## 7. Explain service discovery and service registry
    What is Service Discovery?
        In a microservices architecture, services must communicate with each other dynamically.
        Service Discovery automates the detection of available services without manual configuration.
        Instead of hardcoding service addresses, microservices register themselves dynamically and discover other services when needed.
    What is a Service Registry?
        A Service Registry is a central database where microservices register themselves with their network locations (IP, port, health status).
        Other services can query the registry to find and communicate with registered services. 
        Example tools: Eureka, Consul, Zookeeper.
## 8. List Spring Cloud Modules that serve as Microservice components (e.g. Eureka for Service Discovery)
    Service Discovery & Registration
        Spring Cloud Netflix Eureka – Provides service registry and service discovery.
        Spring Cloud Consul – Uses HashiCorp Consul for service discovery, configuration, and health checking.
        Spring Cloud Zookeeper – Uses Apache Zookeeper for service discovery.
    API Gateway & Routing
        Spring Cloud Gateway – A lightweight, reactive API gateway that supports dynamic routing, rate limiting, and security.
        Spring Cloud Netflix Zuul (Deprecated) – An older gateway solution replaced by Spring Cloud Gateway.
    Load Balancing
        Spring Cloud LoadBalancer – Built-in client-side load balancing (replacement for Netflix Ribbon).
        Spring Cloud Kubernetes – Native Kubernetes service discovery and load balancing.
    Resilience & Fault Tolerance
        Spring Cloud Resilience4j – Circuit breaker and retry mechanism (replacement for Netflix Hystrix).
        Spring Cloud Netflix Hystrix (Deprecated) – Older circuit breaker mechanism, replaced by Resilience4j.
        Example: Resilience4j Circuit Breaker
    Distributed Configuration & Secrets Management
        Spring Cloud Config – Externalized configuration management (stores configs in Git, databases, or Consul).      
        Spring Cloud Vault – Secure secrets management using HashiCorp Vault.
    Distributed Messaging & Event-Driven Communication
        Spring Cloud Stream – Simplifies event-driven messaging using Kafka, RabbitMQ, or other brokers.
        Spring Cloud Bus – Broadcasts configuration changes across microservices using Kafka or RabbitMQ.
        Example: Spring Cloud Stream with Kafka
    Security & Identity Management
        Spring Cloud Security – Integrates OAuth2, JWT, and SSO for microservices security.
        Spring Cloud Gateway + OAuth2 – Secures API Gateway with OAuth2 authentication.
        Example: Securing API Gateway with OAuth2
    Observability, Logging & Tracing
        Spring Cloud Sleuth – Adds distributed tracing using Zipkin or OpenTelemetry.
        Spring Cloud Zipkin – Collects and visualizes tracing data.
        Spring Cloud OpenFeign – Declarative HTTP client with built-in logging.
    Deployment & Orchestration
        Spring Cloud Kubernetes – Provides integration with Kubernetes for service discovery, configuration, and scaling.
        Spring Cloud AWS – Helps deploy microservices in AWS Cloud using S3, SQS, RDS, etc..
## 9. Walk through https://microservices.io/patterns/index.html
    Example see: [springcloud-redbook](../../Coding/hw16/springcloud-redbook)