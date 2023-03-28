package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet{
	
	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/loginForm.jsp").forward(req, resp);
	}
	
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//검사	//디비에 가서 해당 ID,PWD 일치하는 행 조회 
		//result = 디비가서쿼리실행하는메소드();
		boolean result = true;
		
		//문자열 내보내기 == 화면작업
		if(result) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	}

}//class

























