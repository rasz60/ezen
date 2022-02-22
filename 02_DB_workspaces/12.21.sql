SELECT * FROM gift;
SELECT * FROM customer;

SELECT c.gname "CUST_NAME" , TO_CHAR(c.point, '999,999') "CUST_POINT" , g.gname "GIFT_NAME"
FROM customer c , gift g
WHERE c.point BETWEEN g.g_start AND g.g_end;

SELECT c.gname "CUST_NAME" , TO_CHAR(c.point, '999,999') "CUST_POINT" , g.gname "GIFT_NAME"
FROM customer c JOIN gift g
ON c.point BETWEEN g.g_start AND g.g_end;

SELECT c.gname "CUST_NAME" , TO_CHAR(c.point, '999,999') "CUST_POINT" , g.gname "GIFT_NAME"
FROM customer c JOIN gift g
ON c.point >= g.g_start AND c.point <= g.g_end;

SELECT c.gname "CUST_NAME" , TO_CHAR(c.point, '999,999') "CUST_POINT" , g.gname "GIFT_NAME"
FROM customer c , gift g
WHERE c.point >= g.g_start AND c.point <= g.g_end;

SELECT * FROM student;
SELECT * FROM score;
SELECT * FROM hakjum;

SELECT s.name "STU_NAME" , c.total "SCORE" , h.grade "CREDIT"
FROM student s JOIN score c
ON s.studno = c.studno
JOIN hakjum h
ON c.total >= h.min_point
AND c.total <= h.max_point
ORDER BY s.studno;

SELECT s.name "STU_NAME" , p.name "PROF_NAME"
FROM student s , professor p
WHERE s.profno = p.profno(+);

SELECT s.name "STU_NAME" , p.name "PROF_NAME"
FROM student s LEFT OUTER JOIN professor p
ON s.profno = p.profno;

SELECT s.name "STU_NAME", p.name "PROF_NAME"
FROM student s, professor p
WHERE s.profno(+) = p.profno
ORDER BY s.studno;

SELECT s.name "STU_NAME", p.name "PROF_NAME"
FROM student s RIGHT OUTER JOIN professor p
ON s.profno = p.profno
ORDER BY s.studno;

SELECT s.name "STU_NAME" , p.name "PROF_NAME"
FROM student s , professor p
WHERE s.profno(+) = p.profno
UNION
SELECT s.name "STU_NAME" , p.name "PROF_NAME"
FROM student s , professor p
WHERE s.profno = p.profno(+);

SELECT s.name "STU_NAME" , p.name "PROF_NAME"
FROM student s FULL OUTER JOIN professor p
ON s.profno = p.profno
ORDER BY s.studno;

SELECT d.deptno , d.dname , d.loc , e.empno , e.ename , e.sal
FROM dept d, emp e
WHERE d.deptno = e.deptno(+)
AND e.deptno(+) = 20
ORDER BY d.deptno;

SELECT empno, ename , job , d.deptno , d.dname , d.loc
FROM dept d , emp e
WHERE e.deptno = d.deptno(+)
AND e.job = 'CLERK'
AND d.loc(+) = 'CHICAGO';

SELECT e.empno , e.ename , e.job , d.deptno , d.dname , d.loc
FROM emp e LEFT OUTER JOIN dept d
ON (e.deptno = d.deptno AND d.loc = 'CHICAGO')
WHERE e.job = 'CLERK';                                                                                                                                 -- SELECT 조건을 주고 OUTER JOIN을 해준 결과. (WHERE)

SELECT e.empno , e.ename , e.job , d.deptno , d.dname , d.loc
FROM emp e LEFT OUTER JOIN dept d
ON (e.deptno = d.deptno AND d.loc = 'CHICAGO')
AND e.job = 'CLERK';                                                                                                                                   -- JOIN 조건 값을 추가해 준 결과. (ON - AND)

SELECT empno , ename , mgr FROM emp;

SELECT e1.empno, e1.ename "ENAME", e2.ename "MGR_NAME"
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
ORDER BY e1.empno;

SELECT e1.ename "ENAME" , e2.ename "MGR_NAME"
FROM emp e1 JOIN emp e2
ON e1.mgr = e2.empno
ORDER BY e1.empno;

-- 연습문제
-- ex01
SELECT s.name "STU_NAME" , s.deptno1 "DEPTNO1" , d.dname "DEPT_NAME"
FROM student s , department d
WHERE s.deptno1 = d.deptno
ORDER BY studno;

-- ex02
SELECT * FROM p_grade;
SELECT * FROM emp2;

SELECT e2.name , e2.position , TO_CHAR(e2.pay, '999,999,999') "PAY", TO_CHAR(pg.s_pay, '999,999,999') "Low PAY" , TO_CHAR(pg.e_pay, '999,999,999') "High PAY"
FROM emp2 e2 , p_grade pg
WHERE e2.position = pg.position;

