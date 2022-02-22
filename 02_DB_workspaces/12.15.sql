/* INITCAP(str) : �ܾ��� ���� ù���� �빮�� ��ȯ */
SELECT empno , INITCAP(ename) "INITCAP NAME" 
FROM emp 
WHERE deptno = 10;

SELECT profno , INITCAP(name) "INITCAP NAME" 
FROM professor 
WHERE deptno = 101;

/* LOWER(str) / UPPER(str) : �ҹ��� / �빮�� ��ȯ */
SELECT empno , LOWER(ename) "LOWER" , UPPER(ename) "UPPER" 
FROM emp 
WHERE deptno = 30;

/* LENGTH(str) / LENGTHB(str) : ���ڿ��� ���� / ���ڿ��� ����Ʈ �� */
SELECT ename , LENGTH(ename) "LENGTH" , LENGTHB(ename) "LENGTHB" 
FROM emp 
WHERE deptno = 10;

SELECT '������' "NAME" , LENGTH('������') "LENGTH" , LENGTHB('������') "LENGTHB" 
FROM dual;                                                                                                                                             /* dual : ������ ���̺� */

SELECT ename , LENGTH(ename) 
FROM emp 
WHERE LENGTH(ename) > LENGTH('&ename');

/* CONCAT(str, str) : ���ڿ� �̾���̱� */
SELECT CONCAT(INITCAP(ename) , INITCAP(job))
FROM emp
WHERE deptno = 10;

/* SUBSTR(str , index , length), SUBSTRB(str, index, byteLength) : ���ڿ� �����ϱ� */
SELECT SUBSTR('abcde', 3, 2) "3, 2" , SUBSTR('abcde' , -3, 2) "-3, 2" , SUBSTR('abcde' , -3 , 4) "-3, 4"
FROM dual;

SELECT deptno1, studno , name , SUBSTR(jumin, 3, 4) "Birthday" , LPAD(SUBSTR(jumin, 3, 4)-1, 4, '0') "Birthday D-1"
FROM student
WHERE deptno1 = 101;

SELECT * FROM nls_database_parameters WHERE parameter = 'NLS_CHARACTERSET';
SELECT '������' "NAME" , LENGTH('������') "LENGTH" , LENGTHB('������') "LENGTHB", 
       SUBSTR('������', 1, 1) "SUBSTR 1, 1" , SUBSTRB('������', 1, 3) "SUBSTRB 1, 3"
FROM dual;

/* INSTR(str1, str2, index, n) : ���ڿ� str1�� index���� �˻��Ͽ�, str2�� n��°�� ������ index ��ȯ (index�� ����̸� ���ʺ���, �����̸� �����ʺ��� �˻�) */
SELECT 'A-B-C-D' "STR" , INSTR('A-B-C-D', '-' , 1 , 3) "INSTR"
FROM dual;

SELECT 'A-B-C-D' "STR" , INSTR('A-B-C-D', '-' , 3 , 1) "INSTR"
FROM dual;

SELECT name , tel, INSTR(tel, ')') "INSTR"                                                                                                             /* index, n �����ϸ� default������ ����(= default 1, 1) */
FROM student
WHERE deptno1 = 201;

SELECT name , tel , INSTR(tel, '3') "INSTR"
FROM student
WHERE deptno1 = 101;

SELECT name , tel , SUBSTR(tel, 1, INSTR(tel, ')')-1 ) "AREA CODE"
FROM student
WHERE deptno1 = 201;

/* LPAD(str1, length, str2) , RPAD() : str1�� length��ŭ ����ϰ�, ���ڶ� �ڸ��� str2�� ä���. (�ѱ��� �� ���ڿ� length = 2) */
SELECT name, ID, RPAD(ID, 10, ' ')
FROM student
WHERE deptno1 = 201;

SELECT LPAD(ename, 9, '123456789') "LPAD"
FROM emp
WHERE deptno = 10;

SELECT ename , RPAD(ename, 10, '-') "RPAD(ename)"
FROM emp
WHERE deptno = 10;

SELECT RPAD(ename, 9, SUBSTR('123456789', LENGTH(ename)+1)) "RPAD(ename)"
FROM emp
WHERE deptno = 10;

SELECT RPAD('������', 9 + LENGTH('������') , SUBSTR('123456789', LENGTH('������')+1) ) "RPAD(KORname)"
FROM dual;

