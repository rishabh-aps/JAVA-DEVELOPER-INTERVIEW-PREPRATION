/* 
Q17. Write your own immutable class.

Creating an immutable class in Java means creating a class whose objects' state cannot be 
changed after they are created. To achieve immutability, we must follow certain principles, 
such as:

Make all fields private and final.
Do not provide setter methods.
Initialize all fields via the constructor.
Ensure that the class cannot be subclassed by declaring it final.
If a field is mutable, return a deep copy of it, not the actual reference.

Example: Immutable Person Class

// Mark the class as final so it cannot be subclassed
public final class Person {

  // Private and final fields
  private final String name;
  private final int age;

  // Constructor initializes all fields
  public Person(String name, int age) {
      this.name = name;
      this.age = age;
  }

  // Only provide getter methods, no setters
  public String getName() {
      return name;
  }

  public int getAge() {
      return age;
  }

  // No methods to modify the fields (no setters or mutable field accessors)
  
  // Override toString for easy object printing
  @Override
  public String toString() {
      return "Person{name='" + name + "', age=" + age + "}";
  }
}

Using the Immutable Person Class:

public class Main {
  public static void main(String[] args) {
      // Creating an instance of the immutable Person class
      Person person = new Person("John", 30);
      
      // Accessing the immutable fields
      System.out.println(person.getName());  // Output: John
      System.out.println(person.getAge());   // Output: 30
      
      // Trying to modify the fields (this won't work because there are no setters)
      // person.setName("Doe");  // Not allowed, as no setter method exists

      // Printing the person object
      System.out.println(person);  // Output: Person{name='John', age=30}
  }
}


Explanation:
Final Class: The class is declared final to prevent it from being subclassed. 
This ensures that no one can create a subclass that might break the immutability by 
introducing setter methods.

Private and Final Fields: The fields name and age are private (to prevent direct access) 
and final (to ensure they can only be assigned once). Once initialized, their values 
cannot be changed.

Constructor Initialization: All fields are initialized in the constructor, which makes 
sure the object is fully initialized when created.

No Setter Methods: There are no setter methods or ways to modify the object's state 
after creation.

Returning Values Safely: The getter methods return the actual field values, but since 
String is immutable and int is a primitive, there's no risk of modifying the internal state.
 */