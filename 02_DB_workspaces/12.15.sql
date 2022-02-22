/* INITCAP(str) : 단어의 시작 첫글자 대문자 변환 */
SELECT empno , INITCAP(ename) "INITCAP NAME" 
FROM emp 
WHERE deptno = 10;

SELECT profno , INITCAP(name) "INITCAP NAME" 
FROM professor 
WHERE deptno = 101;

/* LOWER(str) / UPPER(str) : 소문자 / 대문자 변환 */
SELECT empno , LOWER(ename) "LOWER" , UPPER(ename) "UPPER" 
FROM emp 
WHERE deptno = 30;

/* LENGTH(str) / LENGTHB(str) : 문자열의 길이 / 문자열의 바이트 수 */
SELECT ename , LENGTH(ename) "LENGTH" , LENGTHB(ename) "LENGTHB" 
FROM emp 
WHERE deptno = 10;

SELECT '김진웅' "NAME" , LENGTH('김진웅') "LENGTH" , LENGTHB('김진웅') "LENGTHB" 
FROM dual;                                                                                                                                             /* dual : 가상의 테이블 */

SELECT ename , LENGTH(ename) 
FROM emp 
WHERE LENGTH(ename) > LENGTH('&ename');

/* CONCAT(str, str) : 문자열 이어붙이기 */
SELECT CONCAT(INITCAP(ename) , INITCAP(job))
FROM emp
WHERE deptno = 10;

/* SUBSTR(str , index , length), SUBSTRB(str, index, byteLength) : 문자열 추출하기 */
SELECT SUBSTR('abcde', 3, 2) "3, 2" , SUBSTR('abcde' , -3, 2) "-3, 2" , SUBSTR('abcde' , -3 , 4) "-3, 4"
FROM dual;

SELECT deptno1, studno , name , SUBSTR(jumin, 3, 4) "Birthday" , LPAD(SUBSTR(jumin, 3, 4)-1, 4, '0') "Birthday D-1"
FROM student
WHERE deptno1 = 101;

SELECT * FROM nls_database_parameters WHERE parameter = 'NLS_CHARACTERSET';
SELECT '서진수' "NAME" , LENGTH('서진수') "LENGTH" , LENGTHB('서진수') "LENGTHB", 
       SUBSTR('서진수', 1, 1) "SUBSTR 1, 1" , SUBSTRB('서진수', 1, 3) "SUBSTRB 1, 3"
FROM dual;

/* INSTR(str1, str2, index, n) : 문자열 str1을 index부터 검색하여, str2가 n번째로 나오는 index 반환 (index가 양수이면 왼쪽부터, 음수이면 오른쪽부터 검색) */
SELECT 'A-B-C-D' "STR" , INSTR('A-B-C-D', '-' , 1 , 3) "INSTR"
FROM dual;

SELECT 'A-B-C-D' "STR" , INSTR('A-B-C-D', '-' , 3 , 1) "INSTR"
FROM dual;

SELECT name , tel, INSTR(tel, ')') "INSTR"                                                                                                             /* index, n 생략하면 default값으로 설정(= default 1, 1) */
FROM student
WHERE deptno1 = 201;

SELECT name , tel , INSTR(tel, '3') "INSTR"
FROM student
WHERE deptno1 = 101;

SELECT name , tel , SUBSTR(tel, 1, INSTR(tel, ')')-1 ) "AREA CODE"
FROM student
WHERE deptno1 = 201;

/* LPAD(str1, length, str2) , RPAD() : str1을 length만큼 출력하고, 모자란 자리를 str2로 채운다. (한글은 한 글자에 length = 2) */
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

SELECT RPAD('서진수', 9 + LENGTH('서진수') , SUBSTR('123456789', LENGTH('서진수')+1) ) "RPAD(KORname)"
FROM dual;

/* LTRIM(str1, str2) / RTRIM(str1 , str2) : str1의 시작(LTRIM)이나 끝(RTRIM)에 있는 str2를 제거  */
SELECT ename, LTRIM(ename, 'C') "LTRIM"
FROM emp
WHERE deptno = 10;

SELECT ename, RTRIM(ename, 'R') "RTRIM"
FROM emp
WHERE deptno = 10;

/* REPLACE(str1, str2, str3) : str1의 str2값을 str3으로 대체 */
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

/* ROUND(double, n) : 소수점 n자리로 표현(소수점 n + 1번째 자리에서 반올림 / 음수일 때는 -n + 1번째 정수 자리에서 반올림) */
SELECT ROUND(987.654, 2) "ROUND1" , ROUND(987.654 , 0) "ROUND2" , ROUND(987.654, -1) "ROUND3" , ROUND(987.654, -2) "ROUND4"
FROM dual;

/* TRUNC(double, n) : 소수점 n자리로 표현(소수점 n + 1번째 자리에서 버림 / 음수일 때는 -n + 1번째 정수 자리에서 버림) */
SELECT TRUNC(987.654, 2) "TRUNC1" , TRUNC(987.654 , 0) "TRUNC2" , TRUNC(987.654, -1) "TRUNC3" , TRUNC(987.654, -2) "TRUNC4"
FROM dual;

