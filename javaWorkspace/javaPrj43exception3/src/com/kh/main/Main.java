package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 예외 =====");
		
		Test t = new Test();
		try {
			t.login("z", "1234");
		} catch (Exception e) {
			//String msg = e.getMessage();
			System.out.println(e);
		}

	}//main

}//class






























