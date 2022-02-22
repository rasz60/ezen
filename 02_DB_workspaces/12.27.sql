SELECT ename , comm
FROM emp
WHERE comm < (SELECT comm FROM emp WHERE ename = 'WARD');

-- WHERE를 수행한 후에 ORDER BY로 정렬
SELECT *
FROM emp
WHERE rownum < 5
ORDER BY sal DESC;

-- ORDER BY로 정렬된 테이블에서 WHERE 조건 수행 ( SUB-Query :: TOP-n Query )
SELECT *
FROM ( SELECT *
       FROM emp
       ORDER BY sal DESC )
WHERE rownum < 5;

-- 단일행 subQuery 연습문제
SELECT s.name , d.dname
FROM student s , department d
WHERE deptno1 = (SELECT deptno1 
                 FROM student
                 WHERE name = 'Anthony Hopkins')
AND s.deptno1 = d.deptno;

SELECT p.name , TO_CHAR(p.hiredate, 'YYYY-MM-DD') "HIREDATE" , d.dname
FROM professor p , department d
WHERE hiredate > ( SELECT hiredate 
                   FROM professor
                   WHERE name = 'Meg Ryan')
AND p.deptno = d.deptno;

SELECT name , weight
FROM student
WHERE weight > (SELECT AVG(weight)
                FROM student 
                WHERE deptno1= 201);


SELECT empno , name , deptno 
FROM emp2
WHERE deptno IN(SELECT dcode 
                FROM dept2 
                WHERE area = 'Pohang Main Office');

SELECT * FROM dept
WHERE EXISTS( SELECT deptno
              FROM dept
              WHERE deptno = &dno );

SELECT * FROM dept
WHERE deptno IN( SELECT deptno
                 FROM dept
                 WHERE deptno = &dno );

-- 다중행 subQuery 연습문제
SELECT name , position , TO_CHAR(pay, '$999,999,999') "SALARY"
FROM emp2
WHERE pay > ANY(SELECT pay
                FROM emp2
                WHERE position = 'Section head')
ORDER BY pay DESC;

SELECT name , grade , weight
FROM student
WHERE weight < ALL(SELECT weight
                   FROM student
                   WHERE grade = 2);

SELECT d.dname , e.name , TO_CHAR(e.pay , '$999,999,999') "SALARY"
FROM emp2 e, dept2 d
WHERE e.pay < ALL(SELECT AVG(pay) "AVG_PAY"
                  FROM emp2
                  GROUP BY deptno)
AND e.deptno = d.dcode
ORDER BY pay;


SELECT grade , name , weight
FROM student
WHERE ( grade , weight ) IN ( SELECT grade , MAX(weight)
                              FROM student
                              GROUP BY grade )
ORDER BY 1;

-- 다중칼럼 subQuery 연습문제
SELECT p.profno, p.name "PROF_NAME" , TO_CHAR(p.hiredate, 'YYYY-MM-DD') "HIREDATE" , d.dname "DEPT_NAME" 
FROM professor p, department d
WHERE ( p.deptno, p.hiredate ) IN ( SELECT deptno , MIN(hiredate)
                                    FROM professor
                                    GROUP BY deptno )
AND p.deptno = d.deptno
ORDER BY 3;

SELECT name , position , TO_CHAR(pay, '$999,999,999') "SALARY"
FROM emp2
WHERE ( position , pay ) IN ( SELECT position , MAX(pay) 
                              FROM emp2
                              GROUP BY position )
ORDER BY 3;

-- 상호연관 subQuery : Main Query의 값이 subQuery에 포함되어, subQuery 수행 전 main에 값을 불러오기위해 main이 실행되고 sub를 마친 뒤 다시 main이 실행되므로 성능이 떨어짐
SELECT name , position , TO_CHAR(pay, '$999,999,999') "SALARY"
FROM emp2 a
WHERE pay >= ( SELECT AVG(pay)
               FROM emp2 b
               WHERE a.position = b.position )
ORDER BY 3;

-- Scalar-subQuery
CREATE TABLE t3
( no        NUMBER ,
  name      VARCHAR2(10) ,
  deptno    NUMBER ) ;

CREATE TABLE t4
( deptno    NUMBER ,
  dname     VARCHAR2(10) );

INSERT INTO t3 VALUES(1, 'AAA', 100);
INSERT INTO t3 VALUES(2, 'BBB', 200);
INSERT INTO t3 VALUES(3, 'CCC', 300);

INSERT INTO t4 VALUES(100, 'DDD');
INSERT INTO t4 VALUES(100, 'EEE');
INSERT INTO t4 VALUES(200, 'FFF');
INSERT INTO t4 VALUES(300, 'GGG');

COMMIT;

