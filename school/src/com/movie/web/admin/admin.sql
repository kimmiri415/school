
CREATE TABLE Admin(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(20)NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER,
	role VARCHAR2(20) DEFAULT 'admin'
);

INSERT INTO Admin(id,name,password,addr,birth,role)
VALUES('admin','관리자','1','서울',800101,'admin');

SELECT * FROM Admin;

SELECT * FROM Admin where id='admin' and password='1';