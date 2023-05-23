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

	public int write(GalleryVo gvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		GalleryDao dao = new GalleryDao();
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
		
		GalleryDao dao = new GalleryDao();
		List<GalleryVo> voList = dao.getgalleryList(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public GalleryVo getBoardByNo(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		GalleryDao dao = new GalleryDao();
		GalleryVo vo = dao.getGalleryByNo(conn , no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

}//class


























