-- SEMI 계정 생성 --SYS 계정으로만 실행 가능
/*
CREATE USER C##SEMI IDENTIFIED BY 1234;
GRANT CONNECT , RESOURCE TO C##SEMI;
ALTER USER C##SEMI DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
*/


-- MEMBER
DROP TABLE MEMBER CASCADE CONSTRAINTS; 
CREATE TABLE MEMBER(
    NO       NUMBER        PRIMARY KEY
    , ID     VARCHAR2(100) NOT NULL UNIQUE
    , PWD    VARCHAR2(100) NOT NULL
    , NICK   VARCHAR2(100) UNIQUE
);
DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;



-- BOARD
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER_NO     NUMBER
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO)
);
DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;

-- 샘플 데이터 (MEMBER)
INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL , 'SWY', '1234', '1DRAGON');
COMMIT;




--연습장
ROLLBACK;
























