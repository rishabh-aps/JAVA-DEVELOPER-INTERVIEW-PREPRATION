/* 
Q5. Java8 Features

Java 8 introduced several new features and enhancements that revolutionized how Java 
developers write code. It was one of the biggest and most impactful updates 
in Java’s history. Let’s cover the key features in Java 8 
and explain each in simple terms.

Key Features of Java 8:

1.Lambda Expressions
2.Functional Interfaces
3.Streams API
4.Default and Static Methods in Interfaces
5.Optional Class
6.Method References
7.New Date and Time API
8.Collectors


1. Lambda Expressions
Lambda expressions provide a way to write inline functions in a concise manner. 
They help in reducing boilerplate code, especially when working with collections and 
functional programming.

Example:
Before Java 8, you would need an anonymous class to implement a functional interface 
like Runnable:

Runnable runnable = new Runnable() {
  @Override
  public void run() {
      System.out.println("Running");
  }
};

With Java 8, you can do the same with a lambda expression:

Runnable runnable = () -> System.out.println("Running");


Syntax:
(parameters) -> expression
(parameters) -> {statements}

2. Functional Interfaces
A functional interface is an interface with only one abstract method. Java 8 introduced 
the @FunctionalInterface annotation, and it plays a key role in supporting 
lambda expressions.

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

// Using a lambda expression to implement the functional interface
Greeting greeting = (name) -> System.out.println("Hello, " + name);
greeting.sayHello("John");

Common predefined functional interfaces include:

Function<T, R>
Consumer<T>
Supplier<T>
Predicate<T>


3. Streams API
The Streams API allows for functional-style operations on collections 
(e.g., filtering, mapping, and reducing). 
It helps in processing data in a declarative way, making code more readable and concise.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Using Streams to filter and print even numbers
numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);

Key operations:
filter(): Filters elements based on a condition.
map(): Transforms each element.
reduce(): Aggregates elements.
forEach(): Iterates through the elements.


4. Default and Static Methods in Interfaces
Before Java 8, interfaces could only have abstract methods. 
Now, you can define default and static methods in interfaces. 
This allows you to add methods to interfaces without breaking existing implementations.


interface Vehicle {
  void move();

  // Default method
  default void start() {
      System.out.println("Starting the vehicle...");
  }

  // Static method
  static void stop() {
      System.out.println("Stopping the vehicle...");
  }
}

class Car implements Vehicle {
  public void move() {
      System.out.println("Car is moving");
  }
}

public class Test {
  public static void main(String[] args) {
      Car car = new Car();
      car.start(); // Calls the default method
      car.move();  // Calls the overridden method

      Vehicle.stop(); // Calls the static method
  }
}


5. Optional Class
The Optional class helps in dealing with null values in a safe way, 
avoiding NullPointerException. Instead of returning null, you can return an 
Optional object that may or may not contain a value.


Optional<String> optionalName = Optional.ofNullable(null);

// Check if a value is present
optionalName.ifPresent(name -> System.out.println("Name: " + name));

// Providing a default value
String name = optionalName.orElse("Unknown");
System.out.println(name); // Output: Unknown


6. Method References
Method references allow you to refer to methods or constructors without invoking them. 
They are often used with lambda expressions to make code more readable.

List<String> names = Arrays.asList("John", "Jane", "Jack");

// Using a method reference to print each name
names.forEach(System.out::println);

Types of Method References:

Static methods: Class::staticMethod
Instance methods of an object: instance::instanceMethod
Instance methods of an arbitrary object of a specific type: Class::instanceMethod
Constructor references: Class::new

7. New Date and Time API
Java 8 introduced a new Date and Time API under the java.time package, 
which is much more user-friendly and solves many of the 
issues with the old java.util.Date and java.util.Calendar classes.

LocalDate date = LocalDate.now();
System.out.println("Current Date: " + date);

LocalDate specificDate = LocalDate.of(2020, Month.JANUARY, 1);
System.out.println("Specific Date: " + specificDate);

LocalTime time = LocalTime.now();
System.out.println("Current Time: " + time);


Key Classes:

LocalDate: Represents a date (year, month, day).
LocalTime: Represents a time (hour, minute, second).
LocalDateTime: Represents both date and time.
Period: Represents the difference between dates.
Duration: Represents the difference between times.

8. Collectors
The Collectors class provides utility functions for collecting stream results into 
collections like lists, sets, or maps, and for performing summary operations like counting, 
averaging, etc.

List<String> names = Arrays.asList("John", "Jane", "Jack");

// Collecting names into a list
List<String> nameList = names.stream().collect(Collectors.toList());
System.out.println(nameList);

// Counting elements in the stream
long count = names.stream().count();
System.out.println("Count: " + count);
 */