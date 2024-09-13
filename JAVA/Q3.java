/* 
Q3. Explain Serialization and Deserialization in Java.

Serialization is the process of converting an object into a byte stream so that it can 
be easily saved to a file, sent over a network, or stored in memory. 
Deserialization is the reverse process—converting the byte stream back into an object.

This is particularly useful in scenarios where you need to persist object states or send 
objects between systems over a network (e.g., distributed systems or APIs).

Key Points:
Serialization: Converting a Java object into a byte stream.
Deserialization: Reconstructing the object from the byte stream.
Serializable interface: A marker interface in Java that a class must implement to make its objects serializable.
transient keyword: Used to indicate that a field should not be serialized.

import java.io.*;

// The class must implement Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for version control
    String name;
    int age;

    // Fields marked as 'transient' will not be serialized
    transient String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}

class SerializationDemo {
    public static void main(String[] args) {
        Person person = new Person("John", 30, "mypassword");

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);  // Serializing the object
            System.out.println("Serialization successful: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) in.readObject();  // Deserializing the object
            System.out.println("Deserialization successful: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

Explanation:
Person class:
Implements the Serializable interface, which is required for serialization.
Contains three fields: name, age, and password. The password field is marked as transient, 
meaning it will not be serialized.
Serialization:

We use ObjectOutputStream to write the object into a file (person.ser).
The writeObject method serializes the object and stores it in the file.
Deserialization:

We use ObjectInputStream to read the object from the file.
The readObject method reconstructs the object from the file.

Output:
Serialization successful: Person{name='John', age=30, password='mypassword'}
Deserialization successful: Person{name='John', age=30, password='null'}

Notice that after deserialization, the password field is null because it was marked as transient 
and was not serialized.


 */