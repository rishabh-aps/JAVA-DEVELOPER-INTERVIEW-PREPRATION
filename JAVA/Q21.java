/* 
Q21. Explain Inheritance in Java along with its types and Diamond Problem.

Inheritance in Java:

Inheritance is one of the fundamental concepts of Object-Oriented Programming (OOP) in Java.
It allows one class to inherit fields (attributes) and methods (behavior) from another 
class. The class that inherits is called the subclass (or child class), and the class being
inherited from is called the superclass (or parent class).

Inheritance promotes code reuse and establishes a natural hierarchical relationship 
between classes.

Key Concepts of Inheritance in Java:
1.Superclass (Parent Class): The class whose properties (fields and methods) are inherited.

class Animal {
  String name;
  
  void eat() {
      System.out.println(name + " is eating.");
  }
}


2.Subclass: The class that inherits the superclass. It can add new methods and 
fields or override existing ones.

class Dog extends Animal {
  void bark() {
      System.out.println(name + " is barking.");
  }
}


In the example above:

Animal is the superclass, and Dog is the subclass.

The Dog class inherits the name field and the eat() method from the Animal class and 
adds its own bark() method.


Syntax of Inheritance:
class SubclassName extends SuperclassName {
  // Fields and methods
}


Types of Inheritance in Java

1.Single Inheritance:
In single inheritance, a subclass inherits from a single superclass.

class Animal {
  void eat() {
      System.out.println("Eating...");
  }
}

class Dog extends Animal {
  void bark() {
      System.out.println("Barking...");
  }
}


2.Multilevel Inheritance:
In multilevel inheritance, a class is derived from another subclass, forming a chain.

class Animal {
  void eat() {
      System.out.println("Eating...");
  }
}

class Mammal extends Animal {
  void walk() {
      System.out.println("Walking...");
  }
}

class Dog extends Mammal {
  void bark() {
      System.out.println("Barking...");
  }
}

In this example:
Dog inherits from Mammal, and Mammal inherits from Animal.

3.Hierarchical Inheritance:
In hierarchical inheritance, multiple classes inherit from a single superclass.

class Animal {
  void eat() {
      System.out.println("Eating...");
  }
}

class Dog extends Animal {
  void bark() {
      System.out.println("Barking...");
  }
}

class Cat extends Animal {
  void meow() {
      System.out.println("Meowing...");
  }
}


4.Multiple Inheritance (Not Supported in Java with Classes):
Multiple inheritance occurs when a class inherits from more than one class. 
Java does not support multiple inheritance with classes to avoid ambiguity 
(such as in the Diamond Problem). However, Java allows multiple inheritance through 
interfaces.


Diamond Problem in Inheritance:
The Diamond Problem arises in languages that support multiple inheritance. 
This problem occurs when a class inherits from two classes that both inherit from a common 
superclass. If both parent classes provide a method with the same signature, 
it becomes unclear which method should be inherited by the child class.

Example of the Diamond Problem:
Consider the following scenario:

Class A defines a method display().
Class B and class C both inherit from A and override display().
Class D inherits from both B and C (if multiple inheritance were allowed in Java).

  A
 / \
B   C
 \ /
  D

Now, when D tries to access the display() method, the compiler is confused whether it 
should use B's version or C's version, creating the Diamond Problem.

How Java Solves the Diamond Problem:

Java solves the Diamond Problem by not allowing multiple inheritance with classes. 
In Java, a class can extend only one other class. This eliminates the ambiguity that 
arises in the diamond problem.

However, Java does allow multiple inheritance through interfaces. Interfaces provide a 
solution because, in the case of conflict, Java forces the class implementing 
multiple interfaces to explicitly define which method to use. This removes ambiguity.

interface A {
  default void display() {
      System.out.println("Display from A");
  }
}

interface B extends A {
  default void display() {
      System.out.println("Display from B");
  }
}

interface C extends A {
  default void display() {
      System.out.println("Display from C");
  }
}

class D implements B, C {
  // Must resolve the conflict by overriding the display() method
  @Override
  public void display() {
      // You can call a specific interface method using super
      B.super.display();  // Or C.super.display();
  }
}

public class Main {
  public static void main(String[] args) {
      D obj = new D();
      obj.display();  // Output: Display from B
  }
}

Explanation:
In this example, D implements both B and C, and both interfaces have a display() method. 
Java forces D to resolve the conflict by overriding the display() method.

Using B.super.display() or C.super.display(), you can explicitly choose which method to 
invoke.

This approach allows Java to support multiple inheritance via interfaces, while preventing 
ambiguity like the Diamond Problem in class inheritance.

 */