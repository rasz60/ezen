SELECT TO_NUMBER('10')
FROM dual;                                                                                                                                             /* TO_NUMBER(strNum) : CHARŸ������ �� ���ڸ� �̷���� NUMBERŸ������ ��ȯ */

SELECT ASCII('A')
FROM dual;                                                    

SELECT TO_DATE('2021/12/16')
FROM dual;                                                                                                                                             /* TO_DATE(str<date>) : CHARŸ������ �� date�� DATEŸ������ ��ȯ */

SELECT ename , comm , NVL(comm, 0) , NVL(comm, 100)                                                                                                    /* NVL(col, str) : column���� NULL���� ������ str�� ġȯ */
FROM emp
WHERE deptno = 30;

/*ex01*/
SELECT profno , name , pay , NVL(bonus, 0) "BONUS", TO_CHAR(pay*12 + NVL(bonus, 0), '999,999') "TOTAL"
FROM professor
WHERE deptno = 201;

SELECT empno , ename , sal , comm "COMM" , NVL2(comm, sal + comm, sal * 0) "NVL2"                                                                      /* NVL2(col, a, b) : col���� NULL�̸� b, �ƴϸ� a�� ��� */
FROM emp
WHERE deptno = 30;

/*ex02*/
SELECT empno , ename , comm , NVL2(comm, 'Exist', 'NULL') "NVL2"
FROM emp
WHERE deptno = 30;

/* DECODE() case 1 */
SELECT deptno , name , DECODE(deptno, 101, 'Computer Engineering', 'etc.') "DNAME"                                                                     /*DECODE(A, B, a, b) : A�� B�� ��� a, �ƴϸ� b�� ��� (b�� �����ϸ� NULL) */
FROM professor;

/* DECODE() case 2 */
SELECT deptno , name , DECODE(deptno, 101, 'Computer Engineering', 102, 'Multimedia Engineering', 103, 'Software Engineering', 'ETC') "DNAME"          /* DECODE(A, B, a, C, b, D, c, d) : A�� B�̸� a, C�̸� b, D�̸� c, �� �� �ƴϸ� d ��� */
FROM professor;

/* DECODE() case 3 */
SELECT deptno , name , DECODE(deptno, 101, DECODE(name, 'Audie Murphy', 'BEST!')) "ETC"                                                                /* DECODE(A, B, DECODE(C, a, b), c) : A�� B�̸鼭 C�̸� a, B������ C�� �ƴ� �� b, �� �� �ƴ� �� c ��� */
FROM professor;

SELECT deptno , name , DECODE(deptno, 101, DECODE(name, 'Audie Murphy', 'BEST!', 'GOOD!')) "ETC"
FROM professor;

SELECT deptno , name , DECODE(deptno, 101, DECODE(name, 'Audie Murphy', 'BEST!', 'GOOD!'), 'N/A') "ETC"
FROM professor;

/*ex01*/
SELECT name, jumin, DECODE(SUBSTR(jumin, 7, 1), 1, 'MAN', 'WOMAN') "GENDER"
FROM student
WHERE deptno1 = 101;

/*ex02*/
SELECT name , tel , DECODE(SUBSTR(tel, 1, INSTR(tel, ')')-1), '02' , 'SEOUL', 
                                                              '031', 'GYEONGGI', 
                                                              '051', 'BUSAN', 
                                                              '052', 'ULSAN', 
                                                              '055', 'GYEONGNAM', 'etc') "LOC"
FROM student
WHERE deptno1= 101;

/*CASE case 1*/
SELECT name , tel , CASE(SUBSTR(tel, 1, INSTR(tel, ')') - 1)) WHEN '02'  THEN 'SEOUL'                                                                  /* CASE(case) - WHEN A THEN B... ELSE C - END "AS"*/
                                                              WHEN '031' THEN 'GYEONGGI'                                                               /* case ������ ���� A�� ��, B�� �ƴҶ��� C�� ����ϰ�, Į���� �̸��� AS�� �Ѵ�.*/
                                                              WHEN '051' THEN 'BUSAN'
                                                              WHEN '052' THEN 'ULSAN'
                                                              WHEN '055' THEN 'GYEONGNAM'
                                                                         ELSE 'ETC'
                    END "LOC"
FROM student
WHERE deptno1 = 201;

/*CASE case 2*/
SELECT name , SUBSTR(jumin, 3, 2) "MONTH" , CASE WHEN SUBSTR(jumin, 3, 2) BETWEEN '01' AND '03' THEN '1/4'
                                                 WHEN SUBSTR(jumin, 3, 2) BETWEEN '04' AND '06' THEN '2/4'
                                                 WHEN SUBSTR(jumin, 3, 2) BETWEEN '07' AND '09' THEN '3/4'
                                                 WHEN SUBSTR(jumin, 3, 2) BETWEEN '10' AND '12' THEN '4/4'
                                            END "Quarter"
FROM student;

/*ex01*/
SELECT empno , ename , sal , CASE WHEN sal BETWEEN    1 AND 1000 THEN 'LEVEL 1'                                 
                                  WHEN sal BETWEEN 1001 AND 2000 THEN 'LEVEL 2'
                                  WHEN sal BETWEEN 2001 AND 3000 THEN 'LEVEL 3'
                                  WHEN sal BETWEEN 3001 AND 4000 THEN 'LEVEL 4'
                                  WHEN sal > 4001 THEN 'LEVEL 5'
                                  ELSE 'LEVEL0'
                            END "LEVEL"
