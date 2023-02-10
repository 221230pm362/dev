package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.jdbc.JdbcTemplate;
import com.kh.app.main.Main;

public class BoardService {
	
	//게시글 작성
	public void write() throws Exception {
		//로그인 여부 검사
		if(Main.loginMemberNick == null) {
			System.out.println("로그인 한 유저만 글쓰기가 가능합니다.");
			return;
		}
		
		//입력받은 데이터
		System.out.print("제목 : ");
		String title = Main.sc.nextLine();
		System.out.print("내용 : ");
		String content = Main.sc.nextLine();
		
		//SQL 실행
		String sql = "INSERT INTO BOARD(TITLE, CONTENT, WRITER, ENROLL_DATE) VALUES(?,?,?,SYSDATE)";
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, Main.loginMemberNick);
		int result = pstmt.executeUpdate();
		
		//결과 확인
		if(result == 1) {
			System.out.println("게시글 작성 성공!");
		}else {
			System.out.println("게시글 작성 실패...");
		}
		
		//커넥션 정리
		conn.close();
	}
	
	//게시글 목록 조회
	public void selectBoardList() throws Exception {
		//SQL실행
		String sql = "SELECT TITLE,WRITER,ENROLL_DATE FROM BOARD ORDER BY ENROLL_DATE DESC";
		Connection conn = JdbcTemplate.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//결과집합에서 데이터 꺼내기 
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String writer = rs.getString("WRITER");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			System.out.print(title);
			System.out.print(" / ");
			System.out.print(writer);
			System.out.print(" / ");
			System.out.print(enrollDate);
			System.out.println();
		}
		
		//커넥션정리
		conn.close();
	}

}//class






















