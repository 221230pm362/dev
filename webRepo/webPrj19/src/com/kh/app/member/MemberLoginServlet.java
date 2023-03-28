package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//문자열 내보내기 == 화면작업 == JSP한테위임
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
		
	}
	
	//로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String memberId = req.getParameter("memberId"); 
		String memberPwd = req.getParameter("memberPwd"); 
		
		//서비스 로직 실행	== 디비 가서 select 실행
		
		String dbId = null;
		try {
			//1. conn 준비
			Connection conn = JDBCTemplate.getConnection();
			
			//2. SQL 실행
			String sql = "SELECT ID,PWD,NICK FROM MEMBER WHERE ID = ? AND PWD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			ResultSet rs = pstmt.executeQuery();
			
			//3. tx || rs->obj , close
			if(rs.next()) {
				dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}catch(Exception e) {
			System.out.println("[ERROR] 로그인 중 예외 발생 ...");
			e.printStackTrace();
		}
		
		//문자열 내보내기 == 화면
		if(dbId != null) {
			req.getRequestDispatcher("성공페이지").forward(req, resp);
		}else {
			req.getRequestDispatcher("실패페이지").forward(req, resp);
		}
	
	}//method
	
}//class























