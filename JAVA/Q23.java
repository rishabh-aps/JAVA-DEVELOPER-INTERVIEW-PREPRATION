/* 
Q23. Explain Data Hiding & Access Modifiers in Java.

Data Hiding is one of the key principles of Object-Oriented Programming (OOP). 
It refers to the practice of restricting access to the internal details or data of a 
class and exposing only essential parts to the outside world. This concept is closely 
related to encapsulation, where fields (or variables) are hidden from direct access and 
can only be accessed or modified through getter and setter methods.

By hiding the internal data of a class, you can control how the data is accessed or 
modified, ensuring that the internal state of an object remains consistent and secure. 
This also allows you to enforce data integrity by including validation checks in setter 
methods.

How Data Hiding Works:
Private Fields: In Java, the primary way to achieve data hiding is by declaring fields 
(variables) as private, which means they cannot be accessed directly from outside the class.

Controlled Access: Public methods (getters and setters) are provided to allow controlled 
access to these private fields, ensuring data integrity and validation.

public class Employee {
  // Private fields - hidden from outside access
  private String name;
  private int age;

  // Getter method for name
  public String getName() {
      return name;
  }

  // Setter method for name with validation
  public void setName(String name) {
      if (name != null && !name.isEmpty()) {
          this.name = name;
      } else {
          System.out.println("Invalid name.");
      }
  }

  // Getter method for age
  public int getAge() {
      return age;
  }

  // Setter method for age with validation
  public void setAge(int age) {
      if (age > 0) {
          this.age = age;
      } else {
          System.out.println("Invalid age.");
      }
  }
}

In this example:

The name and age fields are private, so they are hidden from direct access outside the 
Employee class.

Public getter and setter methods are provided to access and modify these fields, 
with validation logic in place to ensure that invalid values (like empty names or negative ages) are not set.


Access Modifiers in Java
Java provides access modifiers that define the visibility or access level of classes, 
methods, variables, and constructors. These modifiers are used to implement data hiding 
by restricting access to certain components of a class.

Java has four access modifiers:

Private
Default (No Modifier)
Protected
Public

1. Private Access Modifier (private)
The private modifier is the most restrictive. Members (fields, methods, constructors) 
declared as private can only be accessed within the same class.

Private members are not visible outside the class they are declared in, which is the 
key to achieving data hiding.

class Employee {
  private String name;  // Private field

  // Getter and setter for the private field
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
}


In this example, name is declared private, so it can only be accessed via the 
getName() and setName() methods within the same class.

2. Default Access Modifier (No Modifier)
If no access modifier is specified, the default access level is package-private. 
Members with default access are accessible only to other classes in the same package.
Default access is less restrictive than private but more restrictive than protected or 
public.

class Employee {
  String department;  // Default access, visible within the same package
}


Here, department can be accessed by any class within the same package, 
but not from classes in other packages.

3. Protected Access Modifier (protected)
The protected modifier allows access to members within the same package and by subclasses 
in different packages.
It provides more access than default but less than public. Protected members are typically 
used when you want to allow access to a subclass.

3. Protected Access Modifier (protected)
The protected modifier allows access to members within the same package and by subclasses 
in different packages.
It provides more access than default but less than public. Protected members are typically 
used when you want to allow access to a subclass.

class Employee {
  protected int employeeId;  // Accessible in subclasses and within the same package
}

class Manager extends Employee {
  void displayEmployeeId() {
      System.out.println("Employee ID: " + employeeId);  // Can access protected member
  }
}


4. Public Access Modifier (public)
The public modifier allows a class, method, or variable to be accessible from anywhere 
in the application. Members declared as public can be accessed from any other class, 
regardless of package.

Public access is the least restrictive, so be cautious when using it, as it completely 
exposes the member.

public class Employee {
  public String name;  // Public field, accessible from anywhere
}

class Main {
  public static void main(String[] args) {
      Employee emp = new Employee();
      emp.name = "John";  // Accessible from anywhere
  }
}

In this example, name is declared as public, so it can be accessed from any class in any package.

Choosing the Right Access Modifier
Use private for sensitive data that should only be accessed within the class. T
his ensures data hiding and encapsulation.

Use protected for members that should be visible to subclasses, especially in cases 
of inheritance.

Use default (package-private) when you want members to be accessible within the same 
package but not outside it.

Use public only when you need to expose members or methods globally, across 
the entire application.

 */