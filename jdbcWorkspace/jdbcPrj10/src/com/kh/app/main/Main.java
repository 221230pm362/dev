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
		
		String sql = "INSERT INTO BOARD(TITLE, CONTENT, WRITER, ENROLL_DATE) VALUES(?,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "title01");
		pstmt.setString(2, "content02");
		pstmt.setString(3, "writer01");
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("작성 성공!");
		}else {
			System.out.println("작성 실패...");
		}
		
		conn.close();
		
	}

}
