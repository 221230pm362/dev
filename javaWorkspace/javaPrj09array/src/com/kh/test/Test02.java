package com.kh.test;

import java.util.Scanner;

public class Test02 {
	
	public void method01() {
		System.out.println("-----테스트02 > 메소드01-----");
		
		//배열
		//학생 3명 성적 입력받기
		//3명 성적 출력하기
		Scanner sc = new Scanner(System.in);
		
		int[] x = new int[3];
		
		for(int i = 0; i < 3; ++i) {
			x[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 3; ++i) {
			System.out.println(x[i]);
		}
		
	}//method

}//class























