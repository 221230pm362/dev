package com.kh.emp;

import java.util.Scanner;

import com.kh.menu.Menu;

public class CounterEmp {
	
	private String name;
	
	public int takeOrder() {
		// 주문 (메뉴보여줌, 손님입력받기)
		System.out.println("-----메뉴-----");
		System.out.println("1. " + Menu.ONE);
		System.out.println("2. " + Menu.TWO);
		System.out.println("3. " + Menu.THREE);
		
		Scanner sc = new Scanner(System.in);
		String menuNum_ = sc.nextLine();
		int menuNum = Integer.parseInt(menuNum_);
		return menuNum;
	}
	
	public void calc() {
		System.out.println("계산 ~~~");
	}

}
