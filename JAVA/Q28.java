/* 
Q28 Exception Handling in Java.

Exceptions in Java are unexpected events that occur during the execution of a program
and disrupt the normal flow of instructions. They are used to handle errors or other 
exceptional conditions that a program may encounter. Here's an overview of exceptions 
in Java:

1. What is an Exception?
An exception is an object that represents an error or unexpected behavior. 
When an error occurs, Java creates an object (an exception object) that contains 
information about the error, such as its type and where it occurred. 
This exception object is then thrown in the method, causing the program to stop 
unless the exception is handled.


2. Exception Hierarchy
All exceptions in Java are subclasses of the Throwable class. 
The two main types of exceptions are:

Checked Exceptions: These are exceptions that are checked at compile-time. 
Examples include IOException, SQLException, etc. You must handle them explicitly 
using try-catch or declare them using throws.

Unchecked Exceptions: These are exceptions that occur during runtime and are
not checked at compile-time. They include NullPointerException, 
ArrayIndexOutOfBoundsException, etc. They can be avoided by writing proper 
code but don't require explicit handling.

Hierarchy Diagram:

java.lang.Object
   └── java.lang.Throwable
        ├── java.lang.Exception
        │     ├── java.io.IOException (Checked)
        │     ├── java.sql.SQLException (Checked)
        │     └── java.lang.RuntimeException (Unchecked)
        │           ├── java.lang.NullPointerException
        │           └── java.lang.ArrayIndexOutOfBoundsException
        └── java.lang.Error (Unchecked)
              ├── java.lang.StackOverflowError
              └── java.lang.OutOfMemoryError


3. Common Exception Types
NullPointerException: Occurs when trying to use an object reference that is null.
ArrayIndexOutOfBoundsException: Happens when accessing an invalid index in an array.
ArithmeticException: Division by zero.
IOException: Related to input-output operations.

4. Handling Exceptions
You handle exceptions using the try-catch block, which allows you to "catch" 
the error and take appropriate action. You can also use the finally block for cleanup 
operations.

try {
  int data = 10 / 0; // This will throw ArithmeticException
} catch (ArithmeticException e) {
  System.out.println("Error: Division by zero is not allowed.");
} finally {
  System.out.println("This will always execute.");
}


5. Throwing Exceptions
You can manually throw exceptions using the throw keyword. 
This is useful when you want to handle custom error conditions in your program.

if (age < 18) {
  throw new IllegalArgumentException("Age must be 18 or above.");
}


6. Throws Keyword
If a method is likely to throw an exception but you don't want to handle 
it in the method itself, you can declare the exception using the throws keyword.

public void readFile(String fileName) throws IOException {
    FileReader file = new FileReader(fileName);
    // method code here
}


7. Custom Exceptions
You can create your own exceptions by extending the Exception class.
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


8. Best Practices
Use specific exceptions (IOException, ArithmeticException) rather than generic ones.
Catch exceptions at the appropriate level where you can handle them effectively.
Always clean up resources (like file handles or database connections) in a finally 
block or use a try-with-resources statement.
Avoid using exceptions for normal control flow.

 */