package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/dup-check")
public class MemberDupCheckcontroller extends HttpServlet {

	//아이디 검사
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		
		//검사 //admin 으로 가입 ㄴㄴ
		if("admin".equals(memberId)) {
			resp.getWriter().write("no");
		}else {
			resp.getWriter().write("ok");
		}
		
	}//method
	
	
	
}//class





















