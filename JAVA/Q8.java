/*  
 Q8. What is HashMap? While Interating through it is it mutable?

What is a HashMap?
In Java, HashMap is a part of the Java Collections Framework and is one of the most 
commonly used implementations of the Map interface. 
It is a data structure that allows you to store and retrieve data in key-value pairs.

Key Features of HashMap:
1.Key-Value Pairs: A HashMap stores data as key-value pairs, where each key is unique, 
but values can be duplicated.
2.Hashing Mechanism: It uses a hashing algorithm to map keys to values, which allows 
for constant-time performance (O(1)) for basic operations like get() and put() in most cases.
3.No Guarantees on Order: The order of the elements is not guaranteed. 
Keys are hashed, and the iteration order can change over time.
4.Allows Null: It allows one null key and multiple null values.
5.Not Synchronized: HashMap is not thread-safe. If multiple threads access a 
HashMap concurrently, and at least one thread modifies it, synchronization must be 
managed externally, or you can use ConcurrentHashMap for thread safety.

Example of Creating and Using a HashMap:

import java.util.HashMap;

class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Accessing values
        System.out.println("Value for key 2: " + map.get(2));  // Output: Banana

        // Iterating through the HashMap
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

Output:
Value for key 2: Banana
1: Apple
2: Banana
3: Cherry



What is a HashMap?
In Java, HashMap is a part of the Java Collections Framework and is one of the most commonly used implementations of the Map interface. It is a data structure that allows you to store and retrieve data in key-value pairs.

Key Features of HashMap:
Key-Value Pairs: A HashMap stores data as key-value pairs, where each key is unique, but values can be duplicated.
Hashing Mechanism: It uses a hashing algorithm to map keys to values, which allows for constant-time performance (O(1)) for basic operations like get() and put() in most cases.
No Guarantees on Order: The order of the elements is not guaranteed. Keys are hashed, and the iteration order can change over time.
Allows Null: It allows one null key and multiple null values.
Not Synchronized: HashMap is not thread-safe. If multiple threads access a HashMap concurrently, and at least one thread modifies it, synchronization must be managed externally, or you can use ConcurrentHashMap for thread safety.
Example of Creating and Using a HashMap:
java
Copy code
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // Accessing values
        System.out.println("Value for key 2: " + map.get(2));  // Output: Banana

        // Iterating through the HashMap
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
Output:
Value for key 2: Banana
1: Apple
2: Banana
3: Cherry

Is HashMap Mutable During Iteration?
Yes, HashMap is mutable during iteration, but mutating it while iterating over its 
entries can lead to ConcurrentModificationException unless it is done carefully.

Mutating HashMap during iteration:
1.Modifications that trigger ConcurrentModificationException:
If you try to modify the HashMap (e.g., adding, removing entries) while iterating using an iterator or enhanced for-loop, 
you will get a ConcurrentModificationException.

public class HashMapMutationExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // This will cause ConcurrentModificationException
        for (Integer key : map.keySet()) {
            if (key == 2) {
                map.put(4, "Date");  // Modifying the map during iteration
            }
        }
    }
}


Output:
Exception in thread "main" java.util.ConcurrentModificationException

2.Safe Modifications During Iteration: If you need to safely modify a HashMap 
during iteration, you can use one of the following approaches:

Iterator with remove() method: Use an Iterator and its remove() method to 
remove elements while iterating.


public class SafeHashMapRemoval {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            if (key == 2) {
                iterator.remove();  // Safely removes the entry with key 2
            }
        }

        System.out.println(map);  // Output: {1=Apple, 3=Cherry}
    }
}

Using ConcurrentHashMap: If you need to modify a HashMap in a multithreaded environment, 
consider using ConcurrentHashMap, which allows concurrent modification without throwing 
ConcurrentModificationException.

import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        for (Integer key : map.keySet()) {
            if (key == 2) {
                map.put(4, "Date");  // This will not throw ConcurrentModificationException
            }
        }

        System.out.println(map);  // Output: {1=Apple, 2=Banana, 3=Cherry, 4=Date}
    }
}

Summary:
HashMap is a key-value pair data structure that provides fast access to data using hashing.
It is mutable during iteration, but modifying it while iterating using an enhanced for-loop 
or an iterator may throw a ConcurrentModificationException.
To safely modify a HashMap during iteration, use:
The Iterator's remove() method for removals.
Consider ConcurrentHashMap if you need to handle concurrent modifications in a 
multi-threaded environment.

 */