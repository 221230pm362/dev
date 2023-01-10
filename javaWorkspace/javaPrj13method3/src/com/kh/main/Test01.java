package com.kh.main;

/*
<메소드 작성법>
public 리턴타입 메소드이름(파라미터){
  //실행내용~~~
}
*/

public class Test01 {
	
	//입력값 X 리턴값 X 
	public void hello() {
		System.out.println("안녕하세요");
	}
	
	//입력값 O 리턴값 X
	public void printNumber(int n) 
	{
		System.out.println("전달받은 숫자 : " + n);
	}
	
	//입력값 X 리턴값 O 
	public int age() 
	{
		System.out.println("나이 리턴해드림");
		return 22;
	}
	
	//입력값 O 리턴값 O
	public int plusOne(int n) {
		int x = n+1;
		return x;
	}

}









