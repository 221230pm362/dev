package main.menu;

import java.util.Scanner;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	
	//메뉴 보여주기
	public void showMenu(int menu01 , int menu02 , int menu03 , int menu04 , int menu05) {
		System.out.println("----- MENU -----");
		System.out.println("1. 김밥 (" + menu01 + ")");
		System.out.println("2. 돈까스 (" + menu02 +")");
		System.out.println("3. 우동 (" + menu03 + ")");
		System.out.println("4. 당근케익 (" + menu04 + ")");
		System.out.println("5. 민초국밥 (" + menu05 + ")");
	}
	
	// 메세지 보여주고, 숫자 받아오는 메소드
	public int showMsgAndScanNumber(String s) {
		System.out.print(s);
		int menuNum = sc.nextInt();
		return menuNum;
	}
	
}//class
























