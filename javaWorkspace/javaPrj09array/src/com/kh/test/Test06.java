package com.kh.test;

public class Test06 {
	
	public void method01() {
		
		System.out.println("테스트06 > 메소드01 호출됨 ~");
		
		// 중첩 반복문 (구구단 2~9단 출력)
		for(int dan = 2; dan <= 9; dan++) {
			for(int i = 1 ; i <= 9 ; i++) {
				System.out.println(dan + " * " + i + " = " + dan * i);
			}
		}
		
	}//method

}//class









