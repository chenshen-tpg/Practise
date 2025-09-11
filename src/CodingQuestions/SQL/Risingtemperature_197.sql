SELECT w1.id
FROM Weather w1
         JOIN Weather w2
              ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;



SELECT A.id
FROM
    WEATHER A,
    WEATHER B
WHERE DATEDIFF(A.recordDate, B.recordDate) = 1 AND A.temperature >= B.temperature;




SELECT
    w1.id
FROM
    Weather w1
        JOIN
    Weather w2
    ON
        DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE
    w1.temperature > w2.temperature;