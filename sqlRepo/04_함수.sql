-- 함수 (FUNCTION)

/*
    <함수>
        컬럼값을 읽어서 계산 결과를 반환한다.
          - 단일행 함수 : N개의 값을 읽어서 N개의 결과를 리턴한다. (매 행 함수 실행 -> 결과 반환)
          - 그룹 함수   : N개의 값을 읽어서 1개의 결과를 리턴한다. (하나의 그룹별로 함수 실행 -> 결과 반환)
        SELECT 절에 단일행 함수와 그룹 함수를 함께 사용하지 못한다. (결과 행의 개수가 다르기 때문에)
        함수를 기술할 수 있는 위치는 SELECT, WHERE, ORDER BY, GROUP BY, HAVING 절에 기술할 수 있다.
*/

------------------단일행 함수----------------------

/*
    <문자 관련 함수>
    1) LENGTH / LENGTHB
      - LENGTH(컬럼|'문자값') : 글자 수 반환
      - LENGTHB(컬럼|'문자값') : 글자의 바이트 수 반환
        한글 한 글자 -> 3BYTE
        영문자, 숫자, 특수문자 한 글자 -> 1BYTE
*/

SELECT EMP_NAME, EMAIL , LENGTH(EMAIL)
FROM EMPLOYEE;

SELECT LENGTHB('ABC') AS 글자수테스트
FROM DUAL;

/*
    2) INSTR
        - INSTR(컬럼|'문자값', '문자'[, POSITION[, OCCURRENCE]])
        - 지정한 위치부터 지정된 숫자 번째로 나타나는 문자의 시작 위치를 반환한다.
*/

SELECT INSTR('HELLO', 'E')
FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 3번째 자리의 B의 위치값 출력
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; -- 3번째 자리의 B의 위치값 출력
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- 9번째 자리의 B의 위치값 출력
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- 10번째 자리의 B의 위치값 출력
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL; -- 3번째 자리의 B의 위치값 출력

-- EMPLOYEE 테이블에서 EMAIL 칼럼의 @ 위치를 찾기
SELECT INSTR(EMAIL , '@')
FROM EMPLOYEE
;

/* 
    3) LPAD / RPAD
        - LPAD/RPAD(컬럼|'문자값', 길이(바이트)[, '덧붙이려고 하는 문자'])
        - 제시된 컬럼|'문자값'에 임의의 문자를 왼쪽 또는 오른쪽에 덧붙여 최종 N 길이 만큼의 문자열을 반환한다.
        - 문자에 대해 통일감 있게 표시하고자 할 때 사용한다.
*/

-- 모든 칸을 20칸으로 맞추기 (왼쪽은 #으로 채우기)
SELECT LPAD(EMAIL, 20 , '!')
FROM EMPLOYEE
;

/*
    4) LTRIM / RTRIM
        - LTRIM/RTRIM(컬럼|'문자값'[, '제거하고자 하는 문자'])
        - 문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 결과를 반환한다.
        - 제거하고자 하는 문자값을 생략 시 기본값으로 공백을 제거한다.
*/

/*
    5) TRIM
        - TRIM([[LEADING|TRAILING|BOTH] '제거하고자 하는 문자값' FROM] 컬럼|'문자값')
        - 문자값 앞/뒤/양쪽에 있는 지정한 문자를 제거한 나머지를 반환한다. 
        - 제거하고자 하는 문자값을 생략 시 기본적으로 양쪽에 있는 공백을 제거한다. 
*/

SELECT TRIM('    ABC    ') AS TEST FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;


/*
    6)  SUBSTR
        - SUBSTR(칼럼|'문자값' , POSITION [, LENGTH])
        - POSITION 부터 LENGTH 만큼 잘라옴
        - LENGTH가 없으면, 마지막까지 잘라옴
*/

SELECT 'HELLOWORLD' FROM DUAL;
SELECT SUBSTR('HELLOWORLD' , 3) FROM DUAL;
SELECT SUBSTR('HELLOWORLD' , 3 , 2) FROM DUAL;

-- EMPLOYEE 테이블에서 사원명, 주민번호 조회 (뒷자리 성별이후는 * 로 표시) , 주민번호 중 성별 부분만 조회 (별칭은 성별)
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO , 1 , 8) , 14 , '*'), SUBSTR(EMP_NO , 8, 1) AS 성별
FROM EMPLOYEE;


/*
    7)  LOWER / UPPER / INITCAP
        LOWER : 모두 소문자로 변경
        UPPER : 모두 대문자로 변경
        INITCAP : 단어 앞 글자마다 대문자로 변경
*/

/*
    8)  CONCAT
        - 문자열 합치기
*/

SELECT CONCAT('AAA' , 'BBB')  
FROM DUAL;

/*
    9)  REPLACE
*/

SELECT REPLACE('HELLO WORLD' , 'WORLD' , 'KOREA')
FROM DUAL; 


------------------------------------------------------------------
-- 숫자 관련 함수

/*
    1) ABS : 절대값
    2) MOD : 나머지 구함
    3) ROUND : 반올림
    4) CEIL : 올림
    5) FLOOR : 버림
    6) TRUNC : 절삭
*/

SELECT ABS(-1.23) FROM DUAL;

SELECT MOD(10,3) FROM DUAL;

SELECT ROUND(123.456 , -1) FROM DUAL;

SELECT CEIL(123.456) FROM DUAL;

SELECT FLOOR(123.456) FROM DUAL;

SELECT TRUNC(123.456 , -2) FROM DUAL;

