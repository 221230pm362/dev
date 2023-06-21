package com.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;

//@WebFilter("/admin/*")
public class CheckAdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("내가 만든 필터 ~~~");
		
		//관리자 여부 체크
		HttpSession session = ((HttpServletRequest)request).getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null 
				|| 
			!"admin".equalsIgnoreCase(loginMember.getId()) 
			) {
			request.getRequestDispatcher("/WEB-INF/views/admin/error.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	
	
}//class

























