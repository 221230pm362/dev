package test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		System.out.println("===== 스캐너 테스트 =====");

		//입력 도구
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		System.out.println("첫번째숫자 : " + num1);
		
		int num2 = sc.nextInt();
		System.out.println("두번째숫자 : " + num2);
		
		sc.nextLine();	//버퍼에 남은 엔터키 잡아먹음
		
		String str = sc.nextLine();
		System.out.println("세번째문자열 : " + str);
		
		String str2 = sc.nextLine();
		System.out.println("네번째문자열 : " + str2);
		
		
	}//main

}//class
























