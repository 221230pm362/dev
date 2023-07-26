package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

public interface BoardService {
	
	//게시글 목록
	List<BoardVo> list(PageVo pv, Map<String, String> paramMap);
	
	//게시글 작성
	int write(BoardVo vo);
	
	//게시글 상세조회 (+조회수증가)
	BoardVo detail(String no);
	
	//게시글 수정
	int edit(BoardVo vo);
	
	//게시글 삭제
	int delete(BoardVo vo);
	
	//전체 게시글 갯수 조회
	int getBoardCnt(Map<String, String> paramMap);

}//class










