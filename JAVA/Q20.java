/* 
Q20. Explain Interface in Java.

An interface is a blueprint of a class that contains abstract methods and constants. 
Interfaces are used to define a contract for what a class must do, without dictating how it 
should do it. Unlike classes, interfaces cannot have any state (instance variables) and are 
implicitly abstract.

An interface allows you to specify methods that a class must implement, 
making it a way to enforce certain behaviors in different classes. Since Java does not 
support multiple inheritance of classes, interfaces provide a way for a class to inherit 
behaviors from multiple sources.

Basic Features of an Interface:

1.Abstract Methods: By default, methods in an interface are abstract (before Java 8). 
These methods are meant to be implemented by any class that implements the interface.

2.Constants: Variables in an interface are public, static, and final by default, 
meaning they are constants.

3.Multiple Inheritance: A class can implement multiple interfaces, allowing Java to 
support a form of multiple inheritance of types.

4.No Constructors: Interfaces cannot have constructors because they do not hold any state.

Defining an Interface:

interface Animal {
  // Abstract method (implicitly public and abstract)
  void sound();

  // Constant (implicitly public, static, and final)
  String TYPE = "Mammal";
}

Implementing an Interface:

A class that implements an interface must provide implementations for all of its abstract 
methods.

class Dog implements Animal {
  @Override
  public void sound() {
      System.out.println("Dog barks");
  }
}

public class Main {
  public static void main(String[] args) {
      Animal dog = new Dog();
      dog.sound();  // Output: Dog barks
  }
}


In the above example:

Animal is an interface with an abstract method sound().
Dog implements the Animal interface and provides an implementation for the sound() method.
The constant TYPE is automatically public, static, and final.

Key Features and Changes in Interfaces Across Java Versions

Java8 Features:

1. Default Methods
Before Java 8, interfaces could only have abstract methods. With Java 8, 
default methods were introduced, which allow you to provide a method with a body 
in the interface. This is particularly useful for backward compatibility, 
where adding a new method to an interface wouldn’t break existing implementations.

Default methods allow the interface to have some concrete behavior, and implementing 
classes can choose to override the default implementation if necessary.

Example of Default Method:
interface Animal {
  void sound();

  // Default method with implementation
  default void sleep() {
      System.out.println("The animal is sleeping.");
  }
}

class Dog implements Animal {
  @Override
  public void sound() {
      System.out.println("Dog barks");
  }
}

public class Main {
  public static void main(String[] args) {
      Dog dog = new Dog();
      dog.sound();  // Output: Dog barks
      dog.sleep();  // Output: The animal is sleeping. (Default method from the interface)
  }
}

Here, Dog implements the sound() method, but sleep() is inherited from the interface 
because it has a default implementation.

2. Static Methods
Java 8 also introduced static methods in interfaces, which can have a body and are used 
just like static methods in classes. These methods are called on the interface itself 
rather than on an instance of the class.

Example of Static Method:
interface Animal {
  static void info() {
      System.out.println("This is an Animal interface.");
  }
}

public class Main {
  public static void main(String[] args) {
      Animal.info();  // Output: This is an Animal interface.
  }
}

Static methods in interfaces are useful for utility methods that are related to the 
interface but do not require an instance of the implementing class.

Java 9 Features:

1. Private Methods
In Java 9, private methods were introduced in interfaces. 
These methods can be used to share common code between default or static methods within the
interface itself but are not accessible by the implementing classes. They are useful for 
reducing code duplication within the interface.

Example of Private Method:

interface Animal {
  default void showDetails() {
      log("Showing animal details.");
  }

  // Private method for internal use in the interface
  private void log(String message) {
      System.out.println("Log: " + message);
  }
}

class Dog implements Animal {
}

public class Main {
  public static void main(String[] args) {
      Dog dog = new Dog();
      dog.showDetails();  // Output: Log: Showing animal details.
  }
}


In this example, the log() method is private and is used by the showDetails() method within
the interface but cannot be called directly by the implementing class.

 */