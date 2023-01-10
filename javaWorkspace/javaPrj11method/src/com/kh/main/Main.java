package com.kh.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.안녕 2.잘가 3.자기소개");
		
		int n = sc.nextInt();
		
		if(n == 1) {
			// 헬로 월드 5번 출력
			Test01 t01 = new Test01();
			t01.helloWorld();
		}else if(n == 2){
			//바이 5번 출력
			Test02 t02 = new Test02();
			t02.bye();
		}else if(n == 3) {
			//자기소개
			Test03 t03 = new Test03();
			t03.introduce();
		}

	}//main

}//class





















