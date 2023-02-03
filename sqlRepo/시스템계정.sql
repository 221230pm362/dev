-- 한줄 주석
/*
    여러줄
    주석
    ㅋㅋㅋ
    가능
*/

--사용자 계정 생성
-- [문법] CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER C##KH IDENTIFIED BY KH;

-- 권한부여
GRANT CONNECT, RESOURCE TO C##KH;

-- 테이블스페이스 권한 수정
ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
