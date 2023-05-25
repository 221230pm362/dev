package com.kh.app.gallery.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.vo.GalleryVo;

public class GalleryService {
	
	private final GalleryDao dao = new GalleryDao();

	public int write(GalleryVo gvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.write(conn , gvo);
		
		// tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<GalleryVo> getGalleryList() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<GalleryVo> voList = dao.getgalleryList(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public GalleryVo getBoardByNo(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		GalleryVo vo = dao.getGalleryByNo(conn , no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int del(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.del(conn, no);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int edit(GalleryVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.edit(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public GalleryVo getGalleryRecent() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		GalleryVo vo = dao.getGalleryRecent(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

}//class


























