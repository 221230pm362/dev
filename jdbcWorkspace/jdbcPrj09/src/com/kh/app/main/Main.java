package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// 디비 연결 (드라이버준비, 커넥션 얻기)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##KH";
		String password = "KH";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// SQL (쿼리준비, stmt준비, 실행)
		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "user04");
		pstmt.setString(2, "1234");
		pstmt.setString(3, "n01");
		int result = pstmt.executeUpdate();
		
		//결과에 따라 처리
		if(result == 1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		//conn 정리
		conn.close();

	}//main

}
















