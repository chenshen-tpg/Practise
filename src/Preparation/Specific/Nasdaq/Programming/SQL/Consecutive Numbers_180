SELECT DISTINCT(l1.num)
AS ConsecutiveNums
FROM
LOGS L1,
LOGS L2,
LOGS L3
Where
    L1.id = L2.id -1 AND
    L2.id = L3.id - 1 AND
    L1.num = L2.num AND
    L2.num = L3.num
;