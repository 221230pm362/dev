package com.kh.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	// 홈 페이지 (화면)
	@RequestMapping(value = {"home" , "/"})
	public String home() {
		return "home";
	}

}//class




















