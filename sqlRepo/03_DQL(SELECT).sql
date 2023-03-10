-- DQL(SELECT)
/*
    <SELECT 절>
        [문법]
            SELECT 컬럼, 컬럼, ..., 컬럼
              FROM 테이블명;
        
        - 데이터를 조회할 때 사용하는 구문
        - SELECT를 통해서 조회된 결과 물을 RESULT SET이라고 한다.(조회된 행들의 집합)
        - 조회하고자 하는 컬럼들은 반드시 FROM 절에 기술한 테이블에 존재하는 컬럼이어야 한다.
*/

-- 사번, 이름, 월급 조회. EMPLOYEE 테이블에서
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- 모든 칼럼 조회. EMPLOYEE 테이블에서
SELECT *
FROM EMPLOYEE;

-- 쿼리는 소문자도 가능
select *
from employee;

/*
    <산술연산>
        SELECT 절에 산술연산 가능
*/

-- 연봉 조회. EMPLOYEE 테이블에서
SELECT SALARY * 12
FROM EMPLOYEE;

-- 사원명, 보너스를 포함한 연봉 조회. EMPLOYEE 테이블에서
-- (산술연산 중 NULL 값이 포함되면 결과는 NULL)
SELECT EMP_NAME , SALARY * 12 + SALARY * BONUS
FROM EMPLOYEE;

-- 사원명, 입사일자, 오늘날짜 , 근무일수 .EMPLOYEE 테이블에서
SELECT EMP_NAME , HIRE_DATE , SYSDATE , FLOOR(SYSDATE-HIRE_DATE) "근무 일 수"
FROM EMPLOYEE;

-- 사원명 (칼럼명 "이름"), 보너스가포함된연봉 조회 (칼럼명 "연봉")
SELECT EMP_NAME AS 이름 , SALARY * 12 + SALARY*BONUS AS "연봉(보너스포함)"
FROM EMPLOYEE;

-- 리터럴
SELECT 100
FROM EMPLOYEE;

-- DISTINCT
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- 중복제거하여서 직급코드 조회. 사원테이블에서
SELECT DISTINCT JOB_CODE , DEPT_CODE
FROM EMPLOYEE;

-- 연결 연산자 ||
SELECT EMP_NO || ' ' || EMP_NAME
FROM EMPLOYEE;

-- ㅇㅇㅇ의 연봉은 0000 입니다.
SELECT EMP_NAME || ' 의 연봉은 ' || (SALARY*12 + SALARY*BONUS) || ' 입니다.'
FROM EMPLOYEE;

/*
    <WHERE>
        [문법]
            SELECT 컬럼, 컬럼, ..., 컬럼
            FROM 테이블명
            WHERE 조건식;
             
        - 조회하고자 하는 테이블에서 해당 조건에 만족하는 결과만을 조회하고자 할 때 사용한다.
        - 조건식에는 다양한 연산자들을 사용할 수 있다.
        
    <비교 연산자>
        >, <, >=, <= : 대소 비교
        =            : 동등 비교
        !=, ^=, <>   : 같지 않다
*/

SELECT *
FROM EMPLOYEE
WHERE EMP_NAME = '이오리'
;

-- 모든 칼럼 조회 . EMPLOYEE 테이블에서. 부서코드가 D9 이 아닌 경우에만
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE ^= 'D9';

-- 사원이름, 급여, 입사일자 조회. EMPLOYEE 테이블에서. 급여가 300만원 이상인 사원들만.
SELECT EMP_NAME , SALARY, HIRE_DATE
FROM EMPLOYEE 
WHERE SALARY >= 3000000;

-- 1. EMPLOYEE 테이블에서 
-- 재직 중(ENT_YN 컬럼 값이 'N')인 직원들의 사번, 이름, 입사일 조회
SELECT EMP_NO , EMP_NAME , HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- 2. EMPLOYEE 테이블에서 
-- 연봉이 5000이상인 직원의 직원명, 급여, 연봉, 입사일 조회
SELECT EMP_NAME , SALARY , HIRE_DATE
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;


-- AND , OR

-- EMPLOYEE 테이블에서 부서코드가 D6 이면서 급여가 300만원 이상인 직원들의 
-- 모든 칼럼 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
AND   SALARY >= 3000000;

-- EMPLOYEE 테이블에서 급여가 400만원 이상, 직급 코드가 J2인 사원의 
-- 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000
AND   JOB_CODE = 'J2';

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하를 받는 직원의 
-- 사번, 직원명, 부서 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000
AND   SALARY <= 6000000;

