-- �Լ� (FUNCTION)

/*
    <�Լ�>
        �÷����� �о ��� ����� ��ȯ�Ѵ�.
          - ������ �Լ� : N���� ���� �о N���� ����� �����Ѵ�. (�� �� �Լ� ���� -> ��� ��ȯ)
          - �׷� �Լ�   : N���� ���� �о 1���� ����� �����Ѵ�. (�ϳ��� �׷캰�� �Լ� ���� -> ��� ��ȯ)
        SELECT ���� ������ �Լ��� �׷� �Լ��� �Բ� ������� ���Ѵ�. (��� ���� ������ �ٸ��� ������)
        �Լ��� ����� �� �ִ� ��ġ�� SELECT, WHERE, ORDER BY, GROUP BY, HAVING ���� ����� �� �ִ�.
*/

------------------������ �Լ�----------------------

/*
    <���� ���� �Լ�>
    1) LENGTH / LENGTHB
      - LENGTH(�÷�|'���ڰ�') : ���� �� ��ȯ
      - LENGTHB(�÷�|'���ڰ�') : ������ ����Ʈ �� ��ȯ
        �ѱ� �� ���� -> 3BYTE
        ������, ����, Ư������ �� ���� -> 1BYTE
*/

SELECT EMP_NAME, EMAIL , LENGTH(EMAIL)
FROM EMPLOYEE;

SELECT LENGTHB('ABC') AS ���ڼ��׽�Ʈ
FROM DUAL;

/*
    2) INSTR
        - INSTR(�÷�|'���ڰ�', '����'[, POSITION[, OCCURRENCE]])
        - ������ ��ġ���� ������ ���� ��°�� ��Ÿ���� ������ ���� ��ġ�� ��ȯ�Ѵ�.
*/

SELECT INSTR('HELLO', 'E')
FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- 9��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- 10��° �ڸ��� B�� ��ġ�� ���
SELECT INSTR('AABAACAABBAA', 'B', -1, 3) FROM DUAL; -- 3��° �ڸ��� B�� ��ġ�� ���

-- EMPLOYEE ���̺��� EMAIL Į���� @ ��ġ�� ã��
SELECT INSTR(EMAIL , '@')
FROM EMPLOYEE
;

/* 
    3) LPAD / RPAD
        - LPAD/RPAD(�÷�|'���ڰ�', ����(����Ʈ)[, '�����̷��� �ϴ� ����'])
        - ���õ� �÷�|'���ڰ�'�� ������ ���ڸ� ���� �Ǵ� �����ʿ� ���ٿ� ���� N ���� ��ŭ�� ���ڿ��� ��ȯ�Ѵ�.
        - ���ڿ� ���� ���ϰ� �ְ� ǥ���ϰ��� �� �� ����Ѵ�.
*/

-- ��� ĭ�� 20ĭ���� ���߱� (������ #���� ä���)
SELECT LPAD(EMAIL, 20 , '!')
FROM EMPLOYEE
;

/*
    4) LTRIM / RTRIM
        - LTRIM/RTRIM(�÷�|'���ڰ�'[, '�����ϰ��� �ϴ� ����'])
        - ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ��� �ϴ� ���ڵ��� ã�Ƽ� ������ ����� ��ȯ�Ѵ�.
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ������ �����Ѵ�.
*/

/*
    5) TRIM
        - TRIM([[LEADING|TRAILING|BOTH] '�����ϰ��� �ϴ� ���ڰ�' FROM] �÷�|'���ڰ�')
        - ���ڰ� ��/��/���ʿ� �ִ� ������ ���ڸ� ������ �������� ��ȯ�Ѵ�. 
        - �����ϰ��� �ϴ� ���ڰ��� ���� �� �⺻������ ���ʿ� �ִ� ������ �����Ѵ�. 
*/

SELECT TRIM('    ABC    ') AS TEST FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(LEADING 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZABCZZZZZ') AS TEST FROM DUAL;


/*
    6)  SUBSTR
        - SUBSTR(Į��|'���ڰ�' , POSITION [, LENGTH])
        - POSITION ���� LENGTH ��ŭ �߶��
        - LENGTH�� ������, ���������� �߶��
*/

SELECT 'HELLOWORLD' FROM DUAL;
SELECT SUBSTR('HELLOWORLD' , 3) FROM DUAL;
SELECT SUBSTR('HELLOWORLD' , 3 , 2) FROM DUAL;

-- EMPLOYEE ���̺��� �����, �ֹι�ȣ ��ȸ (���ڸ� �������Ĵ� * �� ǥ��) , �ֹι�ȣ �� ���� �κи� ��ȸ (��Ī�� ����)
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO , 1 , 8) , 14 , '*'), SUBSTR(EMP_NO , 8, 1) AS ����
FROM EMPLOYEE;


