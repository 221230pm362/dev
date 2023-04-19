package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.common.db.JDBCTemplate;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	public List<BoardVo> getBoardList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> voList = dao.getBoardList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

}//class


















