package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.template.JDBCTemplate;

public class BoardDao {

	public List<BoardVo> getBoardList(SqlSession ss) throws Exception {
		return ss.selectList("board.getBoardList");
	}

	public int write(SqlSession ss, BoardVo vo) {
		return ss.insert("board.write" , vo);
	}

	public BoardVo getBoardByNo(SqlSession ss, String no) {
		return ss.selectOne("board.getBoardByNo" , no);
	}

}











