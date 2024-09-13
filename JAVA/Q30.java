/* 
Q30: throw vs throws keywords in Java

1. throw Keyword
Purpose: The throw keyword is used to explicitly throw an exception from a method or 
block of code. You create an instance of an exception and use throw to signal that 
something has gone wrong.

Where it's Used: Inside a method or block of code, when you want to manually throw an 
exception.

What it Does: When you use throw, the execution of the method is immediately 
terminated, and the exception is passed up the call stack to be handled.

Example:
class ThrowExample {
    public static void main(String[] args) {
        // Manually throw a runtime exception
        throw new ArithmeticException("Division by zero error");
    }
}

In this example, throw is used to explicitly throw an ArithmeticException.

2. throws Keyword
Purpose: The throws keyword is used in a method declaration to indicate that 
the method might throw one or more exceptions that callers should handle. 
It essentially declares that the method might result in certain types of exceptions.

Where it's Used: In the method signature (after the parameter list), to inform the 
caller of the method that it may throw an exception that needs to be 
caught or further propagated.

What it Does: The throws keyword doesn't throw an exception by itself; it only 
tells the caller that they should be prepared to handle the specified exceptions. 
These are typically checked exceptions.

Example:
import java.io.*;
class ThrowsExample {
    public static void readFile(String fileName) throws FileNotFoundException {
        FileReader file = new FileReader(fileName); // May throw FileNotFoundException
    }
    
    public static void main(String[] args) {
        try {
            readFile("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}


In this example, the readFile method declares that it throws a FileNotFoundException. 
It doesn't handle the exception itself but leaves that responsibility to the caller.

throw is used to actually throw an exception at runtime.
throws is used in the method signature to declare that a method may throw certain 
exceptions, so the caller must handle them.

 */