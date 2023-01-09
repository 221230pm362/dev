package com.kh.array;

import java.util.Scanner;

public class Test02 {
	
	public void method01() {
		System.out.println("테스트02 > 메소드01 called...");
		
		// 학생 n명의 성적을 입력받고,
		// n명의 성적 합계 , 평균 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수 : ");
		int n = sc.nextInt();
		
		int[] scoreArr = new int[n];
		
		for(int i = 0; i < scoreArr.length; i++) {
			System.out.print(i+1 + "번 학생 성적 : ");
			scoreArr[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for(int i = 0; i < scoreArr.length; i++) {
			sum += scoreArr[i];
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (double)sum / scoreArr.length);
		
		
	}//method

}//class






















