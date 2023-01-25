package com.kh.main;

public class Main {

	public static void main(String[] args) {
		System.out.println("===== 메인메소드 시작 =====");
		
		//new Test().m01();
		
		Test t = new Test();
		//t.m01();
		//t.m02(10, 0);
		//t.m03("abc");
		//t.m04("a");
		
//		try {
//			t.m05();
//		}catch(Exception e) {
//			System.out.println("아무튼 예외 발생 ... m05가 나한테 던짐..");
//			System.out.println(e);
//		}
		
		try {
			t.m06();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("===== 메인메소드 종료 =====");
	}//main
	
	

}//class





































