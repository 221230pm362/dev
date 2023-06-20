package com.kh.app.greet;

import org.springframework.stereotype.Component;

@Component
public class Greeter {
	
	public void greet() {
		System.out.println("안녕하세요");
	}

}
