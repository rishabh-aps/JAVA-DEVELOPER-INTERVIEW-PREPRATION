/* 
Q22.Explain Encapsulation in Java

Encapsulation is one of the fundamental principles of Object-Oriented Programming (OOP) 
in Java. It is the mechanism of bundling data (variables) and the methods that operate on 
that data together into a single unit, usually a class. 
Additionally, encapsulation restricts direct access to an object's data by making the 
variables private and allows controlled access through public getter and setter methods.

Key Features of Encapsulation:
1.Private Variables: Variables (fields) of a class are declared as private, meaning they 
cannot be accessed directly from outside the class.

2.Public Getter and Setter Methods: Public methods (known as getters and setters) are 
provided to allow controlled access to the private variables. This helps maintain the 
integrity of the data and enables validation or other logic before setting values.

3.Data Hiding: Encapsulation hides the internal state of the object and only exposes 
the necessary details. This helps in maintaining the security of the data and preventing 
unauthorized access.

4.Improved Maintainability: Since the data is accessed through methods, you can change 
the implementation without affecting the external code that uses the class.

Example of Encapsulation:
// Encapsulated class
public class Employee {

    // Private fields (cannot be accessed directly outside this class)
    private String name;
    private int age;

    // Constructor to initialize the fields
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name (with validation)
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age (with validation)
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an object of the Employee class
        Employee emp = new Employee("John", 25);

        // Accessing and modifying the fields through getter and setter methods
        System.out.println("Name: " + emp.getName());  // Output: Name: John
        System.out.println("Age: " + emp.getAge());    // Output: Age: 25

        // Updating the fields using setter methods
        emp.setName("Doe");
        emp.setAge(30);

        System.out.println("Updated Name: " + emp.getName());  // Output: Updated Name: Doe
        System.out.println("Updated Age: " + emp.getAge());    // Output: Updated Age: 30

        // Trying to set invalid values
        emp.setAge(-5);  // Output: Invalid age.
        emp.setName("");  // Output: Invalid name.
    }
}


Explanation of the Example:
The Employee class has two private fields: name and age. 
These fields cannot be accessed or modified directly from outside the class.

The class provides public getter and setter methods for both name and age. 
These methods allow controlled access to the fields.

The setter methods have validation logic to ensure that the values assigned to the 
fields are valid. For example, the setAge() method ensures that the age is a positive 
number.

The Main class demonstrates how to create an instance of Employee and access the 
fields through the getter and setter methods.

 */