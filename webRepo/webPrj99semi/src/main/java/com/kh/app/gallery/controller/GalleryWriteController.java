package com.kh.app.gallery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.file.AttachmentVo;
import com.kh.app.util.file.FileUploader;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 50 ,
			maxRequestSize = 1024 * 1024 * 50 * 10
		)
@WebServlet("/gallery/write")
public class GalleryWriteController extends HttpServlet {
	
	//작성하기 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/gallery/write.jsp").forward(req, resp);
	}
	
	//작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new IllegalStateException("로그인 하고 오세요");
			}
			
			// 데이터 꺼내기 (준비)
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = loginMember.getNo();
			
			String path = req.getServletContext().getRealPath("/static/img/gallery/");
			Part f = req.getPart("f");
			AttachmentVo attVo = FileUploader.saveFile(path, f);
			
			// 데이터 뭉치기
			GalleryVo gvo = new GalleryVo();
			gvo.setTitle(title);
			gvo.setContent(content);
			gvo.setWriterNo(writerNo);
			gvo.setChangeName(attVo.getChangeName());
			gvo.setOriginName(attVo.getOriginName());
			
			// 서비스
			GalleryService gs = new GalleryService();
			int result = gs.write(gvo);
			
			// 결과 == 화면 == 문자열 내보내기
			if(result != 1) {
				throw new Exception();
			}
			
			//성공
			resp.sendRedirect(req.getContextPath() + "/gallery/list");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}

	
	
}






















