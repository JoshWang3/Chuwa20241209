1. list all the new annotations you learned to your annotations.md
2. Explain monolithic architecture, service oriented architecture and Micro service architecture.
> All functionalities such as ui, database, business logic tightly couples in a single codebase. Hard to scale.
> Different sections talk through a centralized communication hub.(ESB) service bus is a bottleneck, complex and slow
> independent food trucks instead of a big restaurant. easy to scale
3. Document the microservice architecture and core components
> api gateway, service discovery,load balancer, circuit breaker - prevent cascading failures when a service is down, configuration management, logging and tracing, event bus/asynchronous communication
> Services communicate via events instead of direct API calls.
4. Explain Resilience patterns? Explain circuit breaker with Spring Cloud Hystrix code example.
> Failures in distributed system is inevitable but resilience pattern helps handle failures gracefully.
> Circuit breaker prevents calling a failing service repeatedly. Fallback pattern provides a default response when a service fails. Retry pattern -If a request fails, retry it a few times before giving up.
```java
@CircuitBreaker(name = "userService", fallbackMethod = "fallbackResponse")
public String getUserData() {
    return restTemplate.getForObject("http://user-service/api/users", String.class);
}

public String fallbackResponse(Exception e) {
    return "User service is currently unavailable. Please try again later.";
}

```
>🔥 Issue: Hystrix is deprecated and no longer actively maintained.


5. Explain load balancing algorithms.
> round robin
> random
> least connections
6. Explain API Gateway.
> entry point for routing requests
7. Explain service discovery and service registry
> register the service in a directory for other services to look up
> discover the service dynamically with name instead of hardcoded ip addresses and port
8. List Spring Cloud Modules that serve as Microservice components (e.g. Euerka for Service Discovery)
> spring cloud config
> spring cloud gateway
> spring cloud LoadBalancer(replace ribbon(deprecated) for client-side load balancing)
> spring cloud resilience4J
> spring cloud zipkin(tracing)
> spring cloud stream(event-driven, rabbitMQ, kafka)
> spring cloud security(Oauth2, JWT, openID connect)
> spring cloud kubernetes
9. Walk through https://microservices.io/patterns/index.html