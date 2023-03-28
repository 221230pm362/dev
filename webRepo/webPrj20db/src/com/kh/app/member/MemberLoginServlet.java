package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	
	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
		
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
		//서비스 로직
		Map<String, String> dbData = null;
		try {
			//1. conn
			Connection conn = JDBCTemplate.getConnection();
			
			//2. SQL
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			ResultSet rs = pstmt.executeQuery();
			
			//3. tx || rs->obj  ,  close
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				dbData = new HashMap<>();
				dbData.put("dbId", dbId);
				dbData.put("dbPwd", dbPwd);
				dbData.put("dbNick", dbNick);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 중 예외 발생 ...");
			e.printStackTrace();
		}
		
		//화면
		if(dbData != null) {
			//req.setAttribute("loginMember", dbData);
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", dbData);
			//req.getRequestDispatcher("/index.jsp").forward(req, resp);
			resp.sendRedirect("/app20/home");
		}else {
			req.getRequestDispatcher("실패페이지JSP").forward(req, resp);
		}
		
	}

}//class






















