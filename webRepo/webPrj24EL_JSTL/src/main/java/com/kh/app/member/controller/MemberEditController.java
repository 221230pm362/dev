package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet {

	
	//정보수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/editForm.jsp").forward(req, resp);
	}
	
	//정보수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getNo(); 
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			vo.setNo(memberNo);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.edit(vo);
			
			//화면
			if( updatedMember != null ) {
				session.setAttribute("loginMember", updatedMember);
				resp.sendRedirect("/app24/home");
			}else {
				throw new Exception("정보 수정 실패 ...");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] 정보 수정 중 예외 발생 ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "에러 ㅠㅠ");
			req.getRequestDispatcher("errorpage~~~~~").forward(req, resp);
		}
		
	}
	
	
}//class












