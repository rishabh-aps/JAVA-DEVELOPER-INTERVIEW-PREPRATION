/* 
Q14. How a Java Program Executes.

1. Writing the Java Program (Source Code)
Source Code: The developer writes the Java program using a text editor or an 
Integrated Development Environment (IDE) like IntelliJ, Eclipse, or VS Code. 
The program is written in plain text and saved with the .java file extension.

public class HelloWorld {
  public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}

In the above code, the developer writes a simple Java program with a main method, 
which is the entry point for any Java application.

2. Compilation (Java Compiler)
Compiler: Java source code written in a .java file cannot be executed directly by the 
computer. It must first be compiled into bytecode using the Java Compiler (javac). 
Bytecode is a platform-independent code that the JVM can understand.

Command: The Java compiler converts the .java file into a .class file containing bytecode.

Compilation Process:
javac HelloWorld.java

Output: This command generates a bytecode file HelloWorld.class, 
which contains the instructions for the JVM.


How Compilation Works:
The Java compiler checks for syntax errors in the source code.
If no errors are found, the source code is converted into bytecode (a .class file).
If there are errors, the compiler provides error messages for the developer to fix.


3. Class Loading (ClassLoader)
ClassLoader: The Java Virtual Machine (JVM) uses a ClassLoader to load the 
compiled .class files into memory. The Bootstrap ClassLoader, Extension ClassLoader, 
and Application ClassLoader work together to load the classes needed for 
the program execution.

Class Loading Steps:
Bootstrap ClassLoader: Loads core Java libraries (e.g., java.lang, java.util).
Extension ClassLoader: Loads classes from the extensions (e.g., javax packages).
Application ClassLoader: Loads the classes in the application (e.g., user-defined classes).

4. Bytecode Verification (Bytecode Verifier)
Bytecode Verifier: Once the class is loaded into memory, 
the Bytecode Verifier checks the loaded bytecode for validity and security. 
It ensures that:
    The bytecode adheres to the JVM specification.
    There are no illegal data access operations.
    The bytecode doesn't violate access permissions or attempt to modify objects in unsafe 
    ways.

This verification ensures that no unsafe or malicious code is executed by the JVM.

5. Execution (Java Virtual Machine - JVM)
JVM: The Java Virtual Machine (JVM) is responsible for executing the bytecode. 
It is an abstract computing machine that provides the runtime environment for the 
Java program. The JVM takes the bytecode and executes it on the host machine.

Steps during Execution:
1.Interpreter: The JVM first uses an interpreter to read the bytecode and execute it 
line by line. This is useful for quick program startup, but it can be slower for 
longer-running programs.

2.Just-In-Time (JIT) Compiler: For performance optimization, 
the JVM uses a Just-In-Time (JIT) compiler to compile bytecode into native machine code 
(specific to the host machine's architecture). 
This compiled machine code is cached, improving the performance of the Java program.
    JIT helps the program run faster because it avoids interpreting the same bytecode 
    multiple times.

3.Garbage Collection: Java has automatic memory management through Garbage Collection (GC). 
The JVM automatically tracks and removes unused objects from memory, freeing up 
resources and preventing memory leaks.

6. Execution of the main() Method
Every Java program must have a main() method, which serves as the entry point for 
the program's execution. When the JVM starts executing the program, 
it looks for the main method in the class that was passed during execution and 
begins executing the code inside that method.

public static void main(String[] args) {
    System.out.println("Hello, World!");
}

The JVM starts the execution of the program by calling the main() method of the HelloWorld class.
The program prints "Hello, World!" to the console.

7. Program Termination
Once the execution of the main() method (and any other invoked methods) completes, 
the program terminates.
The JVM shuts down after performing final tasks such as invoking shutdown hooks (if any) 
and finalizing objects.

Diagram: Java Program Execution Flow

Source Code (.java)  
     |
     v
[ Compilation ] --> ( javac HelloWorld.java )
     |
     v
Bytecode (.class)  
     |
     v
[ Class Loader ] (Loads .class into memory)
     |
     v
[ Bytecode Verifier ] (Ensures valid and safe bytecode)
     |
     v
[ Execution in JVM ] (Using Interpreter & JIT)
     |
     v
[ main() Method Execution ]
     |
     v
Program Output --> "Hello, World!"
     |
     v
Program Termination



Summary of Java Program Execution Flow:

1.Write the Program: The developer writes the Java source code and saves it with the .java extension.
2.Compilation: The source code is compiled using javac, which converts it into bytecode (.class file).
3.Class Loading: The JVM’s ClassLoader loads the .class file into memory.
4.Bytecode Verification: The Bytecode Verifier checks the bytecode for correctness and security.
5.Execution in JVM:
The JVM executes the bytecode using an interpreter and the JIT compiler for performance improvements.
The Garbage Collector manages memory during execution.
6.Execution of main() Method: The program starts execution from the main() method.
7.Program Termination: Once the main() method completes, the program terminates, and the JVM shuts down.

This entire process allows Java programs to be platform-independent, running on any system that has a compatible JVM, thanks to the Write Once, Run Anywhere (WORA) principle.
 */