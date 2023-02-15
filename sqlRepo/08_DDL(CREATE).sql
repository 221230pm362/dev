--DDL

/*
    <DDL(Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB 관리자, 설계자가 주로 사용한다.

        * 오라클에서의 객체 : 테이블, 뷰, 시퀀스, 인덱스, 트리거, 프로시져, 함수, 사용자 등등
        
    <CREATE>
        데이터베이스의 객체를 생성하는 구문이다.
    
    <TABLE(테이블)>
        테이블은 행과 열로 구성되는 가장 기본적인 데이터베이스 객체로 데이터베이스 내에서 모든 데이터는 테이블에 저장된다.
        
    <테이블 생성>
        [표현법]
            CREATE TABLE 테이블명 (
                컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
                컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
                ...
            );
*/

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID           VARCHAR2(100) NOT NULL UNIQUE
    ,PWD         VARCHAR2(100) NOT NULL
    ,NICK        VARCHAR2(100)
    ,QUIT_YN     CHAR(10)      DEFAULT 'N'
    ,ENROLL_DATE TIMESTAMP     DEFAULT SYSDATE
    ,GENDER      CHAR(1)       CHECK( GENDER IN ('M','F') )
);

/*
    <컬럼에 주석 달기>
        [표현법]
            COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
*/

COMMENT ON COLUMN MEMBER.ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.NICK IS '회원 닉네임';
COMMENT ON COLUMN MEMBER.QUIT_YN IS '탈퇴여부';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '가입일시';
COMMENT ON COLUMN MEMBER.GENDER IS '성별';


/*
    데이터 딕셔너리(메타 데이터)
        자원을 효율적으로 관리하기 위한 다양한 객체들의 정보를 저장하는 시스템 테이블이다.
        사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할 때 데이터베이스에 의해서 자동으로 갱신되는 테이블이다.
        데이터에 관한 데이터가 저장되어 있다고 해서 메타 데이터라고도 한다.
        
    USER_TABLES         : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인하는 뷰 테이블이다. 
    USER_TAB_COLUMNS    : 테이블, 뷰의 컬럼과 관련된 정보를 조회하는 뷰 테이블이다.
*/

SELECT * FROM USER_TABLES;
SELECT * FROM USER_TAB_COLUMNS;


/*
    <제약 조건(CONSTRAINT)>
        사용자가 원하는 조건의 데이터만 유지하기 위해서 테이블 작성 시 각 컬럼에 대해 저장될 값에 대한 제약조건을 설정할 수 있다.
        제약 조건은 데이터 무결성 보장을 목적으로 한다. (데이터의 정확성과 일관성을 유지시키는 것)
        
        * 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
        
        [문법]
            1) 컬럼 레벨
                CRATE TABLE 테이블명 (
                    컬럼명 자료형(크기) [CONSTRAINT 제약조건명] 제약조건,
                    ...
                );
            
            2) 테이블 레벨
                CRATE TABLE 테이블명 (
                    컬럼명 자료형(크기),
                    ...,
                    [CONSTRAINT 제약조건명] 제약조건(컬럼명)
                );
*/

-- 테이블 정보 확인
DESC MEMBER;
-- 제약 조건 확인
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MEMBER';

DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'MEMBER';


/*
    <NOT NULL 제약조건>
        해당 칼럼에 반드시 값이 있어야만 하는 경우 사용한다.
        삽입/수정 시 NULL 값을 허용하지 않도록 제한한다.
        
        * 칼럼레벨에만 작성 가능
*/

/*
    <UNIQUE 제약조건>
        칼럼의 입력 값에 중복 값을 제한하는 제약조건이다.
        데이터를 삽입/수정 시 기존에 있는 데이터 값 중에 중복되는 값이 있을 경우 삽입/수정되지 않는다.
        제약조건 지정 방식으로 칼럼 레벨, 테이블 레벨 방식 모두 사용 가능하다.
        여러 칼럼을 묶어서 설정하는것도 가능 (반드시 테이블 레벨 방식으로 설정)
*/






















