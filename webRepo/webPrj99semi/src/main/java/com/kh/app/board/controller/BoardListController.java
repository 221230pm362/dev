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
import com.kh.app.common.page.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService bs = new BoardService();
			
			int cnt = bs.getBoardListCnt();
			int page = Integer.parseInt(req.getParameter("page"));
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			//서비스
			List<BoardVo> voList = bs.getBoardList(pv);
			
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회 에러 ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg" , "목록 조회 실패 ..");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}

}//class



















