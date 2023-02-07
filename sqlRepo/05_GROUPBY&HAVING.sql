-- GROUP BY
/*
    <GROUP BY>
        Ư�� ���ؿ� ���� �׷� �и�
*/

-- ��ü ��� ���
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- �μ�����
SELECT DEPT_CODE , SUM(SALARY) AS �μ����޿��հ�
FROM EMPLOYEE
GROUP BY DEPT_CODE 
;

SELECT JOB_CODE, SUM(SALARY) ���޺��޿��հ�
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE
;

-- ���޺� �޿� ��� , �� �ο� ��
SELECT JOB_CODE, AVG(SALARY) , COUNT(EMP_ID)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- �μ��� �޿� ��� , �� �ο� ��
SELECT DEPT_CODE, AVG(SALARY) , COUNT(EMP_ID)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- ���޺� ���ο� ��
SELECT JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- �μ��� ���ο� ��
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--
SELECT DEPT_CODE , SUM(SALARY)
FROM EMPLOYEE
WHERE SALARY < 5000000
AND   DEPT_CODE IN ('D5' , 'D6' , 'D9')
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 10000000
;


/*
    <SQL �������>
        5 : SELECT
        1 : FROM
        2 : WHERE
        3 : GROUP BY
        4 : HAVING
        6 : ORDER BY
*/

/*
    <HAVING>
        GROUP �� ������� ���� �˻�
*/

-- �μ��� ��� �޿� ��ȸ
SELECT 
    DEPT_CODE 
    , FLOOR(AVG(NVL(SALARY, 0))) AS �μ�����ձ޿�
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) > 3000000
ORDER BY DEPT_CODE
;

-- ��ü ��� �߿��� ���ʽ��� ���� �ƴ� ����� �޿� ���
-- �μ��� �޿� �հ� ��ȸ
-- �μ��ڵ嵵 ��ȸ
-- ��Ī
-- �μ��ڵ� ���� �������� ���� (NULL�� �������� ��������)
-- �μ����޿������ 300���� ������ ��츸
-- �μ��ڵ尡 NULL �� ��� ����
SELECT 
    DEPT_CODE �μ��ڵ� 
    , AVG(SALARY) "�μ����޿����(���ʽ���NULL�� �ƴ�)"
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
--AND   DEPT_CODE IS NOT NULL
GROUP BY DEPT_CODE
HAVING AVG(SALARY) <= 3000000
AND DEPT_CODE IS NOT NULL
ORDER BY DEPT_CODE DESC NULLS LAST
;

-- ��ü ��� ��� ���� ��ȸ
-- �������� ����� ��ȸ
-- ���� ���� �޿�
-- ���޺� ���� ���� �޿�
-- ��Ī (���޺� ���� ���� �޿�)
-- ���� �� ��ȸ
-- ���޺� ���� ���� �޿� . ��Ī
-- ���޺� �޿� ��� . ��Ī
-- ���޺� �ο� �� . ��Ī
-- ��� ���� ��, SALARY �� NULL �� ��� ���
-- �ο� �� ���� ��, SALARY �� NULL �� ��� ���
-- ���޺� �޿������ ���������θ� ǥ��
-- ���޺� �ο����� 3�� �̸��� ���� ����
-- ���� �������� ����
SELECT 
    JOB_CODE 
    , MAX(SALARY) "���޺� ���� ���� �޿�"
    , MIN(SALARY) "���޺� ���� ���� �޿�"
    , TRUNC(AVG(NVL(SALARY , 0)) , -4) "���޺� �޿� ���"
    , COUNT(EMP_ID) "���޺� �ο� ��"
FROM EMPLOYEE
WHERE ENT_YN = 'N'
GROUP BY JOB_CODE
HAVING COUNT(EMP_ID) >= 3
ORDER BY  "���޺� �ο� ��" ASC
        , "���޺� �޿� ���" DESC
;

















