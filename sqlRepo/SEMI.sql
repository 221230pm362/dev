-- SEMI 계정 생성 --SYS 계정으로만 실행 가능
/*
CREATE USER C##SEMI IDENTIFIED BY 1234;
GRANT CONNECT , RESOURCE TO C##SEMI;
ALTER USER C##SEMI DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
*/


-- MEMBER
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID      VARCHAR2(100) NOT NULL UNIQUE
    ,PWD    VARCHAR2(100)
    ,NICK   VARCHAR2(100)
);


--연습장




