package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("인서ㄹ트 ~~~");
		
		//드라이버 준비
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//연결정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//드라이버 사용 해서 커넥션얻기
		Connection conn = DriverManager.getConnection(url , id, pwd);
		
		//sql 실행
		String s = "INSERT INTO MEMBER(ID , PWD , NICK) VALUES ('USER01', '1234', 'NICK01')";
		Statement stmt = conn.createStatement();
		stmt.execute(s);
		
		//conn 정리
		conn.close();
		
	}//main

}//class
























