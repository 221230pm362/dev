package com.kh.menu;

public class Menu {
	
	public static final String ONE = "싸이버거 세트";
	public static final String TWO = "블랙갈릭버거 세트";
	public static final String THREE = "인크레더블버거 세트";
	
	public static String convertMenu(int menuNum) throws Exception {
		String menu = "";
		switch(menuNum) {
		case 1: menu = Menu.ONE; break;
		case 2: menu = Menu.TWO; break;
		case 3: menu = Menu.THREE; break;
		default: throw new Exception("메뉴번호 잘못됨!!!");
		}
		return menu;
	}

}