-------------------------------------------------------
/*
    날짜 관련 함수
        1) SYSDATE          : 시스템의 현재 날짜와 시간
        2) MONTHS_BETWEEN   : 두 날짜 사이의 개월 수
        3) ADD_MONTHS       : 개월 수 더하기
        4) NEXT_DAY         : 구하려는 요일의 가장 가까운 날짜
        5) LAST_DAY         : 해당 월의 마지막 날짜
        6) EXTRACT          : 연 , 월 , 일 정보 추출  (결과값은 NUMBER 타입)
*/

SELECT SYSDATE FROM DUAL;

-- EMPOYEE 테이블에서 사원명, 입사일자, 오늘까지근무개월수 조회
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "근무 개월 수"
FROM EMPLOYEE;

SELECT ADD_MONTHS('23/1/1', 6) FROM DUAL;


SELECT NEXT_DAY(SYSDATE , 'FRI') FROM DUAL;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;  --언어 변경

SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;

SELECT SYSDATE FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';  -- 날짜 포맷 지정
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

/*
    형변환 함수
        CHAR , DATE , NUMBER
        1) TO_CHAR      
        2) TO_DATE
        3) TO_NUMBER
*/

-- 숫자 -> 문자
SELECT TO_CHAR(123) AS 칼럼명ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ FROM DUAL;
SELECT TO_CHAR(123, '99999') AS 칼럼명ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ FROM DUAL;
SELECT TO_CHAR(123, '00000') AS 칼럼명ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ FROM DUAL;
SELECT TO_CHAR(123456789, 'L9,999,999,999,999') AS 칼럼명ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ FROM DUAL;   --현재 설정된 나라(LOCAL) 화폐단위
SELECT TO_CHAR(123, 'L') AS 칼럼명ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ FROM DUAL;

SELECT EMP_NAME, TO_CHAR(SALARY , 'L9,999,999') AS 급여
FROM EMPLOYEE;

-- 날짜 -> 문자
SELECT TO_CHAR(SYSDATE , 'YYYY"년"MM"월"DD"일" DAY AM HH24:MI:SS') FROM DUAL;


-- 숫자 -> 날짜
SELECT TO_DATE(20230206) FROM DUAL;
-- 문자 -> 날짜
SELECT TO_DATE('20230206') FROM DUAL;
SELECT TO_DATE('23/2/6') FROM DUAL;


-- 문자 -> 숫자
SELECT TO_NUMBER('0123456789') FROM DUAL;


/*
    NULL 처리 함수
        - NVL       : NULL 값을 다른 값으로 변경
        - NVL2      : NULL 인지 아닌지 에 따라 값 변경
        - NULLIF    : 두 값이 동일하면 NULL , 그렇지 않으면 특정 값으로 변경
*/

-- 사원명, 보너스포함연봉 조회. 사원테이블에서.
SELECT EMP_NAME, SALARY * 12 + SALARY*NVL(BONUS , 0) AS 연봉 ,  NVL(BONUS , 0)
FROM EMPLOYEE;

SELECT NVL2(BONUS, 1 , 0)
FROM EMPLOYEE;

SELECT NULLIF(456, 456) FROM DUAL;

/*
    DECODE
        DECODE(칼럼 , 조건값1 , 결과값1 , 조건값2, 결과값2 ....)  
*/

-- 사원명 , 주민번호 뒷자리 첫번째 글자 조회
SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO , 8, 1) , 1 , '남' , 2 , '여') 성별
FROM EMPLOYEE;

/*
    CASE WHEN THEN
        [문법]
            CASE
                WHEN 조건식1 THEN 결과1
                WHEN 조건식2 THEN 결과2
                ...
                ELSE 결과99
            END
                
*/


-- 사원명 , 주민번호 뒷자리 첫번째 글자 조회하여서 성별로 출력
SELECT EMP_NAME, 
    CASE 
        WHEN SUBSTR(EMP_NO , 8 , 1) = 1 THEN '남'
        WHEN SUBSTR(EMP_NO , 8 , 1) = 2 THEN '여'
    END
    AS 성별
FROM EMPLOYEE;

-- 사원명, 직급코드 , 직급이름(J1=> 사장 , J2 => 부장, J3 => 차장 , 그 외 직원)  조회
SELECT 
    EMP_NAME 
    , JOB_CODE
    , CASE
        WHEN JOB_CODE = 'J1' THEN '사장'
        WHEN JOB_CODE = 'J2' THEN '부장'
        WHEN JOB_CODE = 'J3' THEN '차장'
        ELSE '직원'
    END AS 직급명
FROM EMPLOYEE;

-- 사번, 
-- 이름, 
-- 부서, 
-- 급여 , 
-- 급여에따른급(300 미만은 초급, 300이상 500 미만은 중급, 500 이상은 고급)
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_CODE
    , SALARY
    , CASE
        WHEN SALARY < 3000000 THEN '초급'
        WHEN SALARY < 5000000 THEN '중급'
        ELSE '고급'
    END AS 급
FROM EMPLOYEE
;

-----------------------------------------------------------

/*
    <그룹 함수>
        대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들이다.
        모든 그룹 함수는 NULL 값을 자동으로 제외하고 값이 있는 것들만 계산을 한다.
        따라서 AVG 함수를 사용할 때는 반드시 NVL() 함수와 함께 사용하는 것을 권장한다.
        
        - SUM
        - AVG
        - MIN / MAX
        - COUNT
*/

SELECT 
    SUM(SALARY) AS 급여합계
    , AVG(SALARY) AS 급여평균
    , COUNT(SALARY) AS 인원수
    , MAX(SALARY) AS 최고급여
    , MIN(SALARY) AS 최저급여
FROM EMPLOYEE;



















