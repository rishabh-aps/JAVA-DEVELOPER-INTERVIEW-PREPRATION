/* 
Q18. Explain Abstraction.

Abstraction in Java
Abstraction in Java is the process of hiding the internal details of an implementation 
and showing only the essential features or functionalities to the user. It allows you to 
focus on what an object does rather than how it does it.

Java achieves abstraction using two key mechanisms:

1.Abstract Classes: These are classes that can have both abstract methods 
(without implementation) and concrete methods (with implementation). 
They provide partial abstraction and can be extended by other classes.

Example: abstract class Vehicle { abstract void start(); }

2.Interfaces: These define a contract (only abstract methods or default methods) that 
implementing classes must follow. They provide 100% abstraction.

Example: interface Animal { void sound(); }

Key Points:
Abstraction allows you to focus on essential functionalities, hiding the complexity behind 
the scenes.
Abstract classes and interfaces enable abstraction by allowing other classes to implement 
or extend them.

Real-Life Example:
Think of a TV remote: You only interact with buttons (interface) to change channels or 
volume without knowing the internal electronics (implementation). This is 
abstraction—showing essential features while hiding complexity.

 */