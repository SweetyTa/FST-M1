REM   Script: Activity 9
REM   FST Module 1

create table customer (custid int, salesman_id int, custname varchar(23) NOT NULL, contactname varchar(20), city varchar(30), postalcode varchar(10), country varchar(10), grade int)  
;

insert into customer (custid, salesman_id, custname, contactname, city, grade) values(1000, 10 ,'Ram', 'manager', 'Delhi', 100) 
;

insert into customer (custid, salesman_id, custname, contactname, city, grade) values(2000, 20, 'Sita', 'manager', 'Mumbai',200)  
;

insert into customer (custid, salesman_id, custname, contactname, city, grade) values(3000, 30, 'Gita', 'manager', 'Kolkata',400)  
;

CREATE TABLE salesman (salesman_id int, grade int, salesman_name varchar2(32), salesman_city varchar2(32),commission int) 
;

INSERT ALL  
    INTO salesman VALUES(5005, 10,'Pit Alex', 'London', 11)  
    INTO salesman VALUES(5006, 30,'McLyon', 'Paris', 14)  
    INTO salesman VALUES(5007,40, 'Paul Adam', 'Rome', 13)  
    INTO salesman VALUES(5003,50, 'Lauson Hen', 'San Jose', 12)  
SELECT 1 FROM DUAL;

create table orders(  
    order_no int primary key, purchase_amount float, order_date date,  
    customer_id int, salesman_id int);

INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL;

SELECT a.custname AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customer a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.custname, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city FROM customer a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.custid;

SELECT a.custname AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customer a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.custname AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customer b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.custname AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customer b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

