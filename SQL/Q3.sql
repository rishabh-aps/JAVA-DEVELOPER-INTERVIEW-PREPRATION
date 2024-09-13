/* 

Q4. SQL Joins

SQL joins are used to retrieve data from two or more tables based on a related column 
between them. Here are the main types of SQL joins with examples.

Types of SQL Joins:
1.INNER JOIN
2.LEFT (OUTER) JOIN
3.RIGHT (OUTER) JOIN
4.FULL (OUTER) JOIN
5.CROSS JOIN
6.SELF JOIN

1. INNER JOIN
Description: Returns records that have matching values in both tables.
Use Case: When you want only the rows that have matching values in both tables.

Example:
Suppose we have two tables:

Employees Table:

employee_id	name	department_id
1	          John	101
2	          Sarah	102
3	          Mike	NULL
4	          Emma	101

Departments Table:

department_id	department_name
101	          HR
102	          Sales
103	          Marketing

SELECT employees.name, departments.department_name
FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id;

Output:
name	department_name
John	HR
Sarah	Sales
Emma	HR

Explanation: Only the employees with matching department_id in both tables are returned.

2. LEFT (OUTER) JOIN
Description: Returns all records from the left table, and the matched records from the 
right table. If no match exists, NULL is returned for columns from the right table.
Use Case: When you want to keep all rows from the left table, even if there are no 
matches in the right table.

SELECT employees.name, departments.department_name
FROM employees
LEFT JOIN departments ON employees.department_id = departments.department_id;


Output:
name	department_name
John	HR
Sarah	Sales
Mike	NULL
Emma	HR

Explanation: All employees are returned, even if they don’t belong to a department 
(like Mike, whose department_id is NULL).



SQL joins are used to retrieve data from two or more tables based on a related column between them. Here are the main types of SQL joins with examples.

Types of SQL Joins:
INNER JOIN
LEFT (OUTER) JOIN
RIGHT (OUTER) JOIN
FULL (OUTER) JOIN
CROSS JOIN
SELF JOIN
1. INNER JOIN
Description: Returns records that have matching values in both tables.
Use Case: When you want only the rows that have matching values in both tables.
Example:
Suppose we have two tables:

Employees Table:

employee_id	name	department_id
1	John	101
2	Sarah	102
3	Mike	NULL
4	Emma	101
Departments Table:

department_id	department_name
101	HR
102	Sales
103	Marketing
Query:
sql
Copy code
SELECT employees.name, departments.department_name
FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id;
Output:
name	department_name
John	HR
Sarah	Sales
Emma	HR
Explanation: Only the employees with matching department_id in both tables are returned.

2. LEFT (OUTER) JOIN
Description: Returns all records from the left table, and the matched records from the right table. If no match exists, NULL is returned for columns from the right table.
Use Case: When you want to keep all rows from the left table, even if there are no matches in the right table.
Query:
sql
Copy code
SELECT employees.name, departments.department_name
FROM employees
LEFT JOIN departments ON employees.department_id = departments.department_id;
Output:
name	department_name
John	HR
Sarah	Sales
Mike	NULL
Emma	HR
Explanation: All employees are returned, even if they don’t belong to a department (like Mike, whose department_id is NULL).

3. RIGHT (OUTER) JOIN
Description: Returns all records from the right table, and the matched records from 
the left table. If no match exists, NULL is returned for columns from the left table.
Use Case: When you want to keep all rows from the right table, even if there are no 
matches in the left table.

SELECT employees.name, departments.department_name
FROM employees
RIGHT JOIN departments ON employees.department_id = departments.department_id;

name	department_name
John	HR
Sarah	Sales
Emma	HR
NULL	Marketing

Explanation: All departments are returned, even if there are no employees in 
that department (e.g., Marketing).

4. FULL (OUTER) JOIN
Description: Returns all records when there is a match in either table. 
If there is no match, NULL values are returned for columns from the missing side.
Use Case: When you want to keep all rows from both tables, even if there are no matches.

SELECT employees.name, departments.department_name
FROM employees
FULL OUTER JOIN departments ON employees.department_id = departments.department_id;

Output:
name	department_name
John	HR
Sarah	Sales
Mike	NULL
Emma	HR
NULL	Marketing

Explanation: This returns all rows from both tables. Mike from the employees table has 
no department, and the Marketing department has no employees, so NULL is used where 
there is no match.

5. CROSS JOIN
Description: Returns the Cartesian product of the two tables, i.e., each row in the 
first table is paired with every row in the second table.
Use Case: When you want all possible combinations between two tables.

SELECT employees.name, departments.department_name
FROM employees
CROSS JOIN departments;


Output:
name	department_name
John	HR
John	Sales
John	Marketing
Sarah	HR
Sarah	Sales
Sarah	Marketing
Mike	HR
Mike	Sales
Mike	Marketing
Emma	HR
Emma	Sales
Emma	Marketing

Explanation: Each employee is paired with each department, 
resulting in the Cartesian product.

6. SELF JOIN
Description: A SELF JOIN is a regular join but where a table is joined with itself.
Use Case: When you want to compare rows in a table with other rows in the same table.

Example:
Suppose you have a managers table that includes employees and their managers 
(where managers are also employees).

Employees Table:
employee_id	name	manager_id
1	          John	2
2	          Sarah	NULL
3	          Mike	1
4	          Emma	1

Query:
SELECT e1.name AS Employee, e2.name AS Manager
FROM employees e1
LEFT JOIN employees e2 ON e1.manager_id = e2.employee_id;


Output:
Employee	Manager
John	    Sarah
Sarah	    NULL
Mike	    John
Emma	    John

Explanation: The SELF JOIN joins the employees table with itself to get the name 
of each employee is manager.


 */