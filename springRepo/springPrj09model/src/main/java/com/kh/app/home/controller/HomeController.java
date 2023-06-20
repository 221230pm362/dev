package com.kh.app.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//홈페이지 (화면)
	@GetMapping(value = {"/" , "home"})
	public String home() {
		return "home";
	}
	
	//로그인 처리 (완료하고나서 홈페이지로 이동)
	@GetMapping("login")
	public String login(Model model , HttpSession session , HttpServletRequest req) {
//		session.setAttribute("nick", "sss");
//		req.setAttribute("nick", "rrr");
		model.addAttribute("nick" , "mmm");
		return "redirect:/home";
	}
	
	
	

}








