package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/one")
public class MemberOneController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데꺼
		String no = req.getParameter("no");
		//데뭉
		
		//서비스
		MemberService ms = new MemberService();
		MemberVo vo = ms.getMemberByNo(no);
		
		//문자열내보내기
		resp.getWriter().write(vo.toString());
	}

}//class























