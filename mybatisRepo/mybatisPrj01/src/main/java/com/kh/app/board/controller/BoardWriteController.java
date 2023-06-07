package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데꺼
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writerNo = req.getParameter("writerNo");
		String categoryNo = req.getParameter("categoryNo");
		//데뭉
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriterNo(writerNo);
		vo.setCategoryNo(categoryNo);
		
		//서비스
		BoardService bs = new BoardService();
		int result = bs.write(vo);
		
		//결과 == 화면 == 문자열 내보내기
		resp.getWriter().write("실행결과 : " + result);
	}

}//class

























