package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {
	
	//게시글 작성
	public int write(BoardVo boardVo) throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		//2. SQL
		BoardDao dao = new BoardDao();
		int result = dao.write(conn, boardVo);
		
		//3. tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//4. close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시글 목록 조회
	public List<BoardVo> selectList() throws Exception {
		
		//1. conn
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		List<BoardVo> voList = dao.selectList(conn);
		
		//4. close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	//게시글 상세 조회
	public BoardVo selectOneByNo(String num) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.selectOneByNo(conn , num);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

}//class




















