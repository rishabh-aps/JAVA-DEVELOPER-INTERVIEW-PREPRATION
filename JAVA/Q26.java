/* 
Q26.How ArrayList work internally.

1. Initial Capacity and Storage
When you create an ArrayList, it internally creates an array (Object[]) to store the 
elements. The default initial capacity is 10, but you can specify a different capacity 
when you instantiate it.

ArrayList<String> list = new ArrayList<>();  // Default initial capacity = 10
ArrayList<String> listWithCapacity = new ArrayList<>(20);  // Initial capacity = 20


2. Adding Elements
When you add an element to the ArrayList, it adds the element to the array at the next 
available index.

list.add("element");  // Adds "element" at the end of the list
Capacity Check: Before adding the element, the ArrayList checks if there is enough 
capacity in the internal array to hold the new element. If the internal array is full, 
the array is resized.

3. Resizing the Internal Array
If the internal array reaches its capacity, a new array is created with a 
larger size (typically 1.5 times the current size).

A new array with increased capacity is created.
The old elements are copied into the new array.
The reference to the old array is discarded.

The resizing process is relatively costly (O(n)), but it happens only when the array needs to grow.

private void grow() {
  int oldCapacity = array.length;
  int newCapacity = oldCapacity + (oldCapacity >> 1);  // 1.5 times the old capacity
  array = Arrays.copyOf(array, newCapacity);  // Copy elements to new array
}

4. Accessing Elements
Accessing elements by index is very efficient (O(1)) because the ArrayList is backed 
by an array. You can directly access any element using its index:

String element = list.get(0);  // Access the first element

5. Inserting or Removing Elements
Insertion at the end of the list is efficient (O(1)) if there's enough capacity.

Inserting or removing elements in the middle of the ArrayList involves shifting the 
subsequent elements to maintain the order, which has a time complexity of O(n).

list.add(2, "newElement");  // Insert at index 2, shift all elements from index 2 onward
list.remove(1);  // Remove element at index 1, shift elements left

Internally, the ArrayList uses System.arraycopy() to shift elements efficiently.

6. Capacity vs. Size
The size of the ArrayList refers to the number of elements it currently holds, 
while the capacity refers to the size of the internal array. 
The capacity can be larger than the size.

ensureCapacity() can be used to manually increase the capacity if you know you need 
to add many elements.
trimToSize() can be used to reduce the capacity to match the current size 
and save memory.

7. Type Safety
Internally, ArrayList uses an Object[] array, but when you declare an ArrayList<String>, 
it works with type safety due to Java's generics system. During compilation, type checks 
are applied to ensure only String objects are added to the list.

8. Iterating Elements
Iterating through an ArrayList can be done in O(n), where n is the number of elements, 
as it simply loops through the internal array. The most common way to iterate is through 
a for-each loop or using an iterator.

 */