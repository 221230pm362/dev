package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private final BoardService bs;
	
	@Autowired
	public BoardController(BoardService bs) {
		this.bs = bs;
	}

	//게시글 작성 (입력받는 화면)
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	//게시글 작성 (결과 처리)
	@PostMapping("write")
	public String write(BoardVo vo) {
		//서비스
		int result = bs.write(vo);
		//결과
		if(result != 1) {
			return "redirect:/board/fail";
		}
		return "redirect:/board/list";
	}
	
	//게시글 목록 조회
	@GetMapping("list")
	public String list() {
		//서비스
		List<BoardVo> voList = bs.selectList();
		//결과
		System.out.println(voList);
		return "board/list";
	}

}












