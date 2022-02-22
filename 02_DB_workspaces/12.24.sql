CREATE INDEX idx_emp_sal
ON emp(sal);

SELECT table_name , index_name , visibility
FROM user_indexes
WHERE table_name = 'EMP';

ALTER INDEX idx_emp_sal INVISIBLE;
ALTER INDEX idx_emp_sal VISIBLE;

SELECT /*+ index(emp idx_emp_sal) */ ename
FROM emp
WHERE ename > '0';

CREATE TABLE new_emp4
( no        NUMBER ,
  name      VARCHAR2(10) ,
  sal       NUMBER );
  
INSERT INTO new_emp4 VALUES(1000, 'SMITH', 300);
INSERT INTO new_emp4 VALUES(1001, 'ALLEN', 250);
INSERT INTO new_emp4 VALUES(1002, 'KING', 430);
INSERT INTO new_emp4 VALUES(1003, 'BLAKE', 220);
INSERT INTO new_emp4 VALUES(1004, 'JAMES', 620);
INSERT INTO new_emp4 VALUES(1005, 'MILLER', 810);

COMMIT;

SELECT * FROM new_emp4;

CREATE INDEX idx_newemp4_name ON new_emp4(name);

SELECT name
FROM new_emp4
WHERE name > '0'; -- �ε����� ����ϰ��ϴ� ���ǰ�

SELECT MIN(name) FROM new_emp4;
SELECT MIN(name) FROM new_emp4
WHERE name > '0' AND rownum = 1;

SELECT MAX(name) FROM new_emp4;

SELECT /*+ INDEX_DESC(e idx_newemp4_name) */ name
FROM new_emp4 e
WHERE name > '0' AND rownum = 1;

SELECT /*+ INDEX_DESC(e idx_newemp4_name) */ MAX(name)
FROM new_emp4 e
WHERE name > '0';

SELECT * FROM emp;

SELECT empno , ename , rowid
FROM emp
WHERE empno = '7900';

CREATE OR REPLACE VIEW v_emp1
AS
   SELECT empno , ename , hiredate
   FROM emp ;

CREATE INDEX idx_vemp_ename ON v_emp1(ename);

SELECT * FROM v_emp1;

CREATE TABLE o_table
( a     NUMBER ,
  b     NUMBER );
  
CREATE VIEW view1
AS
   SELECT a, b
   FROM o_table;

INSERT INTO view1 VALUES(1, 2);
ROLLBACK;

SELECT * FROM view1;
SELECT * FROM o_table;

CREATE VIEW view2
AS SELECT a , b
   FROM o_table
WITH READ ONLY;

SELECT * FROM view2;

INSERT INTO view2 VALUES(3, 4);
INSERT INTO view1 VALUES(3, 4);

INSERT INTO view1 VALUES(5, 6);

CREATE VIEW view3
AS SELECT a, b
   FROM o_table
   WHERE a = 3
WITH CHECK OPTION; -- WHERE ���� ���ǿ� �´� ���� view�� ��������� �Ѵ�.

SELECT * FROM view3;

UPDATE view3 SET a = 5 WHERE b = 4;
UPDATE view3 SET b = 6 WHERE a = 3;
DELETE FROM view3 WHERE a = 3;

CREATE OR REPLACE VIEW v_emp
AS SELECT e.ename , d.dname
   FROM emp e, dept d
   WHERE e.deptno = d.deptno
WITH CHECK OPTION;

SELECT * FROM v_emp;

SELECT e.deptno , d.dname , e.sal
FROM (SELECT deptno , MAX(sal) "SAL"
      FROM emp
      GROUP BY deptno) e, dept d
WHERE e.deptno = d.deptno; -- �ʿ��� ���� SELECT�ؼ� ���̺�ȭ �ϴ°� INLINE VIEW? ���� ��� �θ��� ������?

SELECT DECODE(deptno, ndeptno, NULL, deptno) "DEPTNO" , profno , name
FROM (SELECT LAG(deptno) OVER(ORDER BY deptno) "NDEPTNO" , deptno , profno , name
FROM professor);

SELECT view_name , text , read_only
FROM user_views;

DROP VIEW v_emp;

CREATE MATERIALIZED VIEW m_prof
BUILD IMMEDIATE                 -- view �� ��� ����
REFRESH                         -- table�� ������ ���� �� ���� (����ȭ)
ON DEMAND                       -- ������� �������� ����ȭ (�� ON COMMIT : �ڵ� ����ȭ -> ��� ���� ���ɼ� ����.)
COMPLETE                        -- ���� �����ϰ� ���� (�� FAST : �ٲ� �κи� ���� / FORCE : FAST�� �����ϸ� FAST , �ƴϸ� COMPLETE / NEVER : ����ȭ x)
/* ENABLE QUERY REWRITE */      -- ���� ���ۼ� ���� �ɼ�..? ������ ���� �ο� ���� ���� �ٸ�.
AS SELECT profno , name , pay
   FROM professor;

SELECT * FROM m_prof;
SELECT * FROM professor;

CREATE INDEX idx_m_prof_pay     -- �Ϲ� view���� �Ұ����� �ε��� ���� ����
ON m_prof(pay);

DELETE FROM professor
WHERE profno = 5001;
commit;

BEGIN
    dbms_mview.REFRESH('M_PROF');
END;
/


-- ��������
-- ex01
CREATE OR REPLACE VIEW v_prof_dept2
AS
    SELECT p.profno , p.name , d.dname 
    FROM professor p , department d
    WHERE p.deptno = d.deptno;
    
-- ex02
SELECT d.dname , s.height , s.weight
FROM department d, ( SELECT deptno1, MAX(height) "HEIGHT", MAX(weight) "WEIGHT" FROM student GROUP BY deptno1) s
WHERE s.deptno1 = d.deptno
ORDER BY 1;

-- ex03
SELECT d.dname, s2.max_height , s.name , s.height
FROM student s , department d , ( SELECT deptno1, MAX(height) "MAX_HEIGHT" FROM student GROUP BY deptno1 ) s2
WHERE s.deptno1 = d.deptno
AND s.height = s2.max_height
AND s.deptno1 = s2.deptno1;

-- ex04
SELECT s1.grade , s2.name , s2.height , s1.avg_height
FROM (SELECT grade, ROUND(AVG(height), 1) "AVG_HEIGHT" FROM student GROUP BY grade) s1, student s2
WHERE s1.grade = s2.grade
AND s2.height > s1.avg_height
ORDER BY 1;

-- ex05
SELECT ROW_NUMBER() OVER(ORDER BY pay DESC) "RANKING" , name , pay
FROM professor
WHERE rownum < 6;

SELECT rownum "RANKING" , name , pay
FROM (SELECT name , pay FROM professor ORDER BY pay DESC)
WHERE rownum < 6;

-- ex06
SELECT rownum , profno , name , pay , SUM(PAY) , ROUND(AVG(NVL(pay,0)), 1)
FROM professor
GROUP BY CEIL(rownum/3),ROLLUP((rownum,profno,name,pay));