/* MOD(n1 , n2) : n1 % n2 , CEIL(double) : double과 가장 가까운 큰 정수 값 , FLOOR(double) : 가장 가까운 작은 정수 값 */
SELECT MOD(121, 10) "MOD()" , CEIL(123.45) "CEIL()" , FLOOR(123.45) "FLOOR"
FROM dual;

/*CEIL ex1*/
SELECT rownum "ROWNUM" , CEIL(rownum/3) "TEAM NUM" , ename
FROM emp;

/* POWER(n1, n2) : n1의 n2승 값 */
SELECT POWER(2,3)
FROM dual;

/* 날짜 관련 함수 */
SELECT SYSDATE "SYSDATE" FROM dual;                                                                                                                    /* SYSDATE              : 서버의 현재 날짜 출력 */
SELECT MONTHS_BETWEEN('14/12/30' , '14/08/31') "MONTH_BETWEEN" FROM dual;                                                                              /* MONTHS_BETWEEN(date1, date2) : date1.month - date2.month (윤년체크 불가능)*/

SELECT ename , hiredate , ROUND(MONTHS_BETWEEN(TO_DATE('04/05/31'), hiredate), 1) "DATE1" ,                                                            /* TO_DATE('YY/MM/DD')  : 문자를 날짜로 변환 */
ROUND(((TO_DATE('04/05/31') - hiredate)/31), 1) "DATE2"
FROM emp
WHERE deptno = 10;

SELECT SYSDATE , ADD_MONTHS(SYSDATE , 2) "ADD_MONTHS" FROM dual;                                                                                       /* ADD_MONTHS(date , n) : month + n */
SELECT SYSDATE , NEXT_DAY(SYSDATE, '월') "NEXT_DAY" FROM dual;                                                                                         /* NEXT_DAY(date , 요일) : date 기준으로 가장 가까운 미래에 있는 지정 요일의 날짜를 불러옴 */
SELECT SYSDATE , LAST_DAY(SYSDATE) "LAST_DAY1", LAST_DAY('14/05/01') "LAST_DAY1" FROM dual;                                                            /* LAST_DAY(date)       : 주어진 YY/MM의 마지막 날짜 */

ALTER SESSION set NLS_DATE_FORMAT = 'YYYY-MM-DD,HH24:MI:SS';                                                                                           /* date 포맷을 지정해 주는 명령어 */
SELECT SYSDATE FROM dual;
SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE) FROM dual;                                                                                              /* ROUND(date) : 시간에서 반올림 / TRUNC(date) : 시간에서 버림 */

/* TO_CHAR(date, str) : date를 str에 맞는 형식의 문자열로 출력 */
SELECT SYSDATE , TO_CHAR(SYSDATE, 'YYYY') "YYYY",                                                                                                      /* YYYY : 4자리 년도 값 */
                 TO_CHAR(SYSDATE, 'RRRR') "RRRR",                                                                                                      /* RRRR : 4자리 년도 값 */
                 TO_CHAR(SYSDATE, 'YY')   "YY"  ,                                                                                                      /* YY   : 2자리 년도 값(끝에 2자리)*/
                 TO_CHAR(SYSDATE, 'RR')   "RR"  ,                                                                                                      /* RR   : 2자리 년도 값(끝에 2자리) */
                 TO_CHAR(SYSDATE, 'YEAR') "YEAR"                                                                                                       /* YEAR : 해당 년도의 영문 문자열 값 */
FROM dual;   
                 
SELECT SYSDATE,  TO_CHAR(SYSDATE, 'MM')    "MM",                                                                                                       /* MM    : 2자리 month 값 */
                 TO_CHAR(SYSDATE, 'MON')   "MON",                                                                                                      /* MON   : 'MM월' 문자열로 출력 */
                 TO_CHAR(SYSDATE, 'MONTH') "MONTH"                                                                                                     /* MONTH : 'MM월' 문자열로 출력 */
FROM dual;

SELECT SYSDATE,  TO_CHAR(SYSDATE, 'DD')    "DD",                                                                                                       /* DD   : 2자리 date 값*/
                 TO_CHAR(SYSDATE, 'DAY')   "DAY",                                                                                                      /* DAY  : 요일 값 */
                 TO_CHAR(SYSDATE, 'DDTH')  "DDTH"                                                                                                      /* DDTH : 몇 번째 date인지 서수로 표현*/
FROM dual;

SELECT SYSDATE,  TO_CHAR(SYSDATE, 'RRRR-MM-DD:HH24:MI:SS') "FORMAT"                                                                                    /* FORMAT : 지정한 format으로 날짜 출력 */
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


SELECT name , pay , bonus , TO_CHAR((pay * 12) + bonus, '$9999') "PAYFORYEAR"                                                                          /* TO_CHAR(data, '$09999.99' : $ 달러표시 삽입, 0 - 빈자리 0으로 채움 , . - 소수점 표현 */
FROM professor
WHERE deptno = 201;

/*ex03*/
SELECT empno, ename, TO_CHAR(hiredate,'YY/MM/DD')                 "HIREDATE",
                     TO_CHAR((sal * 12)+comm, '$99,999')          "SAL",
                     TO_CHAR((sal * 12 + comm) * 1.15, '$99,999') "15% UP"
FROM emp
WHERE comm IS NOT NULL;



