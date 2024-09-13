/* 
Q24. Comparable and Comparator Interface.

Comparable Interface:
The Comparable interface is used to define the natural ordering of objects.

A class that implements the Comparable interface must implement the compareTo() method.

The compareTo() method compares the current object (this) with another object 
of the same type.

It is useful when you want to sort objects of a class in a single, default order 
(e.g., ascending order for numbers or lexicographical order for strings).

Signature of compareTo() Method:
int compareTo(T o);

The method returns:
0 if the current object is equal to the specified object.
Negative value if the current object is less than the specified object.
Positive value if the current object is greater than the specified object.

Example of Comparable:

class Student implements Comparable<Student> {
  private String name;
  private int age;

  public Student(String name, int age) {
      this.name = name;
      this.age = age;
  }

  @Override
  public int compareTo(Student other) {
      return this.age - other.age;  // Sort by age in ascending order
  }

  @Override
  public String toString() {
      return name + " (" + age + ")";
  }
}

public class Main {
  public static void main(String[] args) {
      List<Student> students = new ArrayList<>();
      students.add(new Student("John", 22));
      students.add(new Student("Alice", 20));
      students.add(new Student("Bob", 25));

      Collections.sort(students);  // Sort using Comparable (by age)
      System.out.println(students);  // Output: [Alice (20), John (22), Bob (25)]
  }
}


In this example:

The Student class implements Comparable<Student>.
The compareTo() method compares students based on their age, so when you 
call Collections.sort(), students are sorted by age.



Comparator Interface:
The Comparator interface is used to define custom ordering of objects.

Unlike Comparable, which provides a single natural ordering, Comparator can provide 
multiple ways to compare objects.

A class implementing Comparator must implement the compare() method, which takes 
two objects and compares them.

You can use multiple Comparator implementations to sort the same class in 
different ways.

Signature of compare() Method:
int compare(T o1, T o2);

The method returns:
0 if o1 is equal to o2.
Negative value if o1 is less than o2.
Positive value if o1 is greater than o2.

Example of Comparator:
class Student {
  private String name;
  private int age;

  public Student(String name, int age) {
      this.name = name;
      this.age = age;
  }

  public String getName() {
      return name;
  }

  public int getAge() {
      return age;
  }

  @Override
  public String toString() {
      return name + " (" + age + ")";
  }
}

// Comparator to compare students by name
class NameComparator implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
      return s1.getName().compareTo(s2.getName());  // Sort by name
  }
}

// Comparator to compare students by age
class AgeComparator implements Comparator<Student> {
  @Override
  public int compare(Student s1, Student s2) {
      return s1.getAge() - s2.getAge();  // Sort by age
  }
}

public class Main {
  public static void main(String[] args) {
      List<Student> students = new ArrayList<>();
      students.add(new Student("John", 22));
      students.add(new Student("Alice", 20));
      students.add(new Student("Bob", 25));

      // Sort by name using NameComparator
      Collections.sort(students, new NameComparator());
      System.out.println("Sorted by name: " + students);

      // Sort by age using AgeComparator
      Collections.sort(students, new AgeComparator());
      System.out.println("Sorted by age: " + students);
  }
}

In this example:

NameComparator compares students by name in lexicographical order.
AgeComparator compares students by age in ascending order.
You can easily switch between different comparators to sort the same list of 
students in multiple ways.


Explain Iterable vs Iterator in Java.

In Java, both Iterable and Iterator are part of the Java Collections Framework, 
and they are used for looping through collections of objects. However, 
they serve different purposes:

1. Iterable
Definition: An interface that represents a collection of objects that can be 
iterated over.

Purpose: It allows an object (like a collection) to be the target of 
the "for-each" loop.

Key Method: The iterator() method is used to return an instance of Iterator, 
which is then used to traverse the elements.

Common Usage: All collection classes in Java, such as ArrayList, HashSet, etc., 
implement the Iterable interface.

public interface Iterable<T> {
  Iterator<T> iterator();
}
Example:
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");

for (String item : list) {
    System.out.println(item);
}

Here, list is an Iterable, and the for-each loop internally uses an Iterator to 
go through the elements.

2. Iterator
Definition: An interface that provides methods to traverse through the elements of a 
collection, one at a time.

Purpose: It gives you fine control over the iteration process, like manually moving 
through elements, removing elements during iteration, etc.

Key Methods:
hasNext(): Checks if there are more elements to iterate.
next(): Returns the next element.
remove(): Removes the current element from the collection.

public interface Iterator<T> {
  boolean hasNext();
  T next();
  default void remove() {
      throw new UnsupportedOperationException("remove");
  }
}


List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

Here, Iterator is used explicitly to go through the elements in the list.



Collection vs Collections in Java.

1. Collection
Definition: It is an interface in the Java Collections Framework, representing a 
group of objects known as elements. It is the root interface for most of the 
collection classes in Java (like List, Set, Queue, etc.).

Purpose: Defines the basic operations that all collections (like lists, sets, queues) 
should support, such as adding, removing, and checking elements.

Key Methods:
add(): Adds an element to the collection.
remove(): Removes an element from the collection.
size(): Returns the number of elements in the collection.
isEmpty(): Checks if the collection is empty.
contains(): Checks if the collection contains a specific element.

public interface Collection<E> extends Iterable<E> {
  boolean add(E e);
  boolean remove(Object o);
  int size();
  boolean isEmpty();
  boolean contains(Object o);
}


Example:
Collection<String> myCollection = new ArrayList<>();
myCollection.add("Apple");
myCollection.add("Banana");
System.out.println(myCollection.size());  // Output: 2

In this example, myCollection is a Collection of strings, and we can add, remove, 
or check the size of the collection.

2. Collections
Definition: It is a utility class in the java.util package, which consists of 
static methods that operate on or return collections. It contains many helpful 
algorithms, like sorting, searching, and modifying collections.

Purpose: Provides static utility methods to operate on or return collections, 
such as sorting, searching, reversing, and more.

Key Methods:
sort(): Sorts the elements in a collection.
reverse(): Reverses the order of elements in a list.
shuffle(): Randomly shuffles the elements in a list.
min(), max(): Returns the minimum or maximum element from a collection.
unmodifiableCollection(): Returns an unmodifiable view of the collection.

public class Collections {
  public static <T extends Comparable<? super T>> void sort(List<T> list) { ... }
  public static <T> void reverse(List<T> list) { ... }
  public static <T> void shuffle(List<T> list) { ... }
}


Example:
List<String> list = new ArrayList<>();
list.add("Orange");
list.add("Apple");
list.add("Banana");

Collections.sort(list);  // Sorts the list
System.out.println(list);  // Output: [Apple, Banana, Orange]

Collections.reverse(list);  // Reverses the list order
System.out.println(list);  // Output: [Orange, Banana, Apple]

In this example, Collections is used to sort and reverse a list. 
It provides ready-to-use methods to manipulate collections efficiently.


 */