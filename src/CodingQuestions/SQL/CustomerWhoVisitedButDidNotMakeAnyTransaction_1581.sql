
SELECT customer_id, count(visit_id) AS count_no_trans
FROM Transactions
WHERE visit_id not in (SELECT visit_id FROM Transactions)
GROUP BY customer_id


SELECT
    customer_id,
    COUNT(*) AS count_no_trans
FROM
    Visits AS v
        LEFT JOIN Transactions AS t ON v.visit_id = t.visit_id
WHERE
    t.visit_id IS NULL
GROUP BY
    customer_id