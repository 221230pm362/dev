package com.kh.test;

import java.util.Scanner;

public class Test04 {
	
	public void method01() {
		
		System.out.println("테스트04 > 메소드01 ~~~ !");
		
		Scanner sc = new Scanner(System.in);	//입력 도구
		
		//무한반복
		while(true) {
			//정수 입력받고
			int num = sc.nextInt();
			
			//반복문 그만도는지 판단
			if(num == 0) {
				break;
			}
			
			//입력받은 정수가 홀수인지 짝수인지 판단
			if(num % 2 == 1) {
				System.out.println("홀수입니다.");
			}else {
				System.out.println("짝수입니다.");
			}
		}
		
		//언제까지? 입력된 숫자가 0 이면 종료
		
		
		
		
		
		
	}//class

}//class






















