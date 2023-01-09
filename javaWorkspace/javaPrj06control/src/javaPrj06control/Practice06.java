package javaPrj06control;

import java.util.Scanner;

public class Practice06 {

	public static void main(String[] args) {
		
		// 유저로부터 정수 입력받고,
		// 입력받은 숫자가 양수이면 양수 라고 출력
		// 아니면,, 아님 이라고 출력
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n > 0) {
			System.out.println("양수~~~");
		}else {
			System.out.println("아님");
		}

	}

}//class
























