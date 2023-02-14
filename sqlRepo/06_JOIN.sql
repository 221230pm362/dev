-- JOIN
/*
    �� �� �̻��� ���̺��� ������ ��ȸ
    
    1. � ����(EQUAL JOIN) / ���� ����(INNER JOIN)
        �����Ű�� �÷��� ���� ��ġ�ϴ� ��鸸 ���εǼ� ��ȸ�Ѵ�.(��ġ�ϴ� ���� ���� ���� ��ȸ X)
        
        1) ����Ŭ ���� ����
            [ǥ����]
                SELECT �÷�, �÷�, ...
                FROM ���̺�1, ���̺�2
                WHERE ���̺�1.�÷��� = ���̺�2.�÷���;
            
            - FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸�(,)�� �����Ͽ� �����Ѵ�.
            - WHERE ���� ��Ī ��ų �÷��� ���� ������ �����Ѵ�.
        
        2) ANSI ǥ�� ����
            [ǥ����]
                SELECT �÷�, �÷�, ...
                FROM ���̺�1
                [INNER] JOIN ���̺�2 ON (���̺�1.�÷��� = ���̺�2.�÷���);
            
            - FROM ���� ������ �Ǵ� ���̺��� ����Ѵ�.
            - JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺��� ��� �� ��Ī ��ų �÷��� ���� ������ ����Ѵ�.
            - ���ῡ ����Ϸ��� �÷����� ���� ��� ON ���� ��ſ� USING(�÷���) ������ ����Ѵ�.
*/

-- ��� ���̺� ���� �����,�����ڵ� ��ȸ
SELECT EMP_NAME , JOB_CODE
FROM EMPLOYEE
;

-- ���� ���̺� ��ȸ
SELECT *
FROM JOB
;

-- ����̸�, �����ڵ�, ���޸� ��ȸ
SELECT EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J
ON E.JOB_CODE = J.JOB_CODE
;

-- ����̸�, �μ��ڵ�, �μ��̸� ��ȸ
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;


/*
    2. ���� JOIN
        �������� ���̺� ����
        (���� �߿���)
*/

-- �����, �μ��ڵ�, �μ��̸� , �μ���ġ(���̵�)
SELECT EMP_NAME, DEPT_CODE , DEPT_TITLE , LOCATION_ID , NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE
;

/*
    3. �ܺ� ���� (OUTTER JOIN)
        ���̺� ���� JOIN �� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ�� �����ϴ�.
        ��, �ݵ�� �����̵Ǵ� ���̺�(�÷�)�� �����ؾ� �Ѵ�. (LEFT/RIGHT/(+))
        
        - LEFT 
        - RIGHT
        - FULL
*/

-- �����,�μ��ڵ�,�μ���
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
;


/*
    4. ī�׽þȰ�(CARTESIAN PRODUCT) / ���� ����(CROSS JOIN)
        ���εǴ� ��� ���̺��� �� ����� ���μ��� ��� ���ε� �����Ͱ� �˻��ȴ�.
        ���̺��� ����� ��� ������ ����� ������ ��� -> ����ȭ�� ����
*/

SELECT * FROM EMPLOYEE;     --23
SELECT * FROM DEPARTMENT;   --9

SELECT *
FROM EMPLOYEE
CROSS JOIN DEPARTMENT
;


/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
        ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ����̴�.
        ( = �̿ܿ� �� ������ >, <, >=, <=, BETWEEN AND, IN, NOT IN ���� ����Ѵ�.)
        ANSI �������δ� JOIN ON �������θ� ����� �����ϴ�. (USING ��� �Ұ�)
*/

SELECT EMP_NAME, SALARY , SAL_LEVEL , MIN_SAL, MAX_SAL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL)
;


/*
    6. ��ü ����(SELF JOIN)
        ���� ���̺��� �ٽ� �ѹ� �����ϴ� ��쿡 ����Ѵ�.
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



------------------------- ���� �ǽ� ���� -------------------------
-- 1. ������ �븮�̸鼭 ASIA �������� �ٹ��ϴ� �������� ���, �����, ���޸�, �μ���, �ٹ�����, �޿��� ��ȸ�ϼ���.
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
WHERE JOB_NAME = '�븮'
AND   LOCAL_NAME LIKE 'ASIA%'
;

-- 2. 70���� �̸鼭 �����̰�, ���� �� ���� �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE EMP_NO LIKE '7%'
AND   SUBSTR(EMP_NO,8,1) = 2
AND   EMP_NAME LIKE '��%'
;

-- 3. ���ʽ��� �޴� �������� �����, ���ʽ�, ����, �μ���, �ٹ������� ��ȸ�ϼ���.
-- ��, �μ� �ڵ尡 ���� ����� ��µ� �� �ְ�
SELECT 
    EMP_NAME
    , BONUS
    , SALARY * 12 + SALARY*BONUS ����
    , DEPT_TITLE
    , LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
WHERE BONUS IS NOT NULL
;

-- 4. �ѱ��� �Ϻ����� �ٹ��ϴ� �������� �����, �μ���, �ٹ�����, �ٹ� ������ ��ȸ�ϼ���.

-- 5. �� �μ��� ��� �޿��� ��ȸ�Ͽ� �μ���, ��� �޿�(���� ó��)�� ��ȸ�ϼ���.
--    ��, �μ� ��ġ�� �ȵ� ������� ��յ� ���� ������

-- 6. �� �μ��� �� �޿��� ���� 1000���� �̻��� �μ���, �޿��� ���� ��ȸ�Ͻÿ�.

-- 7. ���, �����, ���޸�, �޿� ���, ������ ��ȸ
--    �̶� ���п� �ش��ϴ� ���� �Ʒ��� ���� ��ȸ �ǵ��� �Ͻÿ�.
--    �޿� ����� S1, S2�� ��� '���'
--    �޿� ����� S3, S4�� ��� '�߱�'
--    �޿� ����� S5, S6�� ��� '�ʱ�'


-- 8. ���ʽ��� ���� �ʴ� ������ �� ���� �ڵ尡 J4 �Ǵ� J7�� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�.

-- 9. �μ��� �ִ� �������� �����, ���޸�, �μ���, �ٹ� ������ ��ȸ�Ͻÿ�.

-- 10. �ؿܿ������� �ٹ��ϴ� �������� �����, ���޸�, �μ� �ڵ�, �μ����� ��ȸ�Ͻÿ�

-- 11. �̸��� '��'�ڰ� ����ִ� �������� ���, �����, ���޸��� ��ȸ�Ͻÿ�.





