-- DQL(SELECT)
/*
    <SELECT ��>
        [����]
            SELECT �÷�, �÷�, ..., �÷�
              FROM ���̺��;
        
        - �����͸� ��ȸ�� �� ����ϴ� ����
        - SELECT�� ���ؼ� ��ȸ�� ��� ���� RESULT SET�̶�� �Ѵ�.(��ȸ�� ����� ����)
        - ��ȸ�ϰ��� �ϴ� �÷����� �ݵ�� FROM ���� ����� ���̺� �����ϴ� �÷��̾�� �Ѵ�.
*/

-- ���, �̸�, ���� ��ȸ. EMPLOYEE ���̺���
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- ��� Į�� ��ȸ. EMPLOYEE ���̺���
SELECT *
FROM EMPLOYEE;

-- ������ �ҹ��ڵ� ����
select *
from employee;

/*
    <�������>
        SELECT ���� ������� ����
*/

-- ���� ��ȸ. EMPLOYEE ���̺���
SELECT SALARY * 12
FROM EMPLOYEE;

-- �����, ���ʽ��� ������ ���� ��ȸ. EMPLOYEE ���̺���
-- (������� �� NULL ���� ���ԵǸ� ����� NULL)
SELECT EMP_NAME , SALARY * 12 + SALARY * BONUS
FROM EMPLOYEE;

-- �����, �Ի�����, ���ó�¥ , �ٹ��ϼ� .EMPLOYEE ���̺���
SELECT EMP_NAME , HIRE_DATE , SYSDATE , FLOOR(SYSDATE-HIRE_DATE) "�ٹ� �� ��"
FROM EMPLOYEE;

-- ����� (Į���� "�̸�"), ���ʽ������Եȿ��� ��ȸ (Į���� "����")
SELECT EMP_NAME AS �̸� , SALARY * 12 + SALARY*BONUS AS "����(���ʽ�����)"
FROM EMPLOYEE;

-- ���ͷ�
SELECT 100
FROM EMPLOYEE;

-- DISTINCT
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- �ߺ������Ͽ��� �����ڵ� ��ȸ. ������̺���
SELECT DISTINCT JOB_CODE , DEPT_CODE
FROM EMPLOYEE;

-- ���� ������ ||
SELECT EMP_NO || ' ' || EMP_NAME
FROM EMPLOYEE;

-- �������� ������ 0000 �Դϴ�.
SELECT EMP_NAME || ' �� ������ ' || (SALARY*12 + SALARY*BONUS) || ' �Դϴ�.'
FROM EMPLOYEE;

/*
    <WHERE>
        [����]
            SELECT �÷�, �÷�, ..., �÷�
            FROM ���̺��
            WHERE ���ǽ�;
             
        - ��ȸ�ϰ��� �ϴ� ���̺��� �ش� ���ǿ� �����ϴ� ������� ��ȸ�ϰ��� �� �� ����Ѵ�.
        - ���ǽĿ��� �پ��� �����ڵ��� ����� �� �ִ�.
        
    <�� ������>
        >, <, >=, <= : ��� ��
        =            : ���� ��
        !=, ^=, <>   : ���� �ʴ�
*/

SELECT *
FROM EMPLOYEE
WHERE EMP_NAME = '�̿���'
;

-- ��� Į�� ��ȸ . EMPLOYEE ���̺���. �μ��ڵ尡 D9 �� �ƴ� ��쿡��
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE ^= 'D9';

-- ����̸�, �޿�, �Ի����� ��ȸ. EMPLOYEE ���̺���. �޿��� 300���� �̻��� ����鸸.
SELECT EMP_NAME , SALARY, HIRE_DATE
FROM EMPLOYEE 
WHERE SALARY >= 3000000;

-- 1. EMPLOYEE ���̺��� 
-- ���� ��(ENT_YN �÷� ���� 'N')�� �������� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_NO , EMP_NAME , HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- 2. EMPLOYEE ���̺��� 
-- ������ 5000�̻��� ������ ������, �޿�, ����, �Ի��� ��ȸ
SELECT EMP_NAME , SALARY , HIRE_DATE
FROM EMPLOYEE
WHERE SALARY*12 >= 50000000;


-- AND , OR

-- EMPLOYEE ���̺��� �μ��ڵ尡 D6 �̸鼭 �޿��� 300���� �̻��� �������� 
-- ��� Į�� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
AND   SALARY >= 3000000;