-- ex03
SELECT e2.name , TRUNC(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e2.birthday, 'YYYY'), 0) "AGE", e2.position "CURR_POSITION" , pg.position "BE_POSITION"
FROM emp2 e2 , p_grade pg
WHERE TRUNC(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e2.birthday, 'YYYY'), 0) >= pg.s_age
AND TRUNC(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e2.birthday, 'YYYY'), 0) <= pg.e_age
ORDER BY age;

-- ex04
SELECT * FROM customer;
SELECT * FROM gift;

SELECT c.gname "CUST_NAME" , c.point "POINT" , g.gname "GIFT_NAME"
FROM customer c , gift g
WHERE c.point >= g.g_start
AND g.gname = 'Notebook';

-- ex05
SELECT * FROM professor ORDER BY hiredate;
SELECT p1.profno , p1.name , p1.hiredate , COUNT(p2.hiredate) "COUNT"
FROM professor p1, professor p2
WHERE p1.hiredate > p2.hiredate(+)
GROUP BY p1.profno, p1.name, p1.hiredate
ORDER BY count;

-- ex06
SELECT e1.empno, e1.ename , e1.hiredate , COUNT(e2.hiredate) "COUNT"
FROM emp e1, emp e2
WHERE e1.hiredate > e2.hiredate(+)
GROUP BY e1.empno, e1.ename, e1.hiredate
ORDER BY count;

CREATE TABLE new_table
( no    NUMBER(3),
  name  VARCHAR2(2),
  birth DATE);
  
desc new_table;

CREATE TABLE tt02
 ( no       NUMBER(3, 1)    DEFAULT 0,
   name     VARCHAR2(10) DEFAULT 'NO Name',
   hiredate DATE         DEFAULT SYSDATE );
   
SELECT * FROM tt02;

INSERT INTO tt02 (no) VALUES(1);

CREATE GLOBAL TEMPORARY TABLE temp01
 ( no       NUMBER ,
   name     VARCHAR2(10))
ON COMMIT delete ROWS;

INSERT INTO temp01 VALUES(1, 'AAAAAA');

SELECT * FROM temp01;

SELECT TEMPORARY, DURATION
FROM user_tables
WHERE table_name = 'TEMP01';

CREATE TABLE dept4
AS SELECT * FROM dept2;

CREATE TABLE dept5
AS SELECT * FROM dept2
WHERE 1 = 2;

SELECT * FROM dept5;

CREATE TABLE dept6
AS SELECT dcode, dname
FROM dept2
WHERE dcode IN(1000, 1001, 1002);

SELECT * FROM dept6;

ALTER TABLE dept6 ADD( loc VARCHAR2(10) );
ALTER TABLE dept6 ADD( loc2 VARCHAR2(10) default 'SEOUL');

ALTER TABLE dept6 RENAME COLUMN loc TO location;
ALTER TABLE dept6 RENAME COLUMN location2 TO loc;

RENAME dept6 TO dept7;

SELECT * FROM dept7;

DESC dept7;
ALTER TABLE dept7
MODIFY( loc VARCHAR2(20) );

ALTER TABLE dept7 DROP COLUMN loc;
ALTER TABLE dept7 DROP COLUMN loc CASCADE CONSTRAINT;

DELETE FROM dept7;
TRUNCATE TABLE dept7;
DROP TABLE dept7;
rollback;

DELETE FROM dept4
WHERE dname = 'Sales1 Team';

CREATE TABLE t_readonly
( no        NUMBER,
  name      VARCHAR2(10) );
  
INSERT INTO t_readonly VALUES(1, 'AAAAA');

SELECT * FROM t_readonly;
commit;

ALTER TABLE t_readonly read only;
INSERT INTO t_readonly VALUES(2, 'BBBBB');

ALTER TABLE t_readonly add(tel NUMBER DEFAULT 111);

ALTER TABLE t_readonly read write;
ALTER TABLE t_readonly add(tel NUMBER DEFAULT 111);
SELECT * FROM t_readonly;

CREATE TABLE vt1
( col1  NUMBER ,
  col2  NUMBER ,
  col3  NUMBER GENERATED ALWAYS AS (col1+col2));
  
SELECT * FROM vt1;

INSERT INTO vt1 VALUES(1,2,3);
INSERT INTO vt1 (col1, col2) VALUES(1,2);

UPDATE vt1 SET col1 = 3;

ALTER TABLE vt1
ADD(col4 GENERATED ALWAYS AS (col1 * 12 + col2));

SELECT column_name, data_type, data_default FROM user_tab_columns
WHERE table_name = 'VT1'
ORDER BY column_id;

