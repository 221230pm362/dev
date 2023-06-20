package com.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.app.greet.Greeter;

public class MyFilter implements Filter {
	
	@Autowired
	private Greeter greeter;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		greeter.greet();
		
		System.out.println("내가 만든 필터 ~~~");
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

}//class






















