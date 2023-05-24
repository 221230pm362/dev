package com.kh.app.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryDao {

	public int write(Connection conn, GalleryVo gvo) throws Exception {
		
		// SQL
		String sql = "INSERT INTO GALLERY ( NO ,TITLE ,CONTENT ,WRITER_NO ,ORIGIN_NAME ,CHANGE_NAME ) VALUES ( SEQ_GALLERY_NO.NEXTVAL ,? ,? ,? ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, gvo.getTitle());
		pstmt.setString(2, gvo.getContent());
		pstmt.setString(3, gvo.getWriterNo());
		pstmt.setString(4, gvo.getOriginName());
		pstmt.setString(5, gvo.getChangeName());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public List<GalleryVo> getgalleryList(Connection conn) throws Exception {
		
		// SQL
		String sql = "SELECT NO ,TITLE ,CONTENT ,WRITER_NO ,ORIGIN_NAME ,CHANGE_NAME ,ENROLL_DATE ,STATUS ,HIT FROM GALLERY WHERE STATUS = 'O' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// tx || rs
		List<GalleryVo> voList = new ArrayList<>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String originName = rs.getString("ORIGIN_NAME");
			String changeName = rs.getString("CHANGE_NAME");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			
			GalleryVo vo = new GalleryVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setOriginName(originName);
			vo.setChangeName(changeName);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setHit(hit);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public GalleryVo getGalleryByNo(Connection conn, String no) throws Exception {
		
		//SQL
		String sql = "SELECT NO ,TITLE ,CONTENT ,WRITER_NO ,ORIGIN_NAME ,CHANGE_NAME ,ENROLL_DATE ,STATUS ,HIT FROM GALLERY WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		GalleryVo vo = null;
		if(rs.next()) {
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String originName = rs.getString("ORIGIN_NAME");
			String changeName = rs.getString("CHANGE_NAME");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			
			vo = new GalleryVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			vo.setOriginName(originName);
			vo.setChangeName(changeName);
			vo.setEnrollDate(enrollDate);
			vo.setStatus(status);
			vo.setHit(hit);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public int del(Connection conn, String no) throws Exception {
		//SQL
		String sql = "UPDATE GALLERY SET STATUS = 'X' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	

}










