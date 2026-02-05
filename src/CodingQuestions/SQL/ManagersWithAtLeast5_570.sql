select q1.person_name
from queue q1 inner join queue q2
on q1.turn  >= q2.turn
group by q1.turn
having sum(q2.weight) <= 1000
order by sum(q2.weight) desc limit 1



SELECT person_name
FROM (
    SELECT
        person_name,
        SUM(weight) OVER (ORDER BY turn) AS cumulative_weight
    FROM Queue
) t
WHERE cumulative_weight <= 1000
ORDER BY cumulative_weight DESC
LIMIT 1;