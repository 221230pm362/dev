package kh.swy.game;

import java.util.Scanner;

public class Game03 {

	public static void main(String[] args) {
		
		//가위바위보
		// 1.가위 2.바위 3.보자기
		
		//컴퓨터의 손 설정
		int com = (int)(Math.random() * 3 + 1);
		
		Scanner sc = new Scanner(System.in);	// 도구 준비
		System.out.println("1.가위 2.바위 3.보자기");
		
		//유저로부터 문자열 입력받기
		String userStr = sc.nextLine();
		
		//입력받은 문자열에 따라 유저 손 설정 (숫자로)
		int user = 0;
		if(userStr.equals("가위")) {
			user = 1;
		}else if(userStr.equals("바위")) {
			user = 2;
		}else if(userStr.equals("보자기")) {
			user = 3;
		}
		
		//각자의 손 출력
		System.out.println("유저 : " + user);
		System.out.println("컴퓨터 : " + com);
		
		//결과 출력
		if(com == 1) {
			if(user == 1) {
				System.out.println("무승부");
			}
			else if(user == 2) {
				System.out.println("유저 승리!!!");
			}
			else if(user == 3) {
				System.out.println("유저 패배...");
			}
		}
		else if(com == 2) {
			if(user == 1) {
				System.out.println("유저 패배...");
			}
			else if(user == 2) {
				System.out.println("무승부");
			}
			else if(user == 3) {
				System.out.println("유저 승리!!!");
			}
		}
		else if(com == 3) {
			if(user == 1) {
				System.out.println("유저 승리!!!");
			}
			else if(user == 2) {
				System.out.println("유저 패배...");
			}
			else if(user == 3) {
				System.out.println("무승부");
			}
		}
		
		
		

	}//main

}//class


























