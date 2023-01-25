package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("==== 예외 =====");
		
		MemberController mc = new MemberController();
		
//		boolean result = mc.join("user01", "1234", "nick01");
//		System.out.println("회원가입 결과 : " + result);
		
		try {
			mc.join2("user01", "1234", "nick01");
		} catch (Exception e) {
			System.out.println("회원가입 실패");
			System.out.println(e.getMessage());
		}

	}//main

}//class



















