package com.kh.app.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	// 로그인 (화면)
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(MemberVo vo , HttpServletResponse resp) {
		
		System.out.println("유저가 입력한 데이터 : " + vo);
		
		//로그인 성공시, 쿠키를 추가
		Cookie c = new Cookie("rememberId", vo.getId());
		c.setPath("/app");	//기본값 : 현재경로
//		c.setMaxAge(0);		//기본값 : session
		resp.addCookie(c);
		
		return "redirect:/home";
	}
	
	

}











