package com.kh.app.main.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.kh.app.main.Main;

public class BoardService {

	private BoardInput bi = new BoardInput();
	
	//게시글 작성
	public void write(Connection conn) throws Exception {
		//데이터 입력받기
		BoardData data = bi.write();
		
		//SQL
		String sql = "INSERT INTO BOARD(TITLE, CONTENT, WRITER, ENROLL_DATE) VALUES(?,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, data.getTitle());
		pstmt.setString(2, data.getContent());
		pstmt.setString(3, data.getWriter());
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("게시글 작성 성공!");
		}else {
			System.out.println("게시글 작성 실패...");
		}
		
	}
	
	//게시글 목록
	public void selectBoardList(Connection conn) throws Exception {
		
		//SQL
		String sql = "SELECT RPAD(TITLE , 20) AS TITLE , CONTENT , RPAD(WRITER , 9) AS WRITER , TO_CHAR(ENROLL_DATE , 'YYYY\"년\"MM\"월\"DD\"일\" HH24\"시\" MI\"분\" SS\"초\"') AS ENROLL_DATE FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs에서 데이터 꺼내기
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String writer = rs.getString("WRITER");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			System.out.println(title + " | " + writer + " | " + enrollDate);
		}
	}
	
	//게시글 상세
	public void selectBoardOne() {
		
	}
	
}//class

















