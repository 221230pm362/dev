package com.kh.test;

import java.util.Scanner;

public class Test05 {
	
	public void method01() {
		
		System.out.println("테스트05 > 메소드01 호출됨 ~ !");
		
		//do while
		
		//입력도구 준비
		Scanner sc = new Scanner(System.in);
		
		//위 작업을 무한반복
		int num = 0;
		do {
			//정수 입력받기
			num = sc.nextInt();
			
			//홀 짝 판단
			if(num % 2 == 1) {
				System.out.println("홀수입니다.");
			}else {
				System.out.println("짝수입니다.");
			}
		}while(num != 0);
		
		
		
		
	}//method

}//class





