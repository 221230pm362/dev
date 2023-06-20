package com.kh.app.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}

	// 회원가입 (화면)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	// 회원가입
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		//서비스
		int result = ms.join(vo);
		
		//결과
		if(result != 1) {
			return "failPage";
		}
		
		return "successPage";
	}
	

}//class






















