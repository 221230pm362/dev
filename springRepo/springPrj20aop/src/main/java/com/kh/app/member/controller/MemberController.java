package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	//회원가입
	@PostMapping("join")
	public String join(MemberVo vo) {
		int result = ms.join(vo);
		
		if(result != 1) {
			throw new RuntimeException("errorrrr");
		}
		
		return "회원가입 성공!!!";
	}
	
	//로그인
	@PostMapping("login")
	public String login(MemberVo vo) {
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember == null) {
			throw new RuntimeException("errrrr~~");
		}
		
		return "로그인 성공 ~ !";
	}
	

}//class




















