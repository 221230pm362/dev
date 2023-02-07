package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("jdbc~~");
		
		//Connection 객체 얻기
		
		//드라이버 준비
		Class.forName("oracle.jdbc.OracleDriver");
		
		//연결정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "KH";
		
		//커넥션 얻기
		Connection conn = DriverManager.getConnection(url , id , pwd);
		
		//insert
		String sql = "INSERT INTO MEMBER(ID , PWD , NICK) VALUES ('USER01', '1234', 'NICK01')";
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
		//자원 정리
		conn.close();
		
		System.out.println("프로그램 종료 ...");

	}//main

}//class





























