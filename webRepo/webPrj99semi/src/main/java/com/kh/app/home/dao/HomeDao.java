package com.kh.app.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;

public class HomeDao {

	public BoardVo getBoardTopHit(Connection conn) throws Exception {
		
		//SQL
		String sql = "SELECT * FROM BOARD WHERE HIT = (SELECT MAX(HIT) FROM BOARD WHERE STATUS ='O')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		BoardVo vo = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer_no = rs.getString("WRITER_NO");
			String category_no = rs.getString("CATEGORY_NO");
			String enroll_date = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String modify_date = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writer_no);
			vo.setCategoryNo(category_no);
			vo.setEnrollDate(enroll_date);
			vo.setStatus(status);
			vo.setModifyDate(modify_date);
			vo.setHit(hit);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);		
		
		return vo;
		
	}
	
	

}
