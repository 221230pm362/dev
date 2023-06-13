package com.kh.app.member.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데꺼 , 데뭉
		String[] numArr = req.getParameterValues("num");
		
		//서비스
		MemberService ms = new MemberService();
		List<MemberVo> voList = ms.getMemberList(numArr);
		
		//결과 == 화면 == 문자열내보내기
		resp.getWriter().write(voList.toString());
	}

}//class



















