
-- 1757. Recyclable and Low Fat Products
SELECT product_id FROM Products
WHERE low_fats = 'Y' and recyclable = 'y';


-- 584. Find Customer Referee
SELECT name FROM Customer WHERE referee_id <> '2' OR referee_id IS NULL;

-- 595. Big Countries

SELECT name, population, area FROM World WHERE
    population >= 25000000  or  area >= 3000000;

-- 1148. Article Views I
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY id;

-- 1683. Invalid Tweets
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;


-- 1667. Fix Names in a Table
SELECT user_id, CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) AS name
FROM Users
ORDER BY user_id;

--- 1068 Product Sales Analysis i
SELECT p.product_name, s.year, s.price
FROM Sales s, Product p
WHERE s.product_id = p.product_id;

---1581. Customer Who Visited but Did Not Make Any Transactions

SELECT customer_id, COUNT(visit_id) AS count_no_trans
FROM    Visits
WHERE visit_id NOT IN (SELECT visit_id FROM Transactions)
GROUP BY customer_id
