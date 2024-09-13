/* 
Q29: Checked and Unchecked Exceptions.

In Java, exceptions are categorized into two types: Checked Exceptions and 
Unchecked Exceptions. The main difference between them lies in how they are 
handled in the code and when they are checked during the program execution cycle.

1. Checked Exceptions
Definition: These are exceptions that are checked at compile-time. 
The Java compiler checks whether these exceptions are handled 
(using try-catch or declared with throws), ensuring that the program can handle 
potential issues that may occur during execution.

Handling Requirement: If a method has code that may throw a checked exception, 
it must either handle it using a try-catch block or declare it in the method 
signature using the throws keyword. Otherwise, the program won't compile.

Common Examples: IOException, SQLException, ClassNotFoundException, 
FileNotFoundException.


// Checked exception Example: FileNotFoundException
import java.io.*;

class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("file.txt"); // May throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

In this example, FileNotFoundException is a checked exception. 
The code must handle it or declare it with throws, or it will not compile.

2. Unchecked Exceptions (Runtime Exceptions)

Definition: These are exceptions that occur at runtime, meaning they are not checked 
during compile-time. The Java compiler does not require you to handle or declare them.

Handling Requirement: Since they are unchecked, there’s no compile-time requirement 
to handle them explicitly. However, they can still be caught and handled using 
try-catch blocks if you want to handle potential runtime issues.

Common Examples: NullPointerException, ArithmeticException, 
ArrayIndexOutOfBoundsException, IllegalArgumentException.

// Unchecked exception: ArithmeticException
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int result = 10 / 0; // Throws ArithmeticException at runtime
        System.out.println("Result: " + result);
    }
}


In this example, ArithmeticException is an unchecked exception. 
The code will compile successfully but will throw an exception at runtime.

When to Use Checked vs Unchecked Exceptions:
Checked Exceptions are used for conditions that are expected to occur but are out of 
the programmer's control (like reading a file that may not exist).

Unchecked Exceptions are used for programming errors, like accessing a null object, 
where the programmer has made a mistake in logic. These are generally not expected 
to happen if the code is written correctly.

 */