package com.kh.app.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.exception.KhException;

@Controller
public class MainController {
	
	@RequestMapping("*")
	public void fallback() throws KhException {
		throw new KhException();
	}
	
	

}//class


















