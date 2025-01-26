
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