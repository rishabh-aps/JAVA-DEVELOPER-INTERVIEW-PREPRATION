/* 
Q19. Abstract Classes in Java.

An abstract class is a class that is declared with the keyword abstract. 
Abstract classes cannot be instantiated on their own, meaning you cannot create an object 
of an abstract class. They are designed to be extended by other classes. 
An abstract class can have both abstract methods (methods without a body) and concrete 
methods (methods with a body).

Key Features of Abstract Classes:
1.Cannot Be Instantiated: You cannot create an object of an abstract class directly. 
  Instead, you need to create a subclass that extends the abstract class and implements
  its abstract methods.

// This will cause a compile-time error
AbstractClass obj = new AbstractClass();  // Cannot instantiate an abstract class

2.Abstract Methods: An abstract class can have abstract methods. These are methods declared
  without any implementation (method body). The subclasses of the abstract class must 
  provide an implementation for all the abstract methods, unless the subclass is also 
  abstract.

abstract class Animal {
    // Abstract method with no body
    abstract void sound();
}

3.Concrete Methods: An abstract class can also have concrete methods with implementation. 
These methods can be used directly by the subclasses, and they can also be overridden if 
needed.

abstract class Animal {
  // Concrete method with implementation
  void sleep() {
      System.out.println("The animal is sleeping.");
  }
}

4.Can Have Fields: Abstract classes can have instance variables and constants, 
  just like regular classes.

abstract class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

5.Can Have Constructors: Although you cannot instantiate an abstract class, it can have a 
  constructor, which can be called when a subclass is instantiated. This constructor is 
  usually used to initialize common fields.

abstract class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }
}

6.Inheritance: Abstract classes are meant to be extended. A subclass must implement all 
abstract methods of the abstract class unless the subclass itself is declared as abstract.

class Dog extends Animal {
  Dog(String name) {
      super(name);
  }

  // Providing implementation for the abstract method
  @Override
  void sound() {
      System.out.println("Dog barks");
  }
}


Why Use Abstract Classes?
Abstract classes are useful when:
You want to provide a common base class for several related classes.

You want to define common functionality (concrete methods) for all subclasses but still 
leave room for custom behavior (abstract methods) to be implemented by each subclass.
Example Scenario:
Suppose you are developing a program that models different types of vehicles. 
You can create an abstract class Vehicle that defines common attributes and behaviors 
for all vehicles, such as start() and stop(). 

Specific vehicles like Car and Bike can extend Vehicle and provide their own 
implementations for the abstract method start().

Example of Abstract Class in Java:

// Abstract class
abstract class Vehicle {
  // Instance variables
  String brand;

  // Constructor
  public Vehicle(String brand) {
      this.brand = brand;
  }

  // Abstract method (no implementation)
  abstract void start();

  // Concrete method (with implementation)
  void stop() {
      System.out.println(brand + " is stopping.");
  }
}

// Subclass Car that extends abstract class Vehicle
class Car extends Vehicle {

  public Car(String brand) {
      super(brand);  // Call the constructor of the abstract class
  }

  // Implement the abstract method
  @Override
  void start() {
      System.out.println(brand + " car is starting.");
  }
}

// Subclass Bike that extends abstract class Vehicle
class Bike extends Vehicle {

  public Bike(String brand) {
      super(brand);  // Call the constructor of the abstract class
  }

  // Implement the abstract method
  @Override
  void start() {
      System.out.println(brand + " bike is starting.");
  }
}

public class Main {
  public static void main(String[] args) {
      // Cannot instantiate the abstract class Vehicle
      // Vehicle vehicle = new Vehicle("Generic");

      // Create instances of subclasses
      Vehicle car = new Car("Toyota");
      Vehicle bike = new Bike("Yamaha");

      // Call the methods
      car.start();  // Output: Toyota car is starting.
      car.stop();   // Output: Toyota is stopping.

      bike.start();  // Output: Yamaha bike is starting.
      bike.stop();   // Output: Yamaha is stopping.
  }
}


 */