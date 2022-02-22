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
                       /*category ����  */
                      
DESC product;         

SELECT * FROM product; /*��ü ��ȸ ��ü �Ѹ��� ��  */

SELECT * FROM product WHERE p_brand='nike'; /*�귣�� �� �Ѹ����*/

DROP table product;
