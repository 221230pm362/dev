package com.kh.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.app.member.vo.MemberVo;

public class CheckAdminInterceptor implements HandlerInterceptor {

	// 언제 ? 컨트롤러 가기 전
	// 리턴값 : 핸들러를 호출할지 말지 결정
	// 핸들러 == 컨트롤러
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 > preHandle");
		
		//관리자 여부 체크
		HttpSession session = request.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null 
				|| 
			!"admin".equalsIgnoreCase(loginMember.getId()) 
			) {
			request.getRequestDispatcher("/WEB-INF/views/admin/error.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}

	// 언제 ? 컨트롤러 다녀오고 나서
	// modelAndView : Model 객체 , View 경로
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("인터셉터 > postHandle");
		
	}

	// 언제 ? JSP 이후 == 렌더링 이후
	// 예외 객체를 확인할 수 있음
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("인터셉터 > afterCompletion");
		System.out.println(ex);
		

	}
	
	

}//class














