package com.kh.app.gallery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.gallery.service.GalleryService;

@WebServlet("/gallery/del")
public class GalleryDelController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String no = req.getParameter("no");
			//데뭉
			
			//서비스
			GalleryService gs = new GalleryService();
			int result = gs.del(no);
			
			if(result != 1) {
				throw new IllegalStateException("게시글 삭제 실패...");
			}
			//결과
			resp.sendRedirect(req.getContextPath() + "/gallery/list");
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "갤러리 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}

}