SELECT t3.no , t3.name , ( SELECT dname FROM t4 WHERE t3.deptno = t4.deptno ) -- select와 FROM 사이에 들어가는 select문이 Scalar-subQuery
FROM t3;                                                                    -- deptno가 동일한 값이 2개 있으므로 출력 불가

UPDATE t4
SET deptno = 400
WHERE dname = 'DDD';

SELECT t3.no , t3.name , ( SELECT dname , deptno FROM t4 WHERE t3.deptno = t4.deptno ) -- 2개 이상의 values 출력 불가
FROM t3;

SELECT t3.no , t3.name , ( SELECT deptno FROM t4 WHERE t3.deptno = t4.deptno ) "DEPTNO"
FROM t3;

CREATE TABLE with_test1
( no        NUMBER ,
  name      VARCHAR2(10) ,
  pay       NUMBER(6) )
TABLESPACE USERS;

BEGIN
    FOR i IN 1..5000000 LOOP
        INSERT INTO with_test1
            VALUES(i, DBMS_RANDOM.STRING('A', 5),
                      DBMS_RANDOM.VALUE(6, 999999));
    END LOOP;
    COMMIT;
END;
/

SELECT COUNT(*) FROM with_test1;
SELECT * FROM with_test1 ORDER BY 1;

SELECT MAX(pay) - MIN(pay)
FROM with_test1;

CREATE INDEX idx_with_pay ON with_test1(pay);

-- 가상테이블 a와 b를 이용하여 결과 출력 (WITH table1 AS , table2 AS ..)
WITH a AS  -- index를 내림차순으로 정렬하여 row 1의 값을 가져옴 (최대값)
( SELECT /*+ index_desc( w idx_with_pay ) */ "PAY"
  FROM with_test1 w
  WHERE pay > 0
  AND rownum = 1 )
,
b AS  -- index를 오름차순으로 정렬하여 row 1의 값을 가져옴 (최소값)
( SELECT /*+ index( w idx_with_pay ) */ "PAY"
  FROM with_test1 w
  WHERE pay > 0
  AND rownum = 1 )
SELECT a.pay - b.pay
FROM a, b;

CREATE INDEX idx_with_no ON with_test1(no);

SELECT COUNT(*)
FROM with_test1
WHERE pay <ALL( SELECT /*+ INDEX( w idx_with_no ) */ "PAY"
                FROM with_test1 w
                WHERE no BETWEEN 120000 ANd 130000 );

WITH t AS
( SELECT /*+ INDEX (w idx_with_pay ) */ MIN(pay) "MIN_PAY"
  FROM with_test1 w
  WHERE pay > 0
  AND no BETWEEN 120000 AND 130000
  AND rownum = 1 )
SELECT COUNT(*)
FROM with_test1 w , t
WHERE w.pay < t.min_pay ;

DROP INDEX idx_with_pay;

SELECT 'max_pay' c1, MAX(pay) FROM with_test1
UNION ALL
SELECT 'min_pay' c1, MIN(pay) FROM with_test1
UNION ALL
SELECT 'max_pay - min_pay' c1, (MAX(pay) - MIN(pay)) "DIFF_PAY"
FROM with_test1;

WITH sub_pay AS  -- max_pay와 min_pay를 가지고 있는 가상의 테이블 생성
( SELECT MAX(pay) "MAX_PAY" , MIN(pay) "MIN_PAY"
  FROM with_test1 )

SELECT 'max_pay' c1 , "MAX_PAY" FROM sub_pay
UNION ALL
SELECT 'min_pay' c1 , "MIN_PAY" FROM sub_pay
UNION ALL
SELECT 'max_pay - minpay' c1 , (max_pay - min_pay) "DIFF_PAY"
FROM sub_pay;

CREATE TABLE cust_t
( cust_no       VARCHAR(1000) ,
  cust_nm       VARCHAR(1000) );
  
INSERT INTO cust_t
SELECT level , 'NM'||TO_CHAR(level, '000')
FROM dual CONNECT BY level <= 1000;
COMMIT;

CREATE TABLE order_t
( order_no      VARCHAR2(4000) ,
  cust_no       VARCHAR2(1000) ,
  orderdd       VARCHAR2(8) ,
  product_nm    VARCHAR2(4000) );
TRUNCATE TABLE order_t;
-- /*+ append */ : log를 남기지 않고 대량의 데이터를 INSERT.
INSERT /*+ append */ INTO order_t SELECT LEVEL "ORDER_NO" , mod(level, 500) "CUST_NO" , TO_CHAR(sysdate - mod(level, 30) , 'YYYYMMDD') "ORDERDD" , 
                                         'TEST PRODUCT LONG NAME ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'
                                  FROM dual CONNECT BY level <= 1000000;
COMMIT;

SELECT * FROM order_t;

