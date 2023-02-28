-- DML

/*
    <DML(Data Manipulation Language)>
        ������ ���� ���� ���̺� ���� ����(INSERT)�ϰų�, ����(UPDATE), ����(DELETE)�ϴ� �����̴�.
    
    <INSERT>
        ���̺� ���ο� ���� �߰��ϴ� �����̴�.
        
        [����]
            1) INSERT INTO ���̺�� VALUES(��, ��, ��, ..., ��);
                ���̺� ��� Į���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                Į�� ������ ���Ѽ� VALUES�� ���� �����ؾ� �Ѵ�.
            2) INSERT INTO ���̺��(Į����, Į����, ..., Į����) VALUES(��, ��, ..., ��);
                ���̺� ���� ������ Į���� ���� ���� INSERT �ϰ��� �� �� ����Ѵ�.
                ������ �ȵ� Į������ �⺻������ NULL ���� ����. (NOT NULL ���������� �ɷ��ִ� Į���� �ݵ�� �����ؼ� ���� �����ؾ� �Ѵ�.)
                ��, �⺻��(DEFAULT)�� �����Ǿ� ������ NULL�� �ƴ� �⺻���� ����.
            3) INSERT INTO ���̺�� (��������);
                VALUES�� ����ؼ� ���� ������ ��ȸ�� ������� ��ä�� INSERT �Ѵ�.(��, �������� INSERT ��ų �� �ִ�.)
                ���� ������ ������� INSERT ���� ������ Į���� ������ ������ Ÿ���� ���ƾ� �Ѵ�.
*/


/*
    <INSERT ALL>
        �� �� �̻��� ���̺� INSERT �ϴµ� ������ ���� ������ ���Ǵ� ���
        INSERT ALL�� �̿��ؼ� ���� ���̺� �� ���� ������ ������ �����ϴ�.
        
        [ǥ����]
            1) INSERT ALL
               INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               INTO ���̺��2[(Į��, Į��, Į��, ...)] VALUES(��, ��, ��, ...)
               ���� ����;
               
            2) INSERT ALL
               WHEN ����1 THEN 
                   INTO ���̺��1[(Į��, Į��, ...)] VALUES(��, ��, ...)
               WHEN ����2 THEN     
                   INTO ���̺��2[(Į��, Į��, ...)] VALUES(��, ��, ...)
               ���� ����;
*/


CREATE TABLE TEMP(
    ID VARCHAR2(100)
    ,PWD VARCHAR2(100)
);

CREATE TABLE TEMP2(
    ID VARCHAR2(100)
    ,PWD VARCHAR2(100)
);

SELECT * FROM MEMBER;
INSERT INTO MEMBER(ID,PWD) VALUES('USER01', '1111');
INSERT INTO MEMBER(ID,PWD) VALUES('USER02', '2222');

INSERT ALL
INTO TEMP(ID,PWD) VALUES('�ȳ礻��' , '1234')
INTO TEMP2(ID,PWD) VALUES('�ȳ社��' , '4321')
SELECT 1 FROM DUAL
;

SELECT * FROM TEMP;
SELECT * FROM TEMP2;


INSERT ALL
WHEN SALARY >= 8000000 THEN
    INTO TEMP(ID,PWD) VALUES('�ȹ��̻�' , '1234')
WHEN SALARY < 8000000 THEN
    INTO TEMP2(ID,PWD) VALUES('�ȹ�̸�' , '4321')
SELECT * FROM EMPLOYEE WHERE EMP_NAME = '������'
;

COMMIT;
ROLLBACK;

DROP TABLE TEMP CASCADE CONSTRAINTS;
DROP TABLE TEMP2 CASCADE CONSTRAINTS;

/*
    <UPDATE>
        ���̺� ��ϵ� �����͸� �����ϴ� �����̴�.
         
        [ǥ����]
            UPDATE ���̺��
            SET �÷��� = �����Ϸ��� ��,
                �÷��� = �����Ϸ��� ��,
                ...
            [WHERE ����];

            UPDATE ���̺��
            SET �÷��� = (���� ����),
                �÷��� = (���� ����),
                ...
            [WHERE ����];

        - SET ������ ���� ���� �÷��� �޸�(,)�� �����ؼ� ���� ���ÿ� ������ �� �ִ�.
        - WHERE ���� �����ϸ� ��� ���� �����Ͱ� ����ȴ�.
        - UPDATE �ÿ� ���� ������ ����ؼ� ���� ������ ������ ��������� �÷��� ���� ������ �� �ִ�.
*/

/*
    <DELETE>
        ���̺� ��� �� �����͸� �����ϴ� �����̴�. (�� ������ �����Ѵ�.)
        
        [����]
            DELETE FROM ���̺��
            [WHERE ���ǽ�];
            
        - WHERE ���� �������� ������ ��ü ���� �����ȴ�.
*/


/*
    <TRUNCATE>
        ���̺��� ��ü ���� ������ �� ����ϴ� �������� DELETE ���� ���� �ӵ��� �� ������.
        ������ ���� ���ð� �Ұ����ϰ� ROLLBACK�� �Ұ����ϴ�.
        
        [����]
            TRUNCATE TABLE ���̺��;
*/




