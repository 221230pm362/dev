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

@WebServlet("/notice/edit")
public class NoticeEditcontroller extends HttpServlet {
	
	//수정하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(!"ADMIN".equals(loginMember.getId())) {
			req.setAttribute("errorMsg", "접근 권한 없음");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			return;
		}
		
		try {
			
			//데이터
			String no = req.getParameter("no");
			
			//서비스
			NoticeService ns = new NoticeService();
			NoticeVo vo = ns.selectNoticeOneByNo(no);
			
			//화면
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/notice/edit.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("[ERROR] notice edit errr...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "수정하기 화면 조회 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
	//수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}//class




























