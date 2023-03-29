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

@WebServlet("/member/edit")
public class MemberEditServlet extends HttpServlet {
	
	//회원 정보 수정 (화면)	== 디비가서 회원정보 select 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String id = req.getParameter("id");
		
		//데이터 뭉치기
		
		//서비스 로직
		MemberVo loginMember = null;
		try {
			//1. conn
			Connection conn = JDBCTemplate.getConnection();
			
			//2. SQL
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			//3. tx || rs
			if( rs.next() ) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				loginMember = new MemberVo();
				loginMember.setMemberId(dbId);
				loginMember.setMemberPwd(dbPwd);
				loginMember.setMemberNick(dbNick);
			}
			
			//4. close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
			
		}catch(Exception e) {
			System.out.println("[ERROR] 마이페이지 화면 조회 중 에러 발생 ...");
			e.printStackTrace();
		}
		
		//화면
		req.setAttribute("loginMember", loginMember);
		req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
	}
	
	//회원 정보 수정 == 디비가서 update
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		vo.setMemberNick(memberNick);
		
		//서비스 로직
		int result = 0;
		try {
			//1. conn
			Connection conn = JDBCTemplate.getConnection();
			
			//2. SQL
			String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberPwd());
			pstmt.setString(2, vo.getMemberId());
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
			System.out.println("[ERROR] 정보 수정 중 예외 발생 ...");
			e.printStackTrace();
		}
		
		//화면
		if(result == 1) {
			req.setAttribute("msg", "수정 성공 !!!");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
		
	}
	
	
}//class



































