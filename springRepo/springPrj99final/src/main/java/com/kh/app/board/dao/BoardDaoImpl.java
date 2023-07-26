package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<BoardVo> list(SqlSessionTemplate sst, PageVo pv, Map<String, String> paramMap) {
		RowBounds rb = new RowBounds(pv.getOffset() , pv.getBoardLimit());
		return sst.selectList("board.selectBoardList" , paramMap , rb);
	}

	@Override
	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("board.write" , vo);
	}

	@Override
	public BoardVo detail(SqlSessionTemplate sst, String no) {
		return sst.selectOne("board.getBoardByNo" , no);
	}

	@Override
	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("board.edit" , vo);
	}

	@Override
	public int delete(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("board.delete" , vo.getNo());
	}

	@Override
	public int increaseHit(SqlSessionTemplate sst, String no) {
		return sst.update("board.increaseHit" , no);
	}

	@Override
	public int getBoardCnt(SqlSessionTemplate sst, Map<String, String> paramMap) {
		return sst.selectOne("board.getBoardCnt", paramMap);
	}
	
}
