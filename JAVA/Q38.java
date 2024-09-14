/* 
Q38. Explain Thead Life-cycle

The lifecycle of a thread in Java consists of several states through which a thread
transitions during its execution. Here's an overview of the different states and 
their transitions:

1. New
State: A thread is in the "New" state when it is created but not yet started.
Transition: When a Thread object is instantiated (e.g., Thread thread = new Thread()), 
it enters this state.
Example:
Thread thread = new Thread();

2. Runnable
State: A thread moves to the "Runnable" state when the start() method is called. 
In this state, the thread is ready to run and is waiting for CPU time.

Transition: When you call thread.start(), the thread enters the Runnable state. 
It can then transition between "Running" and "Runnable" based on the thread scheduler.

Example:
thread.start(); // Moves to Runnable state

Note: The "Runnable" state includes both threads that are currently running and those 
waiting for CPU time.


3. Running
State: This is not an official state in the Thread class but is often used to describe 
when a thread is actually executing on the CPU.

Transition: The thread scheduler moves a thread from "Runnable" to "Running" when it 
allocates CPU time to it.

Note: The transition between "Runnable" and "Running" depends on the thread scheduler 
and can happen multiple times.

4. Blocked/Waiting/Timed Waiting
State:
  Blocked: A thread enters this state when it tries to access a synchronized block or 
  method currently held by another thread.

  Waiting: A thread enters this state when it calls methods like wait(). 
  It waits for another thread to perform a specific action (e.g., notify).

  Timed Waiting: A thread enters this state when it calls methods like 
  sleep(milliseconds), wait(milliseconds), or join(milliseconds). 
  It remains in this state for a specified time.

Transition: Threads enter these states when they need to wait for a condition, 
a lock, or a specified time period.

synchronized (object) {
    object.wait(); // Enters the Waiting state
}
thread.sleep(1000); // Enters the Timed Waiting state


5. Terminated
State: A thread enters the "Terminated" state once it has finished executing (run() 
method completes) or has been stopped due to an unhandled exception.
Transition: When the run() method completes or the thread is terminated by an exception, 
it enters this state.
Example:
Completing the run() method.
Terminating due to an exception.


Summary of Transitions
New -> Runnable: When start() is called.
Runnable -> Running: When the thread scheduler selects the thread for execution.
Running -> Blocked/Waiting/Timed Waiting: When the thread is waiting for a lock, condition, or specified time.
Blocked/Waiting/Timed Waiting -> Runnable: When the thread acquires the lock, is notified, or the time period expires.
Running -> Terminated: When the run() method finishes or an exception occurs.

New -> Runnable <-> Running -> Terminated
         |            |
         |            |
       Blocked/Waiting/Timed Waiting

Example Code Demonstrating the Lifecycle:

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            // Thread moves to Running state
            System.out.println("Thread is running");

            // Thread moves to Timed Waiting state
            Thread.sleep(1000);

            synchronized(this) {
                // Thread moves to Waiting state
                wait(500);
            }

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        // Thread will move to Terminated state after this
        System.out.println("Thread has finished execution");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread(); // New state
        thread.start(); // Runnable state
    }
}

 */