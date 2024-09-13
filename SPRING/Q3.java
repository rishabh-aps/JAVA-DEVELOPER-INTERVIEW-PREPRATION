/* 
Q3. What are the different bean scopes in Spring?

In Spring, bean scope defines the lifecycle and visibility of a bean in the Spring context. 
There are several types of bean scopes:

1. Singleton (Default Scope)
Description: Only one instance of the bean is created per Spring context (container). 
It is shared across the entire application.
Use case: For stateless beans like services.

@Scope("singleton")

2. Prototype
Description: A new instance of the bean is created every time it is requested from the 
Spring context.
Use case: For stateful beans, or when you need different instances for each use.

@Scope("prototype")


3. Request (Web application scope)
Description: A new instance is created for each HTTP request in web applications.
Use case: For beans that hold data specific to a single HTTP request.

@Scope("request")


4. Session (Web application scope)
Description: A new instance is created for each HTTP session in web applications.
Use case: For session-specific beans, like user information.

@Scope("session")


5. Application (Web application scope)
Description: A single instance is created for the entire web application and is shared 
across all requests and sessions.
Use case: For beans that are shared across the entire application lifecycle.

@Scope("application")


6. WebSocket (Web application scope)
Description: A new instance is created for each WebSocket session.
Use case: For beans that are specific to WebSocket communication.

@Scope("websocket")
 */