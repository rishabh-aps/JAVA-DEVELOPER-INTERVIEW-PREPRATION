/* 
Q16. Explain String and its immutability in Java.

In Java, a String is a sequence of characters treated as an object. 
The String class is part of the java.lang package, and it is used to handle textual data. 
Strings can be created using string literals or by using the new keyword.

Example:
String str1 = "Hello, World!";   // String literal
String str2 = new String("Hello, World!");   // Using new keyword

In both cases, str1 and str2 are objects of the String class representing the same text.

Why is String Immutable in Java?
Strings are designed to be immutable in Java for several important reasons, 
including memory optimization, security, thread-safety, and performance. 
Let's look at why immutability is crucial:

1. Memory Efficiency with the String Pool
Java uses a String Pool to store string literals. When you create a string using a literal 
(like "Hello"), the JVM checks if an identical string already exists in the pool. 
If it does, the existing string is reused instead of creating a new object. 
This reusability helps save memory.

If strings were mutable, changing one string could inadvertently change the same string 
everywhere it's used in the pool, leading to unpredictable behavior.

String str1 = "Java";
String str2 = "Java";
System.out.println(str1 == str2);  // Output: true (same object in String Pool)


Here, both str1 and str2 point to the same object in memory. 
If strings were mutable, modifying str1 would also affect str2.

2. Security
Strings are often used to store sensitive information like usernames, passwords, and URLs. 
If strings were mutable, someone could modify this data, which could compromise security. 
By making strings immutable, Java ensures that once a string is created, 
it cannot be altered.

3. Thread-Safety
Since strings are immutable, they can be safely shared between multiple threads without 
needing synchronization. Multiple threads can access the same string without worrying about 
one thread changing its value while another is reading it. This makes strings thread-safe 
by default.

4. Performance (Hash Code Caching)
Immutable strings allow for hash code caching. The hash code of a string is often 
computed when the string is first created, and since the string's value cannot change, 
the hash code is stored (cached). This improves performance when strings are used as keys 
in collections like HashMap because the hash code does not need to be recomputed every time.


How Does Immutability Work in Strings?
When you perform operations like concatenation or substring, 
Java creates a new string rather than modifying the existing one. 
The original string remains unchanged.

String str = "Hello";
String newStr = str.concat(" World");
System.out.println(str);      // Output: Hello
System.out.println(newStr);   // Output: Hello World

 */