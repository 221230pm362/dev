package com.kh.main;

public class Test {
	
	public void m01() {
		System.out.println("m01 시작");
		
		//System.out.println(1/0);	//Ari~~~ 예외발생
		
//		String str = null;
//		System.out.println(str.charAt(2));	//NPE 예외발생
		
//		int[] arr = new int[3];
//		arr[5] = 777;		//AIOB 예외 발생
		
		System.out.println("m01 종료");
	}//method
	
	public void m02(int a, int b) {
		
		try {
			System.out.println(a / b);
		}catch(ArithmeticException e) {
			System.out.println("내가 잡은 예외 : " + e);
		}
	}
	
	public void m03(String str) {
		
		try {
			System.out.println(str.charAt(3));
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println(e);
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		
	}//method
	
	public void m04(String s) {
		
		try 
		{
			char x = s.charAt(3);
			System.out.println(x);
		}
		catch(Exception e) 
		{
			System.out.println("NPE 예외 발생 ~~~");
		}
		
	}
	
	public void m05() throws Exception {
		System.out.println("m05 시작");
		int x = 1 / 0;
		System.out.println("m05 종료");
	}
	
	public void m06() throws Exception {
		System.out.println("m06 시작");
		
		//예외 강제로 발생
		throw new Exception("ㅋㅋㅋ예외메세지ㅋㅋ");
		
		//System.out.println("m06 종료");
	}
	

}//class











