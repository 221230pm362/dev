-- JOIN
/*
    두 개 이상의 테이블에서 데이터 조회
    
    1. 등가 조인(EQUAL JOIN) / 내부 조인(INNER JOIN)
        연결시키는 컬럼의 값이 일치하는 행들만 조인되서 조회한다.(일치하는 값이 없는 행은 조회 X)
        
        1) 오라클 전용 구문
            [표현법]
                SELECT 컬럼, 컬럼, ...
                FROM 테이블1, 테이블2
                WHERE 테이블1.컬럼명 = 테이블2.컬럼명;
            
            - FROM 절에 조회하고자 하는 테이블들을 콤마(,)로 구분하여 나열한다.
            - WHERE 절에 매칭 시킬 컬럼명에 대한 조건을 제시한다.
        
        2) ANSI 표준 구문
            [표현법]
                SELECT 컬럼, 컬럼, ...
                FROM 테이블1
                [INNER] JOIN 테이블2 ON (테이블1.컬럼명 = 테이블2.컬럼명);
            
            - FROM 절에 기준이 되는 테이블을 기술한다.
            - JOIN 절에 같이 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술한다.
            - 연결에 사용하려는 컬럼명이 같은 경우 ON 구문 대신에 USING(컬럼명) 구문을 사용한다.
*/

-- 사원 테이블 에서 사원명,직급코드 조회
SELECT EMP_NAME , JOB_CODE
FROM EMPLOYEE
;

-- 직급 테이블 조회
SELECT *
FROM JOB
;

-- 사원이름, 직급코드, 직급명 조회
SELECT EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE
;

-- 사원이름, 부서코드, 부서이름 조회
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;


/*
    2. 다중 JOIN
        여러개의 테이블 조인
        (순서 중요함)
*/

-- 사원명, 부서코드, 부서이름 , 부서위치(아이디)
SELECT EMP_NAME, DEPT_CODE , DEPT_TITLE , LOCATION_ID , NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
;

/*
    3. 외부 조인 (OUTTER JOIN)
        테이블 간의 JOIN 시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
        단, 반드시 기준이되는 테이블(컬럼)을 지정해야 한다. (LEFT/RIGHT/(+))
        
        - LEFT 
        - RIGHT
        - FULL
*/

-- 사원명,부서코드,부서명
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
;


/*
    4. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인(CROSS JOIN)
        조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다.
        테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 과부화의 위험
*/

SELECT * FROM EMPLOYEE;     --23
SELECT * FROM DEPARTMENT;   --9

SELECT *
FROM EMPLOYEE
CROSS JOIN DEPARTMENT
;


/*
    5. 비등가 조인(NON EQUAL JOIN)
        조인 조건에 등호(=)를 사용하지 않는 조인문을 비등가 조인이라고 한다.
        지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식이다.
        ( = 이외에 비교 연산자 >, <, >=, <=, BETWEEN AND, IN, NOT IN 등을 사용한다.)
        ANSI 구문으로는 JOIN ON 구문으로만 사용이 가능하다. (USING 사용 불가)
*/

SELECT EMP_NAME, SALARY , SAL_LEVEL , MIN_SAL, MAX_SAL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL)
;


/*
    6. 자체 조인(SELF JOIN)
        같은 테이블을 다시 한번 조인하는 경우에 사용한다.
*/

SELECT 
    A.EMP_ID
    , A.EMP_NAME
    , A.MANAGER_ID
    , B.EMP_NAME
FROM EMPLOYEE A
JOIN EMPLOYEE B 
ON A.MANAGER_ID = B.EMP_ID
;

SELECT EMP_ID, EMP_NAME, MANAGER_ID
FROM EMPLOYEE
;



------------------------- 종합 실습 문제 -------------------------
-- 1. 직급이 대리이면서 ASIA 지역에서 근무하는 직원들의 사번, 사원명, 직급명, 부서명, 근무지역, 급여를 조회하세요.
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
WHERE JOB_NAME = '대리'
AND   LOCAL_NAME LIKE 'ASIA%'
;

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE EMP_NO LIKE '7%'
AND   SUBSTR(EMP_NO,8,1) = 2
AND   EMP_NAME LIKE '전%'
;

-- 3. 보너스를 받는 직원들의 사원명, 보너스, 연봉, 부서명, 근무지역을 조회하세요.
-- 단, 부서 코드가 없는 사원도 출력될 수 있게
SELECT 
    EMP_NAME
    , BONUS
    , SALARY * 12 + SALARY*BONUS 연봉
    , DEPT_TITLE
    , LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
WHERE BONUS IS NOT NULL
;

-- 4. 한국과 일본에서 근무하는 직원들의 사원명, 부서명, 근무지역, 근무 국가를 조회하세요.

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(정수 처리)를 조회하세요.
--    단, 부서 배치가 안된 사원들의 평균도 같이 나오게

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회하시오.

-- 7. 사번, 사원명, 직급명, 급여 등급, 구분을 조회
--    이때 구분에 해당하는 값은 아래와 같이 조회 되도록 하시오.
--    급여 등급이 S1, S2인 경우 '고급'
--    급여 등급이 S3, S4인 경우 '중급'
--    급여 등급이 S5, S6인 경우 '초급'


-- 8. 보너스를 받지 않는 직원들 중 직급 코드가 J4 또는 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.

-- 9. 부서가 있는 직원들의 사원명, 직급명, 부서명, 근무 지역을 조회하시오.

-- 10. 해외영업팀에 근무하는 직원들의 사원명, 직급명, 부서 코드, 부서명을 조회하시오

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 사원명, 직급명을 조회하시오.





