package com.kh.app.home.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.home.dao.HomeDao;

public class HomeService {

	public BoardVo getBoardTopHit() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		HomeDao dao = new HomeDao();
		BoardVo vo = dao.getBoardTopHit(conn);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

}






















