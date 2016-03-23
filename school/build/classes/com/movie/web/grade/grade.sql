--시퀀스 생성
CREATE SEQUENCE score_seq
START WITH 1
INCREMENT BY 1;


CREATE TABLE Grade(
score_seq NUMBER PRIMARY KEY,
id VARCHAR2(30) NOT NULL,
java NUMBER  NOT NULL,
sql NUMBER NOT NULL,
jsp NUMBER NOT NULL,
spring NUMBER NOT NULL
);

DROP TABLE Grade;
SELECT * FROM Grade;

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'hong',100,100,100,100);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'kim',90,90,90,90);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'lee',80,80,80,80);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'yoon',70,70,70,70);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'song',55,55,55,55);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'kim2',50,50,50,50);

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)
VALUES(score_seq.NEXTVAL,'hong',20,20,20,20);
SELECT * FROM Member WHERE id='song';

ALTER TABLE Grade RENAME hak TO examSeq;
DROP SEQUENCE hak;
DROP TABLE Grade CASCADE CONSTRAINT;

