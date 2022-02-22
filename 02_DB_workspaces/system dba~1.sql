CREATE TABLE scott.tt500
( no        NUMBER      CONSTRAINT tt500_ck CHECK(no > 5));

ALTER TABLE scott.tt500 DISABLE CONSTRAINT TT500_CK;

INSERT INTO scott.tt500 VALUES(1);
INSERT INTO scott.tt500 VALUES(6);
INSERT INTO scott.tt500 VALUES(7);
COMMIT;
SELECT * FROM scott.tt500;

ALTER TABLE scott.tt500 ENABLE VALIDATE CONSTRAINT tt500_ck
EXCEPTIONS INTO SYS.EXCEPTIONS;

SELECT rowid, no
FROM scott.tt500
WHERE rowid IN(SELECT row_id FROM exceptions);

UPDATE scott.tt500
SET no = 8
WHERE rowid = 'AAAE9gAAFAAAAEfAAA';
COMMIT;

TRUNCATE TABLE SYS.EXCEPTIONS;

INSERT INTO scott.tt500 VALUES(1);

CREATE OR REPLACE VIEW v$all_index_usage
( index_name       ,
  table_name       ,
  owner_name       ,
  monitoring       ,
  used             ,
  start_monitoring ,
  end_monitoring   )
  AS
        SELECT a.name , b.name , e.name ,
              DECODE(BITAND(c.flags, 65535), 0, 'NO', 'YES') ,
              DECODE(BITAND(d.flags, 1), 0, 'NO', 'YES') ,
              d.start_monitoring ,
              d.end_monitoring
        FROM sys.obj$ a , sys.obj$ b , sys.ind$ c , sys.user$ e , sys.object_usage d
        WHERE c.obj# = d.obj#
        AND   a.obj# = d.obj#
        AND   b.obj# = c.bo#
        AND   e.user# = a.owner#;
commit;

SELECT * FROM v$all_index_usage;

SELECT table_name, index_name
FROM dba_indexes
WHERE table_name = 'PROFESSOR';

ALTER INDEX scott.SYS_C007002 MONITORING USAGE;
ALTER INDEX scott.SYS_C007002 NOMONITORING USAGE;

SELECT * FROM v$all_index_usage;
commit;

SELECT * FROM obj$;