/*
    <BETWEEN AND>
        [문법]
            WHERE 비교대상컬럼 BETWEEN 하한값 AND 상한값
            
        - WHERE 절에서 사용되는 구문으로 범위에 대한 조건을 제시할 때 사용한다.
        - 비교대상컬럼 값이 하한값 이상이고, 상한값 이하인 경우 TRUE를 리턴한다.
*/

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하를 받는 직원의 
-- 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE 테이블에서 입사일 '90/01/01' ~ '01/01/01'인 사원의 
-- 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- EMPLOYEE 테이블에서 입사일 '90/01/01' ~ '01/01/01'이 아닌 사원의 
-- 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE NOT BETWEEN '90/01/01' AND '01/01/01';

/*
    <LIKE>
        [문법]
            WHERE 비교대상컬럼 LIKE '특정 패턴';
            
        - 비교하려는 컬럼 값이 지정된 특정 패턴에 만족할 경우 TRUE를 리턴한다.
        - 특정 패턴에는 '%', '_'를 와일드카드로 사용할 수 있다.
          '%' : 0글자 이상
            ex) 비교대상컬럼 LIKE '문자%'  => 비교대상컬럼 값 중에 '문자'로 시작하는 모든 행을 조회한다.
                비교대상컬럼 LIKE '%문자'  => 비교대상컬럼 값 중에 '문자'로 끝나는 모든 행을 조회한다.
                비교대상컬럼 LIKE '%문자%' => 비교대상컬럼 값 중에 '문자'가 포함되어 있는 모든 행을 조회한다.
                
          '_' : 1글자
            ex) 비교대상컬럼 LIKE '_문자'  => 비교대상컬럼 값 중에 '문자'앞에 무조건 한 글자가 오는 모든 행을 조회한다.
                비교대상컬럼 LIKE '__문자' => 비교대상컬럼 값 중에 '문자'앞에 무조건 두 글자가 오는 모든 행을 조회한다.
*/


-- EMPLOYEE 테이블에서 성이 전 씨인 사원의 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE 테이블에서 이름 중에 '하'가 포함된 사원의 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE 테이블에서 전화번호 4번째 자리가 9로 시작하는 사원의 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--EMPLOYEE 테이블에서 이메일 중 _ 앞 글자가 3자리인 이메일 주소를 가진 사원의 모든 칼럼 조회
-- ex) sun_di@kh.or.kr, yoo_js@kh.or.kr, ...
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '___!_%' ESCAPE '!';

-- EMPLOYEE 테이블에서 김씨 성이 아닌 직원 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
--WHERE NOT EMP_NAME LIKE '김%';
--WHERE EMP_NAME NOT LIKE '김%';
WHERE NOT EMP_NAME NOT LIKE '김%';

-- 1. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE 
WHERE PHONE NOT LIKE '010%';

-- 2. DEPARTMENT 테이블에서 해외영업부에 대한 모든 컬럼 조회
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';



-- IS NULL / IS NOT NULL

-- EMPLOYEE 에서 BONUS 가 NULL 인 사원 모든칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--EMPLOYEE 테이블에서 관리자(사수)가 없는 사원 모든 칼럼 조회 
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL ;

-- EMPLOYEE 테이블에서 부서 배치를 받진 않았지만 보너스는 받는 사원의 모든 칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL
AND   BONUS IS NOT NULL;

-- IN 연산자
-- 부서코드가 D5 , D6 , D1 ,D8 인 사원 모든칼럼 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5' , 'D6' , 'D1' , 'D8')
;


/*
    <연산자 우선순위>
        0. ()
        1. 산술 연산자
        2. 연결 연산자
        3. 비교 연산자
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. 논리 연산자 - NOT
        7. 논리 연산자 - AND
        8. 논리 연산자 - OR
*/


/*
    <ORDER BY>
    
        [문법]
            SELECT 컬럼, 컬럼, ..., 컬럼
              FROM 테이블명
             WHERE 조건식
          ORDER BY 정렬시키고자 하는 컬럼명|별칭|컬럼 순번 [ASC|DESC] [NULLS FIRST | NULLS LAST];
          
        - SELECT 문에서 가장 마지막에 기입하는 구문으로 실행 또한 가장 마지막에 진행된다.
        - ASC : 오름차순으로 정렬한다. (ASC 또는 DESC 생략 시 기본값)
        - DESC : 내림차순으로 정렬한다.
        - NULLS FIRST : 정렬하고자 하는 컬럼 값에 NULL이 있는 경우 해당 데이터 값을 맨 앞으로 정렬한다.
        - NULLS LAST : 정렬하고자 하는 컬럼 값에 NULL이 있는 경우 해당 데이터 값을 맨 뒤로 정렬한다.
    
        -- ORDER BY
        -- ASC
        -- DESC
        -- NULLS FIRST
        -- NULLS LAST
*/

SELECT *
FROM EMPLOYEE
--ORDER BY SALARY ASC
ORDER BY SALARY DESC
;

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS ASC NULLS FIRST
ORDER BY BONUS DESC NULLS LAST
;
































