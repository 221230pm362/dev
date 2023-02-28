-- PL/SQL

/*
    <PL/SQL>
        ����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���� SQL ���� ������ ������ ����, ���� ó��(IF), �ݺ� ó��(LOOP, FOR, WHILE) ���� �����Ѵ�.
        (�ټ��� SQL ���� �� ���� ������ �����ϴ�.)
        
        [PL/SQL�� ����]
            1) �����(DECLAER SECTION) : DECLARE�� ����, ������ ����� ���� �� �ʱ�ȭ�ϴ� �κ��̴�.
            2) �����(EXECUTABLE SECTION) : BEGIN�� ����, SQL ��, ���(����, �ݺ���) ���� ������ ����ϴ� �κ��̴�.
            3) ���� ó����(EXCEPTION SECTION) : EXCEPTION�� ����, ���� �߻� �� �ذ��ϱ� ���� ������ ����ϴ� �κ��̴�.
            
        
    <PL/SQL �����(DECLAER SECTION)>
        ���� �� ����� ������ ���� �����̴�.(����� ���ÿ� �ʱ�ȭ�� ����)
        ���� �� ����� �Ϲ� Ÿ�� ����, ���۷��� Ÿ�� ����, ROW Ÿ�� ������ �����ؼ� ����� �� �ִ�.
        
        1) �Ϲ� Ÿ�� ������ ���� �� �ʱ�ȭ
            [����]
                ������ [CONSTANT] �ڷ���(ũ��) [:= ��];
*/


--��� ��� Ȱ��ȭ
SET SERVEROUTPUT ON;


DECLARE
    X NUMBER;
    Y CONSTANT VARCHAR2(100) := 'ZZZ';
BEGIN
    X := 777;
    DBMS_OUTPUT.PUT_LINE('X�� �� ::: ' || X);
    DBMS_OUTPUT.PUT_LINE('Y�� �� ::: ' || Y);
END;
/


/*
        2) ���۷��� Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����]
                ������ ���̺��.�÷���%TYPE;
            
            - �ش��ϴ� ���̺��� �÷��� ������ Ÿ���� �����ؼ� �� Ÿ������ ������ �����Ѵ�.
*/

/*
        3) ROW Ÿ�� ���� ���� �� �ʱ�ȭ
            [ǥ����]
                ������ ���̺��%ROWTYPE;
                
            - �ϳ��� ���̺��� ���� �÷��� ���� �Ѳ����� ������ �� �ִ� ������ �ǹ��Ѵ�.
            - ��� �÷��� ��ȸ�ϴ� ��쿡 ����ϱ� ���ϴ�.
*/

DECLARE
    --X EMPLOYEE.EMP_NAME%TYPE;
    X EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO X
    FROM EMPLOYEE
    WHERE EMP_ID = 208;
    DBMS_OUTPUT.PUT_LINE(X.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(X.EMP_ID);
    DBMS_OUTPUT.PUT_LINE(X.DEPT_CODE);
END;
/

---------------------------------------
/*
    <PL/SQL �����(EXECUTABLE SECTION)>
        1) ���ù�
          1-1) ���� IF ����
            [����]
                IF ���ǽ� THEN
                    ���� ����
                END IF;
*/

DECLARE
    X NUMBER;
BEGIN
    
    -- X := '&���ڸ��Է��ϼ���';
    
    SELECT SALARY
    INTO X
    FROM EMPLOYEE
    WHERE EMP_ID = '&������Է��ϼ���';
    
    DBMS_OUTPUT.PUT_LINE('����� �޿� : ' || X);
    
    IF (X > 50000000) THEN
        DBMS_OUTPUT.PUT_LINE('ũ��');
    ELSIF (X > 2000000) THEN
        DBMS_OUTPUT.PUT_LINE('�߰�');
    ELSE
        DBMS_OUTPUT.PUT_LINE('�۴�');
    END IF;
    
END;
/

/*
        1-4) CASE ����
          [����]
            CASE �� ���
                 WHEN �񱳰�1 THEN �����1
                 WHEN �񱳰�2 THEN �����2
                 ...
                 [ELSE �����]
            END;
*/

DECLARE
    X CHAR(1);
BEGIN

    X := 'A';
    
    CASE X
        WHEN 'A' THEN DBMS_OUTPUT.PUT_LINE('���̤ӤӤ�');
        WHEN 'B' THEN DBMS_OUTPUT.PUT_LINE('��ӤӤ�');
        WHEN 'C' THEN DBMS_OUTPUT.PUT_LINE('���ӤӤ�');
    END CASE;

END;
/


/*
        2) �ݺ���
          2-1) BASIC LOOP
            [����]
                LOOP
                    �ݺ������� �����ų ����
                    
                    [�ݺ����� �������� ���ǹ� �ۼ�]
                        1) IF ���ǽ� THEN 
                              EXIT;
                           END IF
                           
                        2) EXIT WHEN ���ǽ�;
                END LOOP;
*/

DECLARE
    X NUMBER;
BEGIN
    X := 1;
    
    WHILE X <= 3
    LOOP
        DBMS_OUTPUT.PUT_LINE('HELLO~~~');
        
        X := X+1;
        
--        IF (X > 3) THEN 
--            EXIT;
--        END IF;

--        EXIT WHEN X > 3;
        
    END LOOP;
    
END;
/


/*
        2-2) WHILE LOOP
          [ǥ����]
            WHILE ���ǽ�
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
*/

/*
        3) FOR LOOP
          [����]
            FOR ���� IN [REVERSE] �ʱⰪ..������
            LOOP
                �ݺ������� ������ ����;
            END LOOP;
*/


/*
    <PL/SQL ����ó����(EXCEPTION SECTION)>
        ���ܶ� ���� �� �߻��ϴ� ������ ���ϰ� PL/SQL ������ �߻��� ���ܸ� ����ó���ο��� �ڵ�� ó���� �����ϴ�.

        [����]
            DECLARE
                ...
            BEGIN
                ...
            EXCEPTION
                WHEN ���ܸ� 1 THEN ����ó������ 1;
                WHEN ���ܸ� 2 THEN ����ó������ 2;
                ...
                WHEN OTHERS THEN ����ó������;
                
        * ����Ŭ���� �̸� ���ǵǾ� �ִ� ����
          - NO_DATA_FOUND : SELECT ���� ���� ����� �� �൵ ���� ��쿡 �߻��Ѵ�.
          - TOO_MANY_ROWS : �� ���� ���ϵǾ�� �ϴµ� SELECT ������ ���� ���� ���� ������ �� �߻��Ѵ�. 
          - ZERO_DIVIDE   : ���ڸ� 0���� ���� �� �߻��Ѵ�.
          - DUP_VAL_ON_INDEX : UNIQUE ���� ������ ���� �÷��� �ߺ��� �����Ͱ� INSERT �� �� �߻��Ѵ�.
*/


















