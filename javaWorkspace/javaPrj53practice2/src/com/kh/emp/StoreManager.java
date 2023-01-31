package com.kh.emp;

public class StoreManager {
	
	public void work() {
		CounterEmp counterEmp = new CounterEmp();
		KitchenEmp kitchenEmp = new KitchenEmp();
		HallEmp hallEmp = new HallEmp();
		
		try {
			hallEmp.hello();
			int menuNum = counterEmp.takeOrder();
			String menu = kitchenEmp.cook(menuNum);
			hallEmp.serve(menu);
		}catch(Exception e) {
			System.out.println("ㅈㅅㅈㅅ");
			e.printStackTrace();
		}
		
		
	}//method

}//class

























