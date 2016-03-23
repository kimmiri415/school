CREATE OR REPLACE VIEW GradeMember
AS
SELECT 
	g.score_seq AS score_seq,
	g.id AS id,
	g.java AS java,
	g.sql AS sql,
	g.jsp AS jsp,
	g.spring AS spring,
	m.name AS name,
	m.password AS password,
	m.addr AS addr,
	m.birth AS birth
FROM Member m, Grade g
WHERE m.id = g.id;

SELECT * FROM GradeMember;
DROP VIEW GradeMember CASCADE CONSTRAINT;
DROP VIEW GradeMember;

INSERT INTO Member(id,name,password,addr,birth)
VALUES('hongs','홍길동s','1','서울s',800101);
SELECT * FROM GradeMember where id='hongs';

--안되
INSERT INTO GradeMember(hak,id,java,sql,jsp,spring,name,password,addr,birth)
VALUES(hak.NEXTVAL,'kim3',100,100,100,100,'김미리','1','평택',920415);

SELECT * FROM GradeMember;
--REPLACE : 오버라이딩 개념, 덮어쓰기
SELECT * FROM GradeMember
WHERE name ='김유신';

SELECT count(*) 
AS count
FROM GradeMember;
DELETE FROM GradeMember WHERE hak=20160001;