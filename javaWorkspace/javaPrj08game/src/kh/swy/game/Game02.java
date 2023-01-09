package kh.swy.game;

import java.util.Scanner;

public class Game02 {

	public static void main(String[] args) {
		
		// 업다운 
		int n = 0;
		int answer = (int)(Math.random() * 10 + 1);
		
		//입력 도구 준비
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("정수를 입력하세요 : ");
			//유저 입력 받기
			int user = sc.nextInt();
			n++;
			
			//결과 출력
			if(user < answer) {
				System.out.println("UP");
			}else if(user > answer) {
				System.out.println("DOWN");
			}else {
				System.out.println("정답~!");
				System.out.println(n + "번 시도하여 정답 맞춤");
				break;
			}
		}
		
		
		

	}//main

}//class

























