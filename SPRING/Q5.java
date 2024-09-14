/* 
Q5: Spring Framework

The Spring Framework is a Java platform that provides comprehensive infrastructure support
for developing robust applications. It simplifies the development of complex applications 
through key features like:

Inversion of Control (IoC): Spring manages object creation and dependency injection, 
leading to loose coupling.

Dependency Injection (DI): Dependencies are injected externally, making the code more 
modular and testable.

Aspect-Oriented Programming (AOP): Allows separation of cross-cutting concerns like 
logging and security.

Transaction Management: Provides consistent transaction management across various 
transaction management mechanisms.

Spring MVC: A web framework for building web applications using the Model-View-Controller 
pattern.

Spring Boot: A tool for quickly building stand-alone, production-ready applications with 
minimal configuration.

Example: Dependency Injection in Spring:
Without Spring (Tight Coupling):
class Car {
  private Engine engine = new Engine(); // Direct dependency

  public void startCar() {
      engine.start();
  }
}

With Spring (Loose Coupling):
public class Car {
  private Engine engine;

  public Car(Engine engine) { // Constructor injection
      this.engine = engine;
  }

  public void startCar() {
      engine.start();
  }
}

Spring Configuration (beans.xml):
<beans>
    <bean id="engine" class="com.example.Engine"/>
    <bean id="car" class="com.example.Car">
        <constructor-arg ref="engine"/>
    </bean>
</beans>


Main Application:
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
Car car = (Car) context.getBean("car");
car.startCar();

Benefits:
Loose Coupling: Through DI, making code easier to maintain.
Modularity: AOP for separating cross-cutting concerns.
Scalability: Comprehensive modules like Spring MVC and Spring Boot for building scalable applications.
Spring helps build maintainable, testable, and scalable Java applications.


 */