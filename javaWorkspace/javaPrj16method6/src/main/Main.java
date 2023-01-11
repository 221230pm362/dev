package main;

import java.util.Scanner;

import main.menu.Menu;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 김밥천국 =====");
		
		//가격
		int menu01 = 3000;
		int menu02 = 11000;
		int menu03 = 8000;
		int menu04 = 20000;
		int menu05 = 500;
		
		//Menu 생성
		Menu menu = new Menu();
		
		// 메뉴 보여주기
		menu.showMenu(menu01, menu02, menu03, menu04, menu05);
		
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		// 메뉴 입력받기
//		System.out.print("원하는 메뉴 번호 : ");
//		int menuNum = sc.nextInt();
		int menuNum = menu.showMsgAndScanNumber("메뉴 번호 : ");
		
		// 수량 입력받기
//		System.out.print("메뉴 개수 : ");
//		int menuCnt = sc.nextInt();
		int menuCnt = menu.showMsgAndScanNumber("메뉴 개수 : ");
		
		// 현재 합계 보여주기 (메뉴가격 * 갯수)
		int sum = 0;
		int price = 0;
		
		switch(menuNum) {
		case 1 : price = menu01; break;
		case 2 : price = menu02; break;
		case 3 : price = menu03; break;
		case 4 : price = menu04; break;
		case 5 : price = menu05; break;
		}
		
		sum = price * menuCnt;
		
		System.out.println("총 주문금액 : " + sum);
		
		//결제 수단
//		System.out.print("결제 수단 (1.카드 2.현금) : ");
//		int pay = sc.nextInt();
		int pay = menu.showMsgAndScanNumber("결제수단 (1.카드 2.현금) : ");
		
		
		System.out.println("주문이 완료되었습니다.");
	}//main

}//class