/* LTRIM(str1, str2) / RTRIM(str1 , str2) : str1�� ����(LTRIM)�̳� ��(RTRIM)�� �ִ� str2�� ����  */
SELECT ename, LTRIM(ename, 'C') "LTRIM"
FROM emp
WHERE deptno = 10;

SELECT ename, RTRIM(ename, 'R') "RTRIM"
FROM emp
WHERE deptno = 10;

/* REPLACE(str1, str2, str3) : str1�� str2���� str3���� ��ü */
SELECT ename, REPLACE(ename, SUBSTR(ename,1,2), '***') "REPLACE"
FROM emp
WHERE deptno = 10;

/*ex1*/
SELECT ename , REPLACE(ename, SUBSTR(ename,3,2), '--') "REPLACE(ename)"
FROM emp
WHERE deptno = 20;
/*ex2*/
SELECT name , jumin , REPLACE(jumin, SUBSTR(jumin, 7), '-*******' ) "REPLACE(jumin)"
FROM student
WHERE deptno1 = 101;
/*ex3*/
SELECT name, tel, REPLACE(tel, SUBSTR(tel, INSTR(tel, ')') + 1, INSTR(tel, '-') - (INSTR(tel, ')') + 1)), '***') "REPLACE(tel)"
FROM student
WHERE deptno1 = 101;
/*ex4*/
SELECT name, tel, REPLACE(tel, SUBSTR(tel, INSTR(tel, '-') + 1), '****') "REPLACE(tel)"
FROM student
WHERE deptno1 = 101;

/* ROUND(double, n) : �Ҽ��� n�ڸ��� ǥ��(�Ҽ��� n + 1��° �ڸ����� �ݿø� / ������ ���� -n + 1��° ���� �ڸ����� �ݿø�) */
SELECT ROUND(987.654, 2) "ROUND1" , ROUND(987.654 , 0) "ROUND2" , ROUND(987.654, -1) "ROUND3" , ROUND(987.654, -2) "ROUND4"
FROM dual;

/* TRUNC(double, n) : �Ҽ��� n�ڸ��� ǥ��(�Ҽ��� n + 1��° �ڸ����� ���� / ������ ���� -n + 1��° ���� �ڸ����� ����) */
SELECT TRUNC(987.654, 2) "TRUNC1" , TRUNC(987.654 , 0) "TRUNC2" , TRUNC(987.654, -1) "TRUNC3" , TRUNC(987.654, -2) "TRUNC4"
FROM dual;

/* MOD(n1 , n2) : n1 % n2 , CEIL(double) : double�� ���� ����� ū ���� �� , FLOOR(double) : ���� ����� ���� ���� �� */
SELECT MOD(121, 10) "MOD()" , CEIL(123.45) "CEIL()" , FLOOR(123.45) "FLOOR"
FROM dual;

/*CEIL ex1*/
SELECT rownum "ROWNUM" , CEIL(rownum/3) "TEAM NUM" , ename
FROM emp;

/* POWER(n1, n2) : n1�� n2�� �� */
SELECT POWER(2,3)
FROM dual;

/* ��¥ ���� �Լ� */
SELECT SYSDATE "SYSDATE" FROM dual;                                                                                                                    /* SYSDATE              : ������ ���� ��¥ ��� */
SELECT MONTHS_BETWEEN('14/12/30' , '14/08/31') "MONTH_BETWEEN" FROM dual;                                                                              /* MONTHS_BETWEEN(date1, date2) : date1.month - date2.month (����üũ �Ұ���)*/

SELECT ename , hiredate , ROUND(MONTHS_BETWEEN(TO_DATE('04/05/31'), hiredate), 1) "DATE1" ,                                                            /* TO_DATE('YY/MM/DD')  : ���ڸ� ��¥�� ��ȯ */
ROUND(((TO_DATE('04/05/31') - hiredate)/31), 1) "DATE2"
FROM emp
WHERE deptno = 10;

