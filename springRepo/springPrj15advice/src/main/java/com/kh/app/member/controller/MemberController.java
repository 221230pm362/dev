package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.annotation.error.ErrorTarget;
import com.kh.app.exception.MemberException;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
	
	private final MemberService ms;
	
	//회원가입 (화면)
	@GetMapping("join")
	public void join() {}

	//회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(MemberVo vo) throws Exception {
		int result = ms.join(vo);
		if(result != 1) {
			throw new RuntimeException("회원가입 실패");
		}
		return "join OK";
	}
	
	
}//class























