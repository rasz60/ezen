SELECT ename, hiredate, sal, LAG(sal, 1, 0) OVER (ORDER BY hiredate) "LAG"                                                                             -- LAG(col, OFFSET, default) : 칼럼에서 OFFSET만큼 건너 뛴 앞 행의 값을 불러온다.
FROM emp;                                                                                                                                              -- OVER(PARTITION BY 칼럼 ORDER BY 정렬) : 불러오는 정렬가 파티션 구문..

SELECT ename, hiredate , sal , LAG(sal, 3, 2) OVER(ORDER BY hiredate) "LAG"
FROM emp;

SELECT ename , hiredate , sal , LEAD(sal, 2, 1) OVER(ORDER BY hiredate) "LEAD"                                                                         -- LEAD(col, OFFSET, default) : 칼럼에서 OFFSET만큼 건너 뛴 뒷 행의 값을 불러온다.
FROM emp;

SELECT RANK('SMITH') WITHIN GROUP(ORDER BY ename) "RANK"                                                                                               -- RANK(조건값) WITHIN GROUP(ORDER BY 조건값 or 칼럼명 [ASC | DESC]
FROM emp;                                                                                                                                              -- RANK() OVER(ORDER BY 조건값 or 칼럼명 [ASC | DESC])

SELECT empno , ename , sal , RANK() OVER (ORDER BY sal ) "RANK_ASC" ,                                                                                 
                             RANK() OVER (ORDER BY sal DESC) "RANK_DESC"
FROM emp;

SELECT empno, ename , sal , RANK() OVER(ORDER BY sal DESC) "RANK"
FROM emp
WHERE deptno = 10;

SELECT empno, ename, sal , RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "PATITION_RANK"
FROM emp;

SELECT empno, ename, job, sal, RANK()       OVER(ORDER BY sal DESC) "sal_rank" ,
                               DENSE_RANK() OVER(ORDER BY sal DESC) "sal_dense_rank" ,                                                                 -- DENSE_RANK : 동일한 값을 비교할 시에는 같은 순위 표시
                               ROW_NUMBER() OVER(ORDER BY sal DESC) "sal_row_num"                                                                      -- ROW_NUMBER : 동일한 값이어도 ROWID가 작은 값을 높은 순위로 표시
FROM emp;

SELECT deptno, sal, empno,
                          ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal) "ROW_NUM1" ,
                          RANK()       OVER(PARTITION BY deptno ORDER BY sal) "RANK_NUM1" ,
                          DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal) "DENSE_RANK_NUM1" ,
                          ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal , empno) "ROW_NUM2" ,
                          RANK()       OVER(PARTITION BY deptno ORDER BY sal , empno) "RANK_NUM2" ,
                          DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal , empno) "DENSE_RANK_NUM2"
FROM emp
ORDER BY deptno , sal , empno ;

SELECT p_date , p_code , p_qty , p_total , SUM(p_total) OVER(ORDER BY p_total) "TOTAL"
FROM panmae
WHERE p_store = 1000;

SELECT p_date , p_code , p_qty , p_total , SUM(p_total) OVER(PARTITION BY p_code ORDER BY p_total) "TOTAL"
FROM panmae
WHERE p_store = 1000;

SELECT p_code , p_store , p_date , p_qty , p_total , SUM(p_total) OVER(PARTITION BY p_code , p_store ORDER BY p_total) "TOTAL"
FROM panmae;

SELECT p_code, SUM(SUM(p_qty)) OVER() "TOTAL_QTY" ,
               SUM(SUM(p_total)) OVER() "TOTAL_PRICE" , p_store , p_qty , p_total, 
               ROUND((RATIO_TO_REPORT(SUM(p_qty)) OVER()) * 100, 1) "qty_%" ,
               ROUND((RATIO_TO_REPORT(SUM(p_total)) OVER()) * 100, 1) "total_%"
FROM panmae
WHERE p_code = 100
GROUP BY p_code , p_store , p_qty , p_total;


-- 3장 연습문제
-- 02
SELECT * FROM (SELECT studno, TO_CHAR(birthday, 'MM') "BD" FROM student)

PIVOT
( COUNT(studno) FOR BD IN ('01' "JAN" ,
                           '02' "FEB" ,
                           '03' "MAR" ,
                           '04' "APR" ,
                           '05' "MAY" ,
                           '06' "JUN" ,
                           '07' "JUL" ,
                           '08' "AUG" ,
                           '09' "SEP" ,
                           '10' "OCT" ,
                           '11' "NOV" ,
                           '12' "DEC" )
);

-- 03
SELECT * FROM (SELECT studno , SUBSTR(tel, 1, INSTR(tel, ')')-1) "LOCAL" FROM student)

