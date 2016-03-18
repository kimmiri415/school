
CREATE TABLE Grade(
hak NUMBER PRIMARY KEY,
id VARCHAR2(30) NOT NULL,
java NUMBER,
sql NUMBER,
jsp NUMBER,
spring NUMBER
);

SELECT * FROM Grade;

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(20160101,'hong',100,100,100,100);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(20160202,'kim',90,90,90,90);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(20160303,'lee',80,80,80,80);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(20160404,'song',70,70,70,70);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(20160505,'yoon',60,60,60,60);