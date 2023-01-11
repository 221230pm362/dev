package com.kh.main;

import java.util.Scanner;

import com.kh.game.Game01;

public class Run {

	public static void main(String[] args) {

		System.out.println("<미니게임천국>");
		
		Game01 g01 = new Game01();				//Game01 객체 생성
		Scanner sc = new Scanner(System.in);	//Scanner 객체 생성
		
		boolean isGaming = true;
		
		while(isGaming) {
			//메뉴 보여주기
			g01.showMenu();
			
			//유저 입력 받기
			int userNum = sc.nextInt();
			
			//입력에 따라 게임 실행
			switch(userNum) {
			case 1 : g01.startUpDownGame(); break;
			case 2 : g01.startGuguGame(); break;
			case 9 : isGaming = false;
			}
		}//while end
		
		System.out.println("프로그램 종료");
	}//main

}//class








































