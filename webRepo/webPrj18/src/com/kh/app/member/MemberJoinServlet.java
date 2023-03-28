package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {

	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/joinForm.jsp").forward(req, resp);
		
	}
	
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//비즈니스 로직
		int result = 1;	//유효성 검사 ... DB에 insert 등 .. 했다고 치고 ..
		
		//화면 작업
		if(result == 1) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	}
	
}//class


























