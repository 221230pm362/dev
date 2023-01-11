package com.kh.game;

import java.util.Scanner;

public class Game01 {
	
	Scanner sc = new Scanner(System.in);	//Scanner 객체 생성
	
	//업다운 게임
	public void startUpDownGame() {
		
		System.out.println("===== 업다운 게임 시작 =====");
		
		//정답 정하기 (랜덤)
		int max = 10;
		int start = 1;
		int answer = (int)(Math.random() * max + start);
		
		while(true) {
			//유저 입력받기
			System.out.print(start + " ~ " + max + "사이의 정수를 입력하세요 : ");
			int user = sc.nextInt();
			
			//판단하기
			if(user == answer) {
				System.out.println("정답입니다.");
				break;
			}else if(user > answer) {
				System.out.println("DOWN");
			}else {
				System.out.println("UP");
			}
		}
		
	}//메소드종료
	
	
	
	//구구단 게임
	public void startGuguGame() {
		
		System.out.println("===== 구구단 게임 =====");
		
		//정답 설정
		int a = 3;
		int b = 4;
		int answer = a*b;
		
		// 문제 내기
		System.out.println(a + " * " + b + " = ?");
		
		// 유저 입력 받기
		int user = sc.nextInt();
		
		// 결과 출력
		if(answer == user) {
			System.out.println("정답입니다.");
		}else {
			System.out.println("땡!");
		}
		
	}//메소드

	//메뉴 보여주는 메소드
	public void showMenu() {
		System.out.println("1. 업다운 게임");
		System.out.println("2. 구구단 게임");
		System.out.println("3. 준비중...");
		System.out.println("4. 준비중...");
		System.out.println("5. 준비중...");
		System.out.println("9. 게임종료");
	}

}//class
























