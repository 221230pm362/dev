package com.kh.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@GetMapping
	public void home(String nick) {
		System.out.println(nick);
	}
	
	@GetMapping("test")
	public String test(RedirectAttributes ra) {
		ra.addAttribute("nick" , "zzzzzzz");
		return "redirect:/home";
	}
	
}//class

























