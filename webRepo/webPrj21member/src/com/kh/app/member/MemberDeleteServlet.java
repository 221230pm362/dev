package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	//회원탈퇴	//디비에 가서 delete 쿼리 실행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String id = req.getParameter("id");
		
		//데이터 뭉치기
		
		//서비스 로직 실행
		
		int result = 0;
		try {
			//1. conn
			Connection conn = JDBCTemplate.getConnection();
			
			//2. SQL
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			//3. tx || rs
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			//4. close
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		}catch(Exception e) {
			System.out.println("[ERROR] 회원 탈퇴 중 예외발생 ...");
			e.printStackTrace();
		}
		
		//화면
		if(result == 1) {
			req.getSession().invalidate();
			resp.sendRedirect("/app21");
		}else {
			resp.sendRedirect("/app21/errrrrrrr");
		}
		
	}
	
}//class

























