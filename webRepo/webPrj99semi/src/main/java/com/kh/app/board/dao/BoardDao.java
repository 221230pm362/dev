package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> getBoardList(Connection conn) throws Exception {
		
		//SQL
		String sql = "SELECT * FROM BOARD WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		List<BoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setCategoryNo(categoryNo);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

}//class




















