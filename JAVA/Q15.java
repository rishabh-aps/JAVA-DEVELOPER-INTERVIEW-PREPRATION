/* 
Q15. Explain Memory Management in Java.

Memory Management in Java
Java provides automatic memory management through the Java Virtual Machine (JVM). 
The JVM takes care of allocating and freeing memory, making Java a developer-friendly 
language in terms of memory handling. The key components of memory management in Java 
include heap memory, stack memory, and garbage collection.

Java memory is divided into two main regions:
1.Heap Memory: Used for dynamic memory allocation, where objects and instance variables 
are stored.
2.Stack Memory: Used for method execution and storing local variables and function call 
details.


1. Heap Memory
Heap memory is the part of memory where all Java objects, arrays, and class instances 
are stored. It is managed automatically by the Garbage Collector.

Heap Memory Structure:
  Young Generation: This is where newly created objects are first allocated. 

 A. The Young Generation is further divided into:
    1.Eden Space: All new objects are initially allocated here.
    2.Survivor Spaces (S0 and S1): After the objects in the Eden space survive the first 
      round of garbage collection, they are moved to the survivor spaces.

 B. Old Generation (Tenured Generation): Objects that survive multiple rounds of 
    garbage collection are moved to the Old Generation. These are typically long-lived 
    objects.

 C. Permanent Generation (or Metaspace in Java 8 and later): Stores metadata like class structures, method data, and 
    static variables.

How Heap Memory Works:
1.Object Allocation: When you create an object using the new keyword, it is allocated in 
heap memory.
2.Garbage Collection: When objects are no longer referenced, the Garbage Collector (GC) 
automatically frees up the memory occupied by these objects, ensuring efficient memory 
management.

2. Stack Memory
Stack memory is used to store method-specific data such as local variables, 
references to objects in the heap, and method call details. Each thread in a Java program 
has its own stack memory.

Key Characteristics of Stack Memory:
LIFO (Last-In-First-Out): Stack memory follows the Last-In-First-Out principle. 
Each time a method is called, a new frame is added to the stack. When the method finishes, 
the frame is popped off the stack.

Stores local variables: Local variables and method call parameters are stored in 
stack memory.

Fast Access: Stack memory is faster than heap memory because it is managed in a very 
organized and predictable manner.

Limited in size: Each thread has a fixed-size stack. If this size is exceeded, 
a StackOverflowError occurs.

3. Garbage Collection
Java’s Garbage Collector (GC) is responsible for automatically managing heap memory. 
It reclaims memory by removing objects that are no longer reachable by the application. 
Garbage collection ensures that memory is freed without the need for manual intervention 
by the developer.

Garbage Collection Process:
1.Mark-and-Sweep: The garbage collector marks objects that are reachable from root references
(such as static references and local variables). It then sweeps (deletes) the objects that
are not marked.
    
2.Generational Garbage Collection: Java uses generational garbage collection to improve 
performance by categorizing objects based on their age:
  A.Young Generation GC (Minor GC): Collects objects that are newly allocated and 
    short-lived. These objects are often in the Eden space or survivor spaces.
  B. Old Generation GC (Major GC): Collects objects that have survived multiple minor GCs. 
     These are long-lived objects in the old generation.


Types of Garbage Collectors:
1.Serial GC: Uses a single thread for garbage collection. It is simpler but not suitable 
for large applications.
2.Parallel GC (Throughput Collector): Uses multiple threads for garbage collection to 
achieve high throughput.
3.G1 Garbage Collector: Divides the heap into regions and uses concurrent threads to 
reduce pause times and optimize performance.
4.Z Garbage Collector: A low-latency garbage collector introduced in Java 11, designed 
to minimize pause times.

4. Memory Areas in JVM

1. Method Area (Metaspace in Java 8 and later):
Stores class metadata, method bytecode, static variables, and runtime constant pool.
Shared among all threads.
In Java 8 and later, this is managed in Metaspace, which resides in native memory 
instead of the JVM heap.

2. Program Counter (PC) Register:
Each thread has its own PC register, which contains the address of the currently 
executing instruction.

3. Native Method Stack:
Stores native method information for methods written in other languages like C/C++.

Memory Leaks and Memory Errors:
Even though Java has automatic memory management, memory leaks can still occur if 
references to objects are not properly removed. For example, if an object is still 
referenced even though it's no longer needed, the GC will not collect it, causing 
unnecessary memory usage.

Common Memory Errors:
1.OutOfMemoryError: Occurs when the JVM runs out of heap memory and the garbage collector 
cannot free up enough space.
2.StackOverflowError: Occurs when the stack memory is exhausted, usually due to deep 
recursion or infinite method calls.

Memory Management Example:

public class MemoryExample {
  public static void main(String[] args) {
      // Stack memory stores the reference 'emp', heap memory stores the object
      Employee emp = new Employee("John", 30);  

      int localVar = 5;  // local variable stored in stack memory
      System.out.println(localVar);

      // After the method ends, localVar and emp reference will be removed from the stack.
      // The 'emp' object will remain in heap memory until garbage collected.
  }
}

class Employee {
  String name;
  int age;

  public Employee(String name, int age) {
      this.name = name;
      this.age = age;
  }
}


The Employee object is allocated in heap memory, while the local variable localVar and 
the reference to the Employee object (emp) are stored in stack memory.

Once the program finishes, garbage collection may collect the Employee object if 
it is no longer referenced.
 */