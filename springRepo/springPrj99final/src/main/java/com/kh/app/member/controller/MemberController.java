package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.controller.BoardController;
import com.kh.app.exception.LoginFailException;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	private final MemberService service;
	
	//회원가입 (화면)
	@GetMapping("join")
	public void join() {}
	
	//회원가입
	@PostMapping("join")
	public String join(MemberVo vo) {
		int result = service.join(vo);
		log.info("result : {}" , result);
		if(result != 1) {
			throw new IllegalStateException("회원가입 실패");
		}
		return "redirect:/";
	}
	
	//로그인
	@PostMapping("login")
	public String login(MemberVo vo , HttpSession session) {
		MemberVo loginMember = service.login(vo);
		log.info("로그인 결과 : {}" , loginMember);
		session.setAttribute("loginMember", loginMember);
		if(loginMember == null) {
			throw new LoginFailException();
		}
		return "redirect:/";
	}
	
	//로그아웃
	
	//수정하기 (화면)
	
	//수정하기
	
	//탈퇴하기

}