PIVOT
( COUNT(studno) FOR LOCAL IN ('02'  "SEOUL" ,
                              '031' "GYEONGGI" ,
                              '051' "BUSAN" ,
                              '052' "ULSAN" ,
                              '053' "DAEGU" ,
                              '055' "GYEONNAM" )
);

-- 04
CREATE TABLE emp00
AS SELECT * FROM emp;

INSERT INTO emp00(empno, deptno, ename, sal) VALUES(1000, 10, 'Tiger', 3600);
INSERT INTO emp00(empno, deptno, ename, sal) VALUES(2000, 10, 'Cat', 3000);

SELECT deptno,
              SUM(DECODE(job, 'CLERK', sal, 0)) "CLERK",
              SUM(DECODE(job, 'MANAGER', sal, 0)) "MANAGER",
              SUM(DECODE(job, 'PRESIDENT', sal, 0)) "PRESIDENT",
              SUM(DECODE(job, 'ANALYST', sal, 0)) "ANALYST",
              SUM(DECODE(job, 'SALESMAN', sal, 0)) "SALESMAN",
              SUM(NVL2(job, sal, 0)) "TOTAL"
              
FROM emp00
GROUP BY deptno
ORDER BY deptno;

-- 05
SELECT deptno , ename , sal , SUM() OVER(ORDER BY sal) "TOTAL"
FROM emp00
GROUP BY deptno
ORDER BY 1;


CREATE TABLE cat_a(no NUMBER, name VARCHAR2(1));
INSERT INTO cat_a VALUES(1, 'A');
INSERT INTO cat_a VALUES(2, 'B');

CREATE TABLE cat_b(no NUMBER, name VARCHAR2(1));
INSERT INTO cat_b VALUES(1, 'C');
INSERT INTO cat_b VALUES(2, 'D');

CREATE TABLE cat_c(no NUMBER, name VARCHAR2(1));
INSERT INTO cat_c VALUES(1, 'E');
INSERT INTO cat_c VALUES(2, 'F');

commit;

SELECT a.name "a.name", b.name "b.name"
FROM cat_a a , cat_b b
WHERE a.no = b.no;

SELECT a.name "a.name" , b.name "b.name"
FROM cat_a a, cat_b b;

SELECT a.name "a.name", b.name "b.name", c.name "c.name"
FROM cat_a a, cat_b b, cat_c c
WHERE a.no = b.no AND a.no = c.no;

SELECT a.name "a.name", b.name "b.name", c.name "c.name"
FROM cat_a a, cat_b b, cat_c c
WHERE a.no = b.no;

SELECT empno , ename , job , sal
FROM emp
WHERE deptno = 10;

SELECT level c1 FROM dual CONNECT BY level <= 3;

SELECT * FROM 
( SELECT empno, ename , job , sal
  FROM emp
  WHERE deptno = 10) ,
( SELECT level c1 FROM dual CONNECT BY level <= 3);

SELECT empno, CASE WHEN c1 = 1 THEN 'ename'
                   WHEN c1 = 2 THEN 'job'
                   WHEN c1 = 3 THEN 'hiredate'
              END TITLE,
              CASE WHEN c1 = 1 THEN ename
                   WHEN c1 = 2 THEN job
                   WHEN c1 = 3 THEN hiredate
              END CONTENTS
FROM
( SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY/MM/DD') hiredate
  FROM emp
  WHERE deptno = 10 ) ,
( SELECT level c1 FROM dual CONNECT BY level <= 3 )
ORDER BY 1, 2;

SELECT * FROM emp;
SELECT * FROM dept;
SELECT DISTINCT deptno FROM emp;

SELECT e.empno, e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY 3;

SELECT * FROM student; 
SELECT * FROM professor; 

SELECT s.name "S.NAME" , p.profno , p.name "P.NAME"
FROM student s, professor p
WHERE s.profno = p.profno
ORDER BY s.studno;

SELECT s.name "S.NAME" , p.profno , p.name "P.NAME"
FROM professor p INNER JOIN student s
ON s.profno = p.profno
ORDER BY s.studno;

SELECT s.name "SNAME" , d.dname "DNAME" , p.name "PNAME"
FROM student s, department d, professor p
WHERE s.deptno1 = d.deptno AND s.profno = p.profno
ORDER BY 2;

SELECT s.name "SNAME" , s.deptno1 "SDEPTNO", d.dname "DNAME" , p.name "PNAME"
FROM student s JOIN department d
ON s.deptno1 = d.deptno 
JOIN professor p
ON s.profno = p.profno
ORDER BY s.deptno1;

SELECT s.name "SNAME" , p.name "PNAME"
FROM student s , professor p
WHERE s.deptno1 = 101 AND s.profno = p.profno;

SELECT s.name "SNAME" , p.name "PNAME"
FROM student s JOIN professor p
ON s.deptno1 = 101 AND s.profno = p.profno;