-- SUBQUERY
/*
    <SUBQUERY>
        �ϳ��� SQL �� �ȿ� ���Ե� �� �ٸ� SQL ���� ���Ѵ�. 
        ���� ����(���� ����)�� �����ϴ� ������ �ϴ� �������̴�.
*/

-- ���ö ����� ���� �μ��� ��ȸ
-- 1. ���ö ��� �μ��ڵ� ��ȸ : result
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';
-- 2. 1���� result�� ���� �μ��ڵ带 ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE =   (
                        SELECT DEPT_CODE
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '���ö'
                    );


/*
    <���� ���� ����>
        ���� ������ ���� ������ ������ ������� ��� ���� ������ ���� �з��� �� �ִ�.
        
        1) ������ ���� ����        : ���� ������ ��ȸ ��� ���� ��� ���� ������ 1�� �� ��
        2) ������ ���� ����        : ���� ������ ��ȸ ��� ���� ���� ������ ���� �� �� ��
        3) ���߿� ���� ����        : ���� ������ ��ȸ ��� ���� �� �������� �÷��� ������ �϶�
        4) ������, ���߿� ���� ���� : ���� ������ ��ȣ ��� ���� ������, ������ �� ��
        
        * ���� ������ ������ ���� ���� ���� �տ� �ٴ� �����ڰ� �޶�����.
        
    <������ ���� ����>
        ���� ������ ��ȸ ��� ���� ��� ���� ������ 1�� �� �� (������, ���Ͽ�)
        �� ������(������ ������) ��� ���� (=, !=, <>, ^=, >, <, >=, <=, ...)
*/

-- 1) ��ü ������ ��� �޿����� �޿��� ���� ����� �̸�,�޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY <  (
                    SELECT 
                        AVG(NVL(SALARY , 0))
                    FROM EMPLOYEE
                )
;

-- 2) ���� �޿��� �޴� ������ �̸�,�޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY =  (
                    SELECT MIN(SALARY)
                    FROM EMPLOYEE
                )
;



-- 3) ���ö ����� �޿����� �� ���� �޿��� �޴� ����� �̸�,�޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >  (
                    SELECT SALARY
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö'
                )
;

-- 4) �μ��� �޿��� ���� ���� ū �μ��� �μ� �ڵ�, �޿��� �� ��ȸ
SELECT DEPT_CODE , SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) =    (
                            SELECT MAX(SUM(SALARY))
                            FROM EMPLOYEE
                            GROUP BY DEPT_CODE
                        )
;

-- 5) ������ ����� �����ִ� �μ������� ��� Į�� ��ȸ (��, ������ ����� ����)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE =   (
                        SELECT DEPT_CODE 
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '������'
                    )
AND EMP_NAME != '������'
;



/*
    <������ ���� ����>
        ���� ������ ��ȸ ��� ���� ���� ������ ���� �� �� ��
        
        IN / NOT IN (���� ����) : ���� ���� ����� �߿��� �� ���� ��ġ�ϴ� ���� �ִٸ� Ȥ�� ���ٸ� TRUE�� �����Ѵ�.
        ANY : ���� ���� ���� �߿��� �� ���� �����ϸ� TRUE, IN�� �ٸ� ���� �� �����ڸ� �Բ� ����Ѵٴ� ���̴�. 
            ANY(100, 200, 300)
            SALARY = ANY(...)  : IN�� ���� ���
            SALARY != ANY(...) : NOT IN�� ���� ���
            SALARY > ANY(...)  : �ּҰ� ���� ũ�� TRUE
            SALARY < ANY(...)  : �ִ밪 ���� ������ TRUE
        ALL : ���� ���� ���� ��ο� ���Ͽ� �����ؾ� TRUE, IN�� �ٸ� ���� �� �����ڸ� �Բ� ����Ѵٴ� ���̴�.
            ALL(100, 200, 300)
            SALARY > ALL(...)  : �ִ밪 ���� ũ�� TRUE
            SALARY < ALL(...)  : �ּҰ� ���� ������ TRUE
*/

-- 1) �� �μ��� �ְ� �޿��� �޴� ������ �̸�, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_NAME , DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY = ANY (  
                    SELECT MAX(SALARY)
                    FROM EMPLOYEE
                    GROUP BY DEPT_CODE
                )
;
-- 2) �븮 �����ӿ��� ���� ���޵��� �ּ� �޿����� ���� �޴� ������ �̸�, �޿� ��ȸ
SELECT EMP_NAME , SALARY
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE SALARY > ANY  (
                        SELECT SALARY
                        FROM EMPLOYEE E
                        JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
                        WHERE JOB_NAME = '����'
                    )
AND JOB_NAME = '�븮'
;

