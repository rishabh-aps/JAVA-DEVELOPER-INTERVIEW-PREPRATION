/* 
Q7. Write a functional interface. 
Refer it to a Lambda Expression. Show it practically while explaining each step.

1. Defining a Functional Interface
In Java, a functional interface is an interface with exactly one abstract method. These interfaces are used as the target for lambda expressions.

Here’s how we define one:
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}


Explanation:
The @FunctionalInterface annotation ensures that the interface has exactly one 
abstract method. It’s not required but is a good practice because it prevents accidental 
addition of other abstract methods.
sayHello(String name) is the single abstract method in the Greeting interface.

2. Implementing the Interface Using a Lambda Expression
Lambda expressions provide a concise way to implement functional interfaces. 
Here’s how we implement our Greeting interface with a lambda expression.

class LambdaDemo {
  public static void main(String[] args) {
      // Using a lambda expression to implement the functional interface
      Greeting greeting = (name) -> System.out.println("Hello, " + name);
      
      // Calling the method via the lambda expression
      greeting.sayHello("John");
  }
}

Explanation:
(name) -> System.out.println("Hello, " + name); is the lambda expression. 
It matches the sayHello(String name) method from the Greeting interface.

(name) is the parameter, which matches the single parameter in the sayHello method.
-> separates the parameter from the body of the lambda expression.
System.out.println("Hello, " + name); is the body of the lambda, which defines what 
happens when sayHello is called.
Greeting greeting = (name) -> ... We assign the lambda expression to the Greeting i
nterface reference greeting. The lambda automatically implements the sayHello method 
of Greeting.

greeting.sayHello("John");: This invokes the lambda, printing "Hello, John" to the console.

3. Full Practical Example
Here’s the full code with explanations:
@FunctionalInterface
interface Greeting {
    void sayHello(String name);  // Single abstract method
}

public class LambdaDemo {
    public static void main(String[] args) {
        // 1. Implementing the interface using a lambda expression
        Greeting greeting = (name) -> System.out.println("Hello, " + name);
        
        // 2. Invoking the lambda expression (same as calling the method)
        greeting.sayHello("John");  // Output: Hello, John
        
        // 3. Invoking with another name to demonstrate reusability
        greeting.sayHello("Jane");  // Output: Hello, Jane
    }
}


Step-by-Step Breakdown:
1.Define the functional interface:
We create a functional interface Greeting with one abstract method sayHello.
This interface serves as the target for our lambda expression.

2.Create a lambda expression:
We implement the interface using a lambda expression: (name) -> System.out.println("Hello, " + name);.
This implementation says that, when sayHello is called, it will print a greeting message using the name provided as input.

3.Invoke the lambda:
We call greeting.sayHello("John");, which executes the lambda expression, printing Hello, John to the console.
We can call greeting.sayHello() with any name to reuse the lambda expression for other inputs.

output:
Hello, John
Hello, Jane


Benefits of Using Lambda Expressions:
Concise: Lambdas make the code more concise by eliminating the need for boilerplate code 
like anonymous inner classes.

Functional Programming Style: Lambdas bring a functional programming paradigm to Java, 
making it easier to work with methods as first-class citizens.

Readability: The syntax is straightforward and readable, especially when performing 
short operations like printing, filtering, or transforming data.

In Summary:
We defined a functional interface named Greeting with a single abstract method sayHello.
We used a lambda expression to provide an implementation of this interface.
The lambda is called with different names, and it dynamically executes based on the input provided. 
*/