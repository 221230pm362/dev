package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main ~~~ !");
		
		//문자열 비교 A.equals(B)
//		String s1 = new String("hello");
//		String s2 = new String("hello");
//		System.out.println( s1.equals(s2) );
		
		//문자열 길이 구하기 문자열.length()
//		System.out.println( s1.length() );
		
		System.out.println("오버로딩 테스트 ~~~~~");
		
		Test t = new Test();
		t.printText("aaa");
		t.printText("bbb");
		t.printText("aaa" , "bbb");
		
	}//main

}//class


























