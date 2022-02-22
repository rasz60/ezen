CREATE TABLE product3 (p_id VARCHAR2(30) NOT NULL PRIMARY KEY,
                       p_brand VARCHAR2(30) NOT NULL,
                       p_collection VARCHAR2(30),
                       p_ename VARCHAR2(100) NOT NULL,
                       p_kname VARCHAR2(100) NOT NULL,
                       p_image VARCHAR2(30) NOT NULL,
                       p_gender VARCHAR2(30) NOT NULL,
                       p_size NUMBER NOT NULL,
                       p_price NUMBER NOT NULL,
                       p_stock NUMBER default 0 NOT NULL,
                       p_date DATE default sysdate NOT NULL,
                       p_hit NUMBER default 0 NOT NULL
                       );
                       /*category 빠짐  */
                      
DESC product;         

SELECT * FROM product; /*전체 조회 전체 뿌리기 용  */

SELECT * FROM product WHERE p_brand='nike'; /*브랜드 별 뿌리기용*/

DROP table product;