-- EMPLOYEE ���̺��� �޿��� 400���� �̻�, ���� �ڵ尡 J2�� ����� 
-- ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000
AND   JOB_CODE = 'J2';

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������ 
-- ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000
AND   SALARY <= 6000000;

/*
    <BETWEEN AND>
        [����]
            WHERE �񱳴���÷� BETWEEN ���Ѱ� AND ���Ѱ�
            
        - WHERE ������ ���Ǵ� �������� ������ ���� ������ ������ �� ����Ѵ�.
        - �񱳴���÷� ���� ���Ѱ� �̻��̰�, ���Ѱ� ������ ��� TRUE�� �����Ѵ�.
*/

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������ 
-- ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE ���̺��� �Ի��� '90/01/01' ~ '01/01/01'�� ����� 
-- ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- EMPLOYEE ���̺��� �Ի��� '90/01/01' ~ '01/01/01'�� �ƴ� ����� 
-- ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE NOT BETWEEN '90/01/01' AND '01/01/01';

/*
    <LIKE>
        [����]
            WHERE �񱳴���÷� LIKE 'Ư�� ����';
            
        - ���Ϸ��� �÷� ���� ������ Ư�� ���Ͽ� ������ ��� TRUE�� �����Ѵ�.
        - Ư�� ���Ͽ��� '%', '_'�� ���ϵ�ī��� ����� �� �ִ�.
          '%' : 0���� �̻�
            ex) �񱳴���÷� LIKE '����%'  => �񱳴���÷� �� �߿� '����'�� �����ϴ� ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '%����'  => �񱳴���÷� �� �߿� '����'�� ������ ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '%����%' => �񱳴���÷� �� �߿� '����'�� ���ԵǾ� �ִ� ��� ���� ��ȸ�Ѵ�.
                
          '_' : 1����
            ex) �񱳴���÷� LIKE '_����'  => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '__����' => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.
*/


-- EMPLOYEE ���̺��� ���� �� ���� ����� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- EMPLOYEE ���̺��� �̸� �߿� '��'�� ���Ե� ����� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE ���̺��� ��ȭ��ȣ 4��° �ڸ��� 9�� �����ϴ� ����� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--EMPLOYEE ���̺��� �̸��� �� _ �� ���ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ��� Į�� ��ȸ
-- ex) sun_di@kh.or.kr, yoo_js@kh.or.kr, ...
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '___!_%' ESCAPE '!';

-- EMPLOYEE ���̺��� �达 ���� �ƴ� ���� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
--WHERE NOT EMP_NAME LIKE '��%';
--WHERE EMP_NAME NOT LIKE '��%';
WHERE NOT EMP_NAME NOT LIKE '��%';

-- 1. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE 
WHERE PHONE NOT LIKE '010%';

-- 2. DEPARTMENT ���̺��� �ؿܿ����ο� ���� ��� �÷� ��ȸ
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';



-- IS NULL / IS NOT NULL

-- EMPLOYEE ���� BONUS �� NULL �� ��� ���Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--EMPLOYEE ���̺��� ������(���)�� ���� ��� ��� Į�� ��ȸ 
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL ;

-- EMPLOYEE ���̺��� �μ� ��ġ�� ���� �ʾ����� ���ʽ��� �޴� ����� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL
AND   BONUS IS NOT NULL;

-- IN ������
-- �μ��ڵ尡 D5 , D6 , D1 ,D8 �� ��� ���Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5' , 'D6' , 'D1' , 'D8')
;


/*
    <������ �켱����>
        0. ()
        1. ��� ������
        2. ���� ������
        3. �� ������
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. �� ������ - NOT
        7. �� ������ - AND
        8. �� ������ - OR
*/


/*
    <ORDER BY>
    
        [����]
            SELECT �÷�, �÷�, ..., �÷�
              FROM ���̺��
             WHERE ���ǽ�
          ORDER BY ���Ľ�Ű���� �ϴ� �÷���|��Ī|�÷� ���� [ASC|DESC] [NULLS FIRST | NULLS LAST];
          
        - SELECT ������ ���� �������� �����ϴ� �������� ���� ���� ���� �������� ����ȴ�.
        - ASC : ������������ �����Ѵ�. (ASC �Ǵ� DESC ���� �� �⺻��)
        - DESC : ������������ �����Ѵ�.
        - NULLS FIRST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� ������ �����Ѵ�.
        - NULLS LAST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� �ڷ� �����Ѵ�.
    
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
































