package com.kh.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.temp.KhConstPool;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
	
	private final BoardService service;
	
	//게시글 목록
	@GetMapping("list")
	public String list(@RequestParam(defaultValue = "1") int p , Model model , @RequestParam Map<String, String> paramMap) {
		
		int listCount = service.getBoardCnt(paramMap);
		int currentPage = p;
		int pageLimit = KhConstPool.PAGE_LIMIT;
		int boardLimit = KhConstPool.BOARD_LIMIT;
		
		PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		List<BoardVo> voList = service.list(pv , paramMap);
		model.addAttribute("voList", voList);
		model.addAttribute("paramMap", paramMap);
		
		return "board/list";
	}
	
	
	//게시글 작성 (화면)
	
	//게시글 작성
	
	//게시글 상세조회
	
	//게시글 수정 (화면)
	//게시글 수정
	
	//게시글 삭제

}//class



