-- 3) ���� �����ӿ��� ���� ������ �ִ� �޿����� �� ���� �޴� �������� ���, �̸�, ���޸�, �޿� ��ȸ 
-- �������� ��....

/*
    <���߿� ���� ����>
        ��ȸ ��� ���� �� �������� ������ Į�� ���� ���� ���� ��
*/

-- 1) ������ ����� �μ��ڵ�,�����ڵ� �� ���� ����� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE , JOB_CODE) =  (
                                    SELECT DEPT_CODE , JOB_CODE
                                    FROM EMPLOYEE
                                    WHERE EMP_NAME = '������'
                                )
--AND JOB_CODE = 'J5'
;

-- 2) �ڳ��� ����� ���� �ڵ尡 ��ġ�ϸ鼭 ���� ����� ������ �ִ� ����� 
-- �̸�, ���� �ڵ�, ��� ��� ��ȸ
SELECT EMP_NAME , JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE,MANAGER_ID) =   ( 
                                    SELECT JOB_CODE,MANAGER_ID
                                    FROM EMPLOYEE
                                    WHERE EMP_NAME = '�ڳ���'
                                )
;

/*
    <������ ���߿� ���� ����>
        ���� ������ ��ȸ ������� ���� ��, ���� ���� ���
*/

-- 1. �� ���޺��� �ּ� �޿��� �޴� ������� ���, �̸�, ���� �ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE,SALARY) IN  (
                                SELECT JOB_CODE , MIN(SALARY)
                                FROM EMPLOYEE
                                GROUP BY JOB_CODE
                            )
;

-- 2. �� �μ����� �ּ� �޿��� �޴� ������� ���, �̸�, ���� �ڵ�, �޿� ��ȸ



/*
    <�ζ��� ��>
        FROM ���� ���� ������ �����ϰ�, ���� ������ ������ ����� ���̺� ��� ����Ѵ�.
*/

SELECT ���,�̸�
FROM 
(
    SELECT EMP_ID AS ��� ,EMP_NAME AS �̸�
    FROM EMPLOYEE
)
;

-- �޿� ���� ���� 5�� ��ȸ
SELECT ROWNUM , EMP_NAME, SALARY
FROM EMPLOYEE
--ORDER BY SALARY DESC
;

SELECT ROWNUM, EMP_NAME, SALARY
FROM 
(
    SELECT *
    FROM EMPLOYEE
    ORDER BY SALARY DESC
)
WHERE ROWNUM <= 5
;

-- �μ��� ��ձ޿��� ���� 3�� �μ��� �μ��ڵ�,��ձ޿� ��ȸ
SELECT ROWNUM , �μ� , ��ձ޿�
FROM 
(
    SELECT 
        NVL(DEPT_CODE , '�μ�����') AS �μ�
        , AVG(NVL(SALARY , 0)) AS ��ձ޿�
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    ORDER BY ��ձ޿� DESC
)
WHERE ROWNUM < 3
;

-- WITH
WITH ABC AS (
    SELECT 
        NVL(DEPT_CODE , '�μ�����') AS �μ�
        , AVG(NVL(SALARY , 0)) AS ��ձ޿�
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    ORDER BY ��ձ޿� DESC
)

SELECT ROWNUM , �μ� , ��ձ޿�
FROM ABC
WHERE ROWNUM <= 3
;

/*
    <RANK �Լ�>
        [ǥ����]
            RANK() OVER(���� ����) / DENSE_RANK() OVER(���� ����)
        
         RANK() OVER(���� ����)         : ������ ���� ������ ����� ������ �ο�����ŭ �ǳʶٰ� ������ ����Ѵ�.
                                         (EX. ���� 1���� 2���̸� ���� ������ 3��)
         DENSE_RANK() OVER(���� ����)   : ������ ���� ������ ����� ������ 1�� �����Ѵ�.
                                         (EX. ���� 1���� 2���̸� ���� ������ 2��)
*/

-- ����� �޿��� ���� ������� ������ �Űܼ� ����,�̸�,�޿� ��ȸ
SELECT 
    DENSE_RANK() OVER(ORDER BY SALARY DESC) ����
    , EMP_NAME
    , SALARY
FROM EMPLOYEE
;




-- ROWNUM �� �̿��Ͽ� 3�� ���� ���� ��ȸ
SELECT *
FROM 
(
    SELECT ROWNUM R , �μ� , ��ձ޿�
    FROM 
    (
        SELECT 
            NVL(DEPT_CODE , '�μ�����') AS �μ�
            , AVG(NVL(SALARY , 0)) AS ��ձ޿�
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY ��ձ޿� DESC
    )
)
WHERE R > 3
;

















