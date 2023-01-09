package javaPrj06control;

import java.util.Scanner;

public class Practice05 {

	public static void main(String[] args) {
		
		// 정수 입력받기
		Scanner sc = new Scanner(System.in);	//입력받을 준비
		int num = sc.nextInt();					//입력받기
		
		// 정수 홀 짝 판단해서 출력
		if(num % 2 == 1) {
			System.out.println("홀수");
		}else {
			System.out.println("짝수");
		}

	}

}
























