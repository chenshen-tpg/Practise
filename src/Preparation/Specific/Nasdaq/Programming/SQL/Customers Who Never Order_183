183. Customers Who Never Order
==============================
select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);

Select Customers.name as Customers
From Customers
left join Orders on Customers.id = Orders.CustomerId
where Orders.CustomerId IS NULL;
