/* 
Q34: Custom Exceptions

1. Extending Exception (Checked Exception)
When to Use: Extend Exception when you want to create a checked exception, 
which forces the caller to handle the exception using try-catch blocks or declare 
it using the throws keyword.

Characteristics:
Checked exceptions are checked at compile-time.
They represent conditions that the caller can recover from.

Example:
// Custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Using the custom exception
class TestCustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

Explanation:
InvalidAgeException extends Exception, making it a checked exception.
The validateAge method throws this custom exception if the age is less than 18.
The caller is required to handle this exception using a try-catch block.



In Java, you can create custom exceptions by extending either the Exception class or the RuntimeException class. This allows you to define specific error conditions that are unique to your application's logic. Here's how you can create custom exceptions:

1. Extending Exception (Checked Exception)
When to Use: Extend Exception when you want to create a checked exception, which forces the caller to handle the exception using try-catch blocks or declare it using the throws keyword.
Characteristics:
Checked exceptions are checked at compile-time.
They represent conditions that the caller can recover from.
Example:
java
Copy code
// Custom checked exception
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Using the custom exception
public class TestCustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
Explanation:
InvalidAgeException extends Exception, making it a checked exception.
The validateAge method throws this custom exception if the age is less than 18.
The caller is required to handle this exception using a try-catch block.




2. Extending RuntimeException (Unchecked Exception)
When to Use: Extend RuntimeException when you want to create an unchecked exception. These exceptions are not checked at compile-time, so the caller is not forced to handle them.
Characteristics:
Unchecked exceptions are checked at runtime.
They represent programming errors (like illegal arguments) that could be avoided by correct coding practices.


Example:
// Custom unchecked exception
public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}

// Using the custom exception
class TestCustomRuntimeException {
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        divide(10, 0); // This will throw the custom unchecked exception
    }
}


Explanation:
DivideByZeroException extends RuntimeException, making it an unchecked exception.
The divide method throws this custom exception if an attempt is made to divide by zero.
The caller is not required to handle this exception, though it can choose to do so.

 */