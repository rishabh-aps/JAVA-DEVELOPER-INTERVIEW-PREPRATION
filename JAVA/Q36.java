/* 
Q36: What happens if a method does not handle a checked exception?

1. Compile-Time Error
Requirement: Java requires that checked exceptions are either caught within the method using a try-catch block or declared to be thrown using the throws keyword in the method signature.
Error: If neither is done, the Java compiler will generate a compile-time error, preventing the program from compiling successfully.


Example Without Handling Checked Exception:
import java.io.FileReader;

class Example {
    public void readFile() {
        // This line throws a checked exception (FileNotFoundException)
        FileReader file = new FileReader("example.txt");
    }
}

In this example, FileReader throws a FileNotFoundException, which is a checked exception. Since the readFile method neither catches this exception nor declares it with throws, the compiler will produce an error like:
Unhandled exception type FileNotFoundException


2. How to Correct It
To fix this, you have two options:

Option 1: Catch the Exception Using try-catch
Handle the exception within the method using a try-catch block.

import java.io.FileReader;
import java.io.FileNotFoundException;

public class Example {
    public void readFile() {
        try {
            FileReader file = new FileReader("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}


Option 2: Declare the Exception with throws
Declare that the method may throw the exception, passing the responsibility to the caller.


import java.io.FileReader;
import java.io.FileNotFoundException;

public class Example {
    public void readFile() throws FileNotFoundException {
        FileReader file = new FileReader("example.txt");
    }
}



If a method does not handle a checked exception in Java, the following outcomes can occur:

1. Compile-Time Error
Requirement: Java requires that checked exceptions are either caught within the method using a try-catch block or declared to be thrown using the throws keyword in the method signature.
Error: If neither is done, the Java compiler will generate a compile-time error, preventing the program from compiling successfully.
Example Without Handling Checked Exception
java
Copy code
import java.io.FileReader;

public class Example {
    public void readFile() {
        // This line throws a checked exception (FileNotFoundException)
        FileReader file = new FileReader("example.txt");
    }
}
In this example, FileReader throws a FileNotFoundException, which is a checked exception. Since the readFile method neither catches this exception nor declares it with throws, the compiler will produce an error like:

bash
Copy code
Unhandled exception type FileNotFoundException
2. How to Correct It
To fix this, you have two options:

Option 1: Catch the Exception Using try-catch
Handle the exception within the method using a try-catch block.

java
Copy code
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Example {
    public void readFile() {
        try {
            FileReader file = new FileReader("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
Option 2: Declare the Exception with throws
Declare that the method may throw the exception, passing the responsibility to the caller.

java
Copy code
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Example {
    public void readFile() throws FileNotFoundException {
        FileReader file = new FileReader("example.txt");
    }
}
Now, the caller of readFile must handle the FileNotFoundException:

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        try {
            example.readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}


 */