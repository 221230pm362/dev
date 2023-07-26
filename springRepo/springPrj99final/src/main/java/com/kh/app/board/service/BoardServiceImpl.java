package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final SqlSessionTemplate sst;
	private final BoardDao dao;

	@Override
	public List<BoardVo> list(PageVo pv, Map<String, String> paramMap) {
		return dao.list(sst, pv, paramMap);
	}

	@Override
	public int write(BoardVo vo) {
		return dao.write(sst, vo);
	}

	@Override
	public BoardVo detail(String no) {
		return dao.detail(sst, no);
	}

	@Override
	public int edit(BoardVo vo) {
		return dao.edit(sst, vo);
	}

	@Override
	public int delete(BoardVo vo) {
		return dao.delete(sst, vo);
	}

	@Override
	public int getBoardCnt(Map<String, String> paramMap) {
		return dao.getBoardCnt(sst, paramMap);
	}
	
	

}
