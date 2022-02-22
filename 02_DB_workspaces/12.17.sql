SELECT COUNT(*), COUNT(comm) "COUNT(comm)", SUM(comm) "SUM(comm)", ROUND(AVG(NVL(comm, 0)),1) "AVG(comm)"                                              /* COUNT(col) , SUM(col) , AVG(col) : 해당 칼럼의 값의 개수(NULL 제외) , 총 합 , 평균 값 출력 */
FROM emp;

SELECT MAX(sal), MIN(sal) FROM emp;                                                                                                                    /* MAX(col) , MIN(col) : 해당 칼럼의 최대 , 최소 값 출력 */
SELECT MAX(hiredate), MIN(hiredate) FROM emp;

SELECT stddev(sal), VARIANCE(sal) FROM emp;                                                                                                            /* stddev(col) , VARIANCE(col) : 해당 칼럼의 표준편차, 분산 값 출력 */

SELECT deptno , ROUND(AVG(NVL(sal,0)), 2) "AVG"
FROM emp
GROUP BY deptno;

SELECT deptno , job , ROUND(AVG(NVL(sal,0)),1) "AVG"
FROM emp
GROUP BY deptno, job
ORDER BY 1, 2;

SELECT deptno, ROUND(AVG(NVL(sal,0)),2) "AVG"
FROM emp
GROUP BY deptno
HAVING AVG(NVL(sal,0)) > 2000                                                                                                                          /* GROUP BY에 조건을 줄 때는 HAVING절을 사용 */
ORDER BY 1;

SELECT deptno, NULL job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY deptno

UNION ALL

SELECT deptno, job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY deptno, job

UNION ALL

SELECT NULL deptno, NULL job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
ORDER BY deptno, job;

SELECT deptno, job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY ROLLUP(deptno, job);

SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor
GROUP BY position, ROLLUP(deptno);


-- professor 복제하기
CREATE TABLE professor2
AS SELECT deptno, position, pay
FROM professor;
-- professor2 값 추가
INSERT INTO professor2 VALUES(101, 'instructor', 100);
INSERT INTO professor2 VALUES(101, 'a full professor', 100);
INSERT INTO professor2 VALUES(101, 'assistant professor', 100);
-- professor2 end

SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor2
GROUP BY deptno, ROLLUP(position);

SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor2
GROUP BY ROLLUP(deptno , position);

SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor2
GROUP BY position, ROLLUP(deptno);

-- 실행 계획
EXPLAIN PLAN FOR                                                                                                                                       /* SELECT * FROM table(dbms_xplan.display)을 실행하면 같은 블럭의 작업 예정 사항을 출력 */
SELECT deptno, NULL job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY deptno

UNION ALL

SELECT deptno, job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY deptno, job

UNION ALL

