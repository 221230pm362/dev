package com.kh.main;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("메인메소드 실행됨");
		
		Test01 t01 = new Test01();
//		t01.hello();
		
//		t01.printNumber(3);
		
//		int x = 22;
//		System.out.println(x);
		
//		int result = t01.plusOne(10);
//		System.out.println(result);
		
		int x = t01.plus(2, 3);
		System.out.println("메소드 호출하고 리턴받은 결과 : " + x);

	}//main

}//class


















