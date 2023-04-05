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
import com.kh.app.util.page.PageVo;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();
	
	//게시글 작성
	public int write(BoardVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.write(conn , vo);
		
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

	//목록조회
	public List<BoardVo> selectBoardList(PageVo pv) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> list = dao.selectBoardList(conn , pv);
		
		//close
		JDBCTemplate.close(conn);
		
		return list;
	}

	//게시글 갯수 조회
	public int selectCnt() throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return cnt;
	}

}//class










