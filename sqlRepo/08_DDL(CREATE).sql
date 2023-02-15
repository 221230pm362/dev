--DDL

/*
    <DDL(Data Definition Language)>
        ������ ���� ���� ����Ŭ���� �����ϴ� ��ü�� �����(CREATE), �����ϰ�(ALTER), �����ϴ�(DROP) ��
        ���� ������ ���� �ƴ� �������� ���� ��ü�� �����ϴ� ���� DB ������, �����ڰ� �ַ� ����Ѵ�.

        * ����Ŭ������ ��ü : ���̺�, ��, ������, �ε���, Ʈ����, ���ν���, �Լ�, ����� ���
        
    <CREATE>
        �����ͺ��̽��� ��ü�� �����ϴ� �����̴�.
    
    <TABLE(���̺�)>
        ���̺��� ��� ���� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü�� �����ͺ��̽� ������ ��� �����ʹ� ���̺� ����ȴ�.
        
    <���̺� ����>
        [ǥ����]
            CREATE TABLE ���̺�� (
                �÷��� �ڷ���(ũ��) [DEFAULT �⺻��] [��������],
                �÷��� �ڷ���(ũ��) [DEFAULT �⺻��] [��������],
                ...
            );
*/

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID           VARCHAR2(100) NOT NULL UNIQUE
    ,PWD         VARCHAR2(100) NOT NULL
    ,NICK        VARCHAR2(100)
    ,QUIT_YN     CHAR(10)      DEFAULT 'N'
    ,ENROLL_DATE TIMESTAMP     DEFAULT SYSDATE
    ,GENDER      CHAR(1)       CHECK( GENDER IN ('M','F') )
);

/*
    <�÷��� �ּ� �ޱ�>
        [ǥ����]
            COMMENT ON COLUMN ���̺��.�÷��� IS '�ּ�����';
*/

COMMENT ON COLUMN MEMBER.ID IS 'ȸ�� ���̵�';
COMMENT ON COLUMN MEMBER.PWD IS 'ȸ�� ��й�ȣ';
COMMENT ON COLUMN MEMBER.NICK IS 'ȸ�� �г���';
COMMENT ON COLUMN MEMBER.QUIT_YN IS 'Ż�𿩺�';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '�����Ͻ�';
COMMENT ON COLUMN MEMBER.GENDER IS '����';


/*
    ������ ��ųʸ�(��Ÿ ������)
        �ڿ��� ȿ�������� �����ϱ� ���� �پ��� ��ü���� ������ �����ϴ� �ý��� ���̺��̴�.
        ����ڰ� ��ü�� �����ϰų� ��ü�� �����ϴ� ���� �۾��� �� �� �����ͺ��̽��� ���ؼ� �ڵ����� ���ŵǴ� ���̺��̴�.
        �����Ϳ� ���� �����Ͱ� ����Ǿ� �ִٰ� �ؼ� ��Ÿ �����Ͷ�� �Ѵ�.
        
    USER_TABLES         : ����ڰ� ������ �ִ� ���̺���� �������� ������ Ȯ���ϴ� �� ���̺��̴�. 
    USER_TAB_COLUMNS    : ���̺�, ���� �÷��� ���õ� ������ ��ȸ�ϴ� �� ���̺��̴�.
*/

SELECT * FROM USER_TABLES;
SELECT * FROM USER_TAB_COLUMNS;


/*
    <���� ����(CONSTRAINT)>
        ����ڰ� ���ϴ� ������ �����͸� �����ϱ� ���ؼ� ���̺� �ۼ� �� �� �÷��� ���� ����� ���� ���� ���������� ������ �� �ִ�.
        ���� ������ ������ ���Ἲ ������ �������� �Ѵ�. (�������� ��Ȯ���� �ϰ����� ������Ű�� ��)
        
        * ���� : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
        
        [����]
            1) �÷� ����
                CRATE TABLE ���̺�� (
                    �÷��� �ڷ���(ũ��) [CONSTRAINT �������Ǹ�] ��������,
                    ...
                );
            
            2) ���̺� ����
                CRATE TABLE ���̺�� (
                    �÷��� �ڷ���(ũ��),
                    ...,
                    [CONSTRAINT �������Ǹ�] ��������(�÷���)
                );
*/

-- ���̺� ���� Ȯ��
DESC MEMBER;
-- ���� ���� Ȯ��
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MEMBER';

DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS WHERE TABLE_NAME = 'MEMBER';


/*
    <NOT NULL ��������>
        �ش� Į���� �ݵ�� ���� �־�߸� �ϴ� ��� ����Ѵ�.
        ����/���� �� NULL ���� ������� �ʵ��� �����Ѵ�.
        
        * Į���������� �ۼ� ����
*/

/*
    <UNIQUE ��������>
        Į���� �Է� ���� �ߺ� ���� �����ϴ� ���������̴�.
        �����͸� ����/���� �� ������ �ִ� ������ �� �߿� �ߺ��Ǵ� ���� ���� ��� ����/�������� �ʴ´�.
        �������� ���� ������� Į�� ����, ���̺� ���� ��� ��� ��� �����ϴ�.
        ���� Į���� ��� �����ϴ°͵� ���� (�ݵ�� ���̺� ���� ������� ����)
*/






















