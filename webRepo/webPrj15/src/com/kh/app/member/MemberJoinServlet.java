package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	
	//회원가입
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		//검사
		boolean joinSuccess = true;
		if(pwd.length() <= 4) {
			joinSuccess = false;
		}
		
		//결과에 따라 문자열 내보내기
		if(joinSuccess) {
			req.getRequestDispatcher("/joinSuccess.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/joinFail.jsp").forward(req, resp);
		}
		
	}//method

}//class



















