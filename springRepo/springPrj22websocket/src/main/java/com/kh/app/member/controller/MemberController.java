package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	
	//로그인 화면
	@GetMapping("login")
	public String login() {
		return "member/login";
	}

	//로그인 화면
	@PostMapping("login")
	public String login(String nick , HttpSession session) {
		session.setAttribute("loginMember", nick);
		return "chat/main";
	}
	
	
}













