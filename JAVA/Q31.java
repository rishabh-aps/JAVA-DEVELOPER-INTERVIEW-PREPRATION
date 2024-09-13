/* 
Q31 What happens if an exception is thrown from a finally block?

1. Basic Behavior of finally Block
The finally block is used to execute code that must run regardless of whether an 
exception was thrown in the try block or caught in the catch block. It is commonly 
used for cleanup activities, such as closing files or releasing resources.

The finally block always executes after the try block, and if there is a catch block, 
it executes after the catch block as well.

2. Throwing an Exception from the finally Block
When an exception is thrown inside a finally block, it overrides any exception that 
might have been thrown in the try or catch block. This means that the exception 
thrown from the finally block will take precedence and be the one that is propagated 
up the call stack.

Example:
class FinallyExceptionExample {
  public static void main(String[] args) {
      try {
          System.out.println("Inside try block");
          throw new RuntimeException("Exception from try block");
      } catch (RuntimeException e) {
          System.out.println("Caught exception: " + e.getMessage());
          throw new RuntimeException("Exception from catch block");
      } finally {
          System.out.println("Inside finally block");
          throw new RuntimeException("Exception from finally block");
      }
  }
}

Output:
Inside try block
Caught exception: Exception from try block
Inside finally block
Exception in thread "main" java.lang.RuntimeException: Exception from finally block
at FinallyExceptionExample.main(FinallyExceptionExample.java:13)


Explanation of the Example:
The try block throws a RuntimeException with the message "Exception from try block".

The catch block catches this exception and prints "Caught exception: Exception from 
try block", then throws another RuntimeException with the 
message "Exception from catch block".

Before the program can propagate the exception from the catch block, 
the finally block executes.

The finally block throws a new RuntimeException with the message
"Exception from finally block".

This exception from the finally block overrides the exception thrown from the 
catch block.

As a result, the program terminates with the exception from the finally block, 
and the original exceptions from the try and catch blocks are effectively lost.

 */