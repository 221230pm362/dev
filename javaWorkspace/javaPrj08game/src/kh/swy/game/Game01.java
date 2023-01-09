package kh.swy.game;

import java.util.Scanner;

public class Game01 {

	public static void main(String[] args) {
		
		//업다운 게임 ,,, 근데 이제 ,, 랜덤숫자로 ,,,
		//answer = 1~10 사이의 랜덤숫자
		int answer = (int) (Math.random() * 10) + 1;
		int num = 0;
		
		while(true) {
			//유저입력
			System.out.print("정수를 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			
			//결과 출력 
			if(num == answer) {
				System.out.println("정답~!");
				break;
			}else if(num < answer) {
				System.out.println("업!!!");
			}else if(num > answer) {
				System.out.println("다운!!!");
			}
		}

	}

}//class
























