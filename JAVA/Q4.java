/* 
Q4. Singleton and Prototype

Singleton Pattern
The Singleton Pattern ensures that a class has only one instance and provides a global 
point of access to that instance. This is useful in cases where you need to coordinate 
actions across the system with a single instance of a class (e.g., managing connections 
to a database).

Key Features:
Single instance: Only one instance of the class is created.
Global access: The instance is accessible globally via a static method.

class Singleton {
  // Static variable to hold the single instance of the class
  private static Singleton instance;

  // Private constructor to prevent instantiation
  private Singleton() {
  }

  // Public method to provide access to the single instance (Lazy initialization)
  public static Singleton getInstance() {
      if (instance == null) {
          instance = new Singleton();
      }
      return instance;
  }
}

Explanation:
Private Constructor: The constructor is private so that no other class can create an 
instance using new.
Static Method: getInstance() checks if an instance already exists; if not, 
it creates one, ensuring only a single instance is created.

Thread-Safe Singleton (Eager Initialization)
For multithreaded applications, we often need to make the Singleton thread-safe. 
One way is to create the instance at the time of class loading (eager initialization).

class Singleton {
  private static final Singleton instance = new Singleton(); // Eager initialization

  private Singleton() {
  }

  public static Singleton getInstance() {
      return instance;
  }
}


Singleton Pattern
The Singleton Pattern ensures that a class has only one instance and provides a global point of access to that instance. This is useful in cases where you need to coordinate actions across the system with a single instance of a class (e.g., managing connections to a database).

Key Features:
Single instance: Only one instance of the class is created.
Global access: The instance is accessible globally via a static method.
Implementation of Singleton Pattern:
java
Copy code
public class Singleton {
    // Static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
    }

    // Public method to provide access to the single instance (Lazy initialization)
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
Explanation:
Private Constructor: The constructor is private so that no other class can create an instance using new.
Static Method: getInstance() checks if an instance already exists; if not, it creates one, ensuring only a single instance is created.
Thread-Safe Singleton (Eager Initialization)
For multithreaded applications, we often need to make the Singleton thread-safe. One way is to create the instance at the time of class loading (eager initialization).

java
Copy code
public class Singleton {
    private static final Singleton instance = new Singleton(); // Eager initialization

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
Use Cases of Singleton:
Database connection management.
Logging systems.
Configuration or settings management in applications.


Prototype Pattern
The Prototype Pattern is used to create new objects by copying an existing object, 
called the prototype, rather than creating new instances from scratch. 
This is useful when creating a new object is costly or complex, and a similar object 
already exists.

Key Features:
Clone existing objects: Instead of creating new objects from scratch, clone an existing one.
Shallow or deep cloning: You can decide whether to copy the reference (shallow clone) or 
duplicate the whole object (deep clone).


Implementation of Prototype Pattern:
1.Prototype Interface: This interface will have a clone method.

public interface Prototype extends Cloneable {
  Prototype clone();
}

2.Concrete Class: Implement the clone method for the object that can be cloned.
public class Person implements Prototype {
  private String name;
  private int age;

  public Person(String name, int age) {
      this.name = name;
      this.age = age;
  }

  // Implement clone method to create a shallow copy
  @Override
  public Person clone() {
      try {
          return (Person) super.clone();  // Shallow copy
      } catch (CloneNotSupportedException e) {
          e.printStackTrace();
          return null;
      }
  }

  @Override
  public String toString() {
      return "Person{name='" + name + "', age=" + age + "}";
  }
}

Explanation:
Cloneable Interface: A class must implement Cloneable and override the clone method from 
Object to allow cloning.
Shallow Copy: The clone() method here creates a shallow copy, meaning only the reference 
to fields is copied, not the actual objects they point to.

public class PrototypeDemo {
  public static void main(String[] args) {
      // Create original object
      Person person1 = new Person("John", 25);

      // Clone the object
      Person person2 = person1.clone();

      System.out.println(person1);  // Output: Person{name='John', age=25}
      System.out.println(person2);  // Output: Person{name='John', age=25}
  }
}

Deep Cloning:
If you want to create a deep copy, meaning you duplicate the objects that are referenced inside your object, you need to manually clone each nested object.

Use Cases of Prototype:
When object creation is expensive and an existing object can be reused or cloned.
Game development: Cloning game objects like enemies, characters, etc.
Customizing cloned objects for different uses.

In summary:

Use Singleton when you need to control object creation and ensure there is only one instance.
Use Prototype when you want to avoid expensive object creation by cloning an existing object.
 */