SELECT SYSDATE , ADD_MONTHS(SYSDATE , 2) "ADD_MONTHS" FROM dual;                                                                                       /* ADD_MONTHS(date , n) : month + n */
SELECT SYSDATE , NEXT_DAY(SYSDATE, '��') "NEXT_DAY" FROM dual;                                                                                         /* NEXT_DAY(date , ����) : date �������� ���� ����� �̷��� �ִ� ���� ������ ��¥�� �ҷ��� */
SELECT SYSDATE , LAST_DAY(SYSDATE) "LAST_DAY1", LAST_DAY('14/05/01') "LAST_DAY1" FROM dual;                                                            /* LAST_DAY(date)       : �־��� YY/MM�� ������ ��¥ */

ALTER SESSION set NLS_DATE_FORMAT = 'YYYY-MM-DD,HH24:MI:SS';                                                                                           /* date ������ ������ �ִ� ��ɾ� */
SELECT SYSDATE FROM dual;
SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE) FROM dual;                                                                                              /* ROUND(date) : �ð����� �ݿø� / TRUNC(date) : �ð����� ���� */

/* TO_CHAR(date, str) : date�� str�� �´� ������ ���ڿ��� ��� */
SELECT SYSDATE , TO_CHAR(SYSDATE, 'YYYY') "YYYY",                                                                                                      /* YYYY : 4�ڸ� �⵵ �� */
                 TO_CHAR(SYSDATE, 'RRRR') "RRRR",                                                                                                      /* RRRR : 4�ڸ� �⵵ �� */
                 TO_CHAR(SYSDATE, 'YY')   "YY"  ,                                                                                                      /* YY   : 2�ڸ� �⵵ ��(���� 2�ڸ�)*/
                 TO_CHAR(SYSDATE, 'RR')   "RR"  ,                                                                                                      /* RR   : 2�ڸ� �⵵ ��(���� 2�ڸ�) */
                 TO_CHAR(SYSDATE, 'YEAR') "YEAR"                                                                                                       /* YEAR : �ش� �⵵�� ���� ���ڿ� �� */
FROM dual;   
                 
SELECT SYSDATE,  TO_CHAR(SYSDATE, 'MM')    "MM",                                                                                                       /* MM    : 2�ڸ� month �� */
                 TO_CHAR(SYSDATE, 'MON')   "MON",                                                                                                      /* MON   : 'MM��' ���ڿ��� ��� */
                 TO_CHAR(SYSDATE, 'MONTH') "MONTH"                                                                                                     /* MONTH : 'MM��' ���ڿ��� ��� */
FROM dual;

SELECT SYSDATE,  TO_CHAR(SYSDATE, 'DD')    "DD",                                                                                                       /* DD   : 2�ڸ� date ��*/
                 TO_CHAR(SYSDATE, 'DAY')   "DAY",                                                                                                      /* DAY  : ���� �� */
                 TO_CHAR(SYSDATE, 'DDTH')  "DDTH"                                                                                                      /* DDTH : �� ��° date���� ������ ǥ��*/
FROM dual;

SELECT SYSDATE,  TO_CHAR(SYSDATE, 'RRRR-MM-DD:HH24:MI:SS') "FORMAT"                                                                                    /* FORMAT : ������ format���� ��¥ ��� */
FROM dual;


/*ex1*/
SELECT studno , name , TO_CHAR(birthday, 'YY/MM/DD') "BIRTHDAY"
FROM student
WHERE TO_CHAR(birthday, 'MM') = '01';

/*ex02*/
SELECT empno , ename , TO_CHAR(hiredate, 'YY/MM/DD') "HIREDATE"
FROM emp
WHERE TO_CHAR(hiredate, 'MM') BETWEEN '01' AND '03';
/* WHERE TO_CHAR(hiredate, 'MM') IN(01, 02, 03); */
/* WHERE TO_CHAR(hiredate, 'MM') <= 3; */


SELECT name , pay , bonus , TO_CHAR((pay * 12) + bonus, '$9999') "PAYFORYEAR"                                                                          /* TO_CHAR(data, '$09999.99' : $ �޷�ǥ�� ����, 0 - ���ڸ� 0���� ä�� , . - �Ҽ��� ǥ�� */
FROM professor
WHERE deptno = 201;

/*ex03*/
SELECT empno, ename, TO_CHAR(hiredate,'YY/MM/DD')                 "HIREDATE",
                     TO_CHAR((sal * 12)+comm, '$99,999')          "SAL",
                     TO_CHAR((sal * 12 + comm) * 1.15, '$99,999') "15% UP"
FROM emp
WHERE comm IS NOT NULL;



