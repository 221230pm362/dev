package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	//게시글 작성
	public int write(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("board.write" , vo);
	}

	//게시글 목록조회
	public List<BoardVo> getBoardList(SqlSessionTemplate sst) {
		return sst.selectList("board.getBoardList");
	}

	//게시글 상세조회
	public BoardVo getBoardOneByNo(SqlSessionTemplate sst, String no) {
		return sst.selectOne("board.getBoardOneByNo" , no);
	}
	
	//게시글 조회수 증가
	public int increaseHit(SqlSessionTemplate sst, String no) {
		return sst.update("board.increaseHit", no);
	}

}//class
























