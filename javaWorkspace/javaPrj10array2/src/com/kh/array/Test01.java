package com.kh.array;

public class Test01 {
	
	public void method01() {
		
		System.out.println("테스트01 > 메소드01 호출됨 ~");
		
		// int 타입 변수 10개를 만들고
		// 각각의 변수에 10 , 20 , 30 , ... 100 을 할당
		// 10개의 변수를 순서대로 출력
		
		int[] x = new int[10];
		
		int value = 10;
		
		for(int i = 0 ; i < 10; i++) {
			x[i] = value;
			value += 10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(x[i]);
		}
		
	}//method

}//class
















