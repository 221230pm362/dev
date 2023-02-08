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
		System.out.println("3. 전체 회원 목록");
		
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
		
		//유저입력받기
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		if("1".equals(input)) {
			//1번 입력받은 경우
			ms.join(conn);
		}else if("2".equals(input)) {
			//2번 입력받은 경우
			ms.login(conn);
		}else if("3".equals(input)) {
			//3번 입력받은 경우
			ms.selectMemberList(conn);
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		
		//커넥션 정리
		conn.close();

	}

}
