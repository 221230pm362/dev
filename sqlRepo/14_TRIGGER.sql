-- Ʈ����

/*
    <TRIGGER>
        ���̺��� INSERT, UPDATE, DELETE �� DML ������ ���ؼ� ����� ���
        �ڵ����� ����� ������ �����س��� ��ü�̴�.
        
        * Ʈ������ ����
          1) SQL ���� ���� �ñ⿡ ���� �з�
            - BEFORE TRIGGER : �ش� SQL ���� ���� ���� Ʈ���Ÿ� �����Ѵ�.
            - AFTER TRIGGER : �ش� SQL ���� ���� �Ŀ� Ʈ���Ÿ� �����Ѵ�.
          
          2) SQL ���� ���� ������ �޴� �࿡ ���� �з�
            - ���� Ʈ���� : �ش� SQL ���� �� ���� Ʈ���Ÿ� �����Ѵ�.
            - �� Ʈ���� : �ش� SQL ���� ������ �޴� �ึ�� Ʈ���Ÿ� �����Ѵ�.
            
        [����]
            CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
            BEFORE|AFTER INSERT|UPDATE|DELETE ON ���̺��
            [FOR EACH ROW]
            DECLARE
                �����
            BEGIN
                �����
            EXCEPTION
                ����ó����
            END;
            /
*/

DROP TABLE PRODUCT CASCADE CONSTRAINTS;
CREATE TABLE PRODUCT(
    PNAME   VARCHAR2(100)
    , CNT   NUMBER
);

CREATE TABLE P_ORDER (
    PNAME   VARCHAR2(100)
    , PCNT  NUMBER
);

SELECT * FROM PRODUCT;
SELECT * FROM P_ORDER;

INSERT INTO PRODUCT(PNAME,CNT) VALUES('������23' , 100);
INSERT INTO PRODUCT(PNAME,CNT) VALUES('������14' , 100);

CREATE TRIGGER TRG_P_ORDER
AFTER INSERT ON P_ORDER
BEGIN
    UPDATE PRODUCT SET CNT = CNT-1 WHERE PNAME = '������23';
END;
/

INSERT INTO P_ORDER(PNAME, PCNT) VALUES('������23' , 1);









