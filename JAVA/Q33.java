/* 
Q33: Exceptions vs Errors

Recoverable Exceptions (Exception)
Nature: Indicate issues that the program can anticipate and handle.
Examples: IOException, SQLException, FileNotFoundException.
Handling: Can be caught and managed using try-catch blocks to allow the program to continue running.
Usage: Used for common problems like invalid input, file not found, and network issues.

Types:
Checked Exceptions: Must be handled or declared.
Unchecked Exceptions: Can be handled but not required.


Irrecoverable Errors (Error)
Nature: Indicate serious problems that are beyond the program's control and typically cannot be recovered from.
Examples: OutOfMemoryError, StackOverflowError.
Handling: Usually not caught or handled, as they represent critical system failures.
Usage: Represent situations like JVM resource exhaustion or severe runtime environment issues.
Outcome: Often cause the program or JVM to terminate.


Summary
Exceptions are recoverable issues that can be managed in code to allow the 
program to continue.
Errors are critical, unrecoverable conditions that usually result in the 
termination of the program.

 */