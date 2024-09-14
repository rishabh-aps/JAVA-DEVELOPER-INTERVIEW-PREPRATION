/* 
Q6: Dependency Injection (DI) and Inversion of Control (IoC)

What is Dependency Injection?
Dependency Injection is a design pattern where an object's dependencies 
(other objects it needs to function) are provided to it rather than the object creating 
them itself. This makes the code more flexible and easier to maintain.

Simple Example:
Imagine you have a Car class that needs an Engine to run.

Without Dependency Injection (Tightly Coupled):
public class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

public class Car {
    private Engine engine;

    public Car() {
        engine = new Engine(); // Directly creating an Engine
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started.");
    }
}


In this code:

The Car class creates the Engine object itself (new Engine()).
This makes Car tightly coupled to Engine, meaning if you want to change the Engine 
(e.g., to a DieselEngine), you have to modify the Car class.



With Dependency Injection (Loosely Coupled):

public class Car {
    private Engine engine;

    // Engine is provided via the constructor
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started.");
    }
}


Now, the Car class:

Does not create the Engine itself.
It receives the Engine as a parameter in the constructor (Car(Engine engine)).
This makes Car flexible and able to work with any engine type.

Spring Implementation:

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


In this setup:

Spring creates the Engine and Car objects and injects the Engine into the Car.
Car doesn’t know where the Engine comes from; it just uses it. This is Dependency 
Injection.





What is Inversion of Control?
Inversion of Control (IoC) means that instead of the object controlling its dependencies, 
the control is inverted. A container (Spring) takes over the creation and management of 
dependencies.

Example:
In the previous example:
Without IoC: Car creates Engine itself (new Engine()).
With IoC (using Spring): The control of creating and managing Engine is inverted to 
Spring. Spring creates the Engine and injects it into the Car.

So, IoC is a broader concept, and DI is one way to implement IoC. With Spring:
IoC: Spring manages the life cycle of objects.
DI: Spring injects the necessary dependencies (like Engine) into objects (like Car).

Summary:
Dependency Injection: Giving an object its dependencies rather than letting it create them itself.
Inversion of Control: Shifting the responsibility of creating and managing dependencies to a container (Spring).


 */