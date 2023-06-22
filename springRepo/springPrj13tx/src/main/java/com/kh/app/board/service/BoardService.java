package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
	
	private final SqlSessionTemplate sst;
	private final BoardDao dao;

	//게시글 작성
	public int write(BoardVo vo) {
		return dao.write(sst , vo);
	}

	//게시글 목록조회
	public List<BoardVo> getBoardList() {
		return dao.getBoardList(sst);
	}

	//게시글 "조회수증가" 및 "상세조회"
	public BoardVo getBoardOneByNo(String no) {
		int result = dao.increaseHit(sst, no);
		if(result != 1) {
			throw new RuntimeException("조회수 증가 실패");
		}
		return dao.getBoardOneByNo(sst , no);
	}
	

}//class























