package com.kh.app.home.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@GetMapping("test")
	@ResponseBody
	public String test(HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		return "test~~~!";
	}
	
	@RequestMapping
	public String home(
			  @CookieValue Cookie rememberId
			, @CookieValue Cookie JSESSIONID) {
		
		System.out.println(rememberId.getName() + " / " + rememberId.getValue());
		
//		Cookie[] cookieArr = req.getCookies();
//		for (Cookie cookie : cookieArr) {
//			System.out.println(cookie.getName()  + " / " + cookie.getValue());
//		}
		
		return "home";
	}

}//class























