package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/insert")
public class MemberInsertController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데꺼
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		String profile = req.getParameter("profile");
		String hobby = req.getParameter("hobby");
		//데뭉
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		vo.setProfile(profile);
		vo.setHobby(hobby);
		
		//서비스
		MemberService ms = new MemberService();
		int result = ms.insertMember(vo);
		
		//결과
		resp.getWriter().write("result : " + result);
	}

}//class



















