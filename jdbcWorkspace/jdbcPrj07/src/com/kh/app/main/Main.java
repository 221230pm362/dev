package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		System.out.println("=====member=====");
		
		//디비 연결 == 커넥션얻기
		
		//연결 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//드라이버 준비
//		Class.forName(driver);
		
		//드라이버 사용해서 커넥션 얻기
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		//메뉴보여주고 입력받기
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원목록");
		String input = SC.nextLine();
		
		//입력값에 따라 서비스 진행
		MemberService ms = new MemberService();
		switch(input) {
		case "1" :	ms.join(conn); break; 
		case "2" :  ms.login(conn); break;
		case "3" :  ms.memberList(conn); break;
		default : System.out.println("잘못입력함");
		}

		//커넥션 정리
		conn.close();
		
		System.out.println("=====프로그램 종료=====");
	}//main

}//class


























