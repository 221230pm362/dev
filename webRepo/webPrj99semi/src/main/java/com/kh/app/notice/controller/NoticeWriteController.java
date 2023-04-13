package com.kh.app.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/notice/write")
public class NoticeWriteController extends HttpServlet {
	
	private final NoticeService ns = new NoticeService();

	//작성하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		boolean isAdmin = (loginMember == null) ? false : ("ADMIN".equals(loginMember.getId())) ? true : false;
		
		if(!isAdmin) {
			req.setAttribute("errorMsg", "잘못된 접근입니다...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/notice/write.jsp").forward(req, resp);
	}
	
	//작성하기
	// insert ~~~
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//데뭉
			NoticeVo vo = new NoticeVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//서비스
			int result = ns.write(vo);
			
			//화면
			if(result == 1) {
				resp.sendRedirect(req.getContextPath() + "/notice/list");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] notice write errr....");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "notice write fail ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp");
		}
		
	}
	
}//class























