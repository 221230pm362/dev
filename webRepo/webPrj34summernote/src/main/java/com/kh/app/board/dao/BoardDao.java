package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.vo.BoardVo;

import sim.wy.db.JDBCTemplate;

public class BoardDao {

	public int write(Connection conn, BoardVo vo) throws Exception {
		
		//SQL
		String sql = "INSERT INTO TEMP_BOARD (TITLE, CONTENT) VALUES (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public BoardVo getBoard(Connection conn) throws Exception {

		BoardVo vo = new BoardVo();
		
		String sql = "SELECT TITLE, CONTENT FROM TEMP_BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			
			vo.setTitle(title);
			vo.setContent(content);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

}
