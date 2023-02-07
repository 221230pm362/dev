package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		//연결 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//드라이버 준비
		Class.forName(driver);
		
		//커넥션 얻기
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//SQL 실행
		MemberService ms = new MemberService();
		
		//1번 입력받은 경우
		ms.join(conn);
		
		//2번 입력받은 경우
		ms.login(conn);
		
		//커넥션 정리
		conn.close();
		
		

	}

}
