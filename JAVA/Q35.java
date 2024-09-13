/* 
Q35: try with resources in Java

The try-with-resources statement in Java is a feature that simplifies the management 
of resources that need to be closed after use, such as files, database connections, 
sockets, etc. It was introduced in Java 7 to automatically close resources that 
implement the AutoCloseable interface, which includes most I/O classes. 
This helps prevent resource leaks, such as leaving files open or connections hanging.

Key Features of Try-with-Resources
Automatic Resource Management: It ensures that each resource is closed at the end of 
the statement, automatically calling the close() method.

Simplifies Code: Eliminates the need for explicit finally blocks for resource cleanup.

Exception Handling: Can handle exceptions that occur while working with resources or 
closing them.

Example:
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TryWithResourcesExample {
    public static void main(String[] args) {
        // Automatically closes FileReader and BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


Explanation
Resource Declaration: The BufferedReader is declared and initialized inside the parentheses of the try statement.
Automatic Closing: At the end of the try block, whether an exception is thrown or not, the BufferedReader and FileReader are automatically closed.
Exception Handling: If an IOException occurs, it is caught and handled in the catch block.

 */