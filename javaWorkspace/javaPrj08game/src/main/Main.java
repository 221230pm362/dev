package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 1.가위 2.바위 3.보자기
		System.out.println("1.가위 2.바위 3.보자기");
		
		//가위바위보 (유저 vs 컴)
		int com = 1; 	//가위
		int user = 0;	//입력받기
		
		//유저 입력 받기
		Scanner sc = new Scanner(System.in);
		user = sc.nextInt();
		
		//컴퓨터 손 공개
		if(com == 1) System.out.println("컴퓨터 : 가위");
		else if(com == 2) System.out.println("컴퓨터 : 바위");
		else if(com == 3) System.out.println("컴퓨터 : 보자기");
		
		//결과출력 (승 , 패 , 무)
		if(com == 1) {
			if(user==1) {
				System.out.println("무승부");
			}else if(user==2) {
				System.out.println("유저 승리!");
			}else if(user==3) {
				System.out.println("유저 패배...");
			}
		}
		
		if(com == 2) {
			if(user==1) {
				System.out.println("유저 패배...");
			}else if(user==2) {
				System.out.println("무승부");
			}else if(user==3) {
				System.out.println("유저 승리!");
			}
		}
		
		if(com == 3) {
			if(user==1) {
				System.out.println("유저 승리!");
			}else if(user==2) {
				System.out.println("유저 패배...");
			}else if(user==3) {
				System.out.println("무승부");
			}
		}

	}

}//class
























