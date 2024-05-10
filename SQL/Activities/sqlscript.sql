REM   Script: SQL Activities
REM   SQL Activities

-------------------------------------------------------------------------------------------------------------------------------------
-- Activity 1
-------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE salesman (salesman_id int,salesman_name varchar2(20), salesman_city varchar2(20),commission int);
describe salesman;

----------------------------------------------------------------------------------------------------------------------------
--ACTIVITY 2
-------------------------------------------------------------------------------------------------------------------------------------
--Insert single row
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);
--Insert multiple rows
INSERT ALL INTO salesman VALUES (5002,'Nail Knite','Paris',13)
        INTO salesman VALUES (5005,'Pit Alex','London',11)
        INTO salesman VALUES (5006,'McLyon','Paris',14)
        INTO salesman VALUES (5007,'Paul Adam' ,'Rome',13)
        INTO salesman VALUES (5003,'Lauson Hen' , 'San Jose' , 12)
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

-------------------------------------------------------------------------------------------------------------------------------------
--Activity3
-------------------------------------------------------------------------------------------------------------------------------------
SELECT salesman_id, salesman_city from salesman;

Select * from salesman where salesman_city ='Paris'

SELECT salesman_id,  commission from salesman where SALESMAN_NAME = 'Paul Adam'

-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY 4
-------------------------------------------------------------------------------------------------------------------------------------
ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade=100;
SELECT * from salesman;

-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY 5
-------------------------------------------------------------------------------------------------------------------------------------

UPDATE salesman SET  grade=200 where SALESMAN_CITY='Rome';
UPDATE salesman SET  grade=300 where SALESMAN_NAME='James Hoog';
UPDATE salesman SET  SALESMAN_NAME= 'Pierre' where SALESMAN_NAME= 'McLyon';

SELECT * from salesman;

-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY6
-------------------------------------------------------------------------------------------------------------------------------------

Select * from Orders;
SELECT DISTINCT SALESMAN_ID FROM Orders;
SELECT ORDER_NO,ORDER_DATE from Orders order by ORDER_DATE ASC;
SELECT ORDER_NO,PURCHASE_AMOUNT from Orders order by PURCHASE_AMOUNT DESC;
SELECT * from Orders where PURCHASE_AMOUNT >500;
SELECT * from Orders where PURCHASE_AMOUNT BETWEEN 1000 AND 2000;

-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY7
-------------------------------------------------------------------------------------------------------------------------------------
--Write an SQL statement to find the total purchase amount of all orders.
SELECT SUM(PURCHASE_AMOUNT) as Total from orders;
--Write an SQL statement to find the average purchase amount of all orders.
SELECT AVG(PURCHASE_AMOUNT) as AVG_PUR_AMT from orders;    
--Write an SQL statement to get the maximum purchase amount of all the orders.
SELECT MAX(PURCHASE_AMOUNT) as MAXIMUM from orders;
--Write an SQL statement to get the minimum purchase amount of all the orders.
SELECT MIN(PURCHASE_AMOUNT) as MINIMUM from orders;
--Write an SQL statement to find the number of salesmen listed in the table.
SELECT count(distinct SALESMAN_ID) as No_of_SalesMan  from salesman;
-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY8
-------------------------------------------------------------------------------------------------------------------------------------
--Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.
SELECT MAX(PURCHASE_AMOUNT), CUSTOMER_ID from orders group by CUSTOMER_ID;
--Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
SELECT MAX(PURCHASE_AMOUNT), ORDER_DATE, SALESMAN_ID from orders where ORDER_DATE =To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

--Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
SELECT MAX(PURCHASE_AMOUNT), ORDER_DATE, CUSTOMER_ID from orders group by CUSTOMER_ID,ORDER_DATE HAVING MAX(PURCHASE_AMOUNT) in (2030, 3450, 5760, 6000);
-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY9
-------------------------------------------------------------------------------------------------------------------------------------
-- Write an SQL statement to know which  are working for which customer.
SELECT a.SALESMAN_ID, b.CUSTOMER_ID ,b.customer_name, b.city from salesman a 
inner join customers b on a.SALESMAN_ID =b.SALESMAN_ID;   

-- Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.
SELECT a.SALESMAN_ID, a.CUSTOMER_ID , a.city, a.grade from customers a
left outer join salesman b on a.SALESMAN_ID =b.SALESMAN_ID where GRADE<300 order by CUSTOMER_ID;

-- Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
SELECT a.SALESMAN_ID, a.CUSTOMER_ID , a.city, b.commission from customers a
right outer join salesman b on a.SALESMAN_ID =b.SALESMAN_ID where b.commission>12;
 -- Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which ORDER_DATE gives the order and which salesman works for that customer and commission rate he gets for an order.
SELECT a.ORDER_NO, a.PURCHASE_AMOUNT, a.ORDER_DATE, b.CUSTOMER_NAME, b.CITY, c.SALESMAN_NAME, c.SALESMAN_CITY, c.COMMISSION
from orders a
Inner join  customers b on a.SALESMAN_ID=b.SALESMAN_ID
    Inner join salesman c on a.SALESMAN_ID=c.SALESMAN_ID
    
-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY10
-------------------------------------------------------------------------------------------------------------------------------------
-- Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * from orders where CUSTOMER_ID = (SELECT CUSTOMER_ID from customers where CUSTOMER_ID= 3007 );

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * from orders where SALESMAN_ID = (SELECT SALESMAN_ID from salesman where SALESMAN_CITY= 'London' );

-- Write a query to count the customers with grades above New York's average.
SELECT grade, count(*) as CUSTOMERS from customers GROUP BY grade HAVING GRADE >(SELECT AVG(GRADE) from CUSTOMERS where CITY='New York');

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT * from orders where SALESMAN_ID in (SELECT SALESMAN_ID from salesman where 
    COMMISSION = (SELECT Max(COMMISSION) from salesman));  
-------------------------------------------------------------------------------------------------------------------------------------
-- ACTIVITY11
-------------------------------------------------------------------------------------------------------------------------------------
-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order.
Select customer_id, customer_name from customers a
where 1< (select count(*) from orders b where a.customer_id=b.customer_id)
UNION
select SALESMAN_ID, SALESMAN_NAME from salesman a 
where 1<(select count(*) from customers b where a.SALESMAN_ID =b.SALESMAN_ID )
ORDER BY CUSTOMER_NAME;


-- Write a query to make a report of which salesman produce the largest and smallest orders on each date. Also add a column that shows "highest on" and "lowest on" values.CUSTOMER_ID
SELECT a.SALESMAN_ID,SALESMAN_NAME, ORDER_NO, 'highest on', ORDER_DATE, PURCHASE_AMOUNT from salesman a,orders b
where a.salesman_id=b.salesman_id
AND b.PURCHASE_AMOUNT= (SELECT Max(PURCHASE_AMOUNT) from orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.SALESMAN_ID,SALESMAN_NAME, ORDER_NO, 'lowest on', ORDER_DATE, PURCHASE_AMOUNT FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);;

