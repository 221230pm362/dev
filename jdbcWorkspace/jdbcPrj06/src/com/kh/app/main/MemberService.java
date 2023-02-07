package com.kh.app.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberService {
	
	public void join(Connection conn) throws Exception {
		//회원가입
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("닉네임 : ");
		String memberNick = sc.nextLine();
		
		String sql = "INSERT INTO MEMBER(ID , PWD , NICK) VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPwd);
		pstmt.setString(3, memberNick);
		int result = pstmt.executeUpdate();
		if(result == 1) {
			System.out.println("회원가입 성공!!!");
		}else {
			System.out.println("회원가입 실패...");
		}
	}
	
	public void login(Connection conn) throws Exception {
		//로그인
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
	}

}
