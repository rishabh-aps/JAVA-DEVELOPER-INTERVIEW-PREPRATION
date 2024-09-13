/* 
Q6. What are Aggregate and Terminal operations in Java8 streams?

In Java 8 Streams, aggregate (also known as intermediate) and terminal operations are
 two types of operations that can be performed on a stream. 
 They define how streams are processed, transformed, and consumed.

1. Aggregate (Intermediate) Operations
Aggregate operations (also called intermediate operations) are operations that 
transform a stream into another stream. 
They do not consume the elements but rather prepare the data for further processing. 
These operations are lazy, meaning they are not executed until a terminal operation is invoked.

Characteristics:
Returns a new stream.
Doesn't process data until a terminal operation is called.
Can be chained to build a pipeline of transformations.


Common Aggregate (Intermediate) Operations:

1.filter(): Filters elements based on a condition.

List<String> names = Arrays.asList("John", "Jane", "Jack");
names.stream()
     .filter(name -> name.startsWith("J"));  // Filters names starting with 'J'

2. map(): Transforms elements by applying a function.
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.stream()
     .map(String::toUpperCase);  // Converts each name to uppercase

3.sorted(): Sorts elements in natural order or using a comparator.
List<Integer> numbers = Arrays.asList(3, 2, 1);
numbers.stream()
       .sorted();  // Sorts the numbers in ascending order

4.distinct(): Returns a stream with unique elements.
List<Integer> numbers = Arrays.asList(1, 2, 2, 3);
numbers.stream()
       .distinct();  // Removes duplicates

5.limit(): Limits the number of elements in the stream.
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .limit(3);  // Returns the first 3 elements

6.skip(): Skips the first n elements.
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
       .skip(2);  // Skips the first 2 elements, returns [3, 4, 5]

Terminal Operations:
Terminal operations are operations that consume the stream and produce a result or a side-effect, such as collecting the elements into a collection, counting elements, or printing them. Once a terminal operation is invoked, the stream pipeline is executed, and the stream cannot be reused after that.

Characteristics:
Produces a result (e.g., a collection, a primitive, or a void).
Triggers the processing of the stream pipeline.
Closes the stream after execution.

Common Terminal Operations:

1.forEach(): Iterates over each element and performs an action.
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.stream()
     .forEach(System.out::println);  // Prints each name

2.collect(): Collects the elements into a collection like a List, Set, or Map.
List<String> names = Arrays.asList("John", "Jane", "Jack");
List<String> result = names.stream()
                           .filter(name -> name.startsWith("J"))
                           .collect(Collectors.toList());  // Collects filtered names into a List

3.count(): Counts the number of elements in the stream.
List<String> names = Arrays.asList("John", "Jane", "Jack");
long count = names.stream().count();  // Counts the elements in the stream

4.reduce(): Reduces the elements of the stream to a single value using a binary operation.
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, Integer::sum);  // Adds all the numbers

5.findFirst(): Returns the first element in the stream (if any).
List<String> names = Arrays.asList("John", "Jane", "Jack");
Optional<String> first = names.stream()
                              .findFirst();  // Returns the first element in the stream

6.anyMatch(), allMatch(), noneMatch(): Checks if any, all, or none of the elements match a given predicate.
List<String> names = Arrays.asList("John", "Jane", "Jack");
boolean anyMatch = names.stream()
                        .anyMatch(name -> name.startsWith("J"));  // Checks if any name starts with 'J'

7.toArray(): Converts the stream into an array.
List<String> names = Arrays.asList("John", "Jane", "Jack");
String[] nameArray = names.stream().toArray(String[]::new);  // Converts the stream to an array

import java.util.*;
import java.util.stream.Collectors;

class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Stream pipeline: filter -> map -> collect (aggregate + terminal operations)
        List<Integer> evenNumbers = numbers.stream()          // 1. Create a stream
                                           .filter(n -> n % 2 == 0)   // 2. Aggregate operation (filter)
                                           .map(n -> n * 2)           // 3. Aggregate operation (map)
                                           .collect(Collectors.toList());  // 4. Terminal operation (collect)

        System.out.println(evenNumbers);  // Output: [4, 8, 12]
    }
}

In Summary:
Aggregate (Intermediate) Operations: Transform the stream (e.g., filter(), map(), sorted()), but they don’t trigger any processing until a terminal operation is called.
Terminal Operations: Consume the stream and produce a result (e.g., forEach(), collect(), reduce()), triggering the entire stream pipeline to process.
This combination of aggregate and terminal operations allows for flexible, functional-style data processing in Java 8.
*/
