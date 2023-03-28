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

		//문자열 내보내기 == 다른애한테넘기기
		req.getRequestDispatcher("/joinForm.jsp").forward(req, resp);
		
	}//method
	
	
	
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd");
		String nick = req.getParameter("memberNick");
		
		//디비에 가서 insert
		int result = 1;//디비에 가서 insert 해주는 메소드 호출(데이터);
		
		//문자열 내보내기 == 화면작업
		if(result == 1) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	}//method

}//class


















