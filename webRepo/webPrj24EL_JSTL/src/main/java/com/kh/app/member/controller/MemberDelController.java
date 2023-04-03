package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/del")
public class MemberDelController extends HttpServlet {

	//탈퇴
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데이터
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			String no = loginMember.getNo();
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.del(no);
			
			//화면
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "탈퇴완료!");
				resp.sendRedirect("/app24/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 탈퇴 실패 ,,,");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "~~~errrrrrr");
			req.getRequestDispatcher("~error~~~").forward(req, resp);
		}
		
	}
	
}