CREATE TABLE sales10
( no        NUMBER ,
  pcode     CHAR(4) ,
  pdate     CHAR(8) ,
  pqty      NUMBER ,
  pquater   NUMBER(1)
  GENERATED ALWAYS AS
    (
    CASE
         WHEN SUBSTR(pdate, 5, 2) IN ('01' , '02' , '03') THEN 1 
         WHEN SUBSTR(pdate, 5, 2) IN ('04' , '05' , '06') THEN 2 
         WHEN SUBSTR(pdate, 5, 2) IN ('07' , '08' , '09') THEN 3 
         ELSE 4
    END ) VIRTUAL );

SELECT * FROM sales10;

INSERT INTO sales10 (no, pcode, pdate, pqty) VALUES(1, '100', '20211221', 10);
INSERT INTO sales10 (no, pcode, pdate, pqty) VALUES(2, '200', '20210822', 20);
INSERT INTO sales10 (no, pcode, pdate, pqty) VALUES(3, '300', '20211322', 30);
INSERT INTO sales10 (no, pcode, pdate, pqty) VALUES(4, '400', '20210522', 40);

UPDATE sales10 SET pdate = '20210322' WHERE no = 3;

SELECT * FROM sales10
ORDER BY 1;

CREATE TABLE st_table( no NUMBER );

BEGIN
   FOR i in 1..1000 loop
    INSERT INTO st_table VALUES(i);
   end loop;
  commit;
 end;
/

SELECT * FROM st_table ORDER BY 1;
SELECT COUNT(*) FROM st_table;

SELECT num_rows, BLOCKS
FROM user_tables
WHERE table_name = 'ST_TABLE';

ANALYZE TABLE st_table COMPUTE STATISTICS;

SELECT num_rows, BLOCKS
FROM user_tables
WHERE table_name = 'ST_TABLE';

SELECT * FROM dept2;

INSERT INTO dept2 VALUES(9000, 'temp_1', 1006, 'Temp Area');
INSERT INTO dept2 (dcode, dname, pdept) VALUES(9002, 'temp_3', 1006);
SELECT * FROM professor;
INSERT INTO professor (profno, name, ID, position, pay, hiredate)
       VALUES(5001, 'James Bond', 'Love_me', 'a full professor', 510, '2014-10-23');

CREATE TABLE t_minus
( no1       NUMBER(3),
  no2       NUMBER(3),
  no3       NUMBER(3,2) );
  
INSERT INTO t_minus VALUES(1, 1, 1);
INSERT INTO t_minus VALUES(1.1, 1.1, 1.1);
INSERT INTO t_minus VALUES(-1.1, -1.1, -1.1);

SELECT * FROM t_minus;

CREATE TABLE professor3
AS SELECT * FROM professor
WHERE 1 = 2;

SELECT * FROM professor3;

CREATE TABLE professor4
AS SELECT profno, name, pay
FROM professor
WHERE 1=2;

INSERT INTO professor4
SELECT profno, name, pay
FROM professor
WHERE profno > 4000;

SELECT * FROM professor4;

CREATE TABLE prof_3
( profno        NUMBER,
  name          VARCHAR2(25) );
  
CREATE TABLE prof_4
( profno        NUMBER,
  name          VARCHAR2(25) );
  
INSERT ALL
WHEN profno >= 1000 AND profno <= 1999 THEN
    INTO prof_3 VALUES(profno , name)
WHEN profno >= 2000 AND profno <= 3999 THEN
    INTO prof_4 VALUES(profno, name)
SELECT profno, name
FROM professor;

SELECT * FROM prof_3;
SELECT * FROM prof_4;
SELECT * FROM professor;

TRUNCATE TABLE prof_3;
TRUNCATE TABLE prof_4;

INSERT ALL
INTO prof_3 VALUES(profno, name)
INTO prof_4 VALUES(profno, name)
SELECT profno, name
FROM professor
WHERE profno BETWEEN 3000 AND 3999;

-- 연습문제
-- ex01
CREATE TABLE new_emp
( no        NUMBER(5),
  name      VARCHAR2(20),
  hiredate  DATE,
  bonus     NUMBER(6,2) );
  
SELECT * FROM new_emp;

-- ex02
CREATE TABLE new_emp2
AS SELECT no, name, hiredate
FROM new_emp;

SELECT * FROM new_emp2;

-- ex03
CREATE TABLE new_emp3
AS SELECT * FROM new_emp2
WHERE 1 = 2;

-- ex04
ALTER TABLE new_emp2 ADD(birthday DATE DEFAULT SYSDATE);

-- ex05
ALTER TABLE new_emp2 RENAME COLUMN birthday TO birth;

-- ex06
ALTER TABLE new_emp2
MODIFY ( no     NUMBER(7) );
desc new_emp2;

-- ex07
ALTER TABLE new_emp2 DROP COLUMN birth;

-- ex08
TRUNCATE TABLE new_emp2;

-- ex09
DROP TABLE new_emp2;