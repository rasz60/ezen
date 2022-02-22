UPDATE professor
SET bonus = 200
WHERE position = 'assistant professor';

SELECT * FROM professor;

UPDATE professor
SET pay = pay * 1.15
WHERE position = ( SELECT position
                   FROM professor
                   WHERE name = 'Sharon Stone' )
AND pay < 250;

CREATE TABLE charge_01
( u_date        VARCHAR2(6) ,
  cust_no       NUMBER ,
  u_time        NUMBER ,
  charge        NUMBER );
  
CREATE TABLE charge_02
( u_date        VARCHAR2(6) ,
  cust_no       NUMBER ,
  u_time        NUMBER ,
  charge        NUMBER );
  
CREATE TABLE ch_total
( u_date        VARCHAR2(6) ,
  cust_no       NUMBER ,
  u_time        NUMBER ,
  charge        NUMBER );

SELECT * FROM charge_01;
SELECT * FROM charge_02;
SELECT * FROM ch_total;

INSERT INTO charge_01 VALUES('141001', 1000, 2, 1000);
INSERT INTO charge_01 VALUES('141001', 1001, 2, 1000);
INSERT INTO charge_01 VALUES('141001', 1002, 1, 500);

INSERT INTO charge_02 VALUES('141002', 1000, 3, 1500);
INSERT INTO charge_02 VALUES('141002', 1001, 4, 2000);
INSERT INTO charge_02 VALUES('141002', 1003, 1, 500);

COMMIT;

MERGE INTO ch_total "TOTAL"
USING charge_01 "CH01"
ON (total.u_date = ch01.u_date)
WHEN MATCHED THEN
UPDATE SET total.cust_no = ch01.cust_no
WHEN NOT MATCHED THEN
INSERT VALUES(ch01.u_date , ch01.cust_no , ch01.u_time , ch01.charge);

MERGE INTO ch_total "TOTAL"
USING charge_02 "CH02"
ON (total.u_date = ch02.u_date)
WHEN MATCHED THEN
UPDATE SET total.cust_no = ch02.cust_no
WHEN NOT MATCHED THEN
INSERT VALUES(ch02.u_date , ch02.cust_no , ch02.u_time , ch02.charge);

UPDATE emp
SET sal = (sal + sal*0.1)
WHERE JOB = 'Clerk';

UPDATE emp e
SET sal = (sal + sal * 0.1)
WHERE EXISTS
  ( SELECT 1 FROM dept d
    WHERE d.loc = 'DALLAS' AND e.deptno = d.deptno );

CREATE TABLE dept_hist
( empno         NUMBER(4) ,
  APPOINTSEQNO  NUMBER(4) ,
  DEPTNO        NUMBER(2) ,
  APPOINTDD     DATE      );

ALTER TABLE dept_hist
ADD CONSTRAINT pk_dept_hist PRIMARY KEY(empno, appointseqno);

INSERT INTO dept_hist 
SELECT empno, 1 appointseqno , 99 deptno , SYSDATE appointdd
FROM emp
WHERE deptno = 20;

SELECT * FROM dept_hist;

INSERT INTO dept_hist VALUES(9322, 1, 99, SYSDATE);
INSERT INTO dept_hist VALUES(9414, 1, 99, SYSDATE);

COMMIT;

SELECT e.empno, e.deptno "TOBE_DEPTNO", d.deptno "ASIS_DEPTNO"
FROM emp e, dept_hist d
WHERE e.empno = d.empno;

UPDATE dept_hist d
SET d.deptno = (
                SELECT e.deptno FROM emp e
                WHERE e.empno = d.empno
                );
COMMIT;
ROLLBACK;

UPDATE dept_hist d
SET d.deptno = (
                SELECT e.deptno FROM emp e
                WHERE e.empno = d.empno
                )
WHERE EXISTS ( SELECT e.empno FROM emp e
               WHERE e.empno = d.empno
              );
              
MERGE INTO dept_hist d
USING emp e
ON ( e.empno = d.empno )
WHEN MATCHED THEN 
UPDATE SET d.deptno = e.deptno;


-- 연습문제
-- ex01
SELECT * FROM dept2;
INSERT INTO dept2 VALUES('9010', 'temp_10', '1006', 'Temp Area');

