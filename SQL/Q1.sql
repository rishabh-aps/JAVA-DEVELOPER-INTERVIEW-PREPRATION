/* 
Q1. Aggregate Functions in SQL

In SQL, aggregate functions are functions that perform a calculation on a set of values 
and return a single value. They are commonly used in conjunction with the GROUP BY clause 
to group rows that share a property and apply an aggregate function to each group.


Common Aggregate Functions in SQL:
1.COUNT(): Returns the number of rows (or non-NULL values) in a result set.
2.SUM(): Returns the sum of numeric values.
3.AVG(): Returns the average of numeric values.
4.MAX(): Returns the maximum value from a set of values.
5.MIN(): Returns the minimum value from a set of values.

Example Table: sales

| id  | product_name | quantity | price |
|-----|--------------|----------|-------|
| 1   | Laptop       | 5        | 1000  |
| 2   | Phone        | 10       | 500   |
| 3   | Laptop       | 3        | 1200  |
| 4   | Headphones   | 7        | 100   |
| 5   | Phone        | 8        | 550   |


1.COUNT()
The COUNT() function is used to count the number of rows or non-NULL values in a column.

SELECT COUNT(*) AS total_sales
FROM sales;

| total_sales |
|-------------|
| 5           |
This counts the total number of rows in the sales table.

2. SUM()
The SUM() function returns the total sum of a numeric column.

SELECT SUM(quantity) AS total_quantity
FROM sales;

| total_quantity |
|----------------|
| 33             |
This returns the total quantity sold.

3. AVG()
The AVG() function returns the average value of a numeric column.

SELECT AVG(price) AS average_price
FROM sales;

| average_price |
|---------------|
| 670.00        |
This calculates the average price of all products.

4. MAX()
The MAX() function returns the maximum value from a column.

SELECT MAX(price) AS max_price
FROM sales;

| max_price |
|-----------|
| 1200      |

This returns the maximum price of products sold.

5. MIN()
The MIN() function returns the minimum value from a column.

SELECT MIN(price) AS min_price
FROM sales;

| min_price |
|-----------|
| 100       |
This returns the minimum price of products sold.

Using Aggregate Functions with GROUP BY
You can use aggregate functions with the GROUP BY clause to group rows 
based on one or more columns and then apply aggregate functions to each group.

Example: Total Quantity Sold by Product
SELECT product_name, SUM(quantity) AS total_quantity_sold
FROM sales
GROUP BY product_name;


output:
| product_name | total_quantity_sold |
|--------------|---------------------|
| Laptop       | 8                   |
| Phone        | 18                  |
| Headphones   | 7                   |


Here, the SUM() function calculates the total quantity sold for each product, 
and the GROUP BY groups the rows by product_name.

Example: Maximum Price by Product
SELECT product_name, MAX(price) AS highest_price
FROM sales
GROUP BY product_name;

Output:
| product_name | highest_price |
|--------------|---------------|
| Laptop       | 1200          |
| Phone        | 550           |
| Headphones   | 100           |

This finds the highest price for each product by grouping the sales data by product 
name and using the MAX() function.



In SQL, aggregate functions are functions that perform a calculation on a set of values and return a single value. They are commonly used in conjunction with the GROUP BY clause to group rows that share a property and apply an aggregate function to each group.

Common Aggregate Functions in SQL:
COUNT(): Returns the number of rows (or non-NULL values) in a result set.
SUM(): Returns the sum of numeric values.
AVG(): Returns the average of numeric values.
MAX(): Returns the maximum value from a set of values.
MIN(): Returns the minimum value from a set of values.
Example Table: sales
sql
Copy code
| id  | product_name | quantity | price |
|-----|--------------|----------|-------|
| 1   | Laptop       | 5        | 1000  |
| 2   | Phone        | 10       | 500   |
| 3   | Laptop       | 3        | 1200  |
| 4   | Headphones   | 7        | 100   |
| 5   | Phone        | 8        | 550   |
1. COUNT()
The COUNT() function is used to count the number of rows or non-NULL values in a column.

Example:
sql
Copy code
SELECT COUNT(*) AS total_sales
FROM sales;
Output:

lua
Copy code
| total_sales |
|-------------|
| 5           |
This counts the total number of rows in the sales table.

2. SUM()
The SUM() function returns the total sum of a numeric column.

Example:
sql
Copy code
SELECT SUM(quantity) AS total_quantity
FROM sales;
Output:

lua
Copy code
| total_quantity |
|----------------|
| 33             |
This returns the total quantity sold.

3. AVG()
The AVG() function returns the average value of a numeric column.

Example:
sql
Copy code
SELECT AVG(price) AS average_price
FROM sales;
Output:

lua
Copy code
| average_price |
|---------------|
| 670.00        |
This calculates the average price of all products.

4. MAX()
The MAX() function returns the maximum value from a column.

Example:
sql
Copy code
SELECT MAX(price) AS max_price
FROM sales;
Output:

lua
Copy code
| max_price |
|-----------|
| 1200      |
This returns the maximum price of products sold.

5. MIN()
The MIN() function returns the minimum value from a column.

Example:
sql
Copy code
SELECT MIN(price) AS min_price
FROM sales;
Output:

lua
Copy code
| min_price |
|-----------|
| 100       |
This returns the minimum price of products sold.

Using Aggregate Functions with GROUP BY
You can use aggregate functions with the GROUP BY clause to group rows based on one or more columns and then apply aggregate functions to each group.

Example: Total Quantity Sold by Product
sql
Copy code
SELECT product_name, SUM(quantity) AS total_quantity_sold
FROM sales
GROUP BY product_name;
Output:

lua
Copy code
| product_name | total_quantity_sold |
|--------------|---------------------|
| Laptop       | 8                   |
| Phone        | 18                  |
| Headphones   | 7                   |
Here, the SUM() function calculates the total quantity sold for each product, and the GROUP BY groups the rows by product_name.

Example: Maximum Price by Product
sql
Copy code
SELECT product_name, MAX(price) AS highest_price
FROM sales
GROUP BY product_name;
Output:

lua
Copy code
| product_name | highest_price |
|--------------|---------------|
| Laptop       | 1200          |
| Phone        | 550           |
| Headphones   | 100           |
This finds the highest price for each product by grouping the sales data by product name and using the MAX() function.

Using Aggregate Functions with HAVING
The HAVING clause is used to filter the results of a GROUP BY based on an 
aggregate function, which cannot be done using the WHERE clause.

Example: Products Sold More than 10 Units
SELECT product_name, SUM(quantity) AS total_quantity_sold
FROM sales
GROUP BY product_name
HAVING SUM(quantity) > 10;

Output:
| product_name | total_quantity_sold |
|--------------|---------------------|
| Phone        | 18                  |

This filters the result to show only products where the total 
quantity sold is greater than 10.

In Summary:
COUNT(): Counts rows or non-NULL values.
SUM(): Returns the sum of numeric values.
AVG(): Returns the average of numeric values.
MAX(): Returns the maximum value.
MIN(): Returns the minimum value.
These aggregate functions are often used with GROUP BY to perform calculations 
on groups of rows, and with HAVING to filter groups based on conditions related 
to aggregate functions.
 */