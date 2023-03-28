package com.kh.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String nick = req.getParameter("nick");
		
		//데이터를 req에 담기
		req.setAttribute("x", nick);
		
		//문자열 내보내기 (JSP한테 위임)
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
//		resp.setContentType("text/html; charset=UTF-8;");
//		PrintWriter out = resp.getWriter();
//		out.write("<h2>");
//		out.write(nick);
//		out.write(" 님 환영합니다.");
//		out.write("</h2>");
		
	}//method
	
}//class











