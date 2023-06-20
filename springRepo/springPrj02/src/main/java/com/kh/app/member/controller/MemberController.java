package com.kh.app.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	//회원가입 (화면)
//	@RequestMapping(value = "member/join" , method = RequestMethod.GET)
	@GetMapping("member/join")
	public String m01() {
		return "member/join";
	}
	
	//회원가입
//	@RequestMapping(value = "member/join" , method = RequestMethod.POST)
	@PostMapping("member/join")
	public String m02(MemberVo vo) {
		
		//데꺼
		//데뭉
		
		System.out.println(vo);
		
		//서비스
		System.out.println("회원가입 진행 ~~~");
		
		//결과 == 문자열 내보내기 == 화면
		return "redirect:/";
	}

}






















