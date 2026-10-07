# Write your MySQL query statement below
SELECT DISTINCT P.PRODUCT_ID, IFNULL(J.NEW_PRICE, 10) AS PRICE
 FROM PRODUCTS P
 LEFT JOIN (SELECT PRODUCT_ID, NEW_PRICE, 
                ROW_NUMBER() OVER (
                    PARTITION BY PRODUCT_ID
                    ORDER BY CHANGE_DATE DESC
                ) AS RN
            FROM PRODUCTS
            WHERE CHANGE_DATE <= '2019-08-16'
            ) J ON P.PRODUCT_ID = J.PRODUCT_ID AND J.RN = 1
;