/* 
Q25. Multiple Parameter Sorting.

To sort a Java ArrayList of objects based on multiple parameters, you can use the 
Comparator interface with Comparator.comparing() and thenComparing() methods.

Example
Let's say you have a class Person with fields name, age, and salary. 
You want to sort the ArrayList first by name (alphabetically), then by age (ascending), 
and finally by salary (descending).

package JAVA;
import java.util.ArrayList;
import java.util.Comparator;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, 50000));
        people.add(new Person("Bob", 25, 70000));
        people.add(new Person("Alice", 25, 45000));
        people.add(new Person("Charlie", 35, 80000));

        // Sort by name (ascending), then age (ascending), then salary (descending)
        people.sort(Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge)
                .thenComparing(Comparator.comparing(Person::getSalary).reversed()));

        // Print the sorted list
        for (Person person : people) {
            System.out.println(person);
        }
    }
}


Output:
Person{name='Alice', age=25, salary=45000.0}
Person{name='Alice', age=30, salary=50000.0}
Person{name='Bob', age=25, salary=70000.0}
Person{name='Charlie', age=35, salary=80000.0}


Explanation:
Comparator.comparing(Person::getName): Sorts by name in ascending order.
thenComparing(Person::getAge): If names are the same, sorts by age in ascending order.
thenComparing(Comparator.comparing(Person::getSalary).reversed()): If both name and age 
are the same, sorts by salary in descending order. 
*/