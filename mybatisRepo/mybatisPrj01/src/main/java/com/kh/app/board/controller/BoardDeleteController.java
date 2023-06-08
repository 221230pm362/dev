package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데꺼
		String no = req.getParameter("no");
		//데뭉
		//서비스
		BoardService bs = new BoardService();
		int result = bs.delete(no);
		//결과
		resp.getWriter().write("result : " + result);
		
	}

}//class





















