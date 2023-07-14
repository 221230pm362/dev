package com.kh.app.handler.exception;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.app.exception.LoginFailException;

@ControllerAdvice(annotations = Controller.class)
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public String handle() {
		return "error/errorPage";
	}
	
	@ExceptionHandler(LoginFailException.class)
	public String handleLoginFail() {
		return "error/loginFail";
	}
	
	@ExceptionHandler(NotFoundException.class)
	public String handleNotFound() {
		return "error/404page";
	}
	
	
	
	

}//class
