-- ex02
INSERT INTO dept2(dcode , dname , pdept) VALUES('9020', 'temp_20', '1006');

-- ex03
SELECT * FROM professor4;

INSERT INTO professor4
SELECT profno , name , pay 
FROM professor 
WHERE profno > 3000; 

-- ex04
UPDATE professor
SET bonus = 100
WHERE name = 'Sharon Stone';

SELECT * FROM professor;



CREATE TABLE new_emp1
( no        NUMBER(4)       CONSTRAINT emp1_no_pk PRIMARY KEY ,
  name      VARCHAR2(20)    CONSTRAINT emp1_name_nn NOT NULL ,
  jumin     VARCHAR2(13)    CONSTRAINT emp1_jumin_nn NOT NULL
                            CONSTRAINT emp1_jumin_uk UNIQUE,
  loc_code  NUMBER(1)       CONSTRAINT emp1_area_ck CHECK(loc_code < 5),
  deptno    VARCHAR2(6)     CONSTRAINT emp1_deptno_fk REFERENCES dept2(dcode) );

SELECT * FROM new_emp1;

CREATE TABLE new_emp2
( no        NUMBER(4)       PRIMARY KEY ,
  name      VARCHAR2(20)    NOT NULL ,
  jumin     VARCHAR2(13)    NOT NULL
                            UNIQUE,
  loc_code  NUMBER(1)       CHECK(loc_code < 5),
  deptno    VARCHAR2(6)     REFERENCES dept2(dcode) );

ALTER TABLE new_emp2
ADD CONSTRAINT emp2_name_uk unique(name);

ALTER TABLE new_emp2
MODIFY(loc_code CONSTRAINT emp2_loccode_nn NOT NULL);

ALTER TABLE new_emp2
ADD CONSTRAINT emp2_no_fk FOREIGN KEY(no)
REFERENCES emp2(empno);

ALTER TABLE new_emp2
ADD CONSTRAINT emp2_name_fk FOREIGN KEY(name)
REFERENCES emp2(name);

ALTER TABLE emp2
ADD CONSTRAINT emp_name_uk UNIQUE(name);

CREATE TABLE c_test1
( no        NUMBER ,
  name      VARCHAR2(6) ,
  deptno    NUMBER );
  
CREATE TABLE c_test2 (
no      NUMBER ,
name    VARCHAR2(10) );

ALTER TABLE c_test1
ADD CONSTRAINT ctest1_deptno_fk FOREIGN KEY(deptno)
REFERENCES c_test2(no);

ALTER TABLE c_test2
ADD CONSTRAINT ctest2_no_uk UNIQUE(no);

ALTER TABLE c_test1
ADD CONSTRAINT ctest1_deptno_fk FOREIGN KEY(deptno)
REFERENCES c_test2(no)
ON DELETE CASCADE;

ALTER TABLE c_test1 DROP CONSTRAINT CTEST1_DEPTNO_FK;

INSERT INTO c_test2 VALUES(10, 'AAAA'); 
INSERT INTO c_test2 VALUES(20, 'BBBB');
INSERT INTO c_test2 VALUES(30, 'CCCC');
SELECT * FROM c_test2;

INSERT INTO c_test1 VALUES(1, 'apple', 10);
INSERT INTO c_test1 VALUES(2, 'banana', 20);
INSERT INTO c_test1 VALUES(3, 'cherry', 30);
INSERT INTO c_test1 VALUES(4, 'peach', 40);
SELECT * FROM c_test1;

DELETE FROM c_test2 WHERE no = 10;

ALTER TABLE c_test1 DROP CONSTRAINT CTEST1_DEPTNO_FK;

ALTER TABLE c_test1
ADD CONSTRAINT ctest1_deptno_fk FOREIGN KEY(deptno)
REFERENCES c_test2(no)
ON DELETE SET NULL;

DELETE FROM c_test2 WHERE no = 20;

ALTER TABLE c_test1
MODIFY (deptno CONSTRAINT ctest1_deptno_nn NOT NULL);

UPDATE c_test1 SET deptno = 30
WHERE no = 2;

SELECT * FROM c_test2;