/*
    7)  LOWER / UPPER / INITCAP
        LOWER : ��� �ҹ��ڷ� ����
        UPPER : ��� �빮�ڷ� ����
        INITCAP : �ܾ� �� ���ڸ��� �빮�ڷ� ����
*/

/*
    8)  CONCAT
        - ���ڿ� ��ġ��
*/

SELECT CONCAT('AAA' , 'BBB')  
FROM DUAL;

/*
    9)  REPLACE
*/

SELECT REPLACE('HELLO WORLD' , 'WORLD' , 'KOREA')
FROM DUAL; 


------------------------------------------------------------------
-- ���� ���� �Լ�

/*
    1) ABS : ���밪
    2) MOD : ������ ����
    3) ROUND : �ݿø�
    4) CEIL : �ø�
    5) FLOOR : ����
    6) TRUNC : ����
*/

SELECT ABS(-1.23) FROM DUAL;

SELECT MOD(10,3) FROM DUAL;

SELECT ROUND(123.456 , -1) FROM DUAL;

SELECT CEIL(123.456) FROM DUAL;

SELECT FLOOR(123.456) FROM DUAL;

SELECT TRUNC(123.456 , -2) FROM DUAL;

-------------------------------------------------------
/*
    ��¥ ���� �Լ�
        1) SYSDATE          : �ý����� ���� ��¥�� �ð�
        2) MONTHS_BETWEEN   : �� ��¥ ������ ���� ��
        3) ADD_MONTHS       : ���� �� ���ϱ�
        4) NEXT_DAY         : ���Ϸ��� ������ ���� ����� ��¥
        5) LAST_DAY         : �ش� ���� ������ ��¥
        6) EXTRACT          : �� , �� , �� ���� ����  (������� NUMBER Ÿ��)
*/

SELECT SYSDATE FROM DUAL;

-- EMPOYEE ���̺��� �����, �Ի�����, ���ñ����ٹ������� ��ȸ
SELECT EMP_NAME, HIRE_DATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "�ٹ� ���� ��"
FROM EMPLOYEE;

SELECT ADD_MONTHS('23/1/1', 6) FROM DUAL;


SELECT NEXT_DAY(SYSDATE , 'FRI') FROM DUAL;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;  --��� ����

SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;

SELECT SYSDATE FROM DUAL;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';  -- ��¥ ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

/*
    ����ȯ �Լ�
        CHAR , DATE , NUMBER
        1) TO_CHAR      
        2) TO_DATE
        3) TO_NUMBER
*/

-- ���� -> ����
SELECT TO_CHAR(123) AS Į���������������������� FROM DUAL;
SELECT TO_CHAR(123, '99999') AS Į���������������������� FROM DUAL;
SELECT TO_CHAR(123, '00000') AS Į���������������������� FROM DUAL;
SELECT TO_CHAR(123456789, 'L9,999,999,999,999') AS Į���������������������� FROM DUAL;   --���� ������ ����(LOCAL) ȭ�����
SELECT TO_CHAR(123, 'L') AS Į���������������������� FROM DUAL;

SELECT EMP_NAME, TO_CHAR(SALARY , 'L9,999,999') AS �޿�
FROM EMPLOYEE;

-- ��¥ -> ����
SELECT TO_CHAR(SYSDATE , 'YYYY"��"MM"��"DD"��" DAY AM HH24:MI:SS') FROM DUAL;


