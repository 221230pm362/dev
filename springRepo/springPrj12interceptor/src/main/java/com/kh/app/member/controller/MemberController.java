package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	// 회원가입 (화면)
	@GetMapping("join")
	public void join() {
		
	}
	
	// 회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(MemberVo vo) {
		
		//서비스
		int result = ms.join(vo);
		
		//결과 == 화면 == 문자열내보내기
		if(result != 1) {
			return "join FAIL";
		}
		return "join OK";
	}

	// 로그인 (화면)
	@GetMapping("login")
	public void login() {}
	
	// 로그인
	@PostMapping("login")
	@ResponseBody
	public String login(MemberVo vo , HttpSession session) {
		MemberVo loginMember = ms.login(vo);
		
		session.setAttribute("loginMember", loginMember);
		
		if(loginMember == null) {
			return "login FAIL";
		}
		return "login OK";
	}
	
	//로그아웃
	@GetMapping("logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout OK";
	}
	
	

}//class

























