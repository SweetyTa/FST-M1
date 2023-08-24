REM   Script: Activity 10
REM   FST Module 1

SELECT grade, COUNT(*) FROM customer 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customer WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

