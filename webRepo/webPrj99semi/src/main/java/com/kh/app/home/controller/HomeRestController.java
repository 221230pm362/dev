package com.kh.app.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.home.service.HomeService;

@WebServlet("/home/board-top-hit")
public class HomeRestController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//서비스
			HomeService hs = new HomeService();
			BoardVo vo = hs.getBoardTopHit();
			
			//가공
			Gson gson = new Gson();
			String str = gson.toJson(vo);
			
			//결과 == 문자열내보내기
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(str);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("error~~~");
		}
		
	}

}//class

























