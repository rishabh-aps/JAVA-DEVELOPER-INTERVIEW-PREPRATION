/* 
Q40: Difference Between synchronized Block and synchronized Method

synchronized Method:

Synchronizes the entire method.

When a thread calls a synchronized method, it locks the object 
(or class if the method is static).

Easier to implement but can be less efficient because it may lock more code than 
necessary.

Example:
public synchronized void synchronizedMethod() {
  // Code here is synchronized
}

synchronized Block:

Synchronizes a specific block of code rather than the entire method.
Offers more granular control, allowing only a part of the method to be synchronized.
More efficient since it reduces the scope of synchronization, leading to less 
contention among threads.

Example:
public void methodWithSynchronizedBlock() {
  // Code not synchronized
  synchronized (this) {
      // Only this block is synchronized
  }
  // Code not synchronized
}


Key Differences:

Scope: synchronized method locks the entire method, while synchronized block only 
locks a specific block of code.

Granularity: synchronized block allows finer control over the code that needs 
synchronization.

Efficiency: synchronized block can be more efficient if only a small section of the 
method needs to be thread-safe.





Q: Deadlocks and How to Prevent Them in Java

Deadlock:
Occurs when two or more threads are waiting indefinitely for each other to release locks.
A classic scenario involves two threads each holding a lock and waiting for the other 
thread to release its lock, leading to a standstill.

Example:
class DeadlockExample {
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  public void method1() {
      synchronized (lock1) {
          synchronized (lock2) {
              // Do something
          }
      }
  }

  public void method2() {
      synchronized (lock2) {
          synchronized (lock1) {
              // Do something
          }
      }
  }
}


Here, method1 locks lock1 and then tries to lock lock2, while method2 does the opposite, 
potentially causing a deadlock.

Preventing Deadlocks:
Lock Ordering: Always acquire locks in a consistent order. For example, 
if multiple threads need to lock both lock1 and lock2, always acquire lock1 before lock2.

Timeouts: Use a timeout when attempting to acquire locks, using tryLock in the 
java.util.concurrent.locks.Lock interface.

Deadlock Detection: Implement deadlock detection using thread monitoring tools, 
though this approach is complex.





Race Condition and How to Avoid It
Race Condition:
Occurs when two or more threads access shared data and try to change it concurrently 
without proper synchronization.

The outcome depends on the sequence of execution, leading to unpredictable results.

Example:
public class RaceConditionExample {
    private int counter = 0;

    public void increment() {
        counter++; // Not thread-safe
    }
}


If multiple threads call increment() simultaneously, they may read, update, 
and write the counter variable inconsistently.

Avoiding Race Conditions:

Synchronization: Use synchronized blocks or methods to ensure that only one thread can 
access the shared data at a time.

public synchronized void increment() {
    counter++; // Thread-safe
}


Locks: Use explicit locks (java.util.concurrent.locks.Lock) to control access to 
shared resources.


Atomic Variables: Use atomic classes like AtomicInteger from java.util.concurrent.atomic 
for single variable updates.

private AtomicInteger counter = new AtomicInteger(0);

public void increment() {
    counter.incrementAndGet();
}


Thread-Safe Collections: Use thread-safe collections like ConcurrentHashMap and 
CopyOnWriteArrayList when working with collections shared across threads.


 */