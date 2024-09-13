/* 
Q12. Wrapper classes

Wrapper classes in Java are used to convert primitive data types (e.g., int, char, boolean)
into objects. This is particularly useful when working with collections that only store 
objects (like ArrayList, HashMap), or when you need to perform operations that require 
objects instead of primitives.

Each primitive type has a corresponding wrapper class:

Primitive Type	Wrapper Class
int	            Integer
char	          Character
boolean	        Boolean
byte	          Byte
short	          Short
long	          Long
float	          Float
double	        Double

class WrapperExample {
  public static void main(String[] args) {
      // Primitive to Wrapper Object (Boxing)
      int primitiveInt = 5;
      Integer wrapperInt = Integer.valueOf(primitiveInt);  // Explicit boxing
      Integer autoBoxedInt = primitiveInt;  // Auto-boxing (implicitly done by Java)

      // Wrapper Object to Primitive (Unboxing)
      int unboxedInt = wrapperInt.intValue();  // Explicit unboxing
      int autoUnboxedInt = wrapperInt;  // Auto-unboxing (implicitly done by Java)

      // Using wrapper class in a collection
      java.util.List<Integer> numbers = new java.util.ArrayList<>();
      numbers.add(10);  // Auto-boxing primitive to Integer
      numbers.add(20);
      System.out.println(numbers);  // Output: [10, 20]
  }
}


Key Features of Wrapper Classes:
1.Boxing/Unboxing: The process of converting a primitive to its corresponding wrapper 
class is called boxing, and converting back to a primitive is unboxing.
2.Auto-boxing/Auto-unboxing: Java automatically converts between primitives and their 
wrapper objects, so you don’t have to manually box and unbox them.

Why Wrapper Classes?
Collections: Primitive types cannot be used in collections like ArrayList, HashMap, etc. 
You must use their wrapper class equivalents (e.g., Integer, Double).
Utility Methods: Wrapper classes provide useful methods, like Integer.parseInt(), 
for converting String to an int, and Double.isNaN() for checking if a double value is not 
a number.
 */