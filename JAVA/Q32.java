/* 
Q32:What is the difference between final, finally, and finalize() in Java?

1. final Keyword
Purpose: final is a keyword used to apply restrictions on classes, methods, 
and variables.

Usage:
Variables: When a variable is declared as final, its value cannot be changed once 
it is initialized. This makes the variable a constant.

final int MAX_VALUE = 100;

Methods: When a method is declared as final, it cannot be overridden by subclasses. 
This is useful when you want to prevent changing the behavior of a 
method in a derived class.

public final void display() {
  System.out.println("This method cannot be overridden.");
}

Classes: When a class is declared as final, it cannot be subclassed. 
This is useful for creating immutable classes or preventing inheritance.

public final class Utility {
  // This class cannot be extended
}


2. finally Block
Purpose: finally is a block used in exception handling to execute a block of code, 
regardless of whether an exception is thrown or caught. It is commonly used for 
cleanup activities like closing resources.

Usage: The finally block is always associated with a try block, and it executes 
after the try and catch blocks, whether an exception occurs or not.

Example:
try {
  int data = 10 / 0;
} catch (ArithmeticException e) {
  System.out.println("Caught an exception.");
} finally {
  System.out.println("This block always executes.");
}

Key Point: The finally block will always execute, even if there is a return statement
in the try or catch block, except when the JVM exits (e.g., using System.exit()).


3. finalize() Method
Purpose: finalize() is a method in the Object class that is called by the garbage 
collector before an object is removed from memory. It is used to perform cleanup 
operations before an object is destroyed, like releasing system resources.

Usage: You can override the finalize() method in your class to specify cleanup 
actions for your objects. However, its use is generally discouraged in favor of 
other resource management techniques like try-with-resources.

Example:
public class Resource {
  @Override
  protected void finalize() throws Throwable {
      System.out.println("Finalize method called.");
  }
}

Note: There's no guarantee when or if finalize() will be called, as it 
depends on the garbage collector's behavior, making it unreliable for 
managing resources.

 */