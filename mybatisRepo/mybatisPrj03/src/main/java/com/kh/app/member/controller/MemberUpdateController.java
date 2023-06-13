package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데꺼
		String no = req.getParameter("no");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		//데뭉
		MemberVo vo = new MemberVo();
		vo.setNo(no);
		vo.setPwd(pwd);
		vo.setNick(nick);
		
		//서비스
		MemberService ms = new MemberService();
		int result = ms.edit(vo);
		
		//결과
		resp.getWriter().write("result : " + result);
		
	}

}
