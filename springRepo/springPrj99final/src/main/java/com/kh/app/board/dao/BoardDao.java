package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

public interface BoardDao {
	
	//게시글 목록
	List<BoardVo> list(SqlSessionTemplate sst, PageVo pv);
	
	//게시글 작성
	int write(SqlSessionTemplate sst, BoardVo vo);
	
	//게시글 상세조회 (+조회수증가)
	BoardVo detail(SqlSessionTemplate sst, String no);
	
	//게시글 수정
	int edit(SqlSessionTemplate sst, BoardVo vo);
	
	//게시글 삭제
	int delete(SqlSessionTemplate sst, BoardVo vo);
	
	//조회수 증가
	int increaseHit(SqlSessionTemplate sst, String no);
	
	//전체 게시글 갯수 조회
	int getBoardCnt(SqlSessionTemplate sst);

}







