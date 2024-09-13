/* 
Q1.Is Java pass by value or by reference?

A1.Java is pass-by-value, but this concept can be a bit confusing because of how 
it works with objects and primitives. Let me explain.

For primitives (like int, double, etc.):
When you pass a primitive value to a method, Java passes a copy of the value. 
Changes made to this value inside the method do not affect the original variable.

class Test {
  public static void main(String[] args) {
      int num = 5;
      modifyPrimitive(num);
      System.out.println(num);  // Output will be 5, the original value
  }

  public static void modifyPrimitive(int x) {
      x = 10;  // Only changes the copy of the value, not the original 'num'
  }
}


For objects (like String, ArrayList, custom objects):
Java passes the reference to the object by value. This means you get a copy of the 
reference to the object, not the object itself. If you modify the object's fields, 
it will affect the original object, but reassigning the reference will not change 
the original object outside the method.

class Test {
    public static void main(String[] args) {
        Person person = new Person("John");
        modifyObject(person);
        System.out.println(person.name);  // Output will be "Jane" because we modified the object
    }

    public static void modifyObject(Person p) {
        p.name = "Jane";  // Modifies the object because we're working with the same reference
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}

But, if you try to reassign the reference inside the method, 
it won’t affect the original object:

class Test {
  public static void main(String[] args) {
      Person person = new Person("John");
      reassignObject(person);
      System.out.println(person.name);  // Output will still be "John"
  }

  public static void reassignObject(Person p) {
      p = new Person("Jane");  // Reassigns the local reference, but the original 'person' is unchanged
  }
}
*/