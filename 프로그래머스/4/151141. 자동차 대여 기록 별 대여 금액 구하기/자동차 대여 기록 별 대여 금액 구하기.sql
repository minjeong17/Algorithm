-- 코드를 입력하세요
WITH DATE_DIFF AS (
    SELECT H.HISTORY_ID, C.CAR_TYPE, C.DAILY_FEE, DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS DIFF
     FROM CAR_RENTAL_COMPANY_CAR C
     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
     WHERE C.CAR_TYPE = '트럭'
)

SELECT D.HISTORY_ID, (DAILY_FEE * ((100 - IFNULL(DISCOUNT_RATE, 0)) / 100) * DIFF) AS FEE
 FROM DATE_DIFF D
 LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON D.CAR_TYPE = P.CAR_TYPE && 
                                            (CASE WHEN D.DIFF >= 90 THEN P.DURATION_TYPE = '90일 이상'
                                                  WHEN D.DIFF >= 30 THEN P.DURATION_TYPE = '30일 이상'
                                                  WHEN D.DIFF >= 7 THEN P.DURATION_TYPE = '7일 이상'
                                             END)
 ORDER BY FEE DESC, D.HISTORY_ID DESC
;