/* 
Q2. Difference btw StringBuilder and StringBuffer ?

The main difference between StringBuilder and StringBuffer in Java lies in how they 
handle synchronization and performance. 
Let’s break it down:

1.Synchronization (Thread Safety)

StringBuffer:
It is thread-safe, meaning it is synchronized. Multiple threads can access it at the same
time, but the methods are synchronized, so only one thread can modify it at any given time.
This makes StringBuffer a good choice when working in a multithreaded environment 
where the same instance may be accessed by multiple threads.

StringBuilder:
It is not thread-safe, meaning it is not synchronized. 
This makes it faster because there is no overhead of synchronization.
Use StringBuilder when you are working in a single-threaded environment or when
thread safety is not a concern.


2.Performance
StringBuffer:
Because of synchronization, StringBuffer is slower compared to StringBuilder. 
The locking mechanism adds overhead.

StringBuilder:
StringBuilder is faster than StringBuffer since it doesn't involve synchronization. 
So, if you don’t need thread safety, you should use StringBuilder for better performance.

3.Use Cases

Use StringBuffer when:
You are working in a multithreaded environment, and you need to ensure that the 
modification of a string is thread-safe.

Use StringBuilder when:
You are working in a single-threaded environment, or thread safety is not required, 
and you need better performance.

class Test {
    public static void main(String[] args) {
        // Using StringBuffer (Thread-safe but slower)
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" World");
        System.out.println("StringBuffer: " + stringBuffer);
        
        // Using StringBuilder (Not thread-safe but faster)
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" World");
        System.out.println("StringBuilder: " + stringBuilder);
    }
}

StringBuffer: Hello World
StringBuilder: Hello World

StringBuffer: Thread-safe but slower due to synchronization.
StringBuilder: Not thread-safe but faster, better for single-threaded use.
When in doubt, always use StringBuilder unless you're specifically working with threads and need safety, 
in which case you’d go for StringBuffer. 
*/