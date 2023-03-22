package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.main.member.MemberController;
import com.kh.app.main.member.MemberService;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String input = SC.nextLine();
		
		if(input.equals("1")) {
			//회원가입 진행
			MemberController mc = new MemberController(new MemberService());
			int result = mc.join();
			System.out.println("회원가입 결과 : " + result);
		}

	}

}//class





















