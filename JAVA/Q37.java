/* 
Q37: What is a thread in Java, and how is it implemented?

A thread in Java is a lightweight process that allows concurrent execution of code. 
Threads enable multitasking by allowing multiple parts of a program to run 
simultaneously, enhancing performance, especially in applications that need to 
perform multiple tasks like handling user interactions, I/O operations, or 
background processing.

Implementing Threads in Java
In Java, you can create a thread in two main ways:

By extending the Thread class
By implementing the Runnable interface

1. Extending the Thread Class
To create a thread by extending the Thread class:

Create a class that extends Thread.
Override the run() method, which contains the code that will be executed by the thread.
Create an instance of your class and call the start() method to begin the execution of the thread.

class MyThread extends Thread {
  @Override
  public void run() {
      // Code to be executed by the thread
      System.out.println("Thread is running");
  }
  
  public static void main(String[] args) {
      MyThread thread = new MyThread(); // Create a thread object
      thread.start(); // Start the thread
  }
}

Here, start() internally calls the run() method in a new thread of execution.



2. Implementing the Runnable Interface
To create a thread by implementing the Runnable interface:

Create a class that implements Runnable.
Implement the run() method with the code to execute.
Pass an instance of your Runnable class to a Thread object and call start().



class MyRunnable implements Runnable {
  @Override
  public void run() {
      // Code to be executed by the thread
      System.out.println("Runnable thread is running");
  }
  
  public static void main(String[] args) {
      MyRunnable runnable = new MyRunnable(); // Create a runnable object
      Thread thread = new Thread(runnable); // Create a thread with the runnable
      thread.start(); // Start the thread
  }
}


This approach is preferred when your class needs to extend another class since 
Java does not support multiple inheritance.

Key Points
Use start() to begin the execution of the thread, which invokes the run() method.

run() should not be called directly; doing so will not start a new thread but will 
execute the method in the current thread.

Threads can be used to improve the performance of applications by allowing 
multitasking.


Process vs Thread

Process: A process is an independent program in execution, with its own memory space. 
It represents an application running on an operating system, 
like a word processor or a web browser.


Thread: A thread is the smallest unit of execution within a process. 
Threads within the same process share the process's resources, such as memory and 
file handles, but execute independently.
 */