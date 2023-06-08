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

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데꺼
		String no = req.getParameter("no");
		//데뭉
		
		//서비스
		BoardService bs = new BoardService();
		BoardVo vo = bs.getBoardByNo(no);
		
		//결과 == 화면 == 문자열 내보내기
		resp.getWriter().write(vo.toString());
	}
	
}//class
























