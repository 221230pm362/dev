package com.kh.emp;

import com.kh.menu.Menu;

public class KitchenEmp {
	
	// 요리하기
	public String cook(int menuNum) throws Exception  {
		String menu = "";
		
		menu = Menu.convertMenu(menuNum);
		
		System.out.println(menu + " 버거 완성");
		return menu;
	}

}//class





















