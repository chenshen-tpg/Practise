select  visited_on ,
    (select sum(amount) from customer
    where visited_on between DATE_SUB(c.visited_on, INTERVAL 6 DAY) and c.visited_on ) as amount ,
    round((select sum(amount) from customer
    where visited_on between DATE_SUB(c.visited_on, INTERVAL 6 DAY) and c.visited_on)/7,2)as average_amount
from customer c
where c.visited_on>=(SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)FROM customer)
group by c.visited_on