-- ���� �ּ�
/*
    ������
    �ּ�
    ������
    ����
*/

--����� ���� ����
-- [����] CREATE USER ������ IDENTIFIED BY ��й�ȣ;
CREATE USER C##KH IDENTIFIED BY KH;

-- ���Ѻο�
GRANT CONNECT, RESOURCE TO C##KH;

-- ���̺����̽� ���� ����
ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
