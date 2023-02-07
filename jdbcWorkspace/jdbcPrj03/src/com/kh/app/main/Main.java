package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("prj03 ~~~");
		
		//연결 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//드라이버 등록
		Class.forName(driver);
		
		//드라이버 사용해서 커넥션 얻기
		Connection conn = DriverManager.getConnection(url , id , pwd);
		
		//계정 정보를 유저한테 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("닉네임 : ");
		String memberNick = sc.nextLine();
		
		//SQL
//		String s = "INSERT INTO MEMBER(ID , PWD , NICK) VALUES ('" + memberId + "', '" + memberPwd + "', '" + memberNick + "')";
//		Statement stmt = conn.createStatement();
//		stmt.execute(s);
		
		String s = "INSERT INTO MEMBER(ID , PWD , NICK) VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(s);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		pstmt.execute();
		
		//커넥션 정리
		conn.close();

	}

}















