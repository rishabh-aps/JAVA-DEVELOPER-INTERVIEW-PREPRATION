/* 
Q9.What is collection framework?

Java Collection Framework Overview
The Java Collection Framework (JCF) is a set of classes and interfaces that implement 
commonly reusable collection data structures and algorithms. It includes several 
interfaces and concrete classes that allow developers to store, manipulate, 
and retrieve data efficiently. The framework standardizes how data structures are 
represented and handled, providing efficient data handling and manipulation.


Core Interfaces of Java Collection Framework:

1.Collection Interface: The root interface that defines the basic operations for all 
collections, such as adding, removing, and querying elements.

2.List Interface: A List is an ordered collection that allows duplicate elements. 
It preserves the insertion order.

  ArrayList: Resizable array implementation.
  LinkedList: Doubly linked list implementation.
  Vector: Synchronized, thread-safe version of ArrayList.

3.Set Interface: A Set is an unordered collection that does not allow duplicate elements.
  HashSet: Implements Set using a hash table.
  LinkedHashSet: Extends HashSet but maintains insertion order.
  TreeSet: Implements Set using a red-black tree, which maintains elements in sorted order.

4.Queue Interface: A Queue is designed to hold elements before processing, 
typically in a FIFO (First In, First Out) order.
  PriorityQueue: Implements Queue where elements are ordered based on their priority.
  LinkedList: Also implements Queue in addition to List.

5.Map Interface (Not part of the Collection hierarchy): A Map is a collection that stores key-value pairs.
  HashMap: Implements Map using a hash table.
  LinkedHashMap: Extends HashMap and maintains insertion order.
  TreeMap: Implements Map using a red-black tree, which sorts keys in natural order or by a comparator.

Java Collection Framework Diagram
Below is the diagram showing the hierarchy of the Java Collection Framework:

                         +-----------------+
                         |   Iterable<T>   |
                         +-----------------+
                                 |
                        +------------------+
                        |  Collection<T>   | <-----------------+
                        +------------------+                   |
                                 |                              |
         +----------------+------+------+                +---------------+
         |                       |                      |   Map<K,V>     |
 +---------------+      +------------------+            +---------------+
 |   List<T>     |      |   Set<T>         |            |   HashMap      |
 +---------------+      +------------------+            +---------------+
 |  ArrayList    |      |   HashSet         |            |  LinkedHashMap |
 |  LinkedList   |      |   LinkedHashSet   |            |  TreeMap       |
 |  Vector       |      |   TreeSet         |            +---------------+
 |  Stack        |      +------------------+
 +---------------+
                                 |
                        +-------------------+
                        |   Queue<T>        |
                        +-------------------+
                        | PriorityQueue     |
                        | Deque (LinkedList)|
                        +-------------------+

                  
Explanation of the Diagram:
1.Iterable<T>:
The root interface for all collections.
Provides the iterator() method, which allows iterating over a collection.

2.Collection<T>:
The root interface of the Java Collection Framework, extended by more specific collection 
types like List, Set, and Queue.
                        
3.List<T>:
An ordered collection that allows duplicate elements.
Implementations:
  ArrayList: A dynamically resizable array.
  LinkedList: A doubly linked list that also implements Queue.
  Vector: A synchronized version of ArrayList.
  Stack: A last-in-first-out (LIFO) stack that extends Vector.
                        
4.Set<T>:
A collection that does not allow duplicate elements.
Implementations:
HashSet: A hash table-based implementation that does not maintain any order.
LinkedHashSet: A version of HashSet that maintains the insertion order.
TreeSet: A set that stores elements in a sorted order.
                        
5.Queue<T>:
A collection that is primarily used to hold elements before processing.
Implementations:
PriorityQueue: A queue where elements are ordered based on priority.
LinkedList: Implements both List and Deque.

6.Map<K, V>:
A collection of key-value pairs, where each key is unique.
Implementations:
HashMap: Stores data using hashing.
LinkedHashMap: Like HashMap, but maintains insertion order.
TreeMap: A sorted map based on the natural ordering of keys or a provided comparator.

Java Collection Framework Components:
1.Interfaces:
The core of the Collection Framework, defining the standard operations that all 
collections must implement. Interfaces include List, Set, Queue, and Map.
                        
2.Concrete Classes:
Provide actual implementations for the interfaces. Examples include 
ArrayList, HashSet, HashMap, PriorityQueue, etc.

3.Algorithms:
The Collections class provides common algorithms like sort(), shuffle(), reverse(), 
and binarySearch() to operate on collections.
                        
4.Iterator:
All collections implement the Iterable interface, which returns an Iterator 
that allows traversal over the elements.
                         */