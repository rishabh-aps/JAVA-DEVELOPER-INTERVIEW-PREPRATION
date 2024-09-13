/* 
Q10. FlatMap in Java

In Java, flatMap() is a method used in both Streams API and Optional API that takes a 
function that returns a stream or another collection and flattens the result into a single 
stream or collection. The key idea is that flatMap() is used to transform and flatten 
nested structures (like lists of lists or streams of streams) into a 
single unified structure.

Example: Flattening a List of Lists

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FlatMapExample {
    public static void main(String[] args) {
        // List of lists (nested structure)
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("grapes", "watermelon")
        );

        // Use flatMap to flatten the structure
        List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream)  // Flatten the inner lists into a single stream
                .collect(Collectors.toList());

        // Output: [apple, banana, orange, kiwi, grapes, watermelon]
        System.out.println(flattenedList);
    }
}
 */