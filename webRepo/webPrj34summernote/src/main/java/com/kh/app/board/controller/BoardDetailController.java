package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
	
	//게시글 상세조회 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService bs = new BoardService();
		BoardVo vo = null;
		try {
			vo = bs.getBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
	}
	
}










