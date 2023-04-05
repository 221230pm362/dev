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
import com.kh.app.util.page.PageVo;
import com.kh.app.util.page.Pagination;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	//게시글 목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			BoardService service = new BoardService();
			
			//페이징 시작
			int listCount = service.selectCnt();
			int currentPage = Integer.parseInt( req.getParameter("page") );
			int pageLimit = 5;
			int boardLimit = 5; 
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			//PageVo pv = Pagination.getPageVo(listCount, currentPage, pageLimit, boardLimit);
			//페이징 종료
			
			//서비스
			List<BoardVo> bvoList = service.selectBoardList(pv);
			
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("bvoList", bvoList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회 중 예외 발생 ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "eeerrrrr~~~");
			req.getRequestDispatcher("errorpage~~~zzz").forward(req, resp);
		}
	}

}