SELECT NULL deptno, NULL job, ROUND(AVG(sal),1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
ORDER BY deptno, job;

SELECT * FROM table(dbms_xplan.display);

EXPLAIN PLAN FOR
SELECT deptno, job, ROUND(avg(nvl(sal,0)), 1) "avg_sal", COUNT(*) "cnt_emp"
FROM emp
GROUP BY ROLLUP(deptno, job);

SELECT * FROM table(dbms_xplan.display);

SELECT * FROM professor2
ORDER BY deptno, position;

SELECT deptno , NVL(position, '10') , SUM(pay)
FROM professor2
GROUP BY deptno, ROLLUP(position);

EXPLAIN PLAN FOR
SELECT deptno , NULL job , ROUND(AVG(sal), 1) "AVG_SAL" , COUNT(*) CNT_EMP
FROM emp
GROUP BY deptno

UNION ALL

SELECT NULL deptno , job , ROUND(AVG(sal), 1) "AVG_SAL" , COUNT(*) CNT_EMP
FROM emp
GROUP BY job

UNION ALL

SELECT deptno , job , ROUND(AVG(sal), 1) "AVG_SAL" , COUNT(*) CNT_EMP
FROM emp
GROUP BY deptno, job

UNION ALL

SELECT NULL deptno , NULL job , ROUND(AVG(sal), 1) "AVG_SAL" , COUNT(*) CNT_EMP
FROM emp
ORDER BY deptno, job;

SELECT * FROM table(dbms_xplan.display);

EXPLAIN PLAN FOR
SELECT deptno , job , ROUND(AVG(sal), 1) "AVG_SAL" , COUNT(*) "CNT_EMP"
FROM emp
GROUP BY CUBE(deptno , job)
ORDER BY 1, 2;

SELECT * FROM table(dbms_xplan.display);

SELECT grade , COUNT(*)
FROM student
GROUP BY grade

UNION

SELECT deptno1 , COUNT(*)
FROM student
GROUP BY deptno1;

SELECT grade , deptno1 , COUNT(*)
FROM student
GROUP BY GROUPING SETS(grade, deptno1);

SELECT grade , deptno1 , profno , COUNT(*) , ROUND(AVG(height), 2) "AVG_height" , ROUND(AVG(weight), 2) "AVG_weight"                                   /* GROUPING SETS(col, col...) : SELECT 수행을 해당 칼럼 별로 진행한다. */
FROM student
GROUP BY GROUPING SETS(grade , deptno1, profno);

SELECT deptno , LISTAGG(ename , ' -> ') WITHIN GROUP(ORDER BY hiredate DESC) "LISTAGG"
FROM emp
GROUP BY deptno;

SELECT job , LISTAGG(ename , ',') WITHIN GROUP(ORDER BY ename) "NAME"
FROM emp
GROUP BY job;

SELECT deptno , SUBSTR(XMLAGG(XMLELEMENT(X, ',', ename) ORDER BY ename)
                .EXTRACT('//text()').getStringVal(), 2) "DEPT_ENAME_LIST"
FROM emp A
GROUP BY deptno;

SELECT MAX(DECODE(day , 'SUN' , dayno)) "SUN",
       MAX(DECODE(day , 'MON' , dayno)) "MON",
       MAX(DECODE(day , 'TUE' , dayno)) "TUE",
       MAX(DECODE(day , 'WED' , dayno)) "WED",
       MAX(DECODE(day , 'THU' , dayno)) "THU",
       MAX(DECODE(day , 'FRI' , dayno)) "FRI",
       MAX(DECODE(day , 'SAT' , dayno)) "SAT"
FROM cal
GROUP BY weekno
ORDER BY weekno;

SELECT * FROM (SELECT weekno "WEEK" , day , dayno FROM cal)
PIVOT
( MAX(dayno) FOR day IN('SUN' AS "SUN" ,
                        'MON' AS "MON" ,
                        'TUE' AS "TUE" ,
                        'WED' AS "WED" ,
                        'THU' AS "THU" ,
                        'FRI' AS "FRI" ,
                        'SAT' AS "SAT" )
)
ORDER BY "WEEK";

SELECT deptno ,
       COUNT(DECODE(job, 'CLERK'    , '0')) "CLERK" , 
       COUNT(DECODE(job, 'MANAGER'  , '0')) "MANAGER" ,
       COUNT(DECODE(job, 'PRESIDENT', '0')) "PRESIDENT" ,
       COUNT(DECODE(job, 'ANALYST'  , '0')) "ANALYST" ,
       COUNT(DECODE(job, 'SALESMAN' , '0')) "SALESMAN"
FROM emp
GROUP BY deptno
ORDER BY 1;

SELECT * FROM (SELECT deptno , empno , job FROM emp)

PIVOT
( COUNT(empno) FOR job IN('CLERK'     AS "CLERK"     , 
                          'MANAGER'   AS "MANAGER"   ,
                          'PRESIDENT' AS "PRESIDENT" ,
                          'ANALYST'   AS "ANALYST"   ,
                          'SALESMAN'  AS "SALESMAN"  )
)
ORDER BY deptno;

SELECT * FROM ( SELECT deptno , empno , job , sal FROM emp )

PIVOT
( COUNT(empno) AS count,
  SUM(NVL(sal, 0)) AS SUM FOR job IN('CLERK'     AS "CLERK"     , 
                                     'MANAGER'   AS "MANAGER"   ,
                                     'PRESIDENT' AS "PRESIDENT" ,
                                     'ANALYST'   AS "ANALYST"   ,
                                     'SALESMAN'  AS "SALESMAN"  )
                                     );

CREATE TABLE upivot
AS SELECT * FROM (SELECT deptno, job , empno FROM emp)

PIVOT
( COUNT(empno) FOR job IN('CLERK'     AS "CLERK"     , 
                          'MANAGER'   AS "MANAGER"   ,
                          'PRESIDENT' AS "PRESIDENT" ,
                          'ANALYST'   AS "ANALYST"   ,
                          'SALESMAN'  AS "SALESMAN"  )
);

SELECT * FROM upivot ORDER BY 1;

SELECT * FROM upivot

UNPIVOT
( empno FOR job IN( clerk , manager , president , analyst , salesman ) )
ORDER BY 1, 2;

SELECT * FROM (SELECT studno, TO_CHAR(birthday, 'MM') "BD" FROM student)
PIVOT
( COUNT(studno) FOR BD IN( '01' "JAN" ,
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