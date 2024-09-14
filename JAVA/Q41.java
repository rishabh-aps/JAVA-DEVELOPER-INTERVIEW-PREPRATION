/* 
Question: Fetch all numbers from a list greater than 5.

List<Integer> numbers = Arrays.asList(3, 9, 2, 6, 7);
List<Integer> result = numbers.stream()
    .filter(n -> n > 5)  // filters numbers greater than 5
    .collect(Collectors.toList());  // collects them into a list

System.out.println(result);  // Output: [9, 6, 7]

Explanation: The filter method filters elements based on a condition (predicate). 
Here, it filters numbers greater than 5.



Question: Transform a list of strings into a list of their uppercase versions.

List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> result = words.stream()
    .map(String::toUpperCase)  // converts each string to uppercase
    .collect(Collectors.toList());  // collects them into a list

System.out.println(result);  // Output: [APPLE, BANANA, CHERRY]


Explanation: The map method transforms each element using a provided function. 
Here, we convert strings to uppercase.


Question: Given a list of lists of strings, flatten them into a single list of strings.

List<List<String>> listOfLists = Arrays.asList(
    Arrays.asList("a", "b"), 
    Arrays.asList("c", "d"), 
    Arrays.asList("e")
);
List<String> result = listOfLists.stream()
    .flatMap(List::stream)  // flattens the lists into a single stream
    .collect(Collectors.toList());  // collects them into a list

System.out.println(result);  // Output: [a, b, c, d, e]


Explanation: The flatMap method is used to flatten nested collections into a single 
stream.



Question: Remove duplicates from a list of integers.

List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
List<Integer> result = numbers.stream()
    .distinct()  // removes duplicates
    .collect(Collectors.toList());  // collects them into a list

System.out.println(result);  // Output: [1, 2, 3, 4, 5]


Explanation: The distinct method removes duplicate elements from the stream.




Question: Sort a list of names in reverse alphabetical order.

List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> result = names.stream()
    .sorted(Comparator.reverseOrder())  // sorts in reverse alphabetical order
    .collect(Collectors.toList());  // collects them into a list

System.out.println(result);  // Output: [Charlie, Bob, Alice]


Explanation: The sorted method sorts elements. Here, we used Comparator.reverseOrder() 
for reverse alphabetical sorting.


Question: Print each element in a list while converting them to uppercase.

List<String> words = Arrays.asList("apple", "banana", "cherry");
List<String> result = words.stream()
    .peek(word -> System.out.println("Before: " + word))  // prints before conversion
    .map(String::toUpperCase)  // converts to uppercase
    .peek(word -> System.out.println("After: " + word))  // prints after conversion
    .collect(Collectors.toList());

System.out.println(result);  // Output: [APPLE, BANANA, CHERRY]


Explanation: The peek method allows us to perform operations (like printing) on each 
element without modifying the stream itself.


Question: Fetch the first 3 elements from a list of integers.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> result = numbers.stream()
    .limit(3)  // limits the stream to 3 elements
    .collect(Collectors.toList());

System.out.println(result);  // Output: [1, 2, 3]


Explanation: The limit method limits the number of elements processed in the stream.



Question: Skip the first 4 elements and fetch the remaining elements from a list of integers.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> result = numbers.stream()
    .skip(4)  // skips the first 4 elements
    .collect(Collectors.toList());

System.out.println(result);  // Output: [5, 6]


Explanation: The skip method skips a specified number of elements.



Question: Print each element of a list of strings with a prefix "Item: ".

List<String> items = Arrays.asList("apple", "banana", "cherry");
items.stream()
    .forEach(item -> System.out.println("Item: " + item));  // prints each item with a prefix

// Output: 
// Item: apple
// Item: banana
// Item: cherry


Question: Collect a list of integers into a Set.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5);
Set<Integer> result = numbers.stream()
    .collect(Collectors.toSet());  // collects the stream elements into a set

System.out.println(result);  // Output: [1, 2, 3, 4, 5]


Explanation: The collect method gathers elements into a specific collection. 
Here, we collect them into a Set, which removes duplicates.


Question: Compute the product of all numbers in a list.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
int result = numbers.stream()
    .reduce(1, (a, b) -> a * b);  // multiplies all numbers

System.out.println(result);  // Output: 24


Explanation: The reduce method performs a reduction operation 
(like summing or multiplying) on elements. Here, it multiplies the numbers.


Question: Check if all numbers in a list are positive.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
boolean allPositive = numbers.stream()
    .allMatch(n -> n > 0);  // checks if all numbers are positive

System.out.println(allPositive);  // Output: true

Explanation: The allMatch method checks if all elements satisfy a condition.


Question: Check if any number in the list is greater than 10.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 11);
boolean anyGreaterThanTen = numbers.stream()
    .anyMatch(n -> n > 10);  // checks if any number is greater than 10

System.out.println(anyGreaterThanTen);  // Output: true

Explanation: The anyMatch method checks if any element satisfies a condition.



Question: Check if no elements in a list are negative.

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
boolean noneNegative = numbers.stream()
    .noneMatch(n -> n < 0);  // checks if no number is negative

System.out.println(noneNegative);  // Output: true


Explanation: The noneMatch method checks if none of the elements satisfy a condition.

Question: Find the first element in a list greater than 5.

List<Integer> numbers = Arrays.asList(3, 6, 8, 2, 9);
Optional<Integer> first = numbers.stream()
    .filter(n -> n > 5)  // filters numbers greater than 5
    .findFirst();  // finds the first matching element

System.out.println(first.orElse(-1));  // Output: 6

Explanation: The findFirst method returns the first element that matches the condition, 
wrapped in an Optional.

 */