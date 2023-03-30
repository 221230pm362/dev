-- SEMI 계정 생성 --SYS 계정으로만 실행 가능
/*
CREATE USER C##SEMI IDENTIFIED BY 1234;
GRANT CONNECT , RESOURCE TO C##SEMI;
ALTER USER C##SEMI DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
*/


-- MEMBER
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    NO       VARCHAR2(100) PRIMARY KEY
    , ID     VARCHAR2(100) NOT NULL UNIQUE
    , PWD    VARCHAR2(100) NOT NULL
    , NICK   VARCHAR2(100) UNIQUE
);

DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;


--연습장
ROLLBACK;

