-- ���� -> ��¥
SELECT TO_DATE(20230206) FROM DUAL;
-- ���� -> ��¥
SELECT TO_DATE('20230206') FROM DUAL;
SELECT TO_DATE('23/2/6') FROM DUAL;


-- ���� -> ����
SELECT TO_NUMBER('0123456789') FROM DUAL;


/*
    NULL ó�� �Լ�
        - NVL       : NULL ���� �ٸ� ������ ����
        - NVL2      : NULL ���� �ƴ��� �� ���� �� ����
        - NULLIF    : �� ���� �����ϸ� NULL , �׷��� ������ Ư�� ������ ����
*/

-- �����, ���ʽ����Կ��� ��ȸ. ������̺���.
SELECT EMP_NAME, SALARY * 12 + SALARY*NVL(BONUS , 0) AS ���� ,  NVL(BONUS , 0)
FROM EMPLOYEE;

SELECT NVL2(BONUS, 1 , 0)
FROM EMPLOYEE;

SELECT NULLIF(456, 456) FROM DUAL;

/*
    DECODE
        DECODE(Į�� , ���ǰ�1 , �����1 , ���ǰ�2, �����2 ....)  
*/

-- ����� , �ֹι�ȣ ���ڸ� ù��° ���� ��ȸ
SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO , 8, 1) , 1 , '��' , 2 , '��') ����
FROM EMPLOYEE;

/*
    CASE WHEN THEN
        [����]
            CASE
                WHEN ���ǽ�1 THEN ���1
                WHEN ���ǽ�2 THEN ���2
                ...
                ELSE ���99
            END
                
*/


-- ����� , �ֹι�ȣ ���ڸ� ù��° ���� ��ȸ�Ͽ��� ������ ���
SELECT EMP_NAME, 
    CASE 
        WHEN SUBSTR(EMP_NO , 8 , 1) = 1 THEN '��'
        WHEN SUBSTR(EMP_NO , 8 , 1) = 2 THEN '��'
    END
    AS ����
FROM EMPLOYEE;

-- �����, �����ڵ� , �����̸�(J1=> ���� , J2 => ����, J3 => ���� , �� �� ����)  ��ȸ
SELECT 
    EMP_NAME 
    , JOB_CODE
    , CASE
        WHEN JOB_CODE = 'J1' THEN '����'
        WHEN JOB_CODE = 'J2' THEN '����'
        WHEN JOB_CODE = 'J3' THEN '����'
        ELSE '����'
    END AS ���޸�
FROM EMPLOYEE;

-- ���, 
-- �̸�, 
-- �μ�, 
-- �޿� , 
-- �޿���������(300 �̸��� �ʱ�, 300�̻� 500 �̸��� �߱�, 500 �̻��� ���)
SELECT 
    EMP_ID
    , EMP_NAME
    , DEPT_CODE
    , SALARY
    , CASE
        WHEN SALARY < 3000000 THEN '�ʱ�'
        WHEN SALARY < 5000000 THEN '�߱�'
        ELSE '���'
    END AS ��
FROM EMPLOYEE
;

-----------------------------------------------------------

/*
    <�׷� �Լ�>
        �뷮�� �����͵�� ���質 ��� ���� �۾��� ó���ؾ� �ϴ� ��� ���Ǵ� �Լ����̴�.
        ��� �׷� �Լ��� NULL ���� �ڵ����� �����ϰ� ���� �ִ� �͵鸸 ����� �Ѵ�.
        ���� AVG �Լ��� ����� ���� �ݵ�� NVL() �Լ��� �Բ� ����ϴ� ���� �����Ѵ�.
        
        - SUM
        - AVG
        - MIN / MAX
        - COUNT
*/

SELECT 
    SUM(SALARY) AS �޿��հ�
    , AVG(SALARY) AS �޿����
    , COUNT(SALARY) AS �ο���
    , MAX(SALARY) AS �ְ�޿�
    , MIN(SALARY) AS �����޿�
FROM EMPLOYEE;



















