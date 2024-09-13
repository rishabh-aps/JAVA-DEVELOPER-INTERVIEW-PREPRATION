/* 
Q13. Explain HashMap & Its Internal working.

What is a HashMap?
HashMap is a part of Java's Collection Framework, under the java.util package. 
It is used to store data in key-value pairs where each key is unique, but values can 
be duplicated. Internally, HashMap uses a hashing mechanism to store and retrieve elements 
efficiently, providing average O(1) time complexity for operations like get(), put(), and 
remove().

Key Features of HashMap:
1.Allows null values: You can store one null key and multiple null values.
2.Not synchronized: HashMap is not thread-safe. If multiple threads access it concurrently, 
you must synchronize it manually or use ConcurrentHashMap.
3.No insertion order guarantee: The order of the elements is not preserved; it depends 
on the hash values of the keys.

import java.util.HashMap;

class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs
        map.put("John", 30);
        map.put("Sarah", 25);
        map.put("Mike", 35);

        // Accessing value by key
        System.out.println("John's age: " + map.get("John")); // Output: 30

        // Removing an entry
        map.remove("Sarah");

        // Iterating over the HashMap
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}

Internal Working of HashMap
The internal structure of a HashMap is based on buckets and hashing. 
The goal of HashMap is to provide fast lookups and inserts, typically
achieving O(1) time complexity for these operations.

Key Components
1.Hashing: HashMap uses a hash function to compute an index (also called a bucket index) for 
each key. This index determines where the key-value pair will be stored in the internal 
array.

2.Bucket: A bucket is simply an array location that can hold multiple key-value pairs in 
case of hash collisions (when different keys generate the same hash).

3.Node: Each bucket contains a linked list of nodes (in Java 8 and above, 
it uses a tree structure called TreeNode when the list size exceeds a threshold, 
generally 8) where each node contains:
    The key
    The value
    A reference to the next node in case of a hash collision.

4.Load Factor: The load factor defines how full the HashMap can get before it needs to 
increase its capacity (resize). The default load factor is 0.75, meaning the HashMap will 
resize when it's 75% full.

5.Threshold: The threshold is the point at which the HashMap resizes. 
It is calculated as capacity * load factor.

Detailed Steps for put() Operation:

1.Compute Hash: When you insert a key-value pair into the HashMap using the put() method, 
the hash of the key is computed using the hashCode() method of the key object. 
HashMap further applies a bitwise operation to the hash to reduce the possibility of 
collisions.

hash = key.hashCode() ^ (key.hashCode() >>> 16); // Mixing the hash bits

2.Calculate Bucket Index: The hash is used to compute the index of the internal 
array where the entry should be stored:

index = (n - 1) & hash;  // n is the length of the internal array (bucket array)

3.Check for Collision: If there is no entry at the computed index, 
the key-value pair is inserted as a new node. If another entry exists at the index 
(collision occurs), it checks if the keys are equal:
    If the keys are equal, it replaces the value.
    If the keys are different, the new entry is appended to the end of the linked list 
    (or tree structure, starting from Java 8) at that index.

4.Resize (Rehashing): When the size of the HashMap exceeds the threshold 
(determined by the load factor), the HashMap doubles its capacity and rehashes all 
the keys to place them into the new buckets (resize operation).

Example of put() Operation:

1.Initial Setup: Assume a HashMap with a default capacity of 16 and a load factor of 0.75. 
The threshold to resize is 16 * 0.75 = 12.

2.Inserting a Key-Value Pair:
map.put("John", 30);
Hash code for "John" is computed, say hash = 123456.
The bucket index is calculated using the formula (n - 1) & hash where n = 16. 
The index might be 5.
If no other entry is in bucket 5, the key-value pair "John" -> 30 is inserted there.

3.Collision Handling: If another key, say "Jane", also hashes to index 5, 
HashMap checks if "Jane".equals("John"). If not, "Jane" is added to the linked list at 
index 5.

4.Rehashing (Resize): Once the map has more than 12 entries, the internal array is 
resized to 32, and all the existing key-value pairs are rehashed and placed into new 
buckets.


Example of get() Operation:

Lookup Example:
Integer age = map.get("John");
The hash code for "John" is computed.
The bucket index is calculated.
The bucket is traversed, and if "John" is found, its value 30 is returned.

Handling Collisions:
Collisions occur when two keys hash to the same bucket. In Java:

1.Before Java 8: Collisions are handled by using a linked list within each bucket.
2.Java 8 and above: If the number of entries in a bucket exceeds a threshold (default is 8),
the linked list is converted to a balanced binary tree (using TreeNode), 
improving the worst-case time complexity of lookups from O(n) to O(log n).

 */