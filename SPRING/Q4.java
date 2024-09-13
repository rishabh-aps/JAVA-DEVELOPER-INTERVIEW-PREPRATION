/* 
Q4. Eager and Lazy Fetching

In Java, particularly in frameworks like Hibernate (which is a popular ORM tool), 
fetching strategies determine how and when related entities are loaded from the database. 
The two main fetching strategies are Eager Fetching and Lazy Fetching.

1.Eager Fetching (FetchType.EAGER)
Eager Fetching means that the related entities are loaded immediately when the parent entity
is loaded, even if you don’t need the related data.

This can lead to performance issues if you load a lot of unnecessary data upfront.

Eager fetching is generally used when you are sure that the related data will always be 
needed.

@Entity
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Eager fetching - Department will be loaded immediately with Employee
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;
}

Here, when an Employee is fetched, the associated Department is also fetched immediately, 
even if it is not used in the current operation.


2.Lazy Fetching (FetchType.LAZY)
Lazy Fetching means that the related entities are loaded only when they are accessed 
(i.e., when they are needed).

This can improve performance by avoiding unnecessary data loading.

Lazy fetching is useful when you have large datasets or when related data is not 
always required.

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Lazy fetching - Department will be loaded only when accessed
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
}


In this case, when an Employee is fetched, the Department associated with that employee is 
not fetched immediately. It will be fetched only when you explicitly access it, like 
employee.getDepartment().
 */