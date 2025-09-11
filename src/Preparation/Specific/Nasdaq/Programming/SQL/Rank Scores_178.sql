178. Rank Scores
================

SELECT
S1.score,
(
  SELECT
    COUNT(DISTINCT S2.score)
  FROM
    Scores S2
  WHERE
    S2.score >= S1.score
) AS 'rank'
FROM
Scores S1
ORDER BY
S1.score DESC;


SELECT
  S.score,
  DENSE_RANK() OVER (
    ORDER BY
      S.score DESC
  ) AS 'rank'
FROM
  Scores S;


SELECT
  S.score,
  COUNT(DISTINCT T.score) AS 'rank'
FROM
  Scores S
  INNER JOIN Scores T ON S.score <= T.score
GROUP BY
  S.id,
  S.score
ORDER BY
  S.score DESC;
====================