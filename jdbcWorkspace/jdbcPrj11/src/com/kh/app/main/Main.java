package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##KH";
		String password = "KH";
		Connection conn = DriverManager.getConnection(url, username, password);

		String sql = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String a = rs.getString("TITLE");
			String b = rs.getString("CONTENT");
			String c = rs.getString("WRITER");
			String d = rs.getString("ENROLL_DATE");
			System.out.print(a);
			System.out.print(" / ");
			System.out.print(b);
			System.out.print(" / ");
			System.out.print(c);
			System.out.print(" / ");
			System.out.print(d);
			
			System.out.println();
		}
		
		conn.close();
		
	}

}
