/* 
Q2. Find the Nth highest salary in sql

SELECT DISTINCT salary
FROM tbl_salary
ORDER BY salary DESC
LIMIT 1 OFFSET (n - 1);


The query you provided is a very efficient and valid approach to find the Nth highest 
salary in MySQL (and other databases that support LIMIT and OFFSET syntax). 
Here's an explanation of how it works:

Query:
sql
Copy code
SELECT DISTINCT salary
FROM tbl_salary
ORDER BY salary DESC
LIMIT 1 OFFSET (n - 1);
Explanation:
DISTINCT salary: This ensures that you are selecting unique salary values, 
ignoring any duplicates.

ORDER BY salary DESC: Orders the salary values in descending order, meaning the 
highest salary comes first.

LIMIT 1: Limits the result to one row (since you only want the Nth highest salary).

OFFSET (n - 1): Skips the first (n - 1) rows and returns the next row, which is the 
Nth highest salary.

For example, if n = 3 (i.e., you want the 3rd highest salary), OFFSET 2 will skip the 
first two rows and return the 3rd row. 
*/