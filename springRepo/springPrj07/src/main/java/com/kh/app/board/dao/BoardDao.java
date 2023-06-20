package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("board.write" , vo);
	}

	public List<BoardVo> selectList(SqlSessionTemplate sst) {
		return sst.selectList("board.selectList");
	}

}//class























