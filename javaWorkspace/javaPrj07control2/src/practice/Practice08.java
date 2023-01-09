package practice;

import java.util.Scanner;

public class Practice08 {

	public static void main(String[] args) {
		
		// UP/DOWN 숫자 맞추기 ,,, 근데 이제 반복문이 추가된 ,,,
		int answer = 123;
		int num = 0;
		
		while(true) {
			System.out.print("정수를 입력하세요 : ");
			// 유저한테 입력받기
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			
			// 업 || 다운 || 정답 
			if(num < answer) {
				System.out.println("업");
			}else if(num > answer) {
				System.out.println("다운");
			}else if(num == answer) {
				System.out.println("정답");
				break;	//반복문 박살
			}
		}
		
	}

}//class

























