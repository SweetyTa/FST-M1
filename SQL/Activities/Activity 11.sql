REM   Script: Activity 11
REM   FST Module 1

SELECT customer_id, custname FROM customer a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, salesman_name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY custname;

SELECT a.salesman_id, salesman_name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, salesman_name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

