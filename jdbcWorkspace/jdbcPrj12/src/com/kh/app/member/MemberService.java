package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.jdbc.JdbcTemplate;
import com.kh.app.main.Main;

public class MemberService {

	private final MemberInput mi = new MemberInput();
	
	//회원가입
	public void join() throws Exception {
		//유저 데이터 입력받기
		MemberData data = mi.join();
		
		//insert
		Connection conn = JdbcTemplate.getConnection();
		String sql = "INSERT INTO MEMBER(ID,PWD,NICK) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, data.getMemberId());
		pstmt.setString(2, data.getMemberPwd());
		pstmt.setString(3, data.getMemberNick());
		int result = pstmt.executeUpdate();
		
		//결과에 따른 처리
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패...");
		}
		
		//커넥션 정리
		conn.close();
	}
	
	//로그인
	public void login() throws Exception {
		//유저 데이터 입력받기
		MemberData data = mi.login();
		
		//select
		Connection conn = JdbcTemplate.getConnection();
		String sql = "SELECT ID,PWD,NICK FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, data.getMemberId());
		pstmt.setString(2, data.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//결과집합에서 데이터 꺼내기
		if(rs.next()) {
			String nick = rs.getString("NICK");
			System.out.println(nick + " 님 환영합니다.");
			Main.loginMemberNick = nick;
		}else {
			System.out.println("로그인 실패");
		}
		
		conn.close();
	}
	
}//class


























