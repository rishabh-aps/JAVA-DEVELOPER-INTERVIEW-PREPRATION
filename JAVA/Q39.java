/* 
Q39: What are Runnable and Callable interfaces? How are they different?

1. Runnable and Callable Interfaces

Runnable:

An interface that represents a task that can be executed by a thread.
Has a single method run(), which does not return a result and cannot throw a 
checked exception.

Typically used when the task does not need to return any result.

class MyRunnable implements Runnable {
  @Override
  public void run() {
      System.out.println("Runnable task is running.");
  }
}


Callable:

An interface that represents a task that can return a result and throw a checked exception.
Has a single method call(), which returns a result of type T.
Used with the ExecutorService to submit tasks that return a result.

class MyCallable implements Callable<String> {
  @Override
  public String call() throws Exception {
      return "Callable task result";
  }
}


Differences:

Runnable does not return a result (void), while Callable returns a result of type T.
Runnable cannot throw checked exceptions, but Callable can.





Q:Difference between start() and run() Methods in Java

start():

Used to create a new thread and execute the run() method in that new thread.
Internally calls the run() method after the thread is scheduled by the thread scheduler.
Example:

Thread thread = new Thread(new MyRunnable());
thread.start(); // Creates a new thread and calls run() in that thread


run():
Contains the code that the thread executes.

If run() is called directly, it will not create a new thread but will run the code in 
the current thread.

Example:
thread.run(); // Calls run() in the current thread, no new thread is created

Difference:

start() creates a new thread and executes run() in that thread, while run() 
directly executes on the current thread.





Q: Synchronized Keyword in Java

The synchronized keyword is used to control access to a shared resource by multiple 
threads.

When a method or block is marked as synchronized, it locks the object 
(or class, if static) for that thread, preventing other threads from accessing the 
synchronized code until the lock is released.

Example:
public synchronized void synchronizedMethod() {
  // Code here can only be executed by one thread at a time
}

How It Works:

Monitor: When a thread enters a synchronized block/method, it acquires a lock on the 
object's monitor.

Mutual Exclusion: Other threads attempting to access the synchronized code will 
block until the lock is released.

Release: The lock is released when the thread exits the synchronized block or method.




Q:volatile Keyword in Java

The volatile keyword is used to indicate that a variable's value may be changed by 
different threads.

Ensures that changes to a variable are immediately visible to other threads.

Prevents threads from caching the variable value, ensuring they always read the 
latest value from the main memory.

Example:
private volatile boolean running = true;

Daemon Thread in Java
A daemon thread is a background thread that provides services to user threads.
JVM exits when all user threads finish execution, even if daemon threads are still running.
How It's Different from a User Thread:
Lifecycle: Daemon threads run in the background and do not prevent the JVM from exiting.
Usage: Used for background tasks like garbage collection.

Example:
Thread daemonThread = new Thread(new MyRunnable());
daemonThread.setDaemon(true); // Set thread as daemon
daemonThread.start();




Q: join() Method in Threads
The join() method allows one thread to wait for the completion of another.
When join() is called on a thread, the calling thread pauses until the thread on 
which join() was called completes.

Example:
Thread thread = new Thread(new MyRunnable());
thread.start();
try {
    thread.join(); // Waits for thread to complete
} catch (InterruptedException e) {
    e.printStackTrace();
}


Q: Thread Priority in Java
Thread priority determines the order in which threads are scheduled for execution.
Priorities range from Thread.MIN_PRIORITY (1) to Thread.MAX_PRIORITY (10), 
with Thread.NORM_PRIORITY (5) as the default.

Thread thread = new Thread(new MyRunnable());
thread.setPriority(Thread.MAX_PRIORITY);


Note: Thread priority is a hint to the thread scheduler, and its behavior can vary 
across different JVM implementations.


 */