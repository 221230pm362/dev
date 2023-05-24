package com.kh.app.admin.member.controller;

import java.awt.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.app.admin.member.service.AdminMemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/admin/member/stop")
public class AdminMemberStopController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//데꺼
			//데뭉
			String str = req.getParameter("noArr");
			Gson gson = new Gson();
			String[] noArr = gson.fromJson(str, String[].class);
			//서비스
			AdminMemberService service = new AdminMemberService();
			int result = service.restrainMembers(noArr);
			//결과
			if(result <= 0) {
				throw new IllegalStateException();
			}
			resp.getWriter().write("ok");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("fail...");
		}
	}//doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String no = req.getParameter("no");
			//데뭉
			
			//서비스
			AdminMemberService service = new AdminMemberService();
			int result = service.restrainMember(no);
			
			//결과
			if(result != 1) {
				throw new IllegalStateException();
			}
			
			resp.sendRedirect(req.getContextPath() + "/admin/member/list");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "제제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}

}//class






















