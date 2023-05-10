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

	//게시글 작성하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성하기
	//INSERT INTO BOARD (TITLE, CONTENT, WRITER) VALUES (?,?,?)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			//데뭉
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			
			//서비스
			BoardService bs = new BoardService();
			int result = bs.write(vo);
			
			//화면
			if(result == 1) {
				//성공 ~
				resp.sendRedirect("/app/board/list");
			}else {
				//실패 ~
				req.setAttribute("errorMsg", "작성실패...");
				req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
}



















