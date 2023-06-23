package com.kh.app.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.app.exception.KhException;

//@ControllerAdvice(basePackages = "com.kh.app.member.controller")
@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {
	
	@ExceptionHandler(Exception.class)
	public String m01(Exception e) {
		System.out.println("예외 발생 : " + e.getMessage());
		System.out.println("ErrorProcessor > m01 called...");
		return "errorPage~~~";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String m02() {
		return "NPE~~~~";
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String m03() {
		return "ARR~~~~";
	}	
	
	@ExceptionHandler(KhException.class)
	public String notFoundHandler() {
		return "error/notFountPage";
	}
	

}//class























