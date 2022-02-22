INSERT INTO t_novalidate VALUES(1, 'DDD');

ALTER TABLE t_novalidate DISABLE NOVALIDATE CONSTRAINT SYS_C007018;

INSERT INTO t_validate VALUES(4, NULL);

ALTER TABLE t_validate DISABLE VALIDATE CONSTRAINT TV_NAME_NN;

INSERT INTO t_enable VALUES(1, 'AAA');
INSERT INTO t_enable VALUES(2, 'BBB');
ALTER TABLE t_enable DISABLE CONSTRAINT te_name_nn;
INSERT INTO t_enable VALUES(3, NULL);
ALTER TABLE t_enable ENABLE NOVALIDATE CONSTRAINT te_name_nn;
INSERT INTO t_enable VALUES(4, NULL);

ALTER TABLE t_enable DISABLE CONSTRAINT te_name_nn;
ALTER TABLE t_enable ENABLE VALIDATE CONSTRAINT te_name_nn;

CREATE TABLE tt501
( no        NUMBER ,
  name      VARCHAR2(10)       CONSTRAINT tt551_uk UNIQUE);

ALTER TABLE tt501 DISABLE CONSTRAINT TT551_UK;

INSERT INTO tt501 VALUES(1, 'AAA');
INSERT INTO tt501 VALUES(2, 'AAA');
INSERT INTO tt501 VALUES(3, 'AAA');

commit;

SELECT * FROM tt501;

ALTER TABLE tt501 ENABLE VALIDATE CONSTRAINT TT551_uk
EXCEPTIONS INTO EXCEPTIONS;

SELECT rowid , name
FROM tt501
WHERE rowid IN(SELECT row_id FROM exceptions);

UPDATE tt501
SET name = 'BBB'
WHERE rowid = 'AAAE9jAAFAAAAL+AAB';

UPDATE tt501
SET name = 'CCC'
WHERE rowid = 'AAAE9jAAFAAAAL+AAC';

commit;

INSERT INTO tt501 VALUES(4, 'DDD');

SELECT owner , constraint_name , constraint_type , status
FROM user_constraints
WHERE table_name = 'NEW_EMP2';

SELECT owner , constraint_name , table_name , column_name
FROM user_cons_columns
WHERE table_name = 'EMP';

SELECT a.table_name "Child_Table" , 
       c.column_name "Child_Column" ,
       a.constraint_name "Child_Cons_name" ,
       b.table_name "Parent_Table" ,
       a.r_constraint_name "Parent_Cons_name" ,       
       d.column_name "Parent_Column"
FROM user_constraints a , user_constraints b , user_cons_columns c ,
     ( SELECT constraint_name , column_name , table_name
       FROM user_cons_columns) d
WHERE a.r_constraint_name = b.constraint_name
AND   a.constraint_name = c.constraint_name
AND   a.r_constraint_name = d.constraint_name
AND   a.constraint_type = 'R';

ALTER TABLE new_emp2
DROP CONSTRAINT emp2_name_fk;

SELECT owner , constraint_name , table_name , column_name
FROM user_cons_columns
WHERE table_name = 'NEW_EMP2';

-- 연습문제
-- ex01
CREATE TABLE tcons
( no        NUMBER(5)       CONSTRAINT tcons_no_pk PRIMARY KEY ,
  name      VARCHAR2(20)    CONSTRAINT tcons_name_nn NOT NULL ,
  jumin     VARCHAR2(13)    CONSTRAINT tcons_jumin_nn NOT NULL
                            CONSTRAINT tcons_jumin_uk UNIQUE ,
  area      NUMBER(1)       CONSTRAINT tcons_area_ck CHECK(area BETWEEN 1 AND 4) ,
  deptno    VARCHAR2(6)     CONSTRAINT tcons_deptno_fk REFERENCES dept2(dcode) );

SELECT * FROM tcons;

-- ex02
ALTER TABLE tcons
ADD CONSTRAINT tcons_name_fk FOREIGN KEY(name)
REFERENCES emp2(name);

-- ex03
ALTER TABLE tcons
DISABLE CONSTRAINT tcons_jumin_uk;

-- ex04
ALTER TABLE tcons
ENABLE VALIDATE CONSTRAINT tcons_jumin_uk;

-- ex05
SELECT * FROM user_constraints;
SELECT * FROM user_cons_columns;

SELECT table_name , column_name , constraint_name
FROM user_cons_columns 
WHERE table_name = 'EMP';

CREATE UNIQUE INDEX idx_dept2_dname
ON dept2(dname);

INSERT INTO dept2 VALUES(9100, 'TEMP_01', 1006, 'Seoul Branches');
INSERT INTO dept2 VALUES(9101, 'TEMP_01', 1006, 'Busan Branches');

CREATE INDEX idx_dept2_area
ON dept2(area);

CREATE INDEX idx_prof_pay_fbi
ON professor(pay+1000);

SELECT * FROM professor;

CREATE INDEX idx_prof_pay
ON professor(pay desc);

CREATE BITMAP INDEX idx_emp_sex_bit
ON emp(sex);

SELECT table_name , column_name , index_name
FROM user_ind_columns
WHERE table_name = 'EMP2';

SELECT table_name , index_name
FROM user_indexes
WHERE table_name = 'DEPT2';

ALTER INDEX EMP_NAME_UK MONITORING USAGE;

SELECT index_name, used
FROM v$object_usage
WHERE index_name = 'EMP_NAME_UK';

ALTER INDEX EMP_NAME_UK NOMONITORING USAGE;
commit;

CREATE TABLE inx_test (no   NUMBER);

BEGIN
    FOR i IN 1..10000 LOOP
        INSERT INTO inx_test VALUES(i);
    END LOOP;
    COMMIT;
END;
/

CREATE INDEX idx_inxtest_no
ON inx_test(no);

ANALYZE INDEX idx_inxtest_no VALIDATE STRUCTURE;

SELECT (del_lf_rows_len / lf_rows_len) * 100 "BALANCE"
FROM index_stats
WHERE name = 'IDX_INXTEST_NO';

DELETE FROM inx_test
WHERE no BETWEEN 1 AND 4000;

SELECT COUNT(*) FROM inx_test;

ALTER INDEX idx_inxtest_no REBUILD;