FROM emp
ORDER BY 3 desc;                                                                                                                                       /* ORDER BY 3 DESC : 3��° ���� �������� ����.! */

/*REGEXP_LIKE(col, pattern) : Į���� pattern ���ǿ� �´� ���� ã�Ƽ� ��ȯ */
SELECT * FROM t_reg;

SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-z]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[A-Z]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-zA-Z]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-z] ');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-z] [0-9]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-z]{4}');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[0-9]{3}');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[a-z][0-9]{3}');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[[:upper:]]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[[:lower:]]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[[:space:]]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '^[a-z]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '^[a-z]|^[0-9]');

SELECT name , ID FROM student WHERE REGEXP_LIKE(ID, '^M(a|o)');

SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[A-Za-z]$');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[[:alpha:]]$');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '[0-9]$');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '^[^0-9]');
SELECT * FROM t_reg WHERE REGEXP_LIKE(text, '^[^[:alpha:]]');

SELECT * FROM t_reg WHERE NOT REGEXP_LIKE(text, '[[:alpha:]]');

SELECT name , tel
FROM student
WHERE REGEXP_LIKE(tel, '^[0-9]{2}\)[0-9]{4}');                                                                                                         /* '\' : ���ԽĿ��� Ư�� Ư�����ڰ� ����� �νĵǰԲ� �տ� ���̴� ����(��Ÿ����) */

SELECT name , ID
FROM student
WHERE REGEXP_LIKE(ID, '^...r.');

SELECT *
FROM t_reg2
WHERE REGEXP_LIKE(ip, '^[172]{3}\.[16]{2}\.[168]{3}');

SELECT *
FROM t_reg2
WHERE REGEXP_LIKE(ip, '^[01]{2}\.[01]{2}\.{01}');

SELECT *
FROM t_reg
WHERE NOT REGEXP_LIKE(text, '[a-zA-Z]');

SELECT *
FROM t_reg
WHERE NOT REGEXP_LIKE(text, '[0-9]');

SELECT *
FROM t_reg
WHERE REGEXP_LIKE(text, '!');

SELECT *
FROM t_reg
WHERE REGEXP_LIKE(text, '?');                                                                                                                          /* ���ԽĿ��� '?'�� '*'�� '��� ��'���� �ؼ��ǹǷ� ��Ÿ���ڿ� �Բ� ����� */

SELECT *
FROM t_reg
WHERE REGEXP_LIKE(text, '\?');

SELECT text , REGEXP_REPLACE(text, '[[:digit:]]', '*') "NO->CHAR"
FROM t_reg;

SELECT text , REGEXP_REPLACE(text, '([0-9])', '\1-*') "Add Char"
FROM t_reg;

SELECT REGEXP_REPLACE('aaa bbb'  , '( ){2,}', '*') "ONE" ,
       REGEXP_REPLACE('aaa  bbb' , '( ){2,}', '*') "TWO" ,
       REGEXP_REPLACE('aaa   bbb', '( ){2,}', '*') "THREE"
FROM dual;

SELECT studno , name , ID
FROM student
WHERE ID = REGEXP_REPLACE('&ID', '( ){1,}', '');

SELECT studno , name , ID
FROM student
WHERE ID = LOWER(REGEXP_REPLACE('&ID', '( ){1,}', ''));

SELECT '20211216' "DATE" , REGEXP_REPLACE('20211216', '([[:digit:]]{4})([[:digit:]]{2})([[:digit:]]{2})', '\1-\2-\3') "REGEXP_REPLACE"
FROM dual;

SELECT 'ABC* *DEF $DEF%KJL DEF' "STR" , REGEXP_SUBSTR('ABC* *DEF $DEF%KJL DEF' , '[^ ]+[DEF]') "REGEXP_SUBSTR"
FROM dual;

SELECT name , LTRIM(REGEXP_SUBSTR(hpage, '/([[:alnum:]]+\.?){3,4}?'), '/') "URL"
FROM professor
WHERE hpage IS NOT NULL;

SELECT name , LTRIM(REGEXP_SUBSTR(email,'@([[:alnum:]]+\.?){2,}'), '@') "DOMAIN"
FROM professor
WHERE email IS NOT NULL;

SELECT REGEXP_SUBSTR('sys/oracle@racdb:1521:racdb', '[^:]+', 1, 3) "RESULT"
FROM dual;

SELECT REGEXP_SUBSTR('sys/oracle@racdb:1521:racdb', '[^:]+', 1, 2) "RESULT"
FROM dual;

SELECT text , REGEXP_COUNT(text, 'A') "RESULT 1"
FROM t_reg;

SELECT text , REGEXP_COUNT(text, 'c')           "RESULT 1" ,
              REGEXP_COUNT(text, 'c' , 1 , 'i') "RESULT 2"                                                                                             /* i : ��ҹ��� ���о��� count */
FROM t_reg;

SELECT text , REGEXP_COUNT(text, '\.') "RESULT 1"
FROM t_reg;

SELECT text , REGEXP_COUNT(text, 'aa')     "RESULT 1" ,
              REGEXP_COUNT(text, 'a{2}')   "RESULT 2" ,
              REGEXP_COUNT(text, '(a)(a)') "RESULT 3"
FROM t_reg;