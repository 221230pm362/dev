package com.kh.app.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.vo.MemberVo;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	//관리자 메인 페이지 보여주기
	@GetMapping("main")
	public String main(HttpSession session) {
		return "admin/main";
	}
	
	//관리자 로그인 (화면)
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("atk" , "777");
		System.out.println("컨트롤러 == 핸들러 called...");
		return "admin/login";
	}
	
	//관리자 로그인
	

}//class






