EXEC dbms_stats.gather_table_stats( ownname => 'SCOTT' , tabname => 'CUST_T' , CASCADE => true , no_invalidate => false ) ;
EXEC dbms_stats.gather_table_stats( ownname => 'SCOTT' , tabname => 'ORDER_T' , CASCADE => true , no_invalidate => false );

COL table_name FORMAT a10
SELECT table_name , num_rows , BLOCKS, avg_row_len, sample_size
FROM user_tables
WHERE table_name IN ('ORDER_T' , 'CUST_T');

CREATE INDEX idx_order_t_01 ON order_t(cust_no);

SELECT COUNT(*)
FROM cust_t a
WHERE EXISTS ( SELECT 1
               FROM order_t b
               WHERE a.cust_no = b.cust_no );
               
EXPLAIN PLAN FOR
SELECT COUNT(*)
FROM cust_t a
WHERE EXISTS ( SELECT 1
               FROM order_t b
               WHERE a.cust_no = b.cust_no );
               
SELECT * FROM table(dbms_xplan.display);

DROP INDEX idx_order_t_01;
CREATE INDEX idx_cust_t_01 ON cust_t(cust_no);

SELECT /*+ leading(order_t) use_nl(order_t cust_t) */ COUNT(*)
FROM cust_t
WHERE cust_no IN ( SELECT cust_no FROM order_t );

EXPLAIN PLAN FOR
SELECT /*+ leading(order_t) use_nl(order_t cust_t) */ COUNT(*)
FROM cust_t
WHERE cust_no IN ( SELECT cust_no FROM order_t );

INSERT INTO emp2 ( empno , name , birthday , deptno , emp_type , tel )
       VALUES ( 202000219 , 'Ray' , TO_DATE('1988/03/22' , 'YYYY/MM/DD') , '999' , 'INTERN' , '02)909-2345' );
COMMIT;

-- Scalar subQuery에서 NULL값 처리.
SELECT name , NVL( (SELECT dname FROM dept2 d WHERE e.deptno = d.dcode )                                                                               -- join해 가져오는 외부테이블의 값이 아닌 그 값을 기준으로 실제 불러오는 테이블에 값에 해당하는 항에 NULL 처리
                    , '## not belog to a Dept..' ) "DNAME" 
FROM emp2 e;

EXPLAIN PLAN FOR
SELECT cust_no , NVL( (SELECT MAX(orderdd) FROM order_t c WHERE c.cust_no = a.cust_no) , '99991231') "LAST_ORDER_DD"
FROM cust_t a;

SELECT * FROM table(dbms_xplan.display);

CREATE INDEX idx_order_t_01 ON order_t(cust_no);

-- ch11.
CREATE SEQUENCE jno_seq
INCREMENT BY 1              -- 증감 값 1 (감소하는 seq생성 시 음수로 지정)
START WITH 100              -- 시작 값 100
MAXVALUE 110                -- 최대 값 110
MINVALUE 90                 -- 최소 값 90
CYCLE                       -- 순환 여부 true (false -> NOCYCLE)
CACHE 2;                    -- 캐시 2개 사용

CREATE TABLE s_order
( ord_no        NUMBER(4) ,
  ord_name      VARCHAR2(10) ,
  p_name        VARCHAR2(20) ,
  p_qty         NUMBER );
  
INSERT INTO s_order VALUES(jno_seq.NEXTVAL , 'James' , 'apple' , 5 );   -- NEXTVAL : 다음 시퀀스 값을 넣어줌                     
INSERT INTO s_order VALUES(jno_seq.NEXTVAL , 'Ford' , 'berry' , 3 );

SELECT * FROM s_order;
SELECT jno_seq.CURRVAL FROM dual;  -- 마지막으로 생성된 시퀀스 값을 호출

BEGIN
    FOR i IN 1..9 LOOP
        INSERT INTO s_order VALUES(jno_seq.NEXTVAL , 'Allen' , 'banana' , 5) ;
    END LOOP;
    COMMIT;
END;
/

INSERT INTO s_order VALUES(jno_seq.NEXTVAL , 'Smith' , 'grape' , 3 );   -- 최대값을 초과한 다음 INSERT할 경우 : CYCLE = 최소 값 / NOCYCLE = error 

CREATE SEQUENCE jno_seq_rev
INCREMENT BY -2
MINVALUE 0
MAXVALUE 20
START WITH 10;

CREATE TABLE s_rev1( no        NUMBER ) ;
INSERT INTO s_rev1 VALUES(jno_seq_rev.NEXTVAL);
INSERT INTO s_rev1 VALUES(jno_seq_rev.NEXTVAL);
INSERT INTO s_rev1 VALUES(jno_seq_rev.NEXTVAL);
INSERT INTO s_rev1 VALUES(jno_seq_rev.NEXTVAL);
INSERT INTO s_rev1 VALUES(jno_seq_rev.NEXTVAL);

SELECT * FROM s_rev1;
