package com.kh.app.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberService {
	
	//회원가입
	public void join(Connection conn) throws Exception {
		MemberInput mi = new MemberInput();
		MemberData data = mi.join();
		
		//SQL 실행
		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, data.getMemberId());
		pstmt.setString(2, data.getMemberPwd());
		pstmt.setString(3, data.getMemberNick());
		int result = pstmt.executeUpdate();
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패 ...");
		}
		
	}
	
	//로그인
	public void login(Connection conn) throws Exception {
		
		MemberInput mi = new MemberInput();
		MemberData data = mi.login();
		
		//SQL 실행
		String sql = "SELECT ID,PWD,NICK FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, data.getMemberId());
		pstmt.setString(2, data.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//rs 에서 데이터 꺼내기
		if(rs.next()) {
			String dbId = rs.getString("ID");
			String dbPwd = rs.getString("PWD");
			String dbNick = rs.getString("NICK");
			
			System.out.println(dbId);
			System.out.println(dbPwd);
			System.out.println(dbNick);
			
			System.out.println("로그인 성공 !");
			System.out.println(dbNick + " 님 환영합니다");
		}else {
			System.out.println("로그인 실패...");
		}
		
	}
	
	//회원목록
	public void memberList(Connection conn) throws Exception {
		//sql 실행
		String sql = "SELECT ID,PWD,NICK FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs에서 데이터 꺼내기
		while(rs.next()) {
			String dbId = rs.getString("ID");
			String dbPwd = rs.getString("PWD");
			String dbNick = rs.getString("NICK");
			
			System.out.println(dbId + " / " + dbPwd + " / " + dbNick);
		}
	}

}//class














