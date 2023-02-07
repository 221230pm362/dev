package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("=====로그인=====");
		
		//연결 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//드라이버 등록
		Class.forName(driver);
		
		//드라이버 사용해서 커넥션 얻기
		Connection conn = DriverManager.getConnection(url , id , pwd);
		
		//로그인 정보 받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("패스워드: ");
		String memberPwd = sc.nextLine();
		
		//SQL 실행
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		ResultSet rs = pstmt.executeQuery();
		System.out.println(rs);
		
		//결과집합에서 데이터 꺼내기
		rs.next();
		String dbId = rs.getString("ID");
		String dbPwd = rs.getString("PWD");
		String dbNick = rs.getString("NICK");
		
		System.out.println(dbId);
		System.out.println(dbPwd);
		System.out.println(dbNick);
		
		//conn 반납
		conn.close();

	}//main

}//class
























