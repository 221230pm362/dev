package javaPrj06control;

import java.util.Scanner;

public class Practice07 {

	public static void main(String[] args) {

		int answer = 3;
		
		System.out.print("정수 입력 : ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num == answer) {
			System.out.println("정답~~~!");
		}else {
			System.out.println("땡!!!");
		}
		
	}

}





