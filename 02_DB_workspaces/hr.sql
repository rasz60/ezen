SET SERVEROUTPUT ON ;

BEGIN
    FOR i IN 0..5 LOOP
        dbms_output.put_line(i) ;
    END LOOP ;
END;
/

BEGIN
    FOR i IN 2..9 LOOP
        FOR j IN 1..9 LOOP
            dbms_output.put_line( i || ' x ' || j || ' = ' || (i*j) );
        END LOOP ;
    END LOOP ;
END ;
/

DECLARE
 vempid     employees.employee_id%TYPE ;
 vfname     employees.first_name%TYPE ;
 CURSOR c1 IS
    SELECT employee_id , first_name || ' ' || last_name "NAME"
    FROM employees
    WHERE department_id = 30 ;
 BEGIN
    OPEN c1 ;
    LOOP
        FETCH c1 INTO vempid , vfname ;
        EXIT WHEN c1%NOTFOUND ;
        dbms_output.put_line(vempid || '==' || vfname);
    END LOOP ;
    CLOSE c1 ;
 END;
/

DECLARE
 CURSOR emp_cur IS
    SELECT employee_id , first_name || ' ' || last_name "NAME"
    FROM employees
    WHERE department_id = 100 ;
 BEGIN
    FOR emp_rec IN emp_cur LOOP
        dbms_output.put_line(emp_rec.employee_id || '==' || emp_rec.name );
    END LOOP ;
 END ;
/

DECLARE
 BEGIN
    FOR emp_rec IN ( SELECT employee_id , first_name || ' ' || last_name "NAME"
                     FROM employees
                     WHERE department_id = 100 )
    LOOP
        dbms_output.put_line(emp_rec.employee_id || '--' || emp_rec.name) ;
    END LOOP ;
 END ;
/

