package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {

	//디비에 있는 BOARD 테이블의 모든 행 응답
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데꺼
		//데뭉
		
		//서비스
		BoardService bs = new BoardService();
		List<BoardVo> voList = null;
		try {
			voList = bs.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//결과 == 화면 == 문자열 내보내기
		resp.getWriter().write(voList.toString());
		
	}
	
}











