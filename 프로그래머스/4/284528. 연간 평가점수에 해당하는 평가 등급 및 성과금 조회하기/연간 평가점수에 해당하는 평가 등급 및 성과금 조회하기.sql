SELECT J.EMP_NO, J.EMP_NAME, 
       (CASE
            WHEN J.SCORE >= 96 THEN 'S'
            WHEN J.SCORE >= 90 THEN 'A'
            WHEN J.SCORE >= 80 THEN 'B'
            ELSE 'C'
        END) AS GRADE,
        (CASE
            WHEN J.SCORE >= 96 THEN J.SAL * 0.2
            WHEN J.SCORE >= 90 THEN J.SAL * 0.15
            WHEN J.SCORE >= 80 THEN J.SAL * 0.1
            ELSE 0
        END) AS BONUS
 FROM (
        SELECT E.EMP_NO, E.EMP_NAME, AVG(G.SCORE) AS SCORE, E.SAL
        FROM HR_EMPLOYEES E
        JOIN HR_GRADE AS G ON E.EMP_NO = G.EMP_NO
        GROUP BY E.EMP_NO
      ) AS J
 ORDER BY J.EMP_NO
;