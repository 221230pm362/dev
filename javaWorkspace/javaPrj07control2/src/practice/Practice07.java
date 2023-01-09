package practice;

import java.util.Scanner;

public class Practice07 {

	public static void main(String[] args) {
		
		boolean x = true;
		
		while(x) {
			//메뉴판 보여주기
			System.out.println("===== <스타벅스 메뉴판> =====");
			System.out.println("1.커피 2.아이스티 3.핫초코 4.민트초코 9.종료");
			
			//메뉴번호 입력받기 (스캐너)
			Scanner s = new Scanner(System.in);	//스캐너 만듦
			int menu = s.nextInt();
			
			//메뉴번호에 따라, 주문 확인하기
			switch(menu) {
			case 1 : 
				System.out.println("커피를 고르셨습니다."); 
				break;
			case 2 : 
				System.out.println("아이스티를 고르셨습니다."); 
				break;
			case 3 : 
				System.out.println("핫초코를 고르셨습니다."); 
				break;
			case 4 : 
				System.out.println("민트초코를 고르셨습니다."); 
				break;
			case 9 : 
				x = false;
				System.out.println("주문완료 ~ !");
				break;
			default : 
				System.out.println("그런 메뉴 없음"); 
				break;
			}//switch
		}//while

	}

}//class


























