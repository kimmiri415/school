--시퀀스 생성
CREATE SEQUENCE hak
START WITH 20160001
INCREMENT BY 1
NOCACHE
NOCYCLE;


CREATE TABLE Grade(
hak NUMBER PRIMARY KEY,
id VARCHAR2(30) ,
java NUMBER  NOT NULL,
sql NUMBER NOT NULL,
jsp NUMBER NOT NULL,
spring NUMBER NOT NULL
);

DROP TABLE Grade;
SELECT * FROM Grade;

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'hong',100,100,100,100);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'kim',90,90,90,90);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'lee',80,80,80,80);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'yoon',70,70,70,70);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'song',55,55,55,55);

INSERT INTO Grade(hak,id,java,sql,jsp,spring)
VALUES(hak.NEXTVAL,'kim2',50,50,50,50);

SELECT * FROM Member WHERE id='song';