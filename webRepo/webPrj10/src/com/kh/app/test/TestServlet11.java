package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class TestServlet11 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pwd= req.getParameter("pwd");
		String[] hobby= req.getParameterValues("hobby");
		for(String x : hobby) {
			System.out.println(x);
		}
		
		System.out.println(hobby);
		
		//문자열 내보내기
		PrintWriter out = resp.getWriter();
		if(pwd.length() < 4) {
			out.write("join fail...");
		}else {
			out.write("join success !");
		}
		
	}
	
}
