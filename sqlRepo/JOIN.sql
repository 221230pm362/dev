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


/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
        ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ����̴�.
        ( = �̿ܿ� �� ������ >, <, >=, <=, BETWEEN AND, IN, NOT IN ���� ����Ѵ�.)
        ANSI �������δ� JOIN ON �������θ� ����� �����ϴ�. (USING ��� �Ұ�)
*/

/*
    6. ��ü ����(SELF JOIN)
        ���� ���̺��� �ٽ� �ѹ� �����ϴ� ��쿡 ����Ѵ�.
*/









