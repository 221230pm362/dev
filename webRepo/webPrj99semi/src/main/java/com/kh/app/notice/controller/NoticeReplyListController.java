package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeReplyVo;

@WebServlet("/notice/reply/list")
public class NoticeReplyListController extends HttpServlet {
	
	//댓글 목록 조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String noticeNo = req.getParameter("noticeNo");
			//데뭉
			
			//서비스
			NoticeService ns = new NoticeService();
			List<NoticeReplyVo> list = ns.selectReplyList(noticeNo);
			
			//문자열 내보내기
			PrintWriter out = resp.getWriter();
			//out.write(list 를 JSON 형태로 만들기);
			
		}catch(Exception e) {
			System.out.println("[ERROR] notice reply errr~~~");
			e.printStackTrace();
		}
		
	}

}













