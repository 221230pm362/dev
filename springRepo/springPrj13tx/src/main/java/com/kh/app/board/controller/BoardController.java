package com.kh.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;

	// 게시글 작성 (화면)
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	// 게시글 작성
	@PostMapping("write")
	public String write(BoardVo vo) throws Exception {
		int result = bs.write(vo);
		if(result != 1) {
			throw new Exception("게시글 작성 실패");
		}
		return "redirect:/board/list";
	}
	
	// 게시글 목록
	@GetMapping("list")
	public String list(Model model) {
		List<BoardVo> voList = bs.getBoardList();
		
		model.addAttribute("voList", voList);
		
		return "board/list";
	}
	
	
	// 게시글 상세조회
	@GetMapping("detail")
	public String detail(String no , Model model) {
		BoardVo vo = bs.getBoardOneByNo(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	
	

}//class

























