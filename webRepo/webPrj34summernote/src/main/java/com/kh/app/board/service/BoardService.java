package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import sim.wy.db.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) throws Exception {
		//커넥션
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, vo);
		
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

	public BoardVo getBoard() throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.getBoard(conn);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
	
	

}













