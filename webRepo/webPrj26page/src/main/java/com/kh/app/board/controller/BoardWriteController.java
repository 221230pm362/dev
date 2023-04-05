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

	//게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//인코딩
			req.setCharacterEncoding("UTF-8");
			
			//데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//데뭉
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//서비스
			BoardService service = new BoardService();
			int result = service.write(vo);
			
			//화면
			if(result == 1) {
				resp.sendRedirect("/app26/home");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 에러 ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "eeeerrr~~~~bbbb.....");
			req.getRequestDispatcher("erorrrrpageeee~~~").forward(req, resp);
		}
		
	}
	
}//class













