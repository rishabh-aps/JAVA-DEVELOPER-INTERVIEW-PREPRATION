/* 
Q11. What are Java Generics?

1. Java Generics
Generics in Java enable types (classes, interfaces, and methods) to be parameterized 
with types, allowing code to be more reusable and type-safe. By using generics, 
Java provides compile-time type checking, reducing the chances of ClassCastException 
at runtime and eliminating the need for explicit casting.

Key Features of Generics:
1.Type Safety: You can specify the type of objects that a class, method, or interface will 
work with, which allows the compiler to catch errors at compile time.

2.Reusability: Write classes and methods that can handle any object type, reducing code 
duplication.

// Generic Class
class Box<T> {
  private T item;
  
  public void setItem(T item) {
      this.item = item;
  }

  public T getItem() {
      return item;
  }
}

public class GenericsExample {
  public static void main(String[] args) {
      // Using generic class with Integer
      Box<Integer> intBox = new Box<>();
      intBox.setItem(10);
      System.out.println("Integer value: " + intBox.getItem());

      // Using generic class with String
      Box<String> strBox = new Box<>();
      strBox.setItem("Hello");
      System.out.println("String value: " + strBox.getItem());
  }
}


Explanation:
Box<T>: A generic class where T represents a placeholder for the actual type.
Box<Integer>: A Box object that holds an Integer.
Box<String>: A Box object that holds a String.

Benefits of Generics:
Compile-Time Type Checking: Detects errors at compile-time instead of runtime.
Code Reusability: A single class or method can work with multiple data types